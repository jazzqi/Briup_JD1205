package com.briup.ch03;

public class DecimalToBinary{

	/**Tranditional method made by me*/
	public void getBinary1(double i){
		double result=0;
		int binResult=0;
		int[] bin=new int[32];
		boolean flag=true;

		while(i>0){
			for(int m=0;i>=Math.pow(2,m);m++){
				result=Math.pow(2,m);
				binResult=m;
			}
			i=i-result;
			bin[31-binResult]=1;
		}

		for(int x=0;x<32;x++){
			System.out.print(bin[x]);
		}

		System.out.println();
	}

	/**A better method with higer efficiency, implemented by bit operation*/
	public void getBinary2(int d){
		for(int i=31;i>=0;i--){
			int t=d>>i;
			if((t&1)==1){
				System.out.print(1);
			}else
				System.out.print(0);
		}
	}

	public static void main(String args[]){
		int i=2012;
		DecimalToBinary t=new DecimalToBinary();
		t.getBinary1(i);//(double)i);
		t.getBinary2(i);
		System.out.println();
	}
}
