package com.devexperts.service;

import com.devexperts.account.Account;
import com.devexperts.account.AccountKey;
import com.devexperts.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final List<Account> accounts = new ArrayList<>();
    
    private AccountRepository accountRepository;
    
    
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
        accounts.add(account);
    }

    @Override
    public Account getAccount(long id) {
    	return accountRepository.getById(id);
        
    }

    @Override
    public void transfer(Account source, Account target, double amount) {
        //do nothing for now
    }
}
