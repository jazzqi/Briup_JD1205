package com.briup.ch12;

import java.io.*;

public class SystemIn{
	public static void main(String args[]) throws Exception{
		System.out.print("pls enter some things: ");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println(br.readLine());
		br.close();
	}
}
