package com.devexperts.service;

import com.devexperts.account.Account;
import com.devexperts.account.AccountKey;
import com.devexperts.repository.AccountRepository;
import com.devexperts.repository.AccountRepositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class AccountServiceImpl implements AccountService {

	/*
	 * An ArrayList uses an array which is an immutable data structure, meaning any
	 * change (delete or create an element) involves recreating a new array and
	 * searching for this use case would be O(n)
	 * 
	 * Using a HashMap makes searching, inserting and delete operation O(1) which is
	 * more faster than O(n)
	 * 
	 */

	Map<Long, Account> accounts = new HashMap<>();

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
