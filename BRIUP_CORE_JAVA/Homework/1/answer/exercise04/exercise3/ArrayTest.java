package com.qifei.homework;

public class ArrayTest{
	public static int[] array1={2,3,5,7,11,13,17,19};
	public static int[] array2;

	public static void displayArray(int[] ia){
		for(int i=0;i<ia.length;i++){
			System.out.print(ia[i]+" ");
		}
		System.out.println();
	}

	public static void main(String args[]){
		System.out.println("array1:");
		displayArray(array1);

		System.out.println("============================");

		array2=array1;
		for(int i=0;i<array2.length;i+=2){
			array2[i]=i;
		}

		System.out.println("array1:");
		displayArray(array1);
		System.out.println("array2:");
		displayArray(array2);
	}
}
