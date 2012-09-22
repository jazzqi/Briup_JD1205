package com.qifei.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import oracle.sql.BLOB;

public class BlobTest {

	/**
	 * @param args
	 */
	public static void insertIntoDB(){
		Connection conn = null;
		PreparedStatement pstat = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		ResultSet rs = null;

		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String sql = "insert into jdbc_test values(empty_blob())";
			pstat = conn.prepareStatement(sql);
			pstat.executeUpdate();
			rs = pstat.executeQuery("select bfile from jdbc_test for update");
			while (rs.next()) {
				BLOB blob = (BLOB) rs.getBlob(1);
				bos = new BufferedOutputStream(
						blob.getBinaryOutputStream());
				bis = new BufferedInputStream(
						new FileInputStream("test.rar"));
				byte[] buf = new byte[1024];
				int len = 0;
				while ((len = bis.read(buf)) != -1) {
					//System.out.println(len);
					bos.write(buf, 0, len);
				}
				bos.flush();
				bis.close();
				bos.close();
			}
			conn.commit();
			conn.setAutoCommit(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getOutofDB(){
		try{
			Connection conn=ConnectionFactory.getConnection();
			String sql="select bfile from jdbc_test";
			PreparedStatement psata=conn.prepareStatement(sql);
			ResultSet rs=psata.executeQuery();
			while(rs.next()){
				BLOB blob=(BLOB)rs.getBlob(1);
				byte[] buff=new byte[(int) blob.length()];
				BufferedInputStream bis=new BufferedInputStream(blob.getBinaryStream());
				BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("out.rar"));
				bis.read(buff);
				bos.write(buff);
				bos.flush();
				bos.close();
				bis.close();
				
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		insertIntoDB();
		getOutofDB();
	}

}
