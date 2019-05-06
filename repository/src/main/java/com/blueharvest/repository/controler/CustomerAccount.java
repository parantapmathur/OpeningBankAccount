package com.blueharvest.repository.controler;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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



@Override
public String toString() {
	return "CustomerAccount [id=" + id + ", CutomerID=" + CutomerID + ", name=" + name + ", age=" + age
			+ ", secondaryAccountNumber=" + secondaryAccountNumber + ", primaryAccountNumber=" + primaryAccountNumber
			+ "]";
}
   
   
  
}
