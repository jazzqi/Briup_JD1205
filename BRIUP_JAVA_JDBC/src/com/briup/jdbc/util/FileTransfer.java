package com.briup.jdbc.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileTransfer {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedInputStream bis=null;
		BufferedOutputStream bos=null;
		try{
			bis = new BufferedInputStream(new FileInputStream(new File("test.txt")));
			bos = new BufferedOutputStream(new FileOutputStream(new File("test.bak")));

			int length=0;
			byte[] buff=new byte[1];
			while((length=bis.read(buff))!=-1){

				bos.write(buff, 0, length);
				//System.out.print("!"+buff[0]+"!");
				
				bos.flush();
			}
			
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(null!=bis)
					bis.close();
				if(null!=bos)
					bos.close();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}
