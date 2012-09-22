<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
.displayTab {
	font-size: 18px;
	text-align: center;
	color: gray;
	font-family: Verdana, serif;
	width: 60%;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<div>
		<table class="displayTab">
			<tr>
				<td>标题</td>
				<td>内容</td>
				<td>主题</td>
				<td>发帖时间</td>
				<td>操作</td>
			<tr>
				<s:iterator value="#session.currentPosts" id="post">
					<tr>
						<td><s:property value="#post.title"></s:property></td>
						<td><s:property value="#post.content"></s:property></td>
						<td><s:property value="#post.topic.name"></s:property></td>
						<td><s:date name="#post.issueDate" format="MM-dd HH:mm" /></td>
						<td><a href="modifyPost.action?postId=<s:property value="#post.id"/>"/> <input type="button" value="修改" />
						</a> <a href="deletePost.action?postId=<s:property value="#post.id"/>"/> <input type="button" value="删除" />
						</a> <a href="viewPost.action?postId=<s:property value="#post.id"/>"/> <input type="button" value="查看" />
						</a></td>
					</tr>
				</s:iterator>
		</table>
		<table class="displayTab">
			<tr>
				<s:if test="currentPage!=1">
					<td><a href="listPost.action?currentPage=1"> <input
							type="button" value="第一页" />
					</a></td>
					<td><a href="listPost.action?currentPage=${currentPage-1 }">
							<input type="button" value="前一页" />
					</a></td>
				</s:if>
				<s:if test="currentPage!=#session.pageCount">
					<td><a href="listPost.action?currentPage=${currentPage+1 }">
							<input type="button" value="下一页" />
					</a></td>
					<td><a
						href="listPost.action?currentPage=${sessionScope.pageCount }">
							<input type="button" value="最后一页" />
					</a></td>
				</s:if>
			</tr>
		</table>
		<div class="displayTab">
			<%
				for (int i = 1; i <= (Integer) (session.getAttribute("pageCount")); i++) {
					if (i != (Integer) session.getAttribute("currentPage")) {
			%>
			<a href="${sessionScope.listMethod }.action?currentPage=<%=i%>"><%=i%></a>
			<%
				} else {
			%>
			<%=i%>
			<%
				}
				}
			%>
		</div>
	</div>
	<div>
		<a href="../member/login_success.jsp">Return</a>
	</div>
</body>
</html>