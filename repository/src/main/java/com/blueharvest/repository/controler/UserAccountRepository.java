package com.blueharvest.repository.controler;

import org.springframework.data.jpa.repository.JpaRepository;



/**
 * @author Parantap Mathur
 *
 */

public interface UserAccountRepository extends JpaRepository<CustomerAccount, Long> { 
	
}
