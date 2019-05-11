package com.blueharvest.repository.ws.response;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * @author Parantap Mathur
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerAccountResponse {
	
	private String customerID;
	private String customerName;
	private BigDecimal balanceAmount=BigDecimal.ZERO;
	private String currency;
	private String newAccountNumber;
	private String status;

	public CustomerAccountResponse() {

	}

	/**
	 * @return the cutomerID
	 */
	public String getCustomerID() {
		return customerID;
	}

	/**
	 * @param cutomerID
	 *            the cutomerID to set
	 */
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName
	 *            the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(BigDecimal balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public String getNewAccountNumber() {
		return newAccountNumber;
	}

	public void setNewAccountNumber(String newAccountNumber) {
		this.newAccountNumber = newAccountNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
