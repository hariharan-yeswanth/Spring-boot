package com.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component("accountDAO")
public class AccountsDAO{
	
	@Autowired
	private SessionFactory factory;
	
	public AccountsDTO findByID(int accountId) {
		Session session=factory.getCurrentSession();
		AccountsDTO accountDTO=session.get(AccountsDTO.class,accountId);
		return accountDTO;
	}
	public SessionFactory getFactory() {
		return factory;
	}
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	public void updateuser(AccountsDTO accountDTO) {
		Session session=factory.getCurrentSession();
		session.persist(accountDTO);
	}
	
}
