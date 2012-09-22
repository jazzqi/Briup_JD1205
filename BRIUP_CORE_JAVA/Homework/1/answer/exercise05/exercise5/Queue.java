package com.qifei.homework;

public class Queue{
	private int length;
	private int MAXSIZE;
	private int[] iArray;

	public Queue(){
		MAXSIZE=10;
		length=0;
		iArray=new int[MAXSIZE];
	}

	public void in(int i){
		if(length>=iArray.length){
			int[] temp=new int[length+1];
			System.arraycopy(iArray,0,temp,0,length);
			iArray=temp;
		}
		iArray[length++]=i;
	}

	public int out(){
		if(length>0){
			int temp=iArray[0];
			for(int i=0;i<length-1;i++)
			iArray[i]=iArray[i+1];
			length--;
			return temp;
		}else
			return 0;
	}
}
