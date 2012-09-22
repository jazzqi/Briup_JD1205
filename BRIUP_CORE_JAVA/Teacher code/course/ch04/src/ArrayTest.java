package com.briup.ch04;

public class ArrayTest{
	public static void main(String[] args){
		int[] iArray;
		iArray = new int[2];
		iArray[0] = 100;
		iArray[1] = 200;
		System.out.println("iArray[0]="+iArray[0]+"\tiArray[1]="+iArray[1]);
		//遍历数组
		int[] iArray2 = new int[100];		   for(int i=0;i<iArray2.length;i++){
			iArray2[i] = 100+i;
		}
		for(int j=0;j<iArray2.length;j++){
			System.out.print(iArray2[j]+"  ");
		}
		System.out.println();
	}
}
