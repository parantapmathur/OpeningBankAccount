/**
 * 
 */
package com.blueharvest.account.ws;


/**
 * @author Parantap Mathur
 *
 */
public class CreateAccountRequest {
	
	private String customerID;
	private String initialCredit;
	
	
	
	/**
	 * @param customerID
	 * @param initialCredit
	 */
	public CreateAccountRequest(String customerID, String initialCredit) {
		super();
		this.customerID = customerID;
		this.initialCredit = initialCredit;
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
	 * @return the initialCredit
	 */
	public String getInitialCredit() {
		return initialCredit;
	}



	/**
	 * @param initialCredit the initialCredit to set
	 */
	public void setInitialCredit(String initialCredit) {
		this.initialCredit = initialCredit;
	}



	@Override
	public String toString() {
		return "CreateAccountRequest [customerID=" + customerID + ", initialCredit=" + initialCredit + "]";
	}

	
}
