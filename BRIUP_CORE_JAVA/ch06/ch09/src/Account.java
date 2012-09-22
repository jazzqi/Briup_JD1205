package com.briup.ch09;
import java.util.Date;
import java.util.Comparator;

public class Account implements Comparator,Comparable{
	private double balance;
	private int code;
	private Date openDate;
	private User user;
	public Account(int code,double balance,User user){
		this.code=code;
		this.balance=balance;
		this.openDate=new Date();
		this.user=user;
	}
	public Account(int code,double balance){//for legency codes
		this.code=code;
		this.balance=balance;
		this.openDate=new Date();
	}
	public void setUser(User user){
		this.user=user;
	}
	public User getUser(){
		return user;
	}
	public void setCode(int code){
		this.code=code;
	}
	public int getCode(){
		return code;
	}
	public void setBalance(double balance){
		this.balance=balance;
	}
	public double getBalance(){
		return balance;
	}
	public Date getOpenDate(){
		return openDate;
	}
	public void setOpenDate(Date openDate){
		this.openDate=openDate;
	}
	public String toString(){
		return "code: "+code+"\t balance: "+balance+"\t opendate: "+openDate;
	}
	public boolean equals(Object o){//Override the method
		if(o instanceof Account){
			Account a=(Account)o;
			return (code==a.getCode());
		}else
			return false;
	}
	public int hashCode(){//Override
		return code;
	}
	//declared in comparator
	public int compare(Object o1,Object o2){
		if(o1 instanceof Account && o2 instanceof Account){
			Account a1=(Account)o1;
			Account a2=(Account)o2;
			return a1.getCode()-a2.getCode();
		}else
			return 0;//Don't allow uncompatible type to get in
	}
	//declared in comparable
	public int compareTo(Object o){
		if(o instanceof Account){
			Account a=(Account)o;
			return code-a.getCode();
		}else
			return 0;
	}
	public boolean withdraw(double cash){
		if(cash>=0&&cash<=balance){
			balance-=cash;
			return true;
		}else
			return false;
	}
	public boolean deposit(double cash){
		if(cash>=0){
			balance+=cash;
			return true;
		}else
			return false;
	}
	public boolean transfer(double cash,String code){
		if(cash>=0&&cash<=balance&&getUser().getAccount(code)!=null){//a.getUser().getIdCode()==this.getUser().getIdCode()){
			withdraw(cash);
			getUser().getAccount(code).deposit(cash);
			return true;
		}else
			return false;
	}
}
