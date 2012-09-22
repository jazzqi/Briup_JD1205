package com.briup.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.briup.jdbc.util.ConnectionFactory;

public class BatchTest {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstat = null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "insert into jdbc_test value(?,?)";
			pstat = conn.prepareStatement(sql);

			int count = 10;
			for (int i = 1; i <= 102; i++) {
				pstat.setInt(1, i);
				pstat.setString(2, "briup" + i);
				pstat.addBatch();
				count++;
				if (count % 10 == 0) {
					int[] num = pstat.executeBatch();
					System.out.println(num.length);
				}
			}
			int[] other = pstat.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, pstat, null);
		}

	}

}
