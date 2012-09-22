package com.qifei.homework;

public class SavingAccount extends Account{
	private double rate;

	public SavingAccount(double balance,double rate){
		super(balance);
		this.rate=rate;
	}
}
