package com.devexperts.service.usecase;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.devexperts.account.Account;
import com.devexperts.repository.AccountRepository;
import com.devexperts.service.exception.InvalidAmmountException;
import com.devexperts.service.exception.NoAccountException;

@Service
public class TransfersBetweenAccountsUseCaseImpl implements TransfersBetweenAccountsUseCase{

	private AccountRepository accountRepository;
	
	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	
	public Double transferAmmount(Account source, Account target, Double ammount)
			throws NoAccountException, InvalidAmmountException {

		if (ammount < 0)
			throw new InvalidAmmountException("Ammount to transfer is negative: " + ammount);

		Account _source = this.accountRepository.getById(source.getAccountKey().getAccountId());
		if (Objects.isNull(_source))
			throw new NoAccountException("Source does not exists - Account id:" + source.getAccountKey());

		Account _target = this.accountRepository.getById(target.getAccountKey().getAccountId());
		if (Objects.isNull(_target))
			throw new NoAccountException("Source does not exists - Account id:" + source.getAccountKey());

		_source.setBalance(_source.getBalance() - ammount);
		_target.setBalance(_target.getBalance() + ammount);

		
		return _target.getBalance();
	}
}
