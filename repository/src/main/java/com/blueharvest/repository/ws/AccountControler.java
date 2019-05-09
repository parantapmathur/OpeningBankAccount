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

import com.blueharvest.repository.db.facade.DBManager;
import com.blueharvest.repository.utility.ConfigParams;

/**
 * @author Parantap Mathur
 *
 */
@RestController
public class AccountControler {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ConfigParams configParam;
	@Autowired
	DBManager dbManager;
	@Autowired
	ServiceHelper helper;

	@PostMapping("/openSecondaryAccount")
	public Response openSecondaryAccount(@RequestBody @Valid CustomerAccountRequest accountDetails) {
		try {
			logger.info("#########Request Recived for opening Secondary Account#######");
			dbManager.createSecondaryAccnt(accountDetails);
			CustomerAccountRequest response = null;
		} catch (Exception ex) {
			// error response
		} finally {
			// any performance logging to done
		}
		return null;
	}

	@ResponseBody
	public String getRepsonse() {
		return null;

	}
}
