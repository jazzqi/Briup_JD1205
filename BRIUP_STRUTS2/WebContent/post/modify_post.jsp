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
<div>
	<form action="savePost.action" method="post">
		<table>
			<tr>
				<td>主题</td>
				<td>
					<select name="topic.name" >
						<s:iterator value="#session.topics" id="topic">
						<s:if test="#topic.name == #session.post.topic.name">
								<option value="<s:property value='#topic.name' />" selected="selected">
								<s:property value='#topic.name' />
							</option>
						</s:if>
						<s:else>
								<option value="<s:property value='#topic.name' />">
								<s:property value='#topic.name' />
							</option>
						</s:else>
						</s:iterator>
					</select>
				</td>
			</tr>
			<tr>
				<td>标题</td>
				<td><input type="text" name="post.title" id="" value="${sessionScope.post.title }"/></td>
			</tr>
			<tr>
				<td>内容</td>
				<td><textarea name="post.content" id="" cols="20" rows="10"><s:property value="#session.post.content"/></textarea></td>
			</tr>
			<tr>
				<td><input type="submit" value="提交"/></td>
				<td><input type="reset" value="重置"/></td>
			</tr>
		</table>
	</form>
</div>
	</body>
</html>