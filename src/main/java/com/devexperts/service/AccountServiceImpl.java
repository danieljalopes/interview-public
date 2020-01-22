package com.devexperts.service;

import com.devexperts.account.Account;
import com.devexperts.account.AccountKey;
import com.devexperts.repository.AccountRepository;
import com.devexperts.repository.AccountRepositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AccountServiceImpl implements AccountService {

	

	private AccountRepository accountRepository;

	public AccountServiceImpl() {
		this.accountRepository = new AccountRepositoryImpl();
	}

	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public void clear() {
		accountRepository.clear();
	}

	@Override
	public void createAccount(Account account) {
		accountRepository.create(account);
	}

	@Override
	public Account getAccount(long id) {

		return accountRepository.getById(id);

	}

	@Override
	public void transfer(Account source, Account target, double amount) {
		// do nothing for now
	}
}
