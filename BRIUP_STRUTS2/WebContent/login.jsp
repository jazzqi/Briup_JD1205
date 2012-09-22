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
		<div>
			<form action="member/loginAction.action" method="get">
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
							<input type="submit" value="提交" />
						</td>
						<td>
							<input type="reset" value="重置" />
						</td>
					</tr>
					<tr>
						<td>
						</td>
						<td>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>