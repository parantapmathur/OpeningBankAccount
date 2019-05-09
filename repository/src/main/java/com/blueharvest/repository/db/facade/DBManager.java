package com.blueharvest.repository.db.facade;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blueharvest.repository.db.entity.Account;
import com.blueharvest.repository.utility.ConfigParams;
import com.blueharvest.repository.ws.CustomerAccountRequest;


@Component
public class DBManager {
	
	@Autowired DBOperation dbOperation;
	@Autowired ConfigParams configParam;
	
	//private static DBManager dbManager;
	
	public DBManager() {

	}

//	public static DBManager initilize() {
//
//		if (dbManager == null) {
//			synchronized (DBManager.class) {
//				if (dbManager == null) {
//					dbManager = new DBManager();
//				}
//			}
//		}
//		return dbManager;
//	}
	
	
	public Account createSecondaryAcc(CustomerAccountRequest accountDetails){
		/* Random random = new SecureRandom();
		accountDetails.setSecondaryAccountNumber(random.toString());*/
		
		int length = configParam.getLength();//80;//getAccountNumLength();
	    boolean useLetters = configParam.isAllowAlpha();//true;//utility.useLetters();
	    boolean useNumbers = configParam.isAllowNums();//true;//utility.useNumbers();
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		
		System.out.println("length::"+length);
		System.out.println("useLetters::"+useLetters);
		System.out.println("useNumbers::"+useNumbers);
		
		accountDetails.setSecondaryAccountNumber(generatedString);
		Account account = new Account(accountDetails.getCutomerID(), accountDetails.getCustomerName(),
				accountDetails.getCustomerAge(), accountDetails.getSecondaryAccountNumber(),
				accountDetails.getPrimaryAccountNumber());
		
		//DBOperation dbo = new DBOperation();
		//account = dbo.deleteAccount(account);
		List<Account> fromDB = dbOperation.findAccountByCustomerId(account.getCutomerID());
		System.out.println("DBManager fromDB::" + fromDB);
		CustomerAccountRequest response = new CustomerAccountRequest(account.getCutomerID(), account.getCustomerName(),
				account.getCustomerAge(), account.getSecondaryAccountNumber(), account.getPrimaryAccountNumber());
		return account;
	}
	

}
