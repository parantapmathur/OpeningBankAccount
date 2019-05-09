package com.blueharvest.repository.db.facade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.blueharvest.repository.db.dao.UserAccountRepository;
import com.blueharvest.repository.db.dao.UserTransationRepository;
import com.blueharvest.repository.db.dto.AccountDTO;
import com.blueharvest.repository.db.entity.Account;
import com.blueharvest.repository.db.entity.Transation;
import com.blueharvest.repository.utility.ConfigParams;
import com.blueharvest.repository.ws.CustomerAccountRequest;

@Component
public class DBManager {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	AccountDBOperation dbOperation;
	@Autowired
	UserAccountRepository accountRepo;
	@Autowired
	UserTransationRepository transationRepository;
	@Autowired
	ConfigParams configParam;

	public DBManager() {

	}

	public Account createSecondaryAccnt(CustomerAccountRequest accountDetails) {
		/*
		 * Random random = new SecureRandom();
		 * accountDetails.setSecondaryAccountNumber(random.toString());
		 */

		int length = configParam.getLength();
		boolean useLetters = configParam.isAllowAlpha();
		boolean useNumbers = configParam.isAllowNums();

		logger.info("length::" + length);
		logger.info("useLetters::" + useLetters);
		logger.info("useNumbers::" + useNumbers);

		ArrayList<AccountDTO> accountDTOList = getAccountDetails(accountDetails.getCustomerID(), accountDetails.getCustomerName());
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

		if (accountDetails.getInitialCredit().compareTo(BigDecimal.ZERO) > 0) {
			saveTransation(accountDetails);// as per point 4
		}

		return null;
	}

	public boolean saveTransation(CustomerAccountRequest accountDetails) {

		logger.info("Going to Saving transation");
		transationRepository.save(new Transation());
		logger.info("Transation Saved");
		return true;
	}

	public ArrayList<AccountDTO> getAccountDetails(String customerID, String customerName) {
		ArrayList<AccountDTO> accountDtoList = null;
		ArrayList<Account> accountList = accountRepo.findbyCustomerIDAndCustomerName(customerID, customerName);
		if(!CollectionUtils.isEmpty(accountList)) {
			accountDtoList = new ArrayList<AccountDTO>(accountList.size());
			for (Account account : accountList) {
				AccountDTO accountDto = new AccountDTO();
				BeanUtils.copyProperties(account, accountDto);
				accountDtoList.add(accountDto);
			}			
		}
		return accountDtoList;
	}

}
