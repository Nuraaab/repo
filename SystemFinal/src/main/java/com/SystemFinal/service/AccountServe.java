package com.SystemFinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SystemFinal.repository.AccountRepository;
@Service
public class AccountServe {
	@Autowired
	private AccountRepository accountRepository;
public void transferAmount(int acctID, int destAcctID, int amount) {
	accountRepository.withdrawById(acctID, amount);
	accountRepository.saveBalanceById(destAcctID, amount);
	}
}
