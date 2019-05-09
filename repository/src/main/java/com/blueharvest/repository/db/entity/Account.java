package com.blueharvest.repository.db.entity;

import java.math.BigDecimal;

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
@Table(name = "ACCOUNT")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private long id;
	
	@Column(name = "CUSTOMERID", nullable = false)
	private String customerID;
	
	@Column(name = "CUSTOMERNAME", nullable = false)
	private String customerName;
	
	@Column(name = "CUSTOMERAGE", nullable = false)
	private int customerAge;
	
	@Column(name = "SECONDARYACCOUNTNUMBER", nullable = true)
	private String secondaryAccountNumber;
	
	@Column(name = "PRIMARYACCOUNTNUMBER", nullable = false)
	private String primaryAccountNumber;

	@Column(name = "AMOUNT", nullable = false)
	private BigDecimal amount = BigDecimal.ZERO;
	
	@Column(name = "CURRENCY", nullable = true)
	private String currency="EUR";
	
	@Column(name = "ACCOUNT_TYPE", nullable = true)
	private String account_type;	
	
	public Account() {

	}

	/**
	 * @param CustomerID
	 * @param customerName
	 * @param customerAge
	 * @param secondaryAccountNumber
	 * @param primaryAccountNumber
	 * @param amount
	 * @param currency
	 * @param account_type
	 */
	public Account(String CustomerID, String customerName, int customerAge, String secondaryAccountNumber,
			String primaryAccountNumber, BigDecimal amount, String currency, String account_type) {
		super();
		this.customerID = CustomerID;
		this.customerName = customerName;
		this.customerAge = customerAge;
		this.secondaryAccountNumber = secondaryAccountNumber;
		this.primaryAccountNumber = primaryAccountNumber;
		this.amount = amount;
		this.currency = currency;
		this.account_type = account_type;
	}

	
	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String CustomerID) {
		this.customerID = CustomerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}

	public String getSecondaryAccountNumber() {
		return secondaryAccountNumber;
	}

	public void setSecondaryAccountNumber(String secondaryAccountNumber) {
		this.secondaryAccountNumber = secondaryAccountNumber;
	}

	public String getPrimaryAccountNumber() {
		return primaryAccountNumber;
	}

	public void setPrimaryAccountNumber(String primaryAccountNumber) {
		this.primaryAccountNumber = primaryAccountNumber;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account_type == null) ? 0 : account_type.hashCode());
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + customerAge;
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((customerID == null) ? 0 : customerID.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((primaryAccountNumber == null) ? 0 : primaryAccountNumber.hashCode());
		result = prime * result + ((secondaryAccountNumber == null) ? 0 : secondaryAccountNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (account_type == null) {
			if (other.account_type != null)
				return false;
		} else if (!account_type.equals(other.account_type))
			return false;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (customerAge != other.customerAge)
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (customerID == null) {
			if (other.customerID != null)
				return false;
		} else if (!customerID.equals(other.customerID))
			return false;
		if (id != other.id)
			return false;
		if (primaryAccountNumber == null) {
			if (other.primaryAccountNumber != null)
				return false;
		} else if (!primaryAccountNumber.equals(other.primaryAccountNumber))
			return false;
		if (secondaryAccountNumber == null) {
			if (other.secondaryAccountNumber != null)
				return false;
		} else if (!secondaryAccountNumber.equals(other.secondaryAccountNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", customerID=" + customerID + ", customerName=" + customerName + ", customerAge="
				+ customerAge + ", secondaryAccountNumber=" + secondaryAccountNumber + ", primaryAccountNumber="
				+ primaryAccountNumber + ", amount=" + amount + ", currency=" + currency + ", account_type="
				+ account_type + "]";
	}
	
	
}
