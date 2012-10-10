function createXMLHttp() {
	var ajax;
	if (window.XMLHttpRequest) { // Mozilla 浏览器
		ajax = new XMLHttpRequest();
		if (ajax.overrideMimeType) { // 设置MiME类别
			ajax.overrideMimeType("text/xml");
		}
	} else if (window.ActiveXObject) { // IE浏览器
		try {
			ajax = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				ajax = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
			}
		}
	}
	return ajax;
}

var passwdXmlHttp = createXMLHttp();

function getNewPasswd(form, userName, passwdQuestion, passwdAnswer) {
	// xmlHttp = createXMLHttp();
	var url = form.action;
	var message = "nickname=" + userName + "&passwordquestion="
			+ passwdQuestion + "&passwordanswer=" + passwdAnswer;
	passwdXmlHttp.onreadystatechange = passwdCallback;
	passwdXmlHttp.open("post", url, true);
	passwdXmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	passwdXmlHttp.send(message);
	return false;
}

var randomMemberXmlHttp = createXMLHttp();

function getRandomMember(url) {
	// alert(url);
	randomMemberXmlHttp.onreadystatechange = randomMemberCallback;
	randomMemberXmlHttp.open("get", url, true);
	randomMemberXmlHttp.send(null);
}

var queryMembersXmlHttp = createXMLHttp();

function queryMembers(url) {
	//alert(document.getElementById("age"));
	var message = "age=" + document.getElementById("age").value + "&gender="
			+ document.getElementById("gender").value + "&provincecity="
			+ document.getElementById("provinceCity").value;
	queryMembersXmlHttp.onreadystatechange = queryMemberCallback;
	queryMembersXmlHttp.open("post", url, true);
	queryMembersXmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	queryMembersXmlHttp.send(message);
	return false;
}

var addFriendXmlHttp = createXMLHttp();
function addFriend(name){
	var url = "/RunCommunity/member/addFriendAction.action?member_nickname="+name;
	addFriendXmlHttp.onreadystatechange = addFriendCallback;
	addFriendXmlHttp.open("get",url,true);
	addFriendXmlHttp.send(null);
}

function addFriendCallback(){
	if(addFriendXmlHttp.readyState == 4 && addFriendXmlHttp.status == 200){
		var info = addFriendXmlHttp.responseText;
		if(info == "ok"){
			alert("添加好友成功");
		}else if(info == "not found"){
			alert("未找到该用户");
		}else if(info == "already"){
			alert("对方已经是您的好友了，请勿重复添加! ");
		}else {
			alert("something went wrong~");
		}
	}
}

function passwdCallback() {
	if (passwdXmlHttp.readyState == 4 && passwdXmlHttp.status == 200) {
		var newPwd = passwdXmlHttp.responseText;
		if (newPwd != 0) {
			alert("\u60a8\u7684\u65b0\u5bc6\u7801\u662f: " + newPwd);
		} else {
			alert("\u5bf9\u4e0d\u8d77\u4f60\u7684\u8f93\u5165\u6709\u8bef, \u8bf7\u91cd\u8bd5! ");
		}
	}
}
function randomMemberCallback() {
	if (randomMemberXmlHttp.readyState == 4 && randomMemberXmlHttp.status == 200) {
		showResults(randomMemberXmlHttp.responseXML);
	}
}
function queryMemberCallback() {
	if (queryMembersXmlHttp.readyState == 4 && queryMembersXmlHttp.status == 200) {
		showResults(queryMembersXmlHttp.responseXML);
	}
}

function showResults(responseXml){
	var nicknames = "";
	nicknames = responseXml.getElementsByTagName("nickname");
	var genders = responseXml.getElementsByTagName("gender");
	var ages = responseXml.getElementsByTagName("age");
	var provincecitys = responseXml.getElementsByTagName("provincecity");
	var length = nicknames.length;
	var resultTab = document.getElementById("resultTab");
	resultTab.innerHTML = "";
	for ( var i = 0; i < length; i++) {
	// alert(nicknames[0].firstChild.nodeValue);
	resultTab.innerHTML += '<tr height="25">'
			+ '<td width="15%" align="center">'
			+ nicknames[i].firstChild.nodeValue + '</td>'
			+ '<td width="15%" align="center">'
			+ ((genders[i].firstChild.nodeValue == 0) ? '男' : '女')
			+ '</td>' + '<td width="15%" align="center">'
			+ ages[i].firstChild.nodeValue + '</td>'
			+ '<td width="15%" align="center">'
			+ provincecitys[i].firstChild.nodeValue + '</td>'
			+ '<td width="20%" align="center">'
			+ '<span onclick=\'addFriend("'+nicknames[i].firstChild.nodeValue+'")\'>添加好友<span>' + '</td>'
			+ '<td width="20%" align="center">'
			+ '<a href="sendInfo.jsp?receiverName='+nicknames[i].firstChild.nodeValue+'">发送短信</a>' + '</td>' + '</tr>';
	}
}