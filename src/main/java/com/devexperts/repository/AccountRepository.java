package com.devexperts.repository;

import com.devexperts.account.Account;

public interface AccountRepository {

	public void clear();
	
	public Account getById(long id);
	
	public Account create(Account account);
}
