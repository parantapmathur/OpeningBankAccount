package com.blueharvest.repository.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blueharvest.repository.db.entity.Customer_Detail;
import com.blueharvest.repository.db.facade.DBManager;
import com.blueharvest.repository.exception.InvalidAccountException;
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

}
