package com.model;

public class InsufficientBalance extends Exception {
	String message;
	public InsufficientBalance(String string) {
		this.message=string;
		// TODO Auto-generated constructor stub
	}
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return super.toString();
//	}
	@Override
	public String toString() {
		return "InsufficientBalance [message=" + message + "]";
	}
	
}
