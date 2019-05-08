package com.blueharvest.repository.db.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.blueharvest.repository.db.dao.UserAccountRepository;
import com.blueharvest.repository.db.dao.UserTransationRepository;
import com.blueharvest.repository.db.entity.Account;

@Component
public class DBOperation {
	
	@Autowired UserAccountRepository accountRepository;
	@Autowired UserTransationRepository transationRepository;
	
	public Account deleteAccount(Account account){
		List<Account> customerAccount = findAccountByCustomerId(account.getCutomerID());
		this.accountRepository.delete(account);
		return account;
		
	}
	
	public List<Account> findAccountByCustomerId(String CustomerId) {
		ArrayList<Account> list = this.accountRepository.findByCutomerID(CustomerId);
		return list;
	}	
	
	
	public List<Account> findAllAccounts(){
		List<Account> list = new ArrayList<>();
		this.accountRepository.findAll().forEach(e -> list.add(e));
		return list;
	}
	public String updateSecAccnt(Account account) {
		List<Account> list = findAccountByCustomerId(account.getCutomerID());
		if(list!=null && list.size()>0 && list.size()==1){
			this.accountRepository.save(account);
			return "Customer saved";
		}else if(list!=null && list.size()>1){
			return "Customer Allready have a secondary account";
		}else{
			return "Invalid Customer";
		}
		
	}
	
	
}
