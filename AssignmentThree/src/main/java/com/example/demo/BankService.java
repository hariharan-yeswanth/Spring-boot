package com.example.demo;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("ss")
@Transactional
public class BankService implements BankServiceInterface{

	@Autowired
	BankDAO bankDAO;
	@Override
	public void createUser(BankDTO bank) {
		// TODO Auto-generated method stub
		bankDAO.save(bank);
	}

	@Override
	public BankDTO checkBalance(int id) {
		// TODO Auto-generated method stub
		Optional<BankDTO> obj=bankDAO.findById(Integer.valueOf(id));
		BankDTO bankAcc=obj.get();
		return bankAcc;
	}

	@Override
	@Transactional(propagation =Propagation.REQUIRED)
	public void transfer(Transaction trans) throws InsufficientBalanceException {
		
	  int creditId=trans.getCredit();
	  int debitId=trans.getDebit();
	  int amount =trans.getAmount();
	  
	  debitransfer(debitId, amount);
	  
	 
	  
	  creditransfer(creditId, amount);
		
		
	}
	@Transactional(propagation = Propagation.REQUIRED )
	public void debitransfer(int id,int amount) throws InsufficientBalanceException {
		Optional<BankDTO> obj1=bankDAO.findById(Integer.valueOf(id));
		BankDTO bankAcc1=obj1.get();
		if(bankAcc1.getAmount()<amount) {
			throw new InsufficientBalanceException("Insufficient balance");
		}
		bankAcc1.setAmount(bankAcc1.getAmount()-amount);
		System.out.println(bankAcc1.getAmount());
		bankDAO.save(bankAcc1);
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public void creditransfer(int id,int amount) {
		Optional<BankDTO> obj1=bankDAO.findById(Integer.valueOf(id));
		BankDTO bankAcc=obj1.get();
		bankAcc.setAmount(bankAcc.getAmount()+amount);
		System.out.println(bankAcc.getAmount());
		bankDAO.save(bankAcc);
	}
	
	
	

}