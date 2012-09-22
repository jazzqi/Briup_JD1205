package com.briup.ch07;

public class StaticTest{
	private static int count;

	public StaticTest(){
		count++;
	}

	public static void main(String args[]){
		StaticTest s1=new StaticTest();
		System.out.println(s1.count);
		StaticTest s2=new StaticTest();
		System.out.println(StaticTest.count);
	}
}
