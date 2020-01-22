package com.devexperts.repository;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

import com.devexperts.account.Account;

@Repository
public class AccountRepositoryImpl  implements AccountRepository{
	
	/*
	 * An ArrayList uses an array which is an immutable data structure, meaning any change (delete or create an element) 
	 * involves recreating a new array and searching for this use case would be O(n)
	 * 
	 * Using a HashMap makes searching, inserting and delete operation  O(1) which is more faster than O(n)
	 * 
	 */
	private  Map<Long, Account> accounts = new HashMap<>();;
	
	
	public void clear() {
		accounts.clear();
	}
	
	public Account getById(long id) {
		return accounts.get(Long.valueOf(id));
	}
	
	public Account create(Account account) {
      return accounts.put(account.getAccountKey().getAccountId(), account);
	}
}
