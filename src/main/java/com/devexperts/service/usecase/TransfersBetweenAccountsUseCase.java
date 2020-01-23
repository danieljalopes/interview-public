package com.devexperts.service.usecase;

import com.devexperts.account.Account;
import com.devexperts.repository.AccountRepository;
import com.devexperts.service.exception.InvalidAmmountException;
import com.devexperts.service.exception.NoAccountException;

public interface TransfersBetweenAccountsUseCase {

	public void setAccountRepository(AccountRepository accountRepository);

	public Double transferAmmount(Account source, Account target, Double ammount)
			throws NoAccountException, InvalidAmmountException;

}
