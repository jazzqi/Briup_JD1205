package com.briup.ch03;

public class WhileTest{
	public static void main(String[] args){
		int sum = 0;
		int i = 1;

		while(i<=100){
			sum += i;
			i++;
		}
		System.out.println(sum);

		int sum2 = 0;
		int i2 = 1;
		do{
			sum2 += i2;
			i2++;
		}while(i2<=100);
		System.out.println(sum2);
	}
}
