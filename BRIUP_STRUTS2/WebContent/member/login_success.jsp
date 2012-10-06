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
	<script language="javascript">
		var xmlHttp = null;
		if(window.XMLHttpRequest){
			xmlHttp = new XMLHttpRequest();
		}else if(window.ActiveXObject){
			xmlHttp = new XMLHttpRequest("Microsoft.XMLHTTP");
		}else{
			alert("Sorry, your broswer doesn't support Ajax! ");
		}
		function showMember(memberNameVar){
			xmlHttp.open("get","member/showMember.action?memberName="+memberNameVar,true);
			xmlHttp.onreadystatechange = showMemberCallback;
			xmlHttp.send(null);
		}
		function showMemberCallback(){
			if(xmlHttp.readyState==4){
				if(xmlHttp.status==200){
					var member = xmlHttp.responseXML;
					var showMemberDiv = document.getElementById("showMemberDiv");
					showMemberDiv.style.display="block";
					document.getElementById("memberName").value = member.getElementsByTagName("name")[0].firstChild.nodeValue;
					document.getElementById("memberEmail").value = member.getElementsByTagName("email")[0].firstChild.nodeValue;
					document.getElementById("memberTele").value = member.getElementsByTagName("tele")[0].firstChild.nodeValue;
					document.getElementById("memberAge").value = member.getElementsByTagName("age")[0].firstChild.nodeValue;
					document.getElementById(member.getElementsByTagName("gender")[0].firstChild.nodeValue).checked = true;
				}
			}
		}
		function modify(){
			var memberName = document.getElementById("memberName").value;
			var memberEmail = document.getElementById("memberEmail").value;
			var memberTele = document.getElementById("memberTele").value;
			var memberAge = document.getElementById("memberAge").value;
			var memberGender = "";
			if(document.getElementById("male").checked == true){
				memberGender = document.getElementById("male").value;
			}else{
				memberGender = document.getElementById("female").value;
			}
			if(memberName==null){
				alert("username should not be null");
			}
			xmlHttp.open("get","../member/ajaxModifyAction.action?member.name="+memberName+"&member.email="+memberEmail+"&member.tele="+memberTele+"&member.age="+memberAge+"&member.gender="+memberGender,true);
			xmlHttp.onreadystatechange = modifyCallback;
			xmlHttp.send(null);
		}
		function modifyCallback(){
			if(xmlHttp.readyState==4){
				if(xmlHttp.status==200){
					var result = xmlHttp.responseText;
					if(result=="true"){
						alert("修改成功!");
						alert(document.getElementById("memberName").value);
					} else{
						alert("修改失败!");
					}
				}
			}
		}
	</script>
	<body>
	<s:property value="gender" />,<span style="text-decoration:underline;cursor:pointer;" onclick="showMember(this.innerHTML)">${sessionScope.member.name }</span>,<s:property value="#session.member.name" /> 登录成功！
	<a href="../modify.jsp">修改个人信息</a>
	<a href="../post/add_post.jsp">发帖</a>
	<a href="../post/listPost.action?currentPage=1">查看我的帖子</a>
	<a href="../post/listAllPost.action?currentPage=1">查看所有帖子</a>
	<div id="showMemberDiv" style="display:none; margin:auto; width:300px;">
		<table border="1px">
			<tr>
				<td>姓名</td>
				<td>
					<input type="text" name="memberName" id="memberName" disabled="disabled"/>
				</td>
			</tr>
			<tr>
				<td>年龄</td>
				<td>
					<input type="text" name="memberAge" id="memberAge" />
				</td>
			</tr>
			<tr>
				<td>
					性别
				</td>
				<td>
					<input type="radio" name ="memberGender" id="male" value="male" checked="checked" />男
					<input type="radio" name ="memberGender" id="female" value="female" />女
				</td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input type="text" name="memberEmail" id="memberEmail" /></td>
			</tr>
			<tr>
				<td>联系方式</td>
				<td><input type="text" name="memberTele" id="memberTele" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" id="" onclick="modify()" value="修改"></td>
			</tr>
		</table>
	</div>
	<s:debug></s:debug>
	</body>
</html>