/**
 * 
 */
package com.blueharvest.repository.ws;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.blueharvest.repository.db.dao.UserAccountRepository;
import com.blueharvest.repository.db.entity.Account;
import com.blueharvest.repository.db.facade.DBManager;
import com.blueharvest.repository.utility.ConfigParams;

/**
 * @author Parantap Mathur
 *
 */
@RestController
public class Controler {

	@Autowired ConfigParams configParam;
	@Autowired DBManager dbManager;
     //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/openSecondaryAccount")
    public CustomerAccountRequest openSecondaryAccount(@RequestBody CustomerAccountRequest accountDetails) {
    	
    	//return ServiceHelper.initilize().createSecondaryAcc(accountDetails);
		
    	System.out.println("@@@@@@@@@@@@--------"+configParam.getLength());
		Account account = dbManager.createSecondaryAcc(accountDetails);
		//accountRepository.save(account);
    	CustomerAccountRequest response = new CustomerAccountRequest(account.getCutomerID(), account.getCustomerName(),
				account.getCustomerAge(), account.getSecondaryAccountNumber(), account.getPrimaryAccountNumber());
       return response;
    }
    
   
    
    
    /*List<CustomerAccount> findAll(String primaryAccountNumber) {
        return repository.findAll();
                
    }*/

}
