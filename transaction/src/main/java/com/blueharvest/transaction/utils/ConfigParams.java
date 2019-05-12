package com.blueharvest.transaction.utils;

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
	
	@Value("${app.get.all.transations.url}")
	private String transationURL;

	public ConfigParams() {
		
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
	
}
