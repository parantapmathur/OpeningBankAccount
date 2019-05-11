package com.blueharvest.repository.db.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.blueharvest.repository.db.entity.repository.CustomerAccountRepository;
import com.blueharvest.repository.db.entity.repository.CustomerTransationRepository;

@Component
public class UserCommandLineRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		
		/*
		 * for(Customer_Account ca:this.accountRepository.findAll()) {
		 * System.out.println("UserCommandLineRunner run() UserAccountRepository:::" +
		 * ca.toString()); }
		 * 
		 * for(Transation ca:this.transationRespository.findAll()) {
		 * System.out.println("UserCommandLineRunner run() transationRespository:::" +
		 * ca.toString()); }
		 */
		 
	}
	
//	@Autowired CustomerAccountRepository accountRepository; 
//	@Autowired CustomerTransationRepository transationRespository;
}
