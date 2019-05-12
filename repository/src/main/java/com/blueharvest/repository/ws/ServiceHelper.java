package com.blueharvest.repository.ws;

import java.util.ArrayList;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blueharvest.repository.db.entity.Customer_Detail;
import com.blueharvest.repository.db.entity.dto.CustomerAccountDTO;
import com.blueharvest.repository.db.facade.DBManager;
import com.blueharvest.repository.exception.InsufficientBalanceException;
import com.blueharvest.repository.exception.InvalidAccountException;
import com.blueharvest.repository.exception.WaitTimeOutException;
import com.blueharvest.repository.exception.util.InsufficientBalanceExceptionMapper;
import com.blueharvest.repository.exception.util.InvalidAccountExceptionMapper;
import com.blueharvest.repository.exception.util.ReposityServiceExceptionMapper;
import com.blueharvest.repository.exception.util.WaitTimeOutExceptionMapper;
import com.blueharvest.repository.utility.ConfigParams;
import com.blueharvest.repository.ws.dto.CustomerAccountRequestDTO;
import com.blueharvest.repository.ws.dto.TransactionDAO;

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

	public CustomerAccountDTO updateAccountDetails(CustomerAccountRequestDTO accountDetails) throws InvalidAccountException {

		CustomerAccountDTO secondaryAccntDTO = dbManager.createSecondaryAccnt(accountDetails);

		return secondaryAccntDTO;
		
	}
	
	
	public Response handleExceptions(Exception ex) {
		Response response = null;
		if (null != ex) {
			if (ex instanceof InsufficientBalanceException) {
				response = new InsufficientBalanceExceptionMapper()
						.toResponse((InsufficientBalanceException) ex);
			} else if (ex instanceof InvalidAccountException) {
				response = new InvalidAccountExceptionMapper()
						.toResponse((InvalidAccountException) ex);
			} else if (ex instanceof WaitTimeOutException) {
				response = new WaitTimeOutExceptionMapper()
						.toResponse((WaitTimeOutException) ex);
			} else {
				response = new ReposityServiceExceptionMapper()
						.toResponse(ex);
			}
		}
		return response;
	}

	public ArrayList<TransactionDAO> findAllTransations() {
		ArrayList<TransactionDAO> daoList = dbManager.getAllTransation();
		
		return daoList;
	}

}
