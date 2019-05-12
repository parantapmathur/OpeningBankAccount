/**
 * 
 */
package com.blueharvest.transaction.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.blueharvest.transaction.utils.ConfigParams;
import com.blueharvest.transaction.ws.dao.TransactionDAO;

/**
 * @author Parantap Mathur
 *
 */

@RestController
public class TransactionWS {

	@Autowired ConfigParams configParam;
	
	@GetMapping(value="/findAllTransations")
	public List<TransactionDAO> getAllTransactions(){
		RestTemplate restTemplate = new RestTemplate();
		
		String uri = configParam.getTransationURL();
		
		ResponseEntity<List<TransactionDAO>> result = restTemplate.exchange(uri,  HttpMethod.GET,
				  null,
				  new ParameterizedTypeReference<List<TransactionDAO>>(){});
		
		List<TransactionDAO> list = result.getBody();
		return list;
	}
}
