/**
 * 
 */
package com.blueharvest.transaction.ws;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blueharvest.transaction.ws.dao.TransactionDAO;

/**
 * @author Parantap Mathur
 *
 */

@RestController
public class TransactionWS {

	@GetMapping(value="/findAllTransations")
	public List<TransactionDAO> getAllTransactions(){
		
		return null;
	}
}
