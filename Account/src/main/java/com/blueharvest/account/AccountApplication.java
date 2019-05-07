package com.blueharvest.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author Parantap Mathur
 *
 */
@SpringBootApplication
@EnableSwagger2
public class AccountApplication {

	public static void main(String[] args) {
		System.out.println("Balle balles");		
		SpringApplication.run(AccountApplication.class, args);
	}

}
