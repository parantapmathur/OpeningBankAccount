/**
 * 
 */
package com.blueharvest.repository.ws;

import java.util.ArrayList;

import javax.validation.Valid;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blueharvest.repository.db.entity.dto.CustomerAccountDTO;
import com.blueharvest.repository.exception.InvalidAccountException;
import com.blueharvest.repository.ws.dto.CustomerAccountRequestDTO;
import com.blueharvest.repository.ws.dto.TransactionDAO;
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

	@PostMapping(path="/openSecondaryAccount",consumes = "application/json", produces = "application/json")
	public Response openSecondaryAccount(@RequestBody @Valid CustomerAccountRequest accountDetails){
		Response response = null;
		long startMili = System.currentTimeMillis();
		try {
			logger.info("#########Request Recived for opening Secondary Account#######");
			CustomerAccountRequestDTO requesttDTO = new CustomerAccountRequestDTO();
			BeanUtils.copyProperties(accountDetails, requesttDTO);
			boolean isEligible = helper.findEligibiltyForAccnt(requesttDTO);
			if(isEligible) {
				CustomerAccountDTO responseDto = helper.updateAccountDetails(requesttDTO);
				if(responseDto!=null) {
					return getRepsonse(responseDto);
				}
			}else {
				throw new InvalidAccountException("Invalid customer");
			}
			
		} catch (Exception ex) {
			logger.error("Custmer not registered with customer ID: " + accountDetails.getCustomerID());
			response = helper.handleExceptions(ex);
		}finally {
			long totalTime = System.currentTimeMillis() - startMili;
			logger.debug("Total Time take to exceute the service: " + totalTime + " miliseconds");
		}
		return response;
	}

	@ResponseBody
	public Response getRepsonse(CustomerAccountDTO responseDto) {
		return Response.status(Status.ACCEPTED)
				.entity(responseDto)
				.type(MediaType.APPLICATION_JSON_TYPE).build();

	}
	
	
	@GetMapping(path="/getAllTransation",produces = "application/json")
	public ArrayList<TransactionDAO> getAllTransation() {

		//Response responseDto = null;
		ArrayList<TransactionDAO> transationList = null;
		try {
			transationList = helper.findAllTransations();
			/*
			 * responseDto =
			 * Response.status(Status.ACCEPTED).entity(transationList).type(MediaType.
			 * APPLICATION_JSON_TYPE) .build();
			 */
		} catch (Exception ex) {
			//responseDto = helper.handleExceptions(ex);
		}
		return transationList;
	}
}
