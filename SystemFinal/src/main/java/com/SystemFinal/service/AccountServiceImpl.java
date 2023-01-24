package com.SystemFinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SystemFinal.entity.Account;
import com.SystemFinal.repository.AccountRepository;
@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountRepository accountRepository;
	@Override
	public Iterable<Account> findAllAccount() {
		return accountRepository.findAll();
	}

	@Override
	public Account findById(int id) {
		return accountRepository.findById(id).get();
	}

	@Override
	public void createAccount(Account acc) {
		accountRepository.save(acc);
		
	}

	@Override
	public void updateAccount(Account acc) {
		accountRepository.save(acc);
		
	}

	@Override
	public void deleteAccount(int id) {
		accountRepository.deleteById(id);
		
	}

	
}
