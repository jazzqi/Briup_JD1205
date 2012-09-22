<%@page import="com.briup.bbs.pojo.Member"%>
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
		<div>
			<form action="member/modifyAction" method="get">
				<table>
					<tr>
						<td>
							帐号：
						</td>
						<td>
							<input type="text" name="name" value="${sessionScope.member.getName()}" />
						</td>
					</tr>
					<tr>
						<td>
							密码：
						</td>
						<td>
							<input type="password" name="password" value="${sessionScope.member.getPassword() }"/>
						</td>
					</tr>
					<tr>
						<td>
							年龄：
						</td>
						<td>
							<input type="text" name="age" value="${sessionScope.member.getAge()}" />
						</td>
					</tr>
					<tr>
						<td>
							性别：
						</td>
						<td>
							<% if(((Member)(request.getSession().getAttribute("member"))).getGender().equals("male")) {%>
							<input type="radio" name="gender" value="male" checked="checked"/> 男
							<input type="radio" name="gender" value="female" /> 女
							<%} else {%>
							<input type="radio" name="gender" value="male" /> 男
							<input type="radio" name="gender" value="female" checked="checked" /> 女
							<%} %>
						</td>
					</tr>
					<tr>
						<td>
							Email：
						</td>
						<td>
							<input type="text" name="email" value="${sessionScope.member.getEmail()}"/>
						</td>
					</tr>
					<tr>
						<td>
							电话：
						</td>
						<td>
							<input type="text" name="tele" value="${sessionScope.member.getTele()}"/>
						</td>
					</tr>	
					<tr>
						<td>
							<input type="submit" value="提交" />
						</td>
						<td>
							<input type="reset" value="重置" />
						</td>
					</tr>
				</table>
			</form>	
		</div>
	</body>
</html>