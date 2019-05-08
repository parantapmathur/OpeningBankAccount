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

import com.blueharvest.repository.db.Repository.UserAccountRepository;
import com.blueharvest.repository.db.entity.Account;
import com.blueharvest.repository.db.facade.DBManager;

/**
 * @author Parantap Mathur
 *
 */
@RestController
public class Controler {

	@Autowired UserAccountRepository accountRepository;

     //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/openSecondaryAccount")
    public CustomerAccount openSecondaryAccount(@RequestBody CustomerAccount accountDetails) {
    	
    	//return ServiceHelper.initilize().createSecondaryAcc(accountDetails);
		
    	new DBManager();
		Account account = DBManager.initilize().createSecondaryAcc(accountDetails);
		//accountRepository.save(account);
    	CustomerAccount response = new CustomerAccount(account.getCutomerID(), account.getCustomerName(),
				account.getCustomerAge(), account.getSecondaryAccountNumber(), account.getPrimaryAccountNumber());
       return response;
    }
    
    @GetMapping("/getall")
    public Collection<Account> getAllEntries() {
    	return accountRepository.findAll();
    }
    
    
    /*List<CustomerAccount> findAll(String primaryAccountNumber) {
        return repository.findAll();
                
    }*/

}
