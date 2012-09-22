package com.briup.ch07;

public class StaticInitBlock{
	//Static init block will only run once when the class was loaded at the first time.
	//It is used to init the complicated member variables
	static{
		System.out.println("static init block begin");
	}
	//private static int i;

	public StaticInitBlock(){
		System.out.println("constructor begin");
	}
	public static void main(String args[]){
		System.out.println("main begin");
		StaticInitBlock s=new StaticInitBlock();
		StaticInitBlock ss=new StaticInitBlock();
		System.out.println("main end");
	}
}
