package com.blueharvest.repository.db.facade;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blueharvest.repository.db.entity.Customer_Account;
import com.blueharvest.repository.db.entity.Customer_Detail;
import com.blueharvest.repository.db.entity.Customer_transaction;
import com.blueharvest.repository.db.entity.repository.CustomerDetailRepository;
import com.blueharvest.repository.db.entity.repository.CustomerTransationRepository;
import com.blueharvest.repository.exception.InvalidAccountException;
import com.blueharvest.repository.utility.ConfigParams;
import com.blueharvest.repository.ws.CustomerAccountRequest;

@Component
public class DBManager {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	AccountDBOperation dbOperation;
//	@Autowired
//	CustomerAccountRepository accountRepo;
	@Autowired
	CustomerTransationRepository transationRepository;
	
	@Autowired
	CustomerDetailRepository customerDetailRepository;
	@Autowired
	ConfigParams configParam;

	public DBManager() {

	}

	public Customer_Account createSecondaryAccnt(CustomerAccountRequest accountDetails) throws InvalidAccountException {
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

		Customer_Detail customerDetails = getCustomerDetails(accountDetails.getCustomerID(), accountDetails.getCustomerName());
		customerDetails.getCustomerAge();
		
		//String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

		if (accountDetails.getInitialCredit().compareTo(BigDecimal.ZERO) > 0) {
			saveTransation(accountDetails);// as per point 4
		}

		return null;
	}

	public boolean saveTransation(CustomerAccountRequest accountDetails) {

		logger.info("Going to Saving transation");
		transationRepository.save(new Customer_transaction());
		logger.info("Transation Saved");
		return true;
	}

	public Customer_Detail getCustomerDetails(String customerID, String customerName) throws InvalidAccountException {
		Customer_Detail customerDetail = customerDetailRepository.findByCustomerID(customerID);
		if(customerDetail!=null) {
			customerDetail.getCustomerName();
		}else {
			throw new InvalidAccountException("Customer Not Found");
		}
			
		return customerDetail;
	}

}
