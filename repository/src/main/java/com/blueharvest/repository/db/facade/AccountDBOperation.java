package com.blueharvest.repository.db.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blueharvest.repository.db.entity.repository.CustomerAccountRepository;

@Component
public class AccountDBOperation {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//@Autowired CustomerAccountRepository accountRepository;
	
	/**
	 * 
	 * @param account
	 * 
	 */
	/*
	 * public String updateSecAccnt(Customer_Account account) {
	 * 
	 * List<Customer_Account> list =
	 * accountRepository.findbyCustomerIDAndCustomerName(account.getCustomerID(),
	 * account.getCustomerName()); //List<Account> list =
	 * accountRepository.findByCutomerID(account.getCutomerID()); if(list!=null &&
	 * list.size()>0 && list.size()==1){ Customer_Account savedAccount =
	 * list.get(0);
	 * savedAccount.setSecondaryAccountNumber(account.getSecondaryAccountNumber());
	 * this.accountRepository.save(savedAccount); return "Account Created"; }else
	 * if(list!=null && list.size()>1){ return
	 * "Customer Already have a secondary account"; }else{ return
	 * "Invalid Customer"; } }
	 */
	
	
}
