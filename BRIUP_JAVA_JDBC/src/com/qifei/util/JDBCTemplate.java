package com.qifei.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
	private Connection conn;

	public JDBCTemplate() {
		conn = ConnectionFactory.getConnection();
	}

	public void query(String sql, ResultSetHandler handler) {
		Statement stat = null;
		ResultSet rs = null;
		if (null != sql && null != handler)
			try {
				stat = conn.createStatement();
				rs = stat.executeQuery(sql);
				// while (rs.next()) {
				// 根据sql语句选用不同的处理方式
				// 使用ResultSetHandler接口
				// }
				handler.process(rs);
			} catch (Exception e) {
				// TODO: handle exception
			}
	}

	public int insert(String sql) {
		return executeDML(sql);
	}

	public int delete(String sql) {
		return executeDML(sql);
	}

	public int update(String sql) {
		return executeDML(sql);
	}

	public int executeDML(String sql) {
		Statement stat = null;
		if (null != sql) {
			try {
				stat = conn.createStatement();
				return stat.executeUpdate(sql);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return 0;
			}
		} else
			return 0;
	}

	public void query(String sql, ResultSetHandler handler, Setter setter) {
		PreparedStatement pstat = null;
		ResultSet rs = null;
		try {
			pstat = conn.prepareStatement(sql);
			if (null != setter)
				setter.set(pstat);
			rs = pstat.executeQuery();
			if (null != handler) {
				// while(rs.next()){
				handler.process(rs);
				// }
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String args[]) {
		JDBCTemplate t = new JDBCTemplate();
		// t.insert("insert into s_emp (id,last_name) values(9999,'qifei')");
		// t.update("update s_emp set last_name='Fei Qi' where id=9999");
		// t.delete("delete s_emp where id=9999");
		// t.query("select id,last_name from s_emp", new ResultSetHandler(){
		// @Override
		// public void process(ResultSet rs) {
		// // TODO Auto-generated method stub
		// try {
		// while (rs.next()) {
		// System.out.println(rs.getInt(1)+"_:_"+rs.getString(2));
		// }
		// } catch (Exception e) {
		// // TODO: handle exception
		// }
		// }
		// });

		t.query("select id,last_name from s_emp where id=?",
				new ResultSetHandler() {
					@Override
					public void process(ResultSet rs) {
						// TODO Auto-generated method stub
						try {
							while (rs.next()) {
								System.out.println(rs.getInt(1) + "_:_"
										+ rs.getString(2));
							}
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
				}, new Setter() {
					@Override
					public void set(PreparedStatement pstat) {
						try {
							pstat.setInt(1, 12);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
	}
}
