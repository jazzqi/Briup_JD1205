package com.briup.ch11;

import java.io.*;

public class Copy{
	public static void main(String args[]){
		FileInputStream fis=null;
		BufferedInputStream bis=null;
		FileOutputStream fos=null;
		BufferedOutputStream bos=null;
		try{
			fis=new FileInputStream("test.txt");
			bis=new BufferedInputStream(fis);
			fos=new FileOutputStream("test_backup.txt");
			bos=new BufferedOutputStream(fos);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		int res=0;//bytes from read() can be implicity converted into integer type
		try{
			while((res=bis.read())!=-1){//Implicit type convert
				bos.write(res);//Implicit type convert
			}
			bos.flush();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{//fis and fos will be closed automatically
				bis.close();
				bos.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
}
