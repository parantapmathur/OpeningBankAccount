package com.blueharvest.repository.db.entity.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author Parantap Mathur
 *
 */

public class CustomerAccountDTO {
	private long accountID;
	private String accountType;
	private String accountNumber;
	private String accountBranch;
	private String accountDescription;
	private Timestamp timestamp;
	private BigDecimal accountBalance = BigDecimal.ZERO;
	private String customerID;
	private boolean isEditable = true;
	
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

	public CustomerAccountDTO() {

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

}
