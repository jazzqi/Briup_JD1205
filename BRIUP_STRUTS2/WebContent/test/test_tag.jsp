<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page import="com.briup.bbs.pojo.Member" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<!-- 
		<base href="<%=basePath%>">
		 -->
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<title>Insert title here</title>
		<style type="text/css">
			h1{
				font-size:16px;
				font-family:Verdana,serif;
				color:#4d6d8d;
			}
		</style>
		<%
			Member member=new Member();
			member.setAge(100);
			member.setName("Tom");
			member.setEmail("tom@briup.com");
			request.setAttribute("member",member);
			Date date=new Date();
			request.setAttribute("date",date);
		%>
	</head>
	<body>
	<h1 style="color:blue;">控制标签</h1>
	<hr/>
	<h1>s:append</h1>
	<s:append var="list1">
		<s:param value="{1,2,3}"></s:param>
		<s:param value="{4,5,6}"></s:param>
		<s:param value="{7,8,9}"></s:param>
	</s:append>
	<s:iterator value="list1" id="item">
		<s:property value="#item"></s:property>
		<s:property></s:property>
	</s:iterator>
	<h1>s:merge</h1>
	<s:merge var="list2">
		<s:param value="{1,2,3}"></s:param>
		<s:param value="{4,5,6}"></s:param>
		<s:param value="{7,8,9}"></s:param>
	</s:merge>
	<s:iterator value="lists2">
		<s:property></s:property>
	</s:iterator>
	<h1>s:generator</h1>
	<s:generator separator=":" val="'briup:jd1205:struts:tags'">
		<s:iterator>
			<s:property></s:property>
		</s:iterator>
	</s:generator>
	<h1>s:subset</h1>
	<!-- s:subset start with 0 -->
	<s:subset source="{3,5,1,5,656,6,9}" start="3" count="4">
		<s:iterator>
			<s:property></s:property>
		</s:iterator>	
	</s:subset>
	<h1 style="color:blue;">数据标签</h1>
	<hr>
	<h1>s:set</h1>
	<s:set value="#request.member" scope="session" var="memberSession"></s:set>
	<s:property value="#session.memberSession.name"></s:property>
	<s:property value="#session.memberSession.age"></s:property>
	<s:property value="#session.memberSession.email"></s:property>
	<h1>s:push</h1>
	<s:push value="#session.memberSession">
		<s:property value="name"/>
		<s:property value="email"/>
		<s:property value="age"/>
		<s:property value="id"/>
		<s:property value="tele"></s:property>
	</s:push>
	<h1>s:bean</h1>
	<s:bean name="com.briup.bbs.pojo.Post" var="post">
		<s:param name="title" value="'我的奋斗'"/>
		<s:param name="content" value="'奋斗吧，骚年'"></s:param>
		<s:property value="title"></s:property>
		<s:property value="content"></s:property>
	</s:bean>
	<br>
	<s:property value="#post.title"></s:property>
	<h1>s:date</h1>
	<s:date name="#request.date" format="yyyy-MM-dd HH:mm:ss"></s:date>
	<h1>s:include</h1>
	<s:include value="/login.jsp"></s:include>
	<s:debug></s:debug>
	</body>
</html>