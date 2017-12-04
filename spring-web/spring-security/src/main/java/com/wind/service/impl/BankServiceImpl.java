/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.wind.service.impl;

import com.wind.dao.BankDao;
import com.wind.entity.Account;
import com.wind.service.BankService;
import org.springframework.util.Assert;

/**
 * @author wind
 */
public class BankServiceImpl implements BankService {

	private final BankDao bankDao;

	public BankServiceImpl(BankDao bankDao) {
		Assert.notNull(bankDao, "bankDao cannot be null");
		this.bankDao = bankDao;
	}

	@Override
	public Account[] findAccounts() {
		return this.bankDao.findAccounts();
	}

	@Override
	public Account post(Account account, double amount) {
		Assert.notNull(account, "account cannot be null");

		// We read account back from DAO so it reflects the latest balance
		Account a = bankDao.readAccount(account.getId());
		if (a == null) {
			throw new IllegalArgumentException("Couldn't find requested account");
		}

		a.setBalance(a.getBalance() + amount);
		bankDao.createOrUpdateAccount(a);
		return a;
	}

	@Override
	public Account readAccount(Long id) {
		return bankDao.readAccount(id);
	}
}
