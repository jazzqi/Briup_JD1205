package com.briup.ch03;

public class DoubleAddTest{
	public static void main(String[] args){
		int i = 1;
		System.out.println(i++);

		int i2 = 1;
		int a,b;
		a = ++i2;
		System.out.println("a="+a+"\ti2="+i2);
		b = i2++;
		System.out.println("b="+b+"\ti2="+i2);
	}
}
