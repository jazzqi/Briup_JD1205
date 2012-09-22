package com.briup.ch07;

public class StringTest{
	public static void main(String[] args){
		String a=new String("a");
		String b=new String("a");
		String c="a";
		String d="a";

		System.out.println("a==b\t"+(a==b));
		System.out.println("a.equals(b)\t"+a.equals(b));
		System.out.println("c==d\t"+(c==d));
		System.out.println("c.equals(d)\t"+c.equals(d));
	}
}
