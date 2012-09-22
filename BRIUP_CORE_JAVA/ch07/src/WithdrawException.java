package com.briup.ch07;

public class WithdrawException extends Exception{
	public String getMessage(){
		return "WithdrawException: balance is not enough";
	}
	
}
