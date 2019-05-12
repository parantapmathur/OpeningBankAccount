package com.blueharvest.account.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Parantap Mathur
 *
 */
//@Component
//@Service
@Component
public class ConfigParams {
	
	@Value("${app.open.account.url}") 
	private String openAccountURL;
	
	@Value("${app.get.all.transations.url}")
	private String transationURL;
	
	@Value("${app.get.default.user}")
	private String user;
	
	@Value("${app.get.default.password}")
	private String password;
	
	@Value("${app.get.default.role}")
	private String role;
	
	public ConfigParams() {
		// TODO Auto-generated constructor stub
	}

	public String getOpenAccountURL() {
		return openAccountURL;
	}

	public void setOpenAccountURL(String openAccountURL) {
		this.openAccountURL = openAccountURL;
	}

	/**
	 * @return the transationURL
	 */
	public String getTransationURL() {
		return transationURL;
	}

	/**
	 * @param transationURL the transationURL to set
	 */
	public void setTransationURL(String transationURL) {
		this.transationURL = transationURL;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	
	
	
}
