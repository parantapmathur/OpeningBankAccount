/**
 * 
 */
package com.blueharvest.account.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.blueharvest.account.util.ConfigParams;
import com.blueharvest.account.ws.request.CreateAccountRequest;

/**
 * @author Parantap Mathur
 *
 */
@RestController
public class CreateAccountControl {
	
	@Autowired ConfigParams configParam;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@PostMapping(value="/openCurrentAccount")
	public CreateAccountRequest secondaryCurrentAccount(@RequestBody CreateAccountRequest request) {
		
		System.out.println("requestRecived:::: "+request.toString());
		
		RestTemplate restTemplate = new RestTemplate();
		
		String uri = configParam.getOpenAccountURL();
		String result = restTemplate.getForObject(uri , String.class);
		logger.debug(result);
		return request;
		
	}

}
