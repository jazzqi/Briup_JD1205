package com.briup.ch07;

public class AccountTest{
	public static void main(String args[]){
		Account a=new Account(1001,1000.00);
		try{
			a.withdraw(1001.00);
		}catch(WithdrawException e){
			System.out.println(e.getMessage());
			System.out.println("Please try again!");
		}
	}
}
class Account{
	private int code;
	private double balance;

	public Account(int code,double balance){
		this.code=code;
		this.balance=balance;
	}
	public void withdraw(double cash) throws WithdrawException{
			if(cash>balance||cash<0){
				throw new WithdrawException();
			}else
				balance-=cash;
	}
}
