package com.md02;

public class Factor{
	public int calculate(int x){
		for(int i=x-1;i>0;i--){
			x*=i;
		}
		return x;
	}
}
