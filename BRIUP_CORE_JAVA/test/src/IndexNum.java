package com.qifei.test;

public class IndexNum{
	public static void main(String args[]){
		/**Initialing*/
		int[] iArray={289,12,1,321,322,33,86,90,33,6,776,84,49,19831,18};
		/**Outputing*/
		System.out.println("Normal order:");
		for(int n=0;n<iArray.length;n++)
			System.out.print(iArray[n]+" ");
		/**ASC Indexing*/
		for(int i=0;i<iArray.length-1;i++){
			for(int j=i+1;j<iArray.length;j++){
				if(iArray[i]>iArray[j]){
					int t=iArray[i];
					iArray[i]=iArray[j];
					iArray[j]=t;
				}
			}
		}
		/**Outputing*/
		System.out.println("\nIn ASC order:");
		for(int n=0;n<iArray.length;n++)
			System.out.print(iArray[n]+" ");
		/**DESC Indexing*/
		for(int n=0;n<iArray.length/2;n++){
			int t=iArray[n];
			iArray[n]=iArray[iArray.length-n-1];
			iArray[iArray.length-n-1]=t;
		}
		/**Outputing*/
		System.out.println("\nIn DESC order:");
		for(int n=0;n<iArray.length;n++)
			System.out.print(iArray[n]+" ");
		System.out.println();
	}
}
