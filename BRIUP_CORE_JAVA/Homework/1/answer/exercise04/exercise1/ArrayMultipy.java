package com.qifei.test;

public class ArrayMultipy{
	public static int[] iArray=new int[10];

	public static void initArray(){
		for(int i=0;i<iArray.length;i++){
			iArray[i]=i+1;
		}
	}

	public static int getMultipyResult(){
		int result=1;
		for(int i=0;i<iArray.length;i++){
			result*=iArray[i];
		}
		return result;
	}

	public static void main(String args[]){
		initArray();
		System.out.println("The result of 10! is "+getMultipyResult());
	}
}
