<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
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
			<form action="member/member!register.action" method="get">
			<s:fielderror fieldName="member.name"/>
			<s:fielderror fieldName="member.password"/>
				<table>
					<tr>
						<td>
							帐号：
						</td>
						<td>
							<input type="text" name="member.name" />
						</td>
					</tr>
					<tr>
						<td>
							密码：
						</td>
						<td>
							<input type="password" name="member.password" />
						</td>
					</tr>
					<tr>
						<td>
							年龄：
						</td>
						<td>
							<input type="text" name="member.age" />
						</td>
					</tr>
					<tr>
						<td>
							性别：
						</td>
						<td>
							<input type="radio" name="member.gender" value="male" /> male
							<input type="radio" name="member.gender" value="female" /> female
						</td>
					</tr>
					<tr>
						<td>
							Email：
						</td>
						<td>
							<input type="text" name="member.email" />
						</td>
					</tr>
					<tr>
						<td>
							电话：
						</td>
						<td>
							<input type="text" name="member.tele" />
						</td>
					</tr>
					<tr>
						<td>
							<input type="submit" value="OK" />
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