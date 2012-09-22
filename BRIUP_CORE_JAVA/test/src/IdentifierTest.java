package com.qifei.test;

public class IdentifierTest{
	public static void main(String args[]){
		int $int=10;

		String BigLongStringWithMeaninglessName = "some string";
		
		byte bytes=10;

		final int[] finalist = {1,2};

		System.out.println("$int = "+$int+"\tBigLongStringWithMeaninglessName = "+BigLongStringWithMeaninglessName+"\tbytes = "+bytes);

		for(int i=0;i<finalist.length;i++){
			System.out.println("finalist["+i+"] = "+finalist[i]);
		}
	}
}
