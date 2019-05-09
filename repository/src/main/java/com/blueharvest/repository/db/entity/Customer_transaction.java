package com.blueharvest.repository.db.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Parantap Mathur
 *
 */
@Entity
@Table(name = "customer_transaction")
public class Customer_transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "transation_id", nullable = false)
	private long transation_id;
	@Column(name = "CUSTOMERID", nullable = false)
	private String customerID;
	@Column(name = "description", nullable = false)
	private String description;
	@Column(name = "transaction_type", nullable = false)
	private int transaction_type;
	@Column(name = "amount_in_EUR", nullable = false)
	private String amount_in_EUR;
	@Column(name = "TIMESTAMP", nullable = false)
	private Timestamp timeStamp=new Timestamp(System.currentTimeMillis());
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer_Detail customer_Detail;
	
	@ManyToOne
	@JoinColumn(name = "account_id")
	private Customer_Account account_id;
	

	public Customer_transaction() {

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
	public int getTransaction_type() {
		return transaction_type;
	}


	/**
	 * @param transaction_type the transaction_type to set
	 */
	public void setTransaction_type(int transaction_type) {
		this.transaction_type = transaction_type;
	}


	/**
	 * @return the amount_in_EUR
	 */
	public String getAmount_in_EUR() {
		return amount_in_EUR;
	}


	/**
	 * @param amount_in_EUR the amount_in_EUR to set
	 */
	public void setAmount_in_EUR(String amount_in_EUR) {
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
	 * @return the customer_Detail
	 */
	public Customer_Detail getCustomer_Detail() {
		return customer_Detail;
	}


	/**
	 * @param customer_Detail the customer_Detail to set
	 */
	public void setCustomer_Detail(Customer_Detail customer_Detail) {
		this.customer_Detail = customer_Detail;
	}


	/**
	 * @return the account_id
	 */
	public Customer_Account getAccount_id() {
		return account_id;
	}


	/**
	 * @param account_id the account_id to set
	 */
	public void setAccount_id(Customer_Account account_id) {
		this.account_id = account_id;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account_id == null) ? 0 : account_id.hashCode());
		result = prime * result + ((amount_in_EUR == null) ? 0 : amount_in_EUR.hashCode());
		result = prime * result + ((customerID == null) ? 0 : customerID.hashCode());
		result = prime * result + ((customer_Detail == null) ? 0 : customer_Detail.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((timeStamp == null) ? 0 : timeStamp.hashCode());
		result = prime * result + transaction_type;
		result = prime * result + (int) (transation_id ^ (transation_id >>> 32));
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
		Customer_transaction other = (Customer_transaction) obj;
		if (account_id == null) {
			if (other.account_id != null)
				return false;
		} else if (!account_id.equals(other.account_id))
			return false;
		if (amount_in_EUR == null) {
			if (other.amount_in_EUR != null)
				return false;
		} else if (!amount_in_EUR.equals(other.amount_in_EUR))
			return false;
		if (customerID == null) {
			if (other.customerID != null)
				return false;
		} else if (!customerID.equals(other.customerID))
			return false;
		if (customer_Detail == null) {
			if (other.customer_Detail != null)
				return false;
		} else if (!customer_Detail.equals(other.customer_Detail))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (timeStamp == null) {
			if (other.timeStamp != null)
				return false;
		} else if (!timeStamp.equals(other.timeStamp))
			return false;
		if (transaction_type != other.transaction_type)
			return false;
		if (transation_id != other.transation_id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "customer_transaction [transation_id=" + transation_id + ", customerID=" + customerID + ", description="
				+ description + ", transaction_type=" + transaction_type + ", amount_in_EUR=" + amount_in_EUR
				+ ", timeStamp=" + timeStamp + ", customer_Detail=" + customer_Detail + ", account_id=" + account_id
				+ "]";
	}
	
	


}
