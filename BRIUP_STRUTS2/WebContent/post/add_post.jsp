<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
	<form action="addPost.action" method="post">
		<table>
			<tr>
				<td>主题</td>
				<td>
					<select name="topic.name" id="" >
						<s:iterator value="#session.topics" id="topic">
							<option value="<s:property value='#topic.name' />">
								<s:property value='#topic.name' />
							</option>
						</s:iterator>
					</select>
				</td>
			</tr>
			<tr>
				<td>标题</td>
				<td><input type="text" name="post.title" id="" /></td>
			</tr>
			<tr>
				<td>内容</td>
				<td><textarea name="post.content" id="" cols="20" rows="10"></textarea></td>
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