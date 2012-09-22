package com.briup.ch07;

public class DivTest{
	public static int div(int a,int b){
		System.out.println("div begin "+a+"/"+b+"");
		int res=a/b;
		return res;
	}
	public static void main(String args[]){
		System.out.println("main begin");
		int res=div(3,1);
		System.out.println("first end");
		System.out.println("result:"+res);
		int res2=div(3,0);
		System.out.println("second end");
		System.out.println("result:"+res2);
		System.out.println("main end");
	}
}
