package com.blueharvest.repository.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

import io.micrometer.core.instrument.util.StringUtils;

public class Utility {
	
	@Autowired
	private Environment environment;
	
	@Value("${app.account.num.length}")
	private int accountNumLength;
	
	public int getAccountNumLength() {
		if(accountNumLength==0){
			accountNumLength=10;
		}
		return accountNumLength;
	}

	public boolean useLetters() {
		String allowLetters = environment.getProperty("app.account.withAlpha", "true");
		if(StringUtils.isNotEmpty(allowLetters) && allowLetters.equalsIgnoreCase("true")){
			return true;
		}else{
			return false;
		}
	}

	public boolean useNumbers() {
		String allowNumbers =  environment.getProperty("app.account.withNums", "true");
		if(StringUtils.isNotEmpty(allowNumbers) && allowNumbers.equalsIgnoreCase("true")){
			return true;
		}else{
			return false;
		}
	}
}
