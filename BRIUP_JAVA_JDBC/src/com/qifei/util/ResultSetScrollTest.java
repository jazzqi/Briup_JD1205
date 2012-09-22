package com.qifei.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetScrollTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//normalResultSet();
		sentiveResultSet();
	}
	
	public static void sentiveResultSet(){
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		try{
			String sql="select id,last_name from s_emp order by id desc";
			conn=ConnectionFactory.getConnection();
			stat=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs=stat.executeQuery(sql);			
			while(rs.next()){
				//System.out.println(rs.getInt(1)+":"+rs.getString(2));
			}
			while(true){			
				System.out.println("反向遍历");
				rs.afterLast();
				while(rs.previous()){
					System.out.println("反向成功");
					System.out.println(rs.getInt(1)+":"+rs.getString(2));
				}
				Thread.sleep(5000);
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void normalResultSet(){
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		try{
			String sql="select id,last_name from s_emp";
			conn=ConnectionFactory.getConnection();
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);			
			while(rs.next()){
				System.out.println(rs.getInt(1)+":"+rs.getString(2));
			}
			System.out.println("反向遍历");
			rs.afterLast();
			while(rs.previous()){
				System.out.println("反向成功");
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}

}
