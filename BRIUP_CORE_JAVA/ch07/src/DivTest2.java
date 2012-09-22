package com.briup.ch07;

public class DivTest2{
	public static int div(int a,int b){
		System.out.println("div begin "+a+" div "+b+"");
		int res=a/b;
		return res;
	}
	public static void main(String args[]){
		System.out.println("main begin");
		try{
			int res=div(3,1);
			System.out.println("first end");
			System.out.println("result:"+res);
		}catch(ArithmeticException e){
			System.out.println(e.getMessage());
			System.out.println("div lose! no result");
		}
		try{
			int res2=div(3,0);
			System.out.println("second end");
			System.out.println("result:"+res2);
		}catch(ArithmeticException e){
			System.out.println(e.getMessage());
			System.out.println("div lose! no result");
		}
		System.out.println("main end");
	}
}
