package com.blueharvest.repository.db.facade;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.blueharvest.repository.db.Repository.UserAccountRepository;
import com.blueharvest.repository.db.entity.Account;
import com.blueharvest.repository.ws.CustomerAccount;

public class DBManager {

	private static DBManager dbManager;

	public DBManager() {

	}

	public static DBManager initilize() {

		if (dbManager == null) {
			synchronized (DBManager.class) {
				if (dbManager == null) {
					dbManager = new DBManager();
				}
			}
		}
		return dbManager;
	}
	
	
	public Account createSecondaryAcc(CustomerAccount accountDetails){
		/* Random random = new SecureRandom();
		accountDetails.setSecondaryAccountNumber(random.toString());*/
		
		int length = 80;//utility.getAccountNumLength();
	    boolean useLetters = true;//utility.useLetters();
	    boolean useNumbers = true;//utility.useNumbers();
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		
		System.out.println("length::"+length);
		System.out.println("useLetters::"+useLetters);
		System.out.println("useNumbers::"+useNumbers);
		
		accountDetails.setSecondaryAccountNumber(generatedString);
		Account account = new Account(accountDetails.getCutomerID(), accountDetails.getCustomerName(),
				accountDetails.getCustomerAge(), accountDetails.getSecondaryAccountNumber(),
				accountDetails.getPrimaryAccountNumber());
		
		DBOperation dbo = new DBOperation();
		//account = dbo.updateSecAccnt(account);
		
		CustomerAccount response = new CustomerAccount(account.getCutomerID(), account.getCustomerName(),
				account.getCustomerAge(), account.getSecondaryAccountNumber(), account.getPrimaryAccountNumber());
		return account;
	}
	

}
