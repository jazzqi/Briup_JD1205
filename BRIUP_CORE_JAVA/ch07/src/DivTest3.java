package com.briup.ch07;

public class DivTest3{
	public static int div(int a,int b){
		System.out.println("div begin!");
		int res=a/b;
		System.out.println("div end!");
		return res;
	}
	public static int method2(int a,int b){
		System.out.println("method2 begin!");
		int res=div(a,b);
		System.out.println("method2 end!");
		return res;
	}
	public static int method1(int a,int b){
		int res;
		try{
			System.out.println("method1 begin!");
			res=method2(a,b);
			System.out.println("method1 end!");
			return res;
		}catch(ArithmeticException e){
			e.printStackTrace();
			return 0;
		}
	}
	public static void main(String args[]){
		System.out.println("main begin!");
		int res1=method1(3,1);
		System.out.println("----------first div end");
		System.out.println("res1:"+res1);
		int res2=method1(3,0);
		System.out.println("----------second div end");
		System.out.println("res2:"+res2);
		System.out.println("main end!");
	}
}
