package com.blueharvest.repository.ws;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blueharvest.repository.db.dto.AccountDTO;
import com.blueharvest.repository.db.facade.DBManager;
import com.blueharvest.repository.utility.ConfigParams;

@Component
public class ServiceHelper {

	@Autowired
	ConfigParams configParam;
	@Autowired
	DBManager dbManager;
	public <Account> boolean findEligibiltyForAccnt(@Valid CustomerAccountRequest accountDetails) {

		ArrayList<AccountDTO> accountDTOList = dbManager.getAccountDetails(accountDetails.getCustomerID(),accountDetails.getCustomerName());
		return false;
	}
	public void updateAccountDetails(@Valid CustomerAccountRequest accountDetails) {

		dbManager.createSecondaryAccnt(accountDetails);
	}
	
	
}
