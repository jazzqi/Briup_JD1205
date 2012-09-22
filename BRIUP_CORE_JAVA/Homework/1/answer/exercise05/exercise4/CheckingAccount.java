package com.qifei.homework;

public class CheckingAccount extends Account{
	private double overdraft;

	public CheckingAccount(double balance,double overdraft){
		this(balance);
		this.overdraft=overdraft;
	}

	public CheckingAccount(double balance){
		super(balance);
	}

	public boolean withdraw(double amount){
		if(balance+overdraft>=amount){
			balance-=amount;
			return true;
		}else
			return false;
	}
	
	public double getOverdraft(){
		return overdraft;
	}
}
