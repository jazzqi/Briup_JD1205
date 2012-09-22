package com.briup.ch02;

public class DataTypeChangeTest{
	public static void main (String args[]){
		int i1=10;
		byte b1=(byte)i1;//显式转换

		double d1=i1;//隐式转换

		//double d2=10d;
		//long l1=d2;

		System.out.println("i1="+i1+"\tb1="+b1+"\td1="+d1);
	}
}
