package com.blueharvest.repository.ws.request;

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
