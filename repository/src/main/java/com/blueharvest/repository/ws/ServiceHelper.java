package com.blueharvest.repository.ws;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class ServiceHelper {

	public void findEligibiltyForAccnt(@Valid CustomerAccountRequest accountDetails) {
		BigDecimal creditAmt = accountDetails.getInitialCredit();
	}
	
	
}
