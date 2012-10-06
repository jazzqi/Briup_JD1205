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
		<style type="text/css">
			#userInputText{
				width:460px;
				height:30px;
				font-size:20px;
			}
			.searchBtn{
				width:120px;
				height:35px;
				font-size:20px;
				border-radius:5px;
				border:2px solid black;
				margin:0px;
				padding:0px;
			}
			#promptDiv{
				display:table-cell;
				dont-size:20px;
				width:460px;
				height:100%;
			}
		</style>
		<script type="text/javascript">
			var xmlHttpRequest = null;
			if(window.XMLHttpRequest){
				xmlHttpRequest = new XMLHttpRequest();
			}else if(window.ActiveXObject){
				xmlHttpRequest = new XMLHttpRequest("Microsoft XMLHTTP");
			}else {
				alert("抱歉，您的浏览器不支持Ajax");
			}
			
			function promptWord(userInputTextVar){
				document.getElementById("promptDiv").innerHTML="";
				promptDiv.style.border="0";
				if(userInputTextVar.length>0){
					xmlHttpRequest.open("GET","searchServlet?userInputText="+userInputTextVar,true);
					xmlHttpRequest.onreadystatechange = promptWordCallback;
					xmlHttpRequest.send(null);
				}
			}
			
			function promptWordCallback(){
				if(xmlHttpRequest.readyState==4){
					if(xmlHttpRequest.status==200){
						var xmlPromptWords = xmlHttpRequest.responseXML;
						var xmlDoc = xmlPromptWords.documentElement;
						var promptWords = xmlDoc.getElementsByTagName("promptWord");
						var promptDiv = document.getElementById("promptDiv");
						//alert(promptWords.length);
						for(var i=0;i<promptWords.length;i++){
							promptDiv.innerHTML+="<div onmouseover='highlight(this)' onmouseout='noHighlight(this)' onclick='select(this)' >"+promptWords[i].firstChild.nodeValue+"</div>";
							promptDiv.style.border="1px solid black";
							//alert(promptWords[i].firstChild.nodeValue);
						}
					}
				}
			}
			
			function highlight(divVar){
				divVar.style.background="gray";
			}
			
			function noHighlight(divVar){
				divVar.style.background="white";
			}
			function select(divVar){
				var userInputText = document.getElementById("userInputText");
				userInputText.value = divVar.innerHTML;
				var promptDiv = document.getElementById("promptDiv");
				promptDiv.innerHTML="";
				promptDiv.style.border="0";
			}
		</script>
	</head>
	<body>
		<div style="margin:auto;margin-top:150px;width=400px;text-align:center;">
			<img src="./image/logo3w.png" alt="Google"/>
		</div>
		<div style="width:600px;margin:auto;margin-top:30px;">
			<div style="float:left">
				<input id="userInputText" class="userInputText" type="text" onkeyup="promptWord(this.value)" />
				<div id="promptDiv"></div>
			</div>
			<div style="float:right">
				<input type="button" value="Google" class="searchBtn" />
			</div>
		</div>
	</body>
</html>