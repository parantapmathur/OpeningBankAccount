package com.blueharvest.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.blueharvest.account.ws.CreateAccountRequest;

@SpringBootApplication
public class AccountApplication {

	public static void main(String[] args) {
		System.out.println("Balle balles");		
		SpringApplication.run(AccountApplication.class, args);
	}

}
