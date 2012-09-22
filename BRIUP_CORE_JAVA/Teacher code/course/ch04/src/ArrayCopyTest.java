package com.briup.ch04;

public class ArrayCopyTest{
	public static void main(String[] args){
		int[] array1 = {1,2,3};
		int[] array2 = {4,5,6,7,8,9};

		System.arraycopy(array1,0,array2,0,array1.length);
		for(int i=0;i<array2.length;i++){
			System.out.println(array2[i]);
		}
		for(int k=0;k<array1.length;k++){
			System.out.println(array1[k]);
		}
	}
}
