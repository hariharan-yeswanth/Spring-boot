package com.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service("bankingService")
@Transactional
public class BankingService {
	
	@Autowired
	private AccountsDAO accountDAO;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void doCredit(int accountId,int creditAmount) {
		AccountsDTO accountsDTO=accountDAO.findByID(accountId);
		int amount=accountsDTO.getAmount();
		int newAmount=amount+creditAmount;
		accountsDTO.setAmount(newAmount);
		accountDAO.updateAccounts(accountsDTO);
	}
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor= {InsufficientBalance.class})
	public void doDebit(int accountId,int debitAmount)throws InsufficientBalance {
		AccountsDTO accountsDTO=accountDAO.findByID(accountId);
		int amount=accountsDTO.getAmount();
		if(amount<debitAmount) {
			throw new InsufficientBalance("Not enough money to transfer....");
			
		}
		int newAmount=amount-debitAmount;
		accountsDTO.setAmount(newAmount);
		accountDAO.updateAccounts(accountsDTO);
	}
}