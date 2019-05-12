/**
 * 
 */
package com.blueharvest.account.ws;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.blueharvest.account.client.CustomerAccountRequest;
import com.blueharvest.account.client.CustomerAccountResponse;
import com.blueharvest.account.util.ConfigParams;
import com.blueharvest.account.ws.request.CreateAccountRequest;

import io.micrometer.core.instrument.util.StringUtils;

/**
 * @author Parantap Mathur
 *
 */
@Controller
public class CreateAccountControl {
	
	@Autowired ConfigParams configParam;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	
	@GetMapping("/openAccount")
    public String openAccountForm(Model model) {
        model.addAttribute("createAccountRequest", new CreateAccountRequest());
        model.addAttribute("result", new CustomerAccountResponse());
        return "createAccountRequest";
    }
	
	@PostMapping("/openAccount")
    public String openAccountSubmit(@ModelAttribute CreateAccountRequest createAccountRequest) {
       
		logger.debug("Inside---- openAccountSubmit");

		logger.debug("requestRecived:::: "+createAccountRequest.toString());
		
		RestTemplate restTemplate = new RestTemplate();
		
		String uri = configParam.getOpenAccountURL();
		CustomerAccountRequest accountRequest=new CustomerAccountRequest();
		BeanUtils.copyProperties(createAccountRequest, accountRequest);
		
		CustomerAccountResponse result = restTemplate.postForObject(uri ,accountRequest, CustomerAccountResponse.class);
		
		
		logger.debug("result:"+result.toString());
		//return result;
		return "hello";
    }
	
//	@PostMapping(value="/openCurrentAccount")
//	public CreateAccountRequest openSecondaryAccount(@RequestBody CreateAccountRequest request) {
//		
//		logger.debug("requestRecived:::: "+request.toString());
//		
//		RestTemplate restTemplate = new RestTemplate();
//		
//		String uri = configParam.getOpenAccountURL();
//		String result = restTemplate.getForObject(uri , String.class);
//		logger.debug(result);
//		return request;
//		
//	}
	
	
	

}
