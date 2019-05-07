package com.blueharvest.repository.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class UserCommandLineRunner implements CommandLineRunner{

	@Autowired
	private UserAccountRepository repository;
	@Override
	public void run(String... args) throws Exception {
		repository.save(new CustomerAccount("param01", "param", 23, null, "param01PrimaryAcct"));
		repository.save(new CustomerAccount("param02", "paran", 24, null, "param02PrimaryAcct"));
	}
	
	@Bean
    CommandLineRunner initDatabase(UserAccountRepository repository) {
        return args -> {
        	repository.save(new CustomerAccount("param03", "param", 23, null, "param03PrimaryAcct"));
    		repository.save(new CustomerAccount("param04", "paran", 24, null, "param04PrimaryAcct"));
        };
    }
}
