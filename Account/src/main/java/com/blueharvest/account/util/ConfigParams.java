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
	
	public ConfigParams() {
		// TODO Auto-generated constructor stub
	}

	public String getOpenAccountURL() {
		return openAccountURL;
	}

	public void setOpenAccountURL(String openAccountURL) {
		this.openAccountURL = openAccountURL;
	}

	public String isTransationURL() {
		return transationURL;
	}

	public void setTransationURL(String transationURL) {
		this.transationURL = transationURL;
	}
	
	
}
