<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<script>
	var xmlHttpRequest = null;
	if (window.XMLHttpRequest) {
		xmlHttpRequest = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		xmlHttpRequest = new XMLHttpRequest("Microsoft.XMLHTTP");
	} else {
		alert("抱歉，您的浏览器不支持Ajax");
	}

	function showCity(provinceVar) {
		xmlHttpRequest.open("GET", "cityServlet?province="
				+ provinceVar.trim(), true);
		xmlHttpRequest.onreadystatechange = showCityCallback;
		xmlHttpRequest.send(null);
	}

	function showCityCallback() {
		if (xmlHttpRequest.readyState == 4) {
			if (xmlHttpRequest.status == 200) {
				var citys = xmlHttpRequest.responseXML
						.getElementsByTagName("city");
				var city = document.getElementById("city");
				city.innerHTML="";
				for ( var i = 0; i < citys.length; i++) {
					city.innerHTML+="<option value="+citys[i].firstChild.nodeValue+">"+citys[i].firstChild.nodeValue+"</option>";
				}
			}
		}
	}
	
	showCity("河南");
</script>
<body>
	<div>
		请您选择： <select name="" id="">
			<option value="江苏" onclick="showCity(this.value)">江苏</option>
			<option value="河南" selected="selected" onclick="showCity(this.value)">河南</option>
			<option value="湖南" onclick="showCity(this.value)">湖南</option>
		</select> 省 <select name="" id="city">
			<option value></option>
		</select> 市
	</div>
</body>
</html>