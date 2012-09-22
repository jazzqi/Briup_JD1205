package com.briup.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCTest {

	public static void main(String[] args) {
		
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		try {
			Driver driver=new oracle.jdbc.driver.OracleDriver();
			Driver mysqlDriver=new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			//String url="jdbc:oracle:thin@172.16.8.103:1521:xe";
			java.util.Properties prop=new java.util.Properties();
			prop.load(new FileInputStream("src/jdbc.properties"));
			String url=prop.getProperty("url");
			conn=DriverManager.getConnection(url,prop);
			String user=prop.getProperty("user");
			String passwd=prop.getProperty("password");
			System.out.println(user+passwd);
			String sql="create table jdbc_test (id int,name varchar(32))";
			stat=conn.createStatement();
			stat.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch(IOException e){
			e.printStackTrace();
		}

	}

}
