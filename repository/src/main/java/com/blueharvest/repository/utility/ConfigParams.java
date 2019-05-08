/**
 * 
 */
package com.blueharvest.repository.utility;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Parantap Mathur
 *
 */
@Component
public class ConfigParams {
	@Value("${app.account.num.length}")
	private String length;
	@Value("${app.account.withAlpha}")
	private boolean allowAlpha;
	@Value("${app.account.withNums}")
	private boolean allowNums;
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
