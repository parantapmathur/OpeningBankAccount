/**
 * 
 */
package com.blueharvest.account.ws;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Parantap Mathur
 *
 */
@RestController

public class CreateAccountControl {
	
	@PostMapping(value="/openCurrentAccount")
	public CreateAccountRequest secondaryCurrentAccount(@RequestBody CreateAccountRequest request) {
		
		System.out.println("requestRecived:::: "+request.toString());
		
		return request;
		
	}

}
