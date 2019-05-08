/**
 * 
 */
package com.blueharvest.repository.utility;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author Parantap Mathur
 *
 */
//@Component
//@Service
@Component
public class ConfigParams {
	
	@Value("${app.account.num.length}") 
	private String length;
	
	@Value("${app.account.withAlpha}")
	private boolean allowAlpha;
	
	@Value("${app.account.withNums}")
	private boolean allowNums;

	public ConfigParams(@Value("${app.account.num.length}") String length,
			@Value("${app.account.withAlpha}") boolean allowAlpha,
			@Value("${app.account.withNums}")boolean allowNums){
		this.length = length;
		this.allowAlpha = allowAlpha;
		this.allowNums = allowNums;		
	}
	
	public ConfigParams() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the length
	 */
	public String getLength() {
		return length;
	}
	/**
	 * @param length the length to set
	 */
	public void setLength(String length) {
		this.length = length;
	}
	/**
	 * @return the allowAlpha
	 */
	public boolean isAllowAlpha() {
		return allowAlpha;
	}
	/**
	 * @param allowAlpha the allowAlpha to set
	 */
	public void setAllowAlpha(boolean allowAlpha) {
		this.allowAlpha = allowAlpha;
	}
	/**
	 * @return the allowNums
	 */
	public boolean isAllowNums() {
		return allowNums;
	}
	/**
	 * @param allowNums the allowNums to set
	 */
	public void setAllowNums(boolean allowNums) {
		this.allowNums = allowNums;
	}
	
	
}
