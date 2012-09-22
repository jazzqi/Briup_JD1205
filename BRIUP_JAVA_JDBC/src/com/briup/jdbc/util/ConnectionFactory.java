package com.briup.jdbc.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionFactory {

	public static Connection getConnection() {
		Connection conn = null;
		Properties prop = null;
		try {
			prop = new Properties();
			prop.load(new FileInputStream("src/jdbc.properties"));
			String url = prop.getProperty("url");
			String driver = prop.getProperty("driver");
			Class.forName(driver);
			conn = DriverManager.getConnection(url, prop);
			// return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(ResultSet rs) {
		close(null, null, rs);
	}

	public static void close(Statement stm, ResultSet rs) {
		close(null, stm, rs);
	}

	public static void close(Connection conn, Statement stm, ResultSet rs) {
		try {
			if (null != stm)
				stm.close();
			if (null != rs)
				rs.close();
			if (null != conn)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
