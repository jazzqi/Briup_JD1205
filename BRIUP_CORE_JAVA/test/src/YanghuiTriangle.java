package com.qifei.test;

public class YanghuiTriangle{
	public static void main(String args[]){
		int[][] triangle=new int[13][25];//In this form: int[x][2x-1]
		
		/**Generating*/
		for(int i=0;i<=(triangle[0].length-1)/2;i++){
			triangle[i][(triangle[0].length-1)/2+i]=1;
			triangle[i][(triangle[0].length-1)/2-i]=1;
			if (i>1){
				for(int j=i-1;j>-i;j--){
					triangle[i][(triangle[0].length-1)/2+j]
					=
					triangle[i-1][(triangle[0].length-1)/2+j-1]
					+
					triangle[i-1][(triangle[0].length-1)/2+j+1];
				}
			}
		}

		/**Outputing*/
		for(int i=0;i<triangle.length;i++){
              for(int j=0;j<triangle[i].length;j++){
			  	if(triangle[i][j]==0)
					System.out.print("___");
				else if(triangle[i][j]<10)
				 	System.out.print("_"+triangle[i][j]+"_");
				else if(triangle[i][j]<100)
					System.out.print("_"+triangle[i][j]);
				else 
					System.out.print(triangle[i][j]);
              }
			  System.out.println();
        }
	}
}
