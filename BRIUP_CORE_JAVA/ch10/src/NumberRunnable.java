package com.briup.ch10;

public class NumberRunnable implements Runnable{
	public void run(){
		for(int i=1;i<101;i++)
			System.out.println(Thread.currentThread().getName()+":"+i);
	}
	public static void main(String args[]){ //throws InterruptedException{
		NumberRunnable r=new NumberRunnable();
		Thread t1=new Thread(r);
		Thread t2=new Thread(r);
		t1.start();
		//t1.sleep(400);
		t2.start();
	}
}
