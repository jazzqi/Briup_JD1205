package com.briup.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstJDBC {

	public static void main(String[] args) {
		// 注册驱动： 反射加载 虚拟机参数 DriverManager
		// JDBC操作中会触发的异常 Exception：
		try {// orcle.jdbc.OracleDriver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection conn = DriverManager
						.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
								"briup", "briup");
				Statement sm = conn.createStatement();
				String sql = "select 123 as 1 from dual";
				ResultSet rs = sm.executeQuery(sql);
				while (rs.next()) {
					System.out.println(rs.getString(1));
				}
				if (null != rs)
					rs.close();
				if (null != sm)
					sm.close();
				if (null != conn)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
