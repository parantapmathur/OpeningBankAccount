/**
 * 
 */
package com.blueharvest.repository.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Parantap Mathur
 *
 */
@RestController
public class Controler {

	

     //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/openSecondaryAccount")
    CustomerAccount openSecondaryAccount(@RequestBody CustomerAccount accountDetails) {
    	
    	return ServiceHelper.initilize().createSecondaryAcc(accountDetails);
       
    }
    
    /*List<CustomerAccount> findAll(String primaryAccountNumber) {
        return repository.findAll();
                
    }*/

}
