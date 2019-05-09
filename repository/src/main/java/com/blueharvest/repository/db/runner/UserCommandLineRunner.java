package com.blueharvest.repository.db.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.blueharvest.repository.db.dao.UserAccountRepository;
import com.blueharvest.repository.db.dao.UserTransationRepository;
import com.blueharvest.repository.db.entity.Customer_Account;
import com.blueharvest.repository.db.entity.Transation;

@Component
public class UserCommandLineRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		
		  for(Customer_Account ca:this.accountRepository.findAll()) {
			 System.out.println("UserCommandLineRunner run() UserAccountRepository:::" + ca.toString());
		  }
		  
		  for(Transation ca:this.transationRespository.findAll()) {
				 System.out.println("UserCommandLineRunner run() transationRespository:::" + ca.toString());
		  }
		 
	}
	
	@Autowired UserAccountRepository accountRepository; 
	@Autowired UserTransationRepository transationRespository;
}
