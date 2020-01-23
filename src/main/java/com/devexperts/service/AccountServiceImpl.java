package com.devexperts.service;

import com.devexperts.account.Account;
import com.devexperts.repository.AccountRepository;
import com.devexperts.repository.AccountRepositoryImpl;
import com.devexperts.service.exception.InvalidAmmountException;
import com.devexperts.service.exception.NoAccountException;
import com.devexperts.service.usecase.TransfersBetweenAccountsUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AccountServiceImpl implements AccountService {

	

	private AccountRepository accountRepository;
	
	private TransfersBetweenAccountsUseCase transfersBetweenAccountsUseCase;

	public AccountServiceImpl() {
		this.accountRepository = new AccountRepositoryImpl();
	}

	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository, TransfersBetweenAccountsUseCase transfersBetweenAccountsUseCase) {
		this.accountRepository = accountRepository;
		
		this.transfersBetweenAccountsUseCase = transfersBetweenAccountsUseCase;
		this.transfersBetweenAccountsUseCase.setAccountRepository(this.accountRepository);
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
	public void transfer(Account source, Account target, double amount) throws NoAccountException, InvalidAmmountException {
		this.transfersBetweenAccountsUseCase.transferAmmount(source, target, amount);
	}
}
