package com.qifei.homework;

public class Account{
	protected double balance;

	public Account(double balance){
		this.balance=balance;
	}

	public double getBalance(){
		return balance;
	}

	public boolean deposit(double amount){
		balance+=amount;	
		return true;
	}

	public boolean withdraw(double amount){
		if(balance>=amount){
			balance-=amount;
			return true;
		}else
			return false;
	}
}
