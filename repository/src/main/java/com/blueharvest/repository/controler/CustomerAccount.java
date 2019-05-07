package com.blueharvest.repository.controler;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * @author Parantap Mathur
 *
 */

@Entity
public class CustomerAccount {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;
   private String CutomerID;
   private String name;
   private int age;
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
public CustomerAccount(String cutomerID, String name, int age, String secondaryAccountNumber,
		String primaryAccountNumber) {
	super();
	CutomerID = cutomerID;
	this.name = name;
	this.age = age;
	this.secondaryAccountNumber = secondaryAccountNumber;
	this.primaryAccountNumber = primaryAccountNumber;
}



public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getCutomerID() {
	return CutomerID;
}

public void setCutomerID(String cutomerID) {
	CutomerID = cutomerID;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
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

@Override
public String toString() {
	return "CustomerAccount [id=" + id + ", CutomerID=" + CutomerID + ", name=" + name + ", age=" + age
			+ ", secondaryAccountNumber=" + secondaryAccountNumber + ", primaryAccountNumber=" + primaryAccountNumber
			+ "]";
}
   
   
  
}
