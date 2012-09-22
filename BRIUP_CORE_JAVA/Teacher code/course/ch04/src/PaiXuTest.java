package com.briup.ch04;

public class PaiXuTest{
	public void minToMaxRes(int[] input){
		for(int i=0;i<input.length;i++){
			for(int j=i+1;j<input.length;j++){
				if(input[i]>input[j]){
					int tmp = input[i];
					input[i] = input[j];
					input[j] = tmp;
				}
			}
		}
		System.out.print("排序后：");
		for(int m=0;m<input.length;m++){
			System.out.print(input[m]+"\t");
		}
		System.out.println();
		for(int k=0;k<((input.length)/2);k++){
			int c = input[k];
			input[k] = input[input.length-k-1];
			input[input.length-k-1] = c;
		}
		System.out.print("倒序后：");
		for(int m=0;m<input.length;m++){
			System.out.print(input[m]+"\t");
		}
		System.out.println();
	}
	public static void main(String[] args){
		PaiXuTest p = new PaiXuTest();
		int[] iArray = {2,34,5,65,324};
		System.out.println("排序前："+"2\t34\t5\t65\t324");
		p.minToMaxRes(iArray);
	}
}
