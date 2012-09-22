package com.briup.ch03;

public class FcTest{
	public static void main(String args[]){
		//args[0]=(int)args[0];
		if(Integer.parseInt(args[0])==1||Integer.parseInt(args[0])==2||Integer.parseInt(args[0])==3||Integer.parseInt(args[0])==4||Integer.parseInt(args[0])==5){
			System.out.println("Today is weekday.");
		}else{
			System.out.println("Today is weekend.");
		}
	}
}
