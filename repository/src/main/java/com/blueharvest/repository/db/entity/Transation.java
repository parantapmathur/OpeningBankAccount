package com.blueharvest.repository.db.entity;

import java.sql.Timestamp;

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
@Table(name = "TRANSATION")
public class Transation {
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
	@Column(name = "PRIMARYACCOUNTNUMBER", nullable = false)
	private String primaryAccountNumber;
	@Column(name = "TRANSATION_DESC", nullable = false)
	private String transationDesc;
	@Column(name = "TIMESTAMP", nullable = false)
	private Timestamp timeStamp=new Timestamp(System.currentTimeMillis());

	public Transation() {

	}

	public Transation(String cutomerID, String customerName, int customerAge, String transationDesc,
			String primaryAccountNumber, Timestamp timeStamp) {
		this.cutomerID = cutomerID;
		this.customerName = customerName;
		this.customerAge = customerAge;
		this.transationDesc = transationDesc;
		this.primaryAccountNumber = primaryAccountNumber;
		if(timeStamp!=null){
			this.timeStamp = timeStamp;
		}
	}

	public String getCutomerID() {
		return cutomerID;
	}

	public void setCutomerID(String cutomerID) {
		this.cutomerID = cutomerID;
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

	public String getTransationDesc() {
		return transationDesc;
	}

	public void setTransationDesc(String transationDesc) {
		this.transationDesc = transationDesc;
	}

	public String getPrimaryAccountNumber() {
		return primaryAccountNumber;
	}

	public void setPrimaryAccountNumber(String primaryAccountNumber) {
		this.primaryAccountNumber = primaryAccountNumber;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "Transation [id=" + id + ", cutomerID=" + cutomerID + ", customerName=" + customerName + ", customerAge="
				+ customerAge + ", primaryAccountNumber=" + primaryAccountNumber + ", transationDesc=" + transationDesc
				+ ", timeStamp=" + timeStamp + "]";
	}

	

}
