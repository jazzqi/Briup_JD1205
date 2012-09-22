package com.briup.ch03;

public class BreakContinueTest{
	public static void main(String args[]){
		for(int i=1;i<=10;i++){
			if(i==5)
				//break;//loop 5 times, echo 5 numbers
				continue;//loop 10 times, echo 9 numbers
			System.out.println(i);
		}
	}
}
