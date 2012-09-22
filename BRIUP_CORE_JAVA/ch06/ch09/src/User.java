package com.briup.ch09;

import java.util.*;

public class User{
	private int idCode;
	private String name;
	private Map accounts=new HashMap();

	public User(String name,int idCode){
		this.idCode=idCode;
		this.name=name;
	}

	public boolean openAccount(int code){
		if(!accounts.containsKey(String.valueOf(code))){
			Account a=new Account(code,0.0,this);
			accounts.put(String.valueOf(code),a);
			return true;
		}else
			return false;
	}

	public boolean rmAccount(String code){
		if(accounts.containsKey(code)){
			accounts.remove(code);
			return true;
		}else
			return false;
	}

	public double getAccountBalance(String code){
		if(accounts.containsKey(code))
			return ((Account)(accounts.get(code))).getBalance();
		else
			return 0.0;
	}

	public Account getAccount(String code){
		if(accounts.containsKey(code)){
			return (Account)(accounts.get(code));
		}else
			return null;
	}

	public void setIdCode(int idCode){
		this.idCode=idCode;
	}

	public void setName(String name){
		this.name=name;
	}

	public String getName(){
		return name;
	}

	public int getIdCode(){
		return idCode;
	}

}
