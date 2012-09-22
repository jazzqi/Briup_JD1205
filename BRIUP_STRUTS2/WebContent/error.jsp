<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<title>Insert title here</title>
	</head>
	<body>
	对不起，服务器内部错误！
<!-- 因为是服务器内部跳转，当前路径是出错的action的路径 -->
<a href="/briup_struts2/login.jsp">请重新登陆</a>
<!-- 使用basePath以后,超链接和表单提交的路径会自动添加basePath路径，可以直接识别当前路径 -->
<!-- basePath + login.jsp -->
<a href="login.jsp">请重新登陆</a>
	</body>
</html>