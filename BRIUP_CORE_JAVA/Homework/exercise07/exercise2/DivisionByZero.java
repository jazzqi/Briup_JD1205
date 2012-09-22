/*
写DivisionByZero类，包含
1. division()：要求执行10/0操作，并使用异常处理机制处理产生的异常
2. main()：调用division()
3. 修改division()：执行10/0不变，但不在方法中处理产生的异常，改将异常抛出
4. 修改main()：调用division()并处理其抛出的异常
*/

package com.briup.md07;

public class DivisionByZero
{
	public static void Division(){
		int a = 10;
		int b = 0;
		try{
			System.out.println(a + "/" + b + "=" + (a/b));
		}catch(ArithmeticException e){
			System.out.println("dealt with e");
		}finally{
			System.out.println("finally done");
		}
		System.out.println("returning from devision");
	}
	public static void main(String[] args){
		/*DivisionByZero d = new DivisionByZero();
		d.Division();*/
		new DivisionByZero().Division();
			 System.out.println("Returning from main.");
	}
}
