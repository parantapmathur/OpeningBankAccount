package com.blueharvest.repository.db.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blueharvest.repository.db.entity.Transation;


/**
 * @author Parantap Mathur
 *
 */
@Repository
public interface UserTransationRepository extends JpaRepository<Transation, Long> { 
	public ArrayList<Transation> findByCutomerID(String customerID);
	public ArrayList<Transation> findByCustomerName(String customerName);
	public ArrayList<Transation> findByPrimaryAccountNumber(String primaryAccountNumber);
}
