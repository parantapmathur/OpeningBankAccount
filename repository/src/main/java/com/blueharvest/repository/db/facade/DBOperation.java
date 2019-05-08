package com.blueharvest.repository.db.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.blueharvest.repository.db.Repository.UserAccountRepository;
import com.blueharvest.repository.db.entity.Account;

@Controller
public class DBOperation {
	
	public Account updateSecAccnt(Account account) {
		return accountRepository.save(account);
		
	}
	@Autowired UserAccountRepository accountRepository;
	
}
