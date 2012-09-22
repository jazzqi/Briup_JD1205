package com.briup.ch03;

public class OpTest{
	public static void main(String args[]){
		int x=1;
		String s="1.0";
		System.out.println(x+s);	//When one string plus one int or double, it just appends the latter one after the former one

		double d=2.0;
		double d2=1.1;
		System.out.println(d-d2);	//Binary code cannot stands for things like 0.1, so the float cannot get the true result

		int i2=10;
		int i3=3;
		System.out.println(i2/i3);
		System.out.println(i2%i3);

		int i4 = 3;
		System.out.println(i4<<2);
		System.out.println(i4>>2);

		int i5 = -3;
		System.out.println(i5>>2);
		System.out.println(i5>>>2);

		int i6=2;
		int i7=3;
		System.out.println(i6&i7);
		System.out.println(i6|i7);
		System.out.println(i6^i7);
		System.out.println(~i6);

		System.out.println(1==1?"yes":"no");
	}
}
