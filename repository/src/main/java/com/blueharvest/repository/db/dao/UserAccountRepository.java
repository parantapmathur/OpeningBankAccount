package com.blueharvest.repository.db.dao;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blueharvest.repository.db.entity.Customer_Account;

/**
 * @author Parantap Mathur
 *
 */
@Repository
public interface UserAccountRepository extends JpaRepository<Customer_Account, Long> {

	public ArrayList<Customer_Account> findByAccountNumber(String accountNumber);

	@Query("select u from Account u where u.customerID = :customerID and u.customerName = :customerName")
	//public ArrayList<Customer_Account> findbyCustomerIDAndCustomerName(@Param("customerID") String customerID,
	//		@Param("customerName") String customerName);
}
