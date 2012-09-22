package com.briup.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StatementTest {

	public static void main(String[] args) {
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		try{
			String url="jdbc:mysql://localhost:3306/test";
			String sql="select * from jdbc_test";
			conn=DriverManager.getConnection(url,"root","toor");
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			while(rs.next()){
				//sysout
			}
		} catch(Exception e){
			e.printStackTrace();
		}

	}

}
