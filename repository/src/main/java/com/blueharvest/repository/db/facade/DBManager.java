package com.blueharvest.repository.db.facade;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.blueharvest.repository.db.entity.Account;
import com.blueharvest.repository.utility.ConfigParams;
import com.blueharvest.repository.ws.CustomerAccountRequest;


@Component
public class DBManager {
	
	@Autowired DBOperation dbOperation;
	@Autowired ConfigParams configParam;
	
	public DBManager() {

	}
	
	public Account createSecondaryAcc(CustomerAccountRequest accountDetails){
		/* Random random = new SecureRandom();
		accountDetails.setSecondaryAccountNumber(random.toString());*/
		
		int length = configParam.getLength();
	    boolean useLetters = configParam.isAllowAlpha();
	    boolean useNumbers = configParam.isAllowNums();
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		
		System.out.println("length::"+length);
		System.out.println("useLetters::"+useLetters);
		System.out.println("useNumbers::"+useNumbers);
		
		accountDetails.setSecondaryAccountNumber(generatedString);
		Account account = new Account(accountDetails.getCutomerID(), accountDetails.getCustomerName(),
				accountDetails.getCustomerAge(), accountDetails.getSecondaryAccountNumber(),
				accountDetails.getPrimaryAccountNumber());
		
		List<Account> fromDB = dbOperation.findAccountByCustomerId(account.getCutomerID());
		System.out.println("DBManager fromDB::" + fromDB);
		
		if(CollectionUtils.isEmpty(fromDB)){
			
		}
		
		CustomerAccountRequest response = new CustomerAccountRequest(account.getCutomerID(), account.getCustomerName(),
				account.getCustomerAge(), account.getSecondaryAccountNumber(), account.getPrimaryAccountNumber());
		return account;
	}
	

}
