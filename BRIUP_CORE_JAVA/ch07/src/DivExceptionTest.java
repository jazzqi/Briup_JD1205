package com.briup.ch07;

public class DivExceptionTest{
	public static int div(int a,int b) throws DivException{
		System.out.println("div begin!");
		try{
			int res=a/b;
			return res;
		}catch(ArithmeticException e){
			throw new DivException("div by zero!!",a,b,e);
		}
		//System.out.println("div begin!");
	}
	public static void main(String args[]){
		try{
			System.out.println("main begin");
			int res1=div(3,1);
			System.out.println("res1:"+res1);
			System.out.println("first end");
			int res2=div(3,0);
			System.out.println("res2:"+res2);
			System.out.println("second end");
			System.out.println("main end");
		}catch(DivException e){
			System.out.println(e.getMessage());
			System.out.println(e.getCause().getMessage());
		}
	}
}
