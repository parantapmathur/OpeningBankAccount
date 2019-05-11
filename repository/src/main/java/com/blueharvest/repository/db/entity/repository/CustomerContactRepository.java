package com.blueharvest.repository.db.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blueharvest.repository.db.entity.Customer_Detail;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Parantap Mathur
 *
 */
@Repository
public interface CustomerContactRepository extends JpaRepository<Customer_Detail, Long> { 

	public List<Customer_Detail> findByCustomerID(String customerid);
//	@Query("select u from Customer_Detail u where u.customer_id = :customer_id and u.customer_name = :customer_name")
//	public ArrayList<Customer_Detail> findbyCustomerIDAndCustomerName(@Param("customer_id") String customerID,
//			@Param("customer_name") String customerName);
}
