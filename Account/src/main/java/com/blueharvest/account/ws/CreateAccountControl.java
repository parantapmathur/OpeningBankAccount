/**
 * 
 */
package com.blueharvest.account.ws;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author paran
 *
 */
@RestController

public class CreateAccountControl {
	
	@PostMapping(value="/getSecondaryCurrentAccount")
	public /*javax.ws.rs.core.Response */ String secondaryCurrentAccount(CreateAccountRequest request) {
		
		System.out.println("requestRecived:::: "+request.toString());
		
		return "Message Sent";
		
	}

}
