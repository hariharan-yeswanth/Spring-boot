package com.example.demo;

public class InsufficientBalanceException extends Exception{
String message;

public InsufficientBalanceException(String message) {
	this.message = message;
}

}
