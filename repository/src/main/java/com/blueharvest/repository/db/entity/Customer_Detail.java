package com.blueharvest.repository.db.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Parantap Mathur
 *
 */
@Entity
@Table(name = "customer_detail")
public class Customer_Detail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "detail_id", nullable = false)
	private long detail_id;

	@Column(name = "customer_name", nullable = false)
	private String customerName;

	@Column(name = "customer_age", nullable = false,length=3)
	private String customerAge;

	@Column(name = "dateofJoining", nullable = false)
	private Timestamp dateofJoining;

	@Column(name = "timestamp", nullable = false,updatable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp timestamp;

	@Column(name = "customer_id", nullable = false)
	private String customerID;

	
//	@OneToOne
//	@JoinColumn(name = "contact_id")
//	private Contact_Detail contact_Detail;

	
	public Customer_Detail() {

	}

	/**
	 * @return the detail_id
	 */
	public long getDetail_id() {
		return detail_id;
	}

	/**
	 * @param detail_id the detail_id to set
	 */
	public void setDetail_id(long detail_id) {
		this.detail_id = detail_id;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the customerAge
	 */
	public String getCustomerAge() {
		return customerAge;
	}

	/**
	 * @param customerAge the customerAge to set
	 */
	public void setCustomerAge(String customerAge) {
		this.customerAge = customerAge;
	}

	/**
	 * @return the dateofJoining
	 */
	public Timestamp getDateofJoining() {
		return dateofJoining;
	}

	/**
	 * @param dateofJoining the dateofJoining to set
	 */
	public void setDateofJoining(Timestamp dateofJoining) {
		this.dateofJoining = dateofJoining;
	}

	/**
	 * @return the timestamp
	 */
	public Timestamp getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

//	/**
//	 * @return the contact_Detail
//	 */
//	public Contact_Detail getContact_Detail() {
//		return contact_Detail;
//	}
//
//	/**
//	 * @param contact_Detail the contact_Detail to set
//	 */
//	public void setContact_Detail(Contact_Detail contact_Detail) {
//		this.contact_Detail = contact_Detail;
//	}

	/**
	 * @return the customer_id
	 */
	public String getCustomerID() {
		return customerID;
	}

	/**
	 * @param customer_id the customer_id to set
	 */
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

}
