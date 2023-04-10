package com.model;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MyService{
	@Autowired
	private AccountsDAO accountDAO;
	public void doService(int accountId,int amount) {
		AccountsDTO accountsDTO=accountDAO.findByID(accountId);
		accountsDTO.setAmount(amount);
		accountDAO.updateAccounts(accountsDTO);
	}
	public AccountsDAO getDAO() {
		return accountDAO;
	}
	
	public void setDao(AccountsDAO accountsDAO) {
		this.accountDAO = accountsDAO;
	}
}