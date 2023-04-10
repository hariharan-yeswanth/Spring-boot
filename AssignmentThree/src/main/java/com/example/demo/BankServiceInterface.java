package com.example.demo;


public interface BankServiceInterface {
      public void createUser(BankDTO bank);
      public BankDTO checkBalance(int id);
     public void transfer(Transaction trans) throws InsufficientBalanceException;
}