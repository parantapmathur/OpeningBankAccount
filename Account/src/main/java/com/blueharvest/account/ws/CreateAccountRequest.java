/**
 * 
 */
package com.blueharvest.account.ws;

/**
 * @author paran
 *
 */
public class CreateAccountRequest {
	
	private String customerID;
	private String initialCredit;
	
	
	/**
	 * 
	 */
	protected CreateAccountRequest() {
		super();
	}

	/**
	 * @param customerID
	 * @param initialCredit
	 */
	protected CreateAccountRequest(String customerID, String initialCredit) {
		super();
		this.customerID = customerID;
		this.initialCredit = initialCredit;
	}
	
	protected String getCustomerID() {
		return customerID;
	}
	protected void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	protected String getInitialCredit() {
		return initialCredit;
	}
	protected void setInitialCredit(String initialCredit) {
		this.initialCredit = initialCredit;
	}

	@Override
	public String toString() {
		return "\"CreateAccountRequest\" :{\"customerID\":\"" + customerID + "\"; \"initialCredit\":\"" + initialCredit
				+ "\"}";
	}
	
	

}
