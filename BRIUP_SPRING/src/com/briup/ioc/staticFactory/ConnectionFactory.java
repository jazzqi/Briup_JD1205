package com.briup.ioc.staticFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static String url;
	private static String driver;
	private static String username;
	private static String password;
	
	static{
		url = "jdbc:oracle:thin:@localhost:1521:orcl";
		driver = "oracle.jdbc.driver.OracleDrive";
		username = "briup"; 
		password = "briup";
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,username,password);
		return conn;
	}

}
