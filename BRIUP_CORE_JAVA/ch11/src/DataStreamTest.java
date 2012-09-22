package com.briup.ch11;

import java.io.*;

public class DataStreamTest{
	public static void main(String args[]){
		BufferedOutputStream bos=null;
		BufferedInputStream bis=null;
		DataOutputStream dos=null;
		DataInputStream dis=null;
		try{
			int sum=888;
			bos=new BufferedOutputStream(new FileOutputStream("datastream.txt"));
			dos=new DataOutputStream(bos);
			dos.writeInt(sum);
			dos.flush();
			bis=new BufferedInputStream(new FileInputStream("datastream.txt"));
			dis=new DataInputStream(bis);
			System.out.println(dis.readInt());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				dis.close();
				dos.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
