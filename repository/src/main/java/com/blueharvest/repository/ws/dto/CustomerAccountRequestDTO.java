package com.blueharvest.repository.ws.dto;

import java.math.BigDecimal;

/**
 * @author Parantap Mathur
 *
 */
public class CustomerAccountRequestDTO {
	private String customerID;
	private String customerName;
	private BigDecimal initialCredit=BigDecimal.ZERO;
	private String currency;

	public CustomerAccountRequestDTO() {

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

	@Override
	public String toString() {
		return "CustomerAccountRequestDTO [customerID=" + customerID + ", customerName=" + customerName
				+ ", initialCredit=" + initialCredit + ", currency=" + currency + "]";
	}

	
}
