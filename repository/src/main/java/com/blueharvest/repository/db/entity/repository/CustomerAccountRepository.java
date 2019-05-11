package com.blueharvest.repository.db.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blueharvest.repository.db.entity.Customer_Account;
import java.lang.String;

/**
 * @author Parantap Mathur
 *
 */
@Repository
public interface CustomerAccountRepository extends JpaRepository<Customer_Account, Long> {

	public List<Customer_Account> findByAccountNumber(String accountNumber);
	public List<Customer_Account> findByCustomerID(String customerid);
	List<Customer_Account> findByAccountType(String accounttype);
	
//	@Query("select u from Customer_Account_Details u where u.customer_id = :customer_id and u.account_type = :account_type")
//	public ArrayList<Customer_Account> findbyCustomerIDAndAccountType(@Param("customer_id") String customerID,
//			@Param("account_type") String accounttype);
	
//	@Query("select u from Customer_Account_Details u where u.customerID = :customerID and u.customerName = :customerName")
//	public ArrayList<Customer_Account> findbyCustomerIDAndCustomerName(@Param("customerID") String customerID,
//			@Param("customerName") String customerName);
}
