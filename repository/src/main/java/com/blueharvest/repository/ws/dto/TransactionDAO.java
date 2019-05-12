/**
 * 
 */
package com.blueharvest.repository.ws.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author parantap mathur
 *
 */
public class TransactionDAO {

	private long transationid;
	private String description;
	private String transaction_type;
	private BigDecimal amount_in_EUR;
	private Timestamp timeStamp=new Timestamp(System.currentTimeMillis());
	private String accountNumber;
	private String customerID;

	public TransactionDAO() {

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


	@Override
	public String toString() {
		return "TransactionDAO [transationid=" + transationid + ", description=" + description + ", transaction_type="
				+ transaction_type + ", amount_in_EUR=" + amount_in_EUR + ", timeStamp=" + timeStamp
				+ ", accountNumber=" + accountNumber + ", customerID=" + customerID + "]";
	}
	
	
}
