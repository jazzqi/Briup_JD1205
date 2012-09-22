package com.briup.ch10;

public class NumberThread extends Thread{
	public void run(){
		for(int i=1;i<=100;i++){
			System.out.println(getName()+":"+i);
		}
	}

	public static void main(String args[]){
		NumberThread t1=new NumberThread();
		t1.start();
		NumberThread t2=new NumberThread();
		t2.start();
	}
}
