package com.briup.ch10;

public class Account{
	private int code;
	private double balance;

	public Account(int code,double balance){
		setCode(code);
		setBalance(balance);
	}

	public void setCode(int code){
		this.code=code;
	}

	public void setBalance(double balance){
		this.balance=balance;
	}
	
	public int getCode(){
		return code;
	}
	
	public double getBalacen(){
		return balance;
	}

	public double withdraw(double cash){
		//synchronized(this){...}
		if(cash<0||cash>balance)
			return 0.0;
		balance-=cash;
		return cash;
	}
	
	synchronized public void deposit(double cash){
		balance+=cash;
	}

	public double transfer(double cash,Account a){
		if(cash<0||cash>balance)
			return 0.0;
		synchronized(this){
			balance-=cash;
			a.deposit(cash);
			return cash;
		}
	}
}

