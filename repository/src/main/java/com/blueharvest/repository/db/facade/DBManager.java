package com.blueharvest.repository.db.facade;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blueharvest.repository.db.entity.Customer_Account;
import com.blueharvest.repository.db.entity.Customer_Detail;
import com.blueharvest.repository.db.entity.Customer_transaction;
import com.blueharvest.repository.db.entity.repository.CustomerAccountRepository;
import com.blueharvest.repository.db.entity.repository.CustomerDetailRepository;
import com.blueharvest.repository.db.entity.repository.CustomerTransationRepository;
import com.blueharvest.repository.exception.InvalidAccountException;
import com.blueharvest.repository.utility.ConfigParams;
import com.blueharvest.repository.ws.dto.CustomerAccountRequestDTO;
import com.blueharvest.repository.ws.request.CustomerAccountRequest;

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

	public Customer_Account createSecondaryAccnt(CustomerAccountRequestDTO accountDetails) throws InvalidAccountException {
		/*
		 * Random random = new SecureRandom();
		 * accountDetails.setSecondaryAccountNumber(random.toString());
		 */

		int length = configParam.getLength();
		boolean useLetters = configParam.isAllowAlpha();
		boolean useNumbers = configParam.isAllowNums();

		logger.info("length::" + length);
		logger.info("useLetters::" + useLetters);
		logger.info("useNumbers::" + useNumbers);

		//Customer_Detail customerDetails = getCustomerDetails(accountDetails.getCustomerID(), accountDetails.getCustomerName());
		
		//String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

		
		Customer_Account customerAccount = accountRepo.findbyCustomerIDAndAccountType(accountDetails.getCustomerID(), "primary");
		
		if (accountDetails.getInitialCredit().compareTo(BigDecimal.ZERO) > 0) {
			customerAccount.setAccountBalance(customerAccount.getAccountBalance().subtract(accountDetails.getInitialCredit()));
			accountRepo.save(customerAccount);
			saveNewTransation(accountDetails);
		}

		return null;
	}

	public boolean saveNewTransation(CustomerAccountRequestDTO accountDetails) {

		logger.info("Going to Saving transation");
		transationRepository.save(new Customer_transaction());
		logger.info("Transation Saved");
		return true;
	}

	public Customer_Detail getCustomerDetails(String customerID, String customerName){
		Customer_Detail customerDetail = customerDetailRepository.findByCustomerID(customerID);
//		if(customerDetail!=null) {
//			customerDetail.getCustomerName();
//		}else {
//			throw new InvalidAccountException("Customer Not Found");
//		}
			
		return customerDetail;
	}

}
