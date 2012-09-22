package com.qifei.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Hilo {

	private static int hi;//��λ
	private static int lo;//��λ
	private static final int carry;//��λ

	static {
		carry=10;
		
		//Get hi,lo from the ID index in DataBase	
		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		try{			
			conn = ConnectionFactory.getConnection();
			String sql = "select id from jdbc_test where rownum<=1 order by id desc";
			pstat = conn.prepareStatement(sql);
			rs=pstat.executeQuery(sql);
			String currID="";//Current ID in the DataBase
			while(rs.next()){
				currID = rs.getString(1);
			}
			if(currID.length()>2){
				hi=Integer.parseInt(currID.substring(0,currID.length()-2))+1;//��λ��һ
				//lo=Integer.parseInt(currID.substring(currID.length()-2));
				lo=0;//��λ���㿪ʼ
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	public static int getHi() {
		return hi;
	}

	public static int getLo() {
		if(lo==carry-1){
			nextHi();
			lo=0;
		}
		return lo++;
	}
	
	public static void nextHi(){
		hi++;
	}

	public static long nextHilo() {
		String l=getLo()+"";
		String h=getHi()+"";
		return Long.parseLong(new String(h+l));
	}

}
