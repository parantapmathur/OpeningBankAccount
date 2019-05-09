package com.blueharvest.repository.db.dao;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blueharvest.repository.db.entity.Account;

/**
 * @author Parantap Mathur
 *
 */
@Repository
public interface UserAccountRepository extends JpaRepository<Account, Long> {
	public ArrayList<Account> findByCustomerID(String customerID);

	public ArrayList<Account> findByCustomerName(String customerName);

	public ArrayList<Account> findByPrimaryAccountNumber(String primaryAccountNumber);

	@Query("select u from Account u where u.customerID = :customerID and u.customerName = :customerName")
	public ArrayList<Account> findbyCustomerIDAndCustomerName(@Param("customerID") String customerID,
			@Param("customerName") String customerName);
}
