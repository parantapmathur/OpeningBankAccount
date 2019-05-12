package com.blueharvest.repository.db.entity;

import java.math.BigDecimal;
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
@Table(name = "customer_transaction")
public class Customer_transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "transation_id", nullable = false)
	private long transationid;
	@Column(name = "description", nullable = false,length=250)
	private String description;
	@Column(name = "transaction_type", nullable = false,length=2)
	private String transaction_type;
	@Column(name = "amount_in_EUR", nullable = false)
	private BigDecimal amount_in_EUR;
	@Column(name = "TIMESTAMP", nullable = false)
	private Timestamp timeStamp=new Timestamp(System.currentTimeMillis());
	
	
	@Column(name = "account_number", nullable = false)
	private String accountNumber;
	
	@Column(name = "customer_id", nullable = false)
	private String customerID;
	
//	@ManyToOne
//	@JoinColumn(name = "customer_id",nullable=false)
//	private Customer_Detail customerDetail;
//	
//	@ManyToOne
//	@JoinColumn(name = "account_id",nullable=false)
//	private Customer_Account customerAccount;
//	

	public Customer_transaction() {

	}


	/**
	 * @return the transation_id
	 */
	public long getTransationid() {
		return transationid;
	}


	/**
	 * @param transation_id the transation_id to set
	 */
	public void setTransationid(long transationid) {
		this.transationid = transationid;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * @return the transaction_type
	 */
	public String getTransaction_type() {
		return transaction_type;
	}


	/**
	 * @param transaction_type the transaction_type to set
	 */
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}


	/**
	 * @return the amount_in_EUR
	 */
	public BigDecimal getAmount_in_EUR() {
		return amount_in_EUR;
	}


	/**
	 * @param amount_in_EUR the amount_in_EUR to set
	 */
	public void setAmount_in_EUR(BigDecimal amount_in_EUR) {
		this.amount_in_EUR = amount_in_EUR;
	}


	/**
	 * @return the timeStamp
	 */
	public Timestamp getTimeStamp() {
		return timeStamp;
	}


	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}


	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}


	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	/**
	 * @return the customerID
	 */
	public String getCustomerID() {
		return customerID;
	}


	/**
	 * @param customerID the customerID to set
	 */
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	
	

//
//	/**
//	 * @return the customerDetail
//	 */
//	public Customer_Detail getCustomerDetail() {
//		return customerDetail;
//	}
//
//
//	/**
//	 * @param customerDetail the customerDetail to set
//	 */
//	public void setCustomerDetail(Customer_Detail customerDetail) {
//		this.customerDetail = customerDetail;
//	}
//
//
//	/**
//	 * @return the customerAccount
//	 */
//	public Customer_Account getCustomerAccount() {
//		return customerAccount;
//	}
//
//
//	/**
//	 * @param customerAccount the customerAccount to set
//	 */
//	public void setCustomerAccount(Customer_Account customerAccount) {
//		this.customerAccount = customerAccount;
//	}


	
}
