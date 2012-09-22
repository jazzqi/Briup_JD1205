package com.briup.ch04;

/**Array test class*/
public class ArrayTest{
	public static void main(String args[]){
		int[] iArray;
		iArray=new int[2];
		iArray[0]=100;
		iArray[1]=200;
		System.out.println("iArray[0]="+iArray[0]+"\tiArray[1]="+iArray[1]);

		/**Ergodic traverse array*/
		int[] iArray2=new int[100];
		for(int i=0;i<iArray2.length;i++){
			iArray2[i]=100+i;
			System.out.print(iArray2[i]+"\t");
		}
		System.out.println();
	}
}
