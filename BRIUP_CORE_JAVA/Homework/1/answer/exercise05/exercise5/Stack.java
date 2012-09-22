package com.qifei.homework;

public class Stack{
	private int[] iArray;
	private int length;
	private int MAXSIZE=10;

	public Stack(){
		length=0;
		iArray=new int[MAXSIZE];
	}

	public int pop(){
		if(length>0){
			return iArray[--length];
		}else
			return 0;
	}

	public void push(int i){
		if(length>=iArray.length){
			int[] temp=new int[length+1];
			System.arraycopy(iArray,0,temp,0,length);
			iArray=temp;
		}
		iArray[length++]=i;
	}
}
