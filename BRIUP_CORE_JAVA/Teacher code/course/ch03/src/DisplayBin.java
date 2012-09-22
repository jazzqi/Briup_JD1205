package com.briup.ch03;

public class DisplayBin{
	public void showBin(int num){
		for(int i=31;i>=0;i--){
			int shifRightRes = num>>i;
			if((shifRightRes&1)==1){
				System.out.print(1);
			}else{
				System.out.print(0);
			}
		}
		System.out.println();
	}
	public static void main(String[] args){
		DisplayBin d = new DisplayBin();
		d.showBin(3);
	}
}
