package com.blueharvest.repository.ws;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Parantap Mathur
 *
 */
public class CustomerAccountRequest {
	@NotNull
	@Size(min = 8, max = 10, message = "Please valid CustomerID a name")
	private String customerID;

	@NotNull
	private String customerName;
	
//	@NotNull
//	private int customerAge;
//	private String secondaryAccountNumber;
//	@NotNull
//	@Size(min = 15, max = 15, message = "Please valid CustomerID a name")
//	private String primaryAccountNumber;
//	
	@NotNull
	private BigDecimal initialCredit=BigDecimal.ZERO;
	
	@NotNull
	private String currency;

	public CustomerAccountRequest() {

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

//	/**
//	 * @return the customerAge
//	 */
//	public int getCustomerAge() {
//		return customerAge;
//	}
//
//	/**
//	 * @param customerAge
//	 *            the customerAge to set
//	 */
//	public void setCustomerAge(int customerAge) {
//		this.customerAge = customerAge;
//	}
//
//	/**
//	 * @return the secondaryAccountNumber
//	 */
//	public String getSecondaryAccountNumber() {
//		return secondaryAccountNumber;
//	}
//
//	/**
//	 * @param secondaryAccountNumber
//	 *            the secondaryAccountNumber to set
//	 */
//	public void setSecondaryAccountNumber(String secondaryAccountNumber) {
//		this.secondaryAccountNumber = secondaryAccountNumber;
//	}

//	/**
//	 * @return the primaryAccountNumber
//	 */
//	public String getPrimaryAccountNumber() {
//		return primaryAccountNumber;
//	}
//
//	/**
//	 * @param primaryAccountNumber
//	 *            the primaryAccountNumber to set
//	 */
//	public void setPrimaryAccountNumber(String primaryAccountNumber) {
//		this.primaryAccountNumber = primaryAccountNumber;
//	}

	public BigDecimal getInitialCredit() {
		return initialCredit;
	}

	public void setInitialCredit(BigDecimal initialCredit) {
		this.initialCredit = initialCredit;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
