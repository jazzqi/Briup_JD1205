package com.briup.ch10;

public class ThreadState extends Thread{
	public void run(){
		System.out.println(getName()+" thread will sleep!");
		try{
			sleep(100000000);
		}catch(InterruptedException e){
			System.out.println(getName()+" thread is interupted");
			//e.printStackTrace();
		}
		System.out.println("Thread is end");
	}

	public static void main(String args[]){
		System.out.println("main thread begin!");
		
		ThreadState t1=new ThreadState();

		t1.start();
		try{
			sleep(2);
		}catch(InterruptedException e){ }
		System.out.println("t1 is interrupted: "+t1.isInterrupted());

		t1.interrupt();
		//try{
			//sleep(1);
		//}catch(InterruptedException e){ }
		System.out.println("t1 is interrupted: "+t1.isInterrupted());

		t1.interrupted();
		try{
			sleep(2);
		}catch(InterruptedException e){ }
		System.out.println("t1 is interrupted: "+t1.isInterrupted());

		System.out.println(Thread.currentThread().getName()+" is end!");
	}
}
