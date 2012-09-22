package com.briup.ch12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TcpClient {
	public static void main(String[] args) {
		Socket scoket = null;
		PrintWriter pw = null;
		BufferedReader br = null;
		
		try {
			// 构建socket
			//scoket = new Socket("localhost",8888);
			scoket = new Socket("127.0.0.1",8888);
			// 获取输入输出流并包装
			pw = new PrintWriter(scoket.getOutputStream());
			pw.println(" please give me your time:");
			pw.flush();
			
			br = new BufferedReader(new InputStreamReader(
					(scoket.getInputStream())));
			String temp = "";
			while((temp=br.readLine())!=null){
				System.out.println(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(br!=null)br.close();
				if(pw!=null)pw.close();
				if(scoket!=null)scoket.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
}




















