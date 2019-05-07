package com.blueharvest.repository.controler;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Parantap Mathur
 *
 */
@Service//@Component
public class ServiceHelper {

	@Autowired
    private UserAccountRepository repository;
	
	private static ServiceHelper serviceHelper;
	
	private Utility utility = new Utility();

	private ServiceHelper() {

	}

	public static ServiceHelper initilize() {

		if (serviceHelper == null) {
			synchronized (ServiceHelper.class) {
				if (serviceHelper == null) {
					serviceHelper = new ServiceHelper();
				}
			}
		}
		return serviceHelper;
	}
	
	
	public CustomerAccount createSecondaryAcc(CustomerAccount accountDetails){
		/* Random random = new SecureRandom();
		accountDetails.setSecondaryAccountNumber(random.toString());*/
		
		int length = utility.getAccountNumLength();
	    boolean useLetters = true;//utility.useLetters();
	    boolean useNumbers = true;//utility.useNumbers();
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		
		System.out.println("length::"+length);
		System.out.println("useLetters::"+useLetters);
		System.out.println("useNumbers::"+useNumbers);
		
		accountDetails.setSecondaryAccountNumber(generatedString);
		return repository.save(accountDetails);
	}
	
	
}
