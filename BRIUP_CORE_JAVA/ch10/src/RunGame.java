package com.briup.ch10;

public class RunGame extends Thread{
	public static boolean stop;
	public void run(){
		for(int i=1;i<101;i++){
			if(!stop){
				System.out.println(getName()+":"+i);
			}else
				break;
		}
		stop=true;
	}
	public RunGame(String name){
		super(name);
	}
	public static void main(String args[]){
		RunGame cat=new RunGame("cat");
		RunGame dog=new RunGame("dog");
		RunGame	hourse=new RunGame("hourse");
		cat.start();
		dog.start();
		hourse.start();
	}
}
