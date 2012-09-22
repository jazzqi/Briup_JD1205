package com.qifei.homework;
import java.util.Random;

public class SortArray{
	public static int[] iArray=new int[10];

	public static void initArray(){
		Random rand=new Random();
		for(int i=0;i<iArray.length;i++){
			iArray[i]=rand.nextInt(1000);
		}
	}

	public static void sortArray(){
		for(int i=0;i<iArray.length-1;i++){
			for(int j=i+1;j<iArray.length;j++){
				if(iArray[i]>iArray[j]){
					int t=iArray[i];
					iArray[i]=iArray[j];
					iArray[j]=t;
				}
			}
		}
	}

	public static void displayArray(){
		for(int i=0;i<iArray.length;i++){
			System.out.print(iArray[i]+" ");
		}
		System.out.println();
	}

	public static void main(String args[]){
		System.out.println("Initializing the array with random numbers");
		initArray();
		System.out.println("The array is: ");
		displayArray();
		System.out.println("Sorting the array");
		sortArray();
		System.out.println("The sorted array is");
		displayArray();
	}
}
