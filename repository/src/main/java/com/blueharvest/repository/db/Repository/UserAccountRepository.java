package com.blueharvest.repository.db.Repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blueharvest.repository.db.entity.Account;



/**
 * @author Parantap Mathur
 *
 */

public interface UserAccountRepository extends JpaRepository<Account, Long> { 
	
	Collection<Account>	cutomerID(String customerID);
}
