function validateMemberName() {
	var memberName = document.getElementById("memberName");
	var memberNameSpan = document.getElementById("memberNameSpan");
	var memberNameString = memberName.value.trim();
	memberNameSpan.innerHTML = "";
	if(memberNameString.length<4 || memberNameString.length > 16){
		memberNameSpan.innerHTML = "用户名长度应该在4到16之间";
		memberNameSpan.style.color="red";
		return false;
	}
	var firstChar = memberNameString.charCodeAt(0);
	if(firstChar < 97 || firstChar > 122){
		memberNameSpan.innerHTML="用户名第一个字母必须为小写"
		memberNameSpan.style.color="red";
		return false;
	}
	memberNameSpan.style.color="green";
	return true;
}

function validateMemberPassword(){
	var memberPassword = document.getElementById("memberPassword");
	var memberPasswordSpan = document.getElementById("memberPasswordSpan");
	var memberPasswordString = memberPassword.value.trim();
	memberPasswordSpan.innerHTML="";
	if(memberPasswordString.length<6||memberPasswrodString>16){
		memberPasswordSpan.innerHTML="密码长度应该在6到16之间";
		memberPasswordSpan.style.color="red";
		return false;
	}
	if(memberPasswordString.substring(0,5) == "12345"){
		memberPasswordSpan.innerHTML="拜托, 这密码也太简单了吧";
		memberPasswordSpan.style.color="red";
		return false;
	}
	memberPasswordSpan.style.color="green";
	return true;
}

function validateMemberAge(e){
	var key;
	if(isIE()){
		key = window.event.keyCode;
	}else{
		key = e.which;
	}
	return (key>=48&&key<=57)||key==189||key==46||key==8;
}

function isIE(){
	var isIE = (document.all)?true:false;
	return isIE;
}

function validateMemberEmail(){
	var memberEmail = document.getElementById("memberEmail");
	var memberEmailString = memberEmail.value.trim();
	var memberEmailSpan = document.getElementById("memberEmailSpan");
	memberEmailSpan.innerHTML="";
	var prefix = memberEmailString.indexOf("@")
	var lastfix = memberEmailString.lastIndexOf(".");
	if(prefix<1||lastfix-prefix<2||lastfix==(memberEmailString.length-1)){
		memberEmailSpan.innerHTML="邮箱格式不正确";
		memberEmailSpan.style.color="red";
		return false;
	}
	memberEmailSpan.style.color="green";
	validateAjaxEmail(memberEmailString);
	if(memberEmailSpan.style.color=="green"){
		return true;
	}
}

function validateForm(){
	return validateMemberName()&&validateMemberPassword()&&validateMemberAge()&&validateMemberEmail();
	//return false;
}


//Ajax method
var xmlHttpRequest = null;
function init() {
	if (window.XMLHttpRequest) {
		xmlHttpRequest = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
	} else {
		alert("对不起，您的浏览器不支持ajax技术");
	}
	//alert(xmlHttpRequest);
}

function validateAjaxMemberName() {
	if(document.getElementById("memberName").value.length>=4){
		memberNameVar = document.getElementById("memberName").value;
		xmlHttpRequest.open("GET", "registerAjaxServlet?memberName="
				+ memberNameVar, true);
		xmlHttpRequest.onreadystatechange = memberNameCallback;
		xmlHttpRequest.send();
	}
}

function memberNameCallback() {
	if (xmlHttpRequest.readyState == 4) {
		if (xmlHttpRequest.status == 200) {
			var memberNameString = xmlHttpRequest.responseText;
			var memberNameSpan = document.getElementById("memberNameSpan");
			memberNameSpan.innerHTML = memberNameString.trim().split(":")[0];
			memberNameSpan.style.color = memberNameString.trim().split(":")[1];
		}
	}
}

function validateAjaxEmail(memberEmailVar){
	//var memberEmail = document.getElementById("memberEmail").value;
	xmlHttpRequest.open("GET","registerAjaxServlet?memberEmail="+memberEmailVar,true);
	xmlHttpRequest.onreadystatechange = memberEmailCallback;
	xmlHttpRequest.send();
}

function memberEmailCallback(){
	if(xmlHttpRequest.readyState == 4){
		if(xmlHttpRequest.status == 200){
			var memberEmailString = xmlHttpRequest.responseText;
			var memberEmailSpan = document.getElementById("memberEmailSpan");
			memberEmailSpan.innerHTML = memberEmailString.trim().split(":")[0];
			memberEmailSpan.style.color = memberEmailString.trim().split(":")[1];
		}
	}
}