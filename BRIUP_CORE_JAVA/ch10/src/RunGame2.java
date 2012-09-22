package com.briup.ch10;

public class RunGame2 extends Thread{
	public static boolean stop;
	public static int trace=1;
	public void run(){
		while(trace<=100)
			System.out.println(getName()+":"+(trace++));
	}
	public RunGame2(String name){
		super(name);
	}
	public static void main(String args[]){
		RunGame2 cat=new RunGame2("cat");
		RunGame2 dog=new RunGame2("dog");
		RunGame2 hourse=new RunGame2("hourse");
		cat.start();
		dog.start();
		hourse.start();
	}
}
