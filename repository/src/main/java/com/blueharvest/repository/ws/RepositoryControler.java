/**
 * 
 */
package com.blueharvest.repository.ws;

import javax.validation.Valid;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blueharvest.repository.exception.AccountEligibiltyException;
import com.blueharvest.repository.exception.InvalidAccountException;

/**
 * @author Parantap Mathur
 *
 */
@RestController
public class RepositoryControler {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ServiceHelper helper;

	@PostMapping("/openSecondaryAccount")
	public Response openSecondaryAccount(@RequestBody @Valid CustomerAccountRequest accountDetails) throws AccountEligibiltyException {
		try {
			logger.info("#########Request Recived for opening Secondary Account#######");
			boolean isEligible = helper.findEligibiltyForAccnt(accountDetails);
			if(isEligible) {
				helper.updateAccountDetails(accountDetails);
			}else {
				throw new AccountEligibiltyException("Account not Eligible to open ");
			}
			CustomerAccountRequest response = null;
			
		} /*
			 * catch (ReposityServiceException ex) { // error response }
			 */ catch (InvalidAccountException e) {
				 logger.error("Custmer not registered with customer ID: " + accountDetails.getCustomerID());
			}/*
				 * catch (AccountEligibiltyException e) { // TODO Auto-generated catch block
				 * e.printStackTrace(); }
				 */ finally {
			// any performance logging to done
		}
		return null;
	}

	@ResponseBody
	public String getRepsonse() {
		return null;

	}
}
