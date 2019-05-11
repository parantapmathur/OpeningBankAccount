/**
 * 
 */
package com.blueharvest.repository.ws;

import javax.validation.Valid;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blueharvest.repository.exception.InvalidAccountException;
import com.blueharvest.repository.ws.dto.CustomerAccountRequestDTO;
import com.blueharvest.repository.ws.request.CustomerAccountRequest;

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
	public Response openSecondaryAccount(@RequestBody @Valid CustomerAccountRequest accountDetails){
		try {
			logger.info("#########Request Recived for opening Secondary Account#######");
			CustomerAccountRequestDTO requesttDTO = new CustomerAccountRequestDTO();
			BeanUtils.copyProperties(accountDetails, requesttDTO);
			boolean isEligible = helper.findEligibiltyForAccnt(requesttDTO);
			if(isEligible) {
				helper.updateAccountDetails(requesttDTO);
				
			}else {
				throw new InvalidAccountException("Invalid customer");
			}
			
		} catch (InvalidAccountException e) {
			logger.error("Custmer not registered with customer ID: " + accountDetails.getCustomerID());
		}finally {
			// any performance logging to done
		}
		return null;
	}

	@ResponseBody
	public String getRepsonse() {
		return null;

	}
}
