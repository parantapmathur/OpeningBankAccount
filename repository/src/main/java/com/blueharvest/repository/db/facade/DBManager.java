package com.blueharvest.repository.db.facade;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blueharvest.repository.db.entity.Customer_Account;
import com.blueharvest.repository.db.entity.Customer_Detail;
import com.blueharvest.repository.db.entity.Customer_transaction;
import com.blueharvest.repository.db.entity.dto.CustomerAccountDTO;
import com.blueharvest.repository.db.entity.repository.CustomerAccountRepository;
import com.blueharvest.repository.db.entity.repository.CustomerDetailRepository;
import com.blueharvest.repository.db.entity.repository.CustomerTransationRepository;
import com.blueharvest.repository.exception.InsufficientBalanceException;
import com.blueharvest.repository.exception.InvalidAccountException;
import com.blueharvest.repository.exception.ReposityServiceException;
import com.blueharvest.repository.exception.WaitTimeOutException;
import com.blueharvest.repository.utility.ConfigParams;
import com.blueharvest.repository.ws.dto.CustomerAccountRequestDTO;
import com.blueharvest.repository.ws.dto.TransactionDAO;

import io.micrometer.core.instrument.util.StringUtils;

@Component
public class DBManager {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	AccountDBOperation dbOperation;
	@Autowired
	CustomerAccountRepository accountRepo;
	@Autowired
	CustomerTransationRepository transationRepository;
	
	@Autowired
	CustomerDetailRepository customerDetailRepository;
	@Autowired
	ConfigParams configParam;

	public DBManager() {

	}

	public CustomerAccountDTO createSecondaryAccnt(CustomerAccountRequestDTO request) throws InvalidAccountException, WaitTimeOutException,ReposityServiceException  {
		/*
		 * Random random = new SecureRandom();
		 * accountDetails.setSecondaryAccountNumber(random.toString());
		 */

		CustomerAccountDTO secondaryAccountDto = null;
		
		int length = configParam.getLength();
		boolean useLetters = configParam.isAllowAlpha();
		boolean useNumbers = configParam.isAllowNums();

		logger.info("length::" + length);
		logger.info("useLetters::" + useLetters);
		logger.info("useNumbers::" + useNumbers);

		//String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

		//Customer_Account customerAccount = accountRepo.findbyCustomerIDAndAccountType(accountDetails.getCustomerID(), "primary");
		List<Customer_Account> customerPrimaryAccountList = accountRepo.findbyCustomerIDAndAccountDesc(request.getCustomerID(), "primary account");
		
		CustomerAccountDTO primaryAccountDto = new CustomerAccountDTO();
		
		Customer_Account customerPrimaryAccount = customerPrimaryAccountList.get(0);//primary will always be 1
		BeanUtils.copyProperties(customerPrimaryAccount , primaryAccountDto);
		
		
		
		if (request.getInitialCredit().compareTo(BigDecimal.ZERO) > 0) {
			String balMinLimit = configParam.getAccountBalanceMinLimit();
			if(StringUtils.isBlank(balMinLimit)) {
				balMinLimit = "0";
			}
			BigDecimal minLimit = new BigDecimal(balMinLimit);
			BigDecimal primaryAccountBal = primaryAccountDto.getAccountBalance();
			BigDecimal initAmountRequested = request.getInitialCredit();
			boolean canProcess = canProcessTransation(primaryAccountBal,minLimit,initAmountRequested);
			if(canProcess) {
				primaryAccountProcessor(request, customerPrimaryAccount);
				Customer_Account customerSecAccount = processSecondryAccount(request,primaryAccountDto);
				secondaryAccountDto = new CustomerAccountDTO();
				BeanUtils.copyProperties(customerSecAccount , secondaryAccountDto);
				
			}else {
				throw new InsufficientBalanceException("Primary Account Balance is not sufficent for this  transation");
			}
		}

		return secondaryAccountDto;
	}

	private Customer_Account processSecondryAccount(CustomerAccountRequestDTO request, CustomerAccountDTO primaryAccountDto) throws ReposityServiceException {
		
		
		List<Customer_Account> secondaryAccountList = accountRepo.findbyCustomerIDAndAccountDesc(request.getCustomerID(), "primary account");
		
		int noOfSecAccount = 0;
		if(secondaryAccountList!=null) {
			noOfSecAccount = secondaryAccountList.size();
		}
		
		CustomerAccountDTO customerSecAccountDTO = new CustomerAccountDTO();
		
		customerSecAccountDTO.setAccountBalance(request.getInitialCredit());
		customerSecAccountDTO.setAccountBranch(primaryAccountDto.getAccountBranch());
		customerSecAccountDTO.setAccountDescription("Secondary Account");
		
		int nextNumber = noOfSecAccount++;
		String accountNumber = primaryAccountDto.getAccountNumber()+"secondary"+nextNumber;
		customerSecAccountDTO.setAccountNumber(accountNumber);
		
		customerSecAccountDTO.setAccountType(configParam.getAccountType());
		customerSecAccountDTO.setCustomerID(request.getCustomerID());
		customerSecAccountDTO.setTimestamp(new Timestamp(System.currentTimeMillis()));
		
		Customer_Account customerSecAccount = new Customer_Account();
		
		BeanUtils.copyProperties(customerSecAccountDTO, customerSecAccount);
		try {
		synchronized (customerSecAccount) {
			customerSecAccount = accountRepo.save(customerSecAccount);
			if(customerSecAccount!=null) {
				String transDesc = "add amount from primary account for customerID: "+primaryAccountDto.getCustomerID();
				saveNewTransation(customerSecAccountDTO.getAccountNumber(),transDesc, "CR", request.getInitialCredit(), primaryAccountDto.getCustomerID());
			}
		}
		}catch(Exception ex) {
			customerSecAccount =null;
			throw new ReposityServiceException("Unable to save the secondary account");
		}
		
		return customerSecAccount;
	}

	/**
	 * @param accountDetails
	 * @param customerPrimaryAccount
	 */
	private void primaryAccountProcessor(CustomerAccountRequestDTO accountDetails,
			Customer_Account customerPrimaryAccount) throws WaitTimeOutException {
		try {
			long maxWaitingTime=0;
			while (true) {
				if (customerPrimaryAccount.isEditable()) {
					synchronized (customerPrimaryAccount) {
						if (customerPrimaryAccount.isEditable()) {
							customerPrimaryAccount.setEditable(false);
							customerPrimaryAccount = accountRepo.save(customerPrimaryAccount);
							BigDecimal newBalance = customerPrimaryAccount.getAccountBalance().subtract(accountDetails.getInitialCredit());
							customerPrimaryAccount.setAccountBalance(newBalance);
							accountRepo.save(customerPrimaryAccount);
							// transtion for primary Account
							saveNewTransation(customerPrimaryAccount.getAccountNumber(),
									"Amount Transfered to new secondary account", "DR",
									accountDetails.getInitialCredit(), accountDetails.getCustomerID());
							customerPrimaryAccount.setEditable(true);
							accountRepo.save(customerPrimaryAccount);
							break;
						}
					}
					
				} else {
					maxWaitingTime = maxWaitingTime + 50;
					if (configParam.getPrimaryAccntMaxWait() <= maxWaitingTime) {
						throw new WaitTimeOutException("Primary account couldnt updated as max WaitTIme exausted");
					}
				}
			}

		} catch (Exception ex) {

		}
	}

	private boolean canProcessTransation(BigDecimal primaryAccountBal, BigDecimal minLimit,
			BigDecimal initAmountRequested) {

		boolean sufficentBalance = primaryAccountBal.compareTo(minLimit)>-1 && primaryAccountBal.compareTo(initAmountRequested)>-1;
		
		return sufficentBalance;
	}

	public boolean saveNewTransation(String accountNumber,
			String transationDesc, String transaction_type, BigDecimal amount_in_EUR, String customerID) {

		logger.info("Going to Saving transation");
		Customer_transaction transation = new Customer_transaction();
		transation.setAccountNumber(accountNumber);
		transation.setAmount_in_EUR(amount_in_EUR);
		transation.setCustomerID(customerID);
		transation.setDescription(transationDesc);
		transation.setTimeStamp(new Timestamp(System.currentTimeMillis()));
		transation.setTransaction_type(transaction_type);

		transationRepository.save(transation);
		logger.info("Transation Saved");
		return true;
	}

	public Customer_Detail getCustomerDetails(String customerID, String customerName){
		Customer_Detail customerDetail = customerDetailRepository.findByCustomerID(customerID);
		return customerDetail;
	}

	public ArrayList<TransactionDAO> getAllTransation() {
		List<Customer_transaction> transationList = transationRepository.findAll();
		ArrayList<TransactionDAO> daoList = null;
		if (transationList != null) {
			daoList = new ArrayList<TransactionDAO>(transationList.size());
			for (Customer_transaction entiry : transationList) {
				TransactionDAO daoObj = new TransactionDAO();
				BeanUtils.copyProperties(entiry, daoObj);
				daoList.add(daoObj);
			}
		}
		return daoList;
	}

}
