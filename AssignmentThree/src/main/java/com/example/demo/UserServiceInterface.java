package com.example.demo;

public interface UserServiceInterface {
      public void createUser(UserDTO bank);
      public UserDTO checkBalance(int id);
     public void transfer(Transaction trans) throws InsufficientBalanceException;
}