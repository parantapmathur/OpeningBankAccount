package com.blueharvest.repository.db.entity;

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
	@Column(name = "CUTOMERID", nullable = false)
	private String cutomerID;
	@Column(name = "CUSTOMERNAME", nullable = false)
	private String customerName;
	@Column(name = "CUSTOMERAGE", nullable = false)
	private int customerAge;
	@Column(name = "SECONDARYACCOUNTNUMBER", nullable = true)
	private String secondaryAccountNumber;
	@Column(name = "PRIMARYACCOUNTNUMBER", nullable = false)
	private String primaryAccountNumber;

	public Account() {

	}

	/**
	 * @param cutomerID
	 * @param name
	 * @param age
	 * @param secondaryAccountNumber
	 * @param primaryAccountNumber
	 */
	public Account(String cutomerID, String customerName, int customerAge, String secondaryAccountNumber,
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
	 * @param cutomerID
	 *            the cutomerID to set
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
	 * @param customerName
	 *            the customerName to set
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
	 * @param customerAge
	 *            the customerAge to set
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
	 * @param secondaryAccountNumber
	 *            the secondaryAccountNumber to set
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
	 * @param primaryAccountNumber
	 *            the primaryAccountNumber to set
	 */
	public void setPrimaryAccountNumber(String primaryAccountNumber) {
		this.primaryAccountNumber = primaryAccountNumber;
	}

	@Override
	public String toString() {
		return "CustomerAccount [id=" + id + ", cutomerID=" + cutomerID + ", customerName=" + customerName
				+ ", customerAge=" + customerAge + ", secondaryAccountNumber=" + secondaryAccountNumber
				+ ", primaryAccountNumber=" + primaryAccountNumber + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerAge;
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((cutomerID == null) ? 0 : cutomerID.hashCode());
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
		if (customerAge != other.customerAge)
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (cutomerID == null) {
			if (other.cutomerID != null)
				return false;
		} else if (!cutomerID.equals(other.cutomerID))
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

}
