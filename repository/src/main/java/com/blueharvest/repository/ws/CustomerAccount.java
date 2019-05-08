package com.blueharvest.repository.ws;

/**
 * @author Parantap Mathur
 *
 */
public class CustomerAccount {
   private String cutomerID;
   private String customerName;
   private int customerAge;
   private String secondaryAccountNumber;
   private String primaryAccountNumber;
   
   public CustomerAccount(){
	   
   }

/**
 * @param cutomerID
 * @param name
 * @param age
 * @param secondaryAccountNumber
 * @param primaryAccountNumber
 */
public CustomerAccount(String cutomerID, String customerName, int customerAge, String secondaryAccountNumber,
		String primaryAccountNumber) {
	this.cutomerID = cutomerID;
	this.customerName = customerName;
	this.customerAge = customerAge;
	this.secondaryAccountNumber = secondaryAccountNumber;
	this.primaryAccountNumber = primaryAccountNumber;
}

/**
 * @return the cutomerID
 */
public String getCutomerID() {
	return cutomerID;
}

/**
 * @param cutomerID the cutomerID to set
 */
public void setCutomerID(String cutomerID) {
	this.cutomerID = cutomerID;
}

/**
 * @return the customerName
 */
public String getCustomerName() {
	return customerName;
}

/**
 * @param customerName the customerName to set
 */
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}

/**
 * @return the customerAge
 */
public int getCustomerAge() {
	return customerAge;
}

/**
 * @param customerAge the customerAge to set
 */
public void setCustomerAge(int customerAge) {
	this.customerAge = customerAge;
}

/**
 * @return the secondaryAccountNumber
 */
public String getSecondaryAccountNumber() {
	return secondaryAccountNumber;
}

/**
 * @param secondaryAccountNumber the secondaryAccountNumber to set
 */
public void setSecondaryAccountNumber(String secondaryAccountNumber) {
	this.secondaryAccountNumber = secondaryAccountNumber;
}

/**
 * @return the primaryAccountNumber
 */
public String getPrimaryAccountNumber() {
	return primaryAccountNumber;
}

/**
 * @param primaryAccountNumber the primaryAccountNumber to set
 */
public void setPrimaryAccountNumber(String primaryAccountNumber) {
	this.primaryAccountNumber = primaryAccountNumber;
}

@Override
public String toString() {
	return "CustomerAccount [cutomerID=" + cutomerID + ", customerName=" + customerName
			+ ", customerAge=" + customerAge + ", secondaryAccountNumber=" + secondaryAccountNumber
			+ ", primaryAccountNumber=" + primaryAccountNumber + "]";
}
   
   
}
