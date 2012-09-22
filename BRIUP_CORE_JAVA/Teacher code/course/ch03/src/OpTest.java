package com.briup.ch03;

public class OpTest{
	public static void main(String[] args){
		int x = 1;
		String s = "1.0";
		System.out.println(x+s);

		double d = 2.0;
		double d2 = 1.1;
		System.out.println(d-d2);
		
		int i2 = 10;
		int i3 = 3;
		System.out.println(i2/i3);
		System.out.println(i2%i3);

		int i4 = 3;
		System.out.println(i4<<2);
		System.out.println(i4>>2);

		int i5 = -3;
		System.out.println(i5>>2);
		System.out.println(i5>>>2);

		int m = 2;
		int y = 3;
		System.out.println(m&y);
		System.out.println(m|y);
		System.out.println(m^y);
		System.out.println(~m);

		System.out.println(1==2?"yes":"no");

	}
}
