package com.blueharvest.repository.db.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

	@Column(name = "customer_Name", nullable = false)
	private String customer_Name;

	@Column(name = "customer_Age", nullable = false)
	private String customer_Age;

	@Column(name = "dateofJoining", nullable = false)
	private int dateofJoining;

	@Column(name = "timestamp", nullable = true)
	private String timestamp;

	@OneToOne
	@JoinColumn(name = "contact_id")
	private Contact_Detail contact_Detail;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer_id")
	private Set<Customer_transaction> statt = new HashSet<Customer_transaction>();

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
	 * @return the customer_Name
	 */
	public String getCustomer_Name() {
		return customer_Name;
	}

	/**
	 * @param customer_Name the customer_Name to set
	 */
	public void setCustomer_Name(String customer_Name) {
		this.customer_Name = customer_Name;
	}

	/**
	 * @return the customer_Age
	 */
	public String getCustomer_Age() {
		return customer_Age;
	}

	/**
	 * @param customer_Age the customer_Age to set
	 */
	public void setCustomer_Age(String customer_Age) {
		this.customer_Age = customer_Age;
	}

	/**
	 * @return the dateofJoining
	 */
	public int getDateofJoining() {
		return dateofJoining;
	}

	/**
	 * @param dateofJoining the dateofJoining to set
	 */
	public void setDateofJoining(int dateofJoining) {
		this.dateofJoining = dateofJoining;
	}

	/**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the contact_Detail
	 */
	public Contact_Detail getContact_Detail() {
		return contact_Detail;
	}

	/**
	 * @param contact_Detail the contact_Detail to set
	 */
	public void setContact_Detail(Contact_Detail contact_Detail) {
		this.contact_Detail = contact_Detail;
	}

}
