package com.example.demo;

public class Transaction {
	  private int credit;
	  private int debit;
	  private int amount;
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public int getDebit() {
		return debit;
	}
	public void setDebit(int debit) {
		this.debit = debit;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Transaction [credit=" + credit + ", debit=" + debit + ", amount=" + amount + "]";
	}
	  

	}