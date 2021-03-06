/**
 * 
 */
package com.blueharvest.repository.utility;

import java.math.BigDecimal;

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
	
	@Value("${app.account.num.length}") 
	private int length;
	
	@Value("${app.account.withAlpha}")
	private boolean allowAlpha;
	
	@Value("${app.account.withNums}")
	private boolean allowNums;
	
	@Value("${app.account.default.currency}") 
	private String currency;
	
	@Value("${app.account.default.accounttype}") 
	private String accountType;
	
	@Value("${app.account.min.balance}") 
	private String accountBalanceMinLimit;
	
	@Value("${app.account.max.wait}") 
	private long primaryAccntMaxWait;
	
	

	/*
	 * public ConfigParams(@Value("${app.account.num.length}") String length,
	 * 
	 * @Value("${app.account.withAlpha}") boolean allowAlpha,
	 * 
	 * @Value("${app.account.withNums}")boolean allowNums){ this.length = length;
	 * this.allowAlpha = allowAlpha; this.allowNums = allowNums; }
	 */
	
	/**
	 * @return the primaryAccntMaxWait
	 */
	public long getPrimaryAccntMaxWait() {
		return primaryAccntMaxWait;
	}

	/**
	 * @param primaryAccntMaxWait the primaryAccntMaxWait to set
	 */
	public void setPrimaryAccntMaxWait(long primaryAccntMaxWait) {
		this.primaryAccntMaxWait = primaryAccntMaxWait;
	}

	/**
	 * @return the accountBalanceminLimit
	 */
	public String getAccountBalanceMinLimit() {
		return accountBalanceMinLimit;
	}

	/**
	 * @param accountBalanceminLimit the accountBalanceminLimit to set
	 */
	public void setAccountBalanceMinLimit(String accountBalanceMinLimit) {
		this.accountBalanceMinLimit = accountBalanceMinLimit;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public ConfigParams() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}
	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
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

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
}
