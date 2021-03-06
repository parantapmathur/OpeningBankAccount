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
@Table(name = "customer_account_details")
public class Customer_Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "account_id", nullable = false)
	private long accountID;
	
	@Column(name = "account_type", nullable = false,length=20)
	private String accountType;
	
	@Column(name = "account_number", nullable = false,length=20)
	private String accountNumber;
	
	@Column(name = "account_branch", nullable = false,length=20)
	private String accountBranch;
	
	@Column(name = "account_description", nullable = false,length=100)
	private String accountDescription;
	
	@Column(name = "timestamp", nullable = false, updatable = false)
	private Timestamp timestamp;
	
	@Column(name = "account_balance", nullable = false)
	private BigDecimal accountBalance = BigDecimal.ZERO;
	
	@Column(name = "isEditable", nullable = false)
	private boolean isEditable = true;
	
	

//	@ManyToOne
//	@JoinColumn(name = "customer_id", nullable = false)
//	private Customer_Detail customerDetail;

	/**
	 * @return the isEditable
	 */
	public boolean isEditable() {
		return isEditable;
	}


	/**
	 * @param isEditable the isEditable to set
	 */
	public void setEditable(boolean isEditable) {
		this.isEditable = isEditable;
	}


	@Column(name = "customer_id", nullable = false,length=20)
	private String customerID;
	
	
	public Customer_Account() {

	}


	/**
	 * @return the accountID
	 */
	public long getAccountID() {
		return accountID;
	}


	/**
	 * @param accountID the accountID to set
	 */
	public void setAccountID(long accountID) {
		this.accountID = accountID;
	}


	/**
	 * @return the accountType
	 */
	public String getAccountType() {
		return accountType;
	}


	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
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
	 * @return the accountBranch
	 */
	public String getAccountBranch() {
		return accountBranch;
	}


	/**
	 * @param accountBranch the accountBranch to set
	 */
	public void setAccountBranch(String accountBranch) {
		this.accountBranch = accountBranch;
	}


	/**
	 * @return the accountDescription
	 */
	public String getAccountDescription() {
		return accountDescription;
	}


	/**
	 * @param accountDescription the accountDescription to set
	 */
	public void setAccountDescription(String accountDescription) {
		this.accountDescription = accountDescription;
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


	/**
	 * @return the accountBalance
	 */
	public BigDecimal getAccountBalance() {
		synchronized (accountBalance) {
			return accountBalance;
		}
	}


	/**
	 * @param accountBalance the accountBalance to set
	 */
	public void setAccountBalance(BigDecimal accountBalance) {
		synchronized (accountBalance) {
			this.accountBalance = accountBalance;
		}
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

}
