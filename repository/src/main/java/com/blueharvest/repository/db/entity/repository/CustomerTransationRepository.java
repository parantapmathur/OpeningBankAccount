package com.blueharvest.repository.db.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blueharvest.repository.db.entity.Customer_transaction;
import java.lang.String;


/**
 * @author Parantap Mathur
 *
 */
@Repository
public interface CustomerTransationRepository extends JpaRepository<Customer_transaction, Long> { 

	public List<Customer_transaction> findByAccountNumber(String accountnumber);
	public List<Customer_transaction> findByCustomerID(String customerid);
}
