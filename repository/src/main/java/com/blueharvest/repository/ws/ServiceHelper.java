package com.blueharvest.repository.ws;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blueharvest.repository.db.entity.Customer_Detail;
import com.blueharvest.repository.db.facade.DBManager;
import com.blueharvest.repository.exception.InsufficientBalanceException;
import com.blueharvest.repository.exception.InvalidAccountException;
import com.blueharvest.repository.exception.util.InsufficientBalanceExceptionMapper;
import com.blueharvest.repository.exception.util.InvalidAccountExceptionMapper;
import com.blueharvest.repository.exception.util.ReposityServiceExceptionMapper;
import com.blueharvest.repository.utility.ConfigParams;
import com.blueharvest.repository.ws.dto.CustomerAccountRequestDTO;

@Component
public class ServiceHelper {

	@Autowired
	ConfigParams configParam;
	@Autowired
	DBManager dbManager;

	public boolean findEligibiltyForAccnt(CustomerAccountRequestDTO requesttDTO) {
		Customer_Detail customerDetail = dbManager.getCustomerDetails(requesttDTO.getCustomerID(),
				requesttDTO.getCustomerName());
		if (customerDetail != null) {
			return true;
		}
		return false; 
	}

	public void updateAccountDetails(CustomerAccountRequestDTO accountDetails) throws InvalidAccountException {

		accountDetails.getCustomerID();
		accountDetails.getCustomerName();
		accountDetails.getCurrency();
		accountDetails.getInitialCredit();
		
		dbManager.createSecondaryAccnt(accountDetails);
	}
	
	
	public static Response handleExceptions(RuntimeException ex) {
		Response response = null;
		if (null != ex) {
			if (ex instanceof InsufficientBalanceException) {
				response = new InsufficientBalanceExceptionMapper()
						.toResponse((InsufficientBalanceException) ex);
			} else if (ex instanceof InvalidAccountException) {
				response = new InvalidAccountExceptionMapper()
						.toResponse((InvalidAccountException) ex);
			} else {
				response = new ReposityServiceExceptionMapper()
						.toResponse(ex);
			}
		}
		return response;
	}

}
