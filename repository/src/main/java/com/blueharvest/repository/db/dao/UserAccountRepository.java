package com.blueharvest.repository.db.dao;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blueharvest.repository.db.entity.Account;


/**
 * @author Parantap Mathur
 *
 */
@Repository
public interface UserAccountRepository extends JpaRepository<Account, Long> { 
	public ArrayList<Account> findByCutomerID(String customerID);
	public ArrayList<Account> findByCustomerName(String customerName);
	public ArrayList<Account> findByPrimaryAccountNumber(String primaryAccountNumber);
}
