package com.briup.test.ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/xml");
		PrintWriter pw = resp.getWriter();
		pw.println("<promptWords>");
		String userInputText = req.getParameter("userInputText");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","struts","struts");
			String sql = "select prompt_name from t_prompt where prompt_name like ?";
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, userInputText+"%");
			ResultSet rs = pstat.executeQuery();
			while(rs.next()){
				pw.println("<promptWord>");
				pw.println(rs.getString(1));
				pw.println("</promptWord>");
			}
			rs.close();
			pstat.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		pw.println("</promptWords>");
		pw.flush();
		pw.close();
	}
}
