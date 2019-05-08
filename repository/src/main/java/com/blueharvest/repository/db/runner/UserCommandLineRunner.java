package com.blueharvest.repository.db.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.blueharvest.repository.db.Repository.UserAccountRepository;
import com.blueharvest.repository.db.entity.Account;

@Component
public class UserCommandLineRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		
		  for(Account ca:this.accountRepository.findAll()) {
			  System.out.println(ca.toString()); 
		  }
		 
	}
	
	@Autowired UserAccountRepository accountRepository; 
}
