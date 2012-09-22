package com.briup.ch04;

public class YangHuiTest{
	public static void main(String[] args){
		int[][] yanghui = new int[10][];
		for(int i=0;i<yanghui.length;i++){
			for(int k=0;k<10-i;k++){
				System.out.print("  ");
			}
			yanghui[i] = new int[i+1];
			for(int j=0;j<yanghui[i].length;j++){
				if(j==0||j==i){
					System.out.print(1+"  ");
					yanghui[i][j] = 1;
					continue;
				}else{
					yanghui[i][j] = yanghui[i-1][j]+yanghui[i-1][j-1];
					System.out.print(yanghui[i][j]+"  ");
				}
			}
			System.out.println();
		}
	}
}
