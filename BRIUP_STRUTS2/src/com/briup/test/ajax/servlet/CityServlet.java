package com.briup.test.ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cityServlet")
public class CityServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/xml");
		String province = new String(req.getParameter("province").getBytes("ISO-8859-1"), "UTF-8").trim();
		PrintWriter pw = resp.getWriter();
		
		List<String> jiangsuList = new ArrayList<>();
		List<String> henanList = new ArrayList<>();
		List<String> hunanList = new ArrayList<>();
		
		jiangsuList.add("南京");
		jiangsuList.add("苏州");
		jiangsuList.add("昆山");
		jiangsuList.add("徐州");
		jiangsuList.add("扬州");
		
		henanList.add("郑州");
		henanList.add("洛阳");
		henanList.add("开封");
		henanList.add("焦作");
		henanList.add("许昌");
		
		hunanList.add("长沙");
		hunanList.add("株洲");
		hunanList.add("湘潭");
		hunanList.add("张家界");
		hunanList.add("常德");
		
		Map<String, List<String>> map = new HashMap<>();
		map.put("江苏",jiangsuList);
		map.put("河南",henanList);
		map.put("湖南",hunanList);
		
		//System.out.println("============================="+province.trim());
		List<String> currentList = map.get(province);
		pw.println("<citys>");
		for(int i=0;i<currentList.size();i++){
			pw.println("<city>");
			pw.println(currentList.get(i));
			pw.println("</city>");
		}
		pw.println("</citys>");
		pw.flush();
		pw.close();
	}

}
