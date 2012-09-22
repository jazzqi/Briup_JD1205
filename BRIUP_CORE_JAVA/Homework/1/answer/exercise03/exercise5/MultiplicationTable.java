package com.qifei.test;

public class MultiplicationTable{
	public static void show1(){
		for(int i=1;i<10;i++){
			for(int j=1;j<=i;j++){
				System.out.print(i+"*"+j+"="+i*j+"\t");
			}
			System.out.println();
		}
	}

	public static void show2(){
		for(int i=9;i>0;i--){
			for(int j=1;j<=i;j++){
				System.out.print(j+"*"+i+"="+i*j+"\t");
			}
			System.out.println();
		}
	}

	public static void show3(){
		for(int i=1;i<10;i++){
			for(int k=9-i;k>0;k--)
				System.out.print("       ");
			for(int j=1;j<=i;j++){
				System.out.print(" "+j+"*"+i+"=");//+i*j+" ");
				if(i*j<10)
					System.out.print(" "+i*j);
				else
					System.out.print(i*j);
			}
			System.out.println();
		}
	}

	public static void show4(){
		for(int i=9;i>0;i--){
			for(int k=i;k<9;k++)
				System.out.print("       ");
			for(int j=1;j<=i;j++){
				System.out.print(" "+j+"*"+i+"=");//+i*j+" ");
				if(i*j<10)
					System.out.print(" "+i*j);
				else
					System.out.print(i*j);
			}
			System.out.println();
		}
	}
	public static void main(String args[]){
		show1();
		System.out.println("--------------------------------------------------------");
		show2();
		System.out.println("--------------------------------------------------------");
		show3();
		System.out.println("--------------------------------------------------------");
		show4();
	}
}
