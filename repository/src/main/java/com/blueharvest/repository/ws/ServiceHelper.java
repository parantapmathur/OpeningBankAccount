package com.blueharvest.repository.ws;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blueharvest.repository.db.entity.Customer_Detail;
import com.blueharvest.repository.db.facade.DBManager;
import com.blueharvest.repository.exception.InvalidAccountException;
import com.blueharvest.repository.utility.ConfigParams;

@Component
public class ServiceHelper {

	@Autowired
	ConfigParams configParam;
	@Autowired
	DBManager dbManager;

	public <Account> boolean findEligibiltyForAccnt(@Valid CustomerAccountRequest accountDetails)
			throws InvalidAccountException {
		Customer_Detail customerDetail = dbManager.getCustomerDetails(accountDetails.getCustomerID(),
				accountDetails.getCustomerName());
		if (customerDetail != null) {
			return true;
		} else {
			return false;
		}
	}

	public void updateAccountDetails(@Valid CustomerAccountRequest accountDetails) throws InvalidAccountException {

		dbManager.createSecondaryAccnt(accountDetails);
	}

}
