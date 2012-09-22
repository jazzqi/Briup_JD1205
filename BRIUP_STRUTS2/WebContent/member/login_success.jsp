<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
	</head>
	<body>
	<s:property value="gender" />,${sessionScope.member.name },<s:property value="#session.member.name" /> 登录成功！<a href="../modify.jsp">修改个人信息</a>
	<a href="../post/add_post.jsp">发帖</a>
	<a href="../post/listPost.action?currentPage=1">查看我的帖子</a>
	<a href="../post/listAllPost.action?currentPage=1">查看所有帖子</a>
	<s:debug></s:debug>
	</body>
</html>