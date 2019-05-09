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
@Table(name = "contact_detail")
public class Contact_Detail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "contact_id", nullable = false)
	private long contact_id;
	@Column(name = "email_id", nullable = false)
	private String email_id;
	@Column(name = "modile_num", nullable = false)
	private String modile_num;
	@Column(name = "landline_num", nullable = false)
	private int landline_num;
	@Column(name = "address", nullable = false)
	private String address;
	@Column(name = "TIMESTAMP", nullable = false)
	private Timestamp timeStamp=new Timestamp(System.currentTimeMillis());
	
	public Contact_Detail() {

	}



	/**
	 * @return the contact_id
	 */
	public long getContact_id() {
		return contact_id;
	}



	/**
	 * @param contact_id the contact_id to set
	 */
	public void setContact_id(long contact_id) {
		this.contact_id = contact_id;
	}



	/**
	 * @return the email_id
	 */
	public String getEmail_id() {
		return email_id;
	}



	/**
	 * @param email_id the email_id to set
	 */
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}



	/**
	 * @return the modile_num
	 */
	public String getModile_num() {
		return modile_num;
	}



	/**
	 * @param modile_num the modile_num to set
	 */
	public void setModile_num(String modile_num) {
		this.modile_num = modile_num;
	}



	/**
	 * @return the landline_num
	 */
	public int getLandline_num() {
		return landline_num;
	}



	/**
	 * @param landline_num the landline_num to set
	 */
	public void setLandline_num(int landline_num) {
		this.landline_num = landline_num;
	}



	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}



	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
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


}
