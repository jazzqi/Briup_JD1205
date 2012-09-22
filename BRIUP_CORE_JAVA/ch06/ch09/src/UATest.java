package com.briup.ch09;

public class UATest{
	public static void main(String args[]){
		User u=new User("zhangsan",123456);
		u.openAccount(1001);
		u.openAccount(1002);
		Account a1=u.getAccount("1001");
		Account a2=u.getAccount("1002");
		a1.deposit(1000.00);
		double balance1=u.getAccountBalance("1001");
		System.out.println("a1:"+u.getAccountBalance("1001"));
		a2.deposit(1000.00);
		System.out.println("a2:"+u.getAccountBalance("1002"));
		a2.withdraw(500.00);
		System.out.println("a2:"+u.getAccountBalance("1002"));
		if(a1.transfer(500,"1002")){
			System.out.println("transfer succeed! ");
		}
		System.out.println("a1:"+u.getAccountBalance("1001"));
		System.out.println("a2:"+u.getAccountBalance("1002"));
	}
}
