package com.briup.ch08;

import java.util.*;

public class ListTest{
	public static void main(String args[]){
		Account a1=new Account(1001,1000.00);
		Account a2=new Account(1002,2000.00);
		Account a3=new Account(1003,3000.00);
		Account a4=new Account(1004,4000.00);
		Account a5=new Account(1005,5000.00);
		Account a6=new Account(1006,6000.00);
	
		List list=new LinkedList();//new ArrayList();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		list.add(a4);
		list.add(a5);
		list.add(a6);
		list.add(a1);
		list.remove(1);
		list.remove(a4);
		Account setA=new Account(2000,9999.99);
		list.set(2,setA);	
		out_list(list);
	}
	
	public static void out_list(List list){
		Iterator i=list.iterator();
		while(i.hasNext()){
			Account a=(Account)i.next();
			a.show();
		}
	}
}



class Account{
	private double balance;
	private int code;
	private Date openDate;

	public Account(int code,double balance){
		this.code=code;
		this.balance=balance;
		this.openDate=new Date();
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
	public void show(){
		System.out.println("code: "+code+"\t balance: "+balance+"\t opendate: "+openDate);
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
}
