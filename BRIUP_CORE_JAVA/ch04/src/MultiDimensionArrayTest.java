package com.briup.ch04;

public class MultiDimensionArrayTest{
	public static void main(String args[]){
		int[][] mArray=new int[3][5];
		for(int i=0;i<mArray.length;i++){
			for(int j=0;j<mArray[i].length;j++){
				mArray[i][j]=1;
			}
		}
		for(int i=0;i<mArray.length;i++){
			for(int j=0;j<mArray[i].length;j++){
				System.out.println("mArray["+i+"]["+j+"]="+mArray[i][j]);
			}
		}
	}
}
