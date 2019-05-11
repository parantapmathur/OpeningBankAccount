package com.blueharvest.repository.db.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blueharvest.repository.db.entity.Contact_Detail;
import com.blueharvest.repository.db.entity.Customer_Detail;


/**
 * @author Parantap Mathur
 *
 */
@Repository
public interface CustomerDetailRepository extends JpaRepository<Customer_Detail, Long> { 

public Customer_Detail findByCustomerID(String customerID);
}
