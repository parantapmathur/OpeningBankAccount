package com.blueharvest.repository.db.entity.repository;

import java.util.List;

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
public interface CustomerAccountRepository extends JpaRepository<Customer_Account, Long> {

	public List<Customer_Account> findByAccountNumber(String accountNumber);
	public List<Customer_Account> findByCustomerID(String customerid);
	List<Customer_Account> findByAccountType(String accounttype);
	
	@Query("select u from Customer_Account u where u.customerID = :customerID and u.accountType = :accountType")
	public Customer_Account findbyCustomerIDAndAccountType(@Param("customerID") String customerID,
			@Param("accountType") String accounttype);
	
	@Query("select u from Customer_Account u where u.customerID = :customerID and u.accountDescription = :accountDescription")
	public List<Customer_Account> findbyCustomerIDAndAccountDesc(@Param("customerID") String customerID,
			@Param("accountDescription") String accountDescription);
}
