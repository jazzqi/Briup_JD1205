package com.briup.ch10;

public class AccountThread extends Thread{
	private Account a;

	public AccountThread(Account a){
		this.a=a;
	}
	public void run(){
		//try{
			//sleep(500);
		//}catch(InterruptedException e){ }
		//double cash;
		//synchronized(a){//lock the critical resource
			//cash=a.withdraw(9000.0);
		//}
		//System.out.println(Thread.currentThread().getName()+" withdraw $:"+cash+" from "+a.getCode());

		double transfer=a.transfer(10000.0,new Account(1002,10000.0));
		System.out.println(transfer);
		System.out.println(Thread.currentThread().getName()+" transfer $:"+transfer+" from "+a.getCode());
	}

	public static void main(String args[]){
		Account a1=new Account(1001,10000.0);
		AccountThread t1=new AccountThread(a1);
		AccountThread t2=new AccountThread(a1);
		t1.start();
		t2.start();
		try{
			t1.join();//block the main waiting for t1
			t2.join();
		}catch(InterruptedException e){ }
	}
}
