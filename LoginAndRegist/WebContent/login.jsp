<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/login.css">
</head>
<title>登录</title>
</head>
<body>
<h1 class="h1">煎饼考勤系统</h1>
<form action="login" method="post" onsubmit="return checkForm()">
	<div class="div1"><span>用户名：</span><input type="text" name="uname" id="uname"/></div>
	<div class="div1"><span>密&nbsp;&nbsp;&nbsp;&nbsp;码：</span><input type="password" name="psd" id="psd"/></div>
	<div class="div2"><input type="button" value="注册" onclick="window.location.href='regist.jsp'"/><input type="submit" value="登录"/></div>
</form>
<span class="span"><%= (request.getAttribute("msg")==null)?"":request.getAttribute("msg") %></span>
</body>
<script type="text/javascript">
function checkForm() {
	var uname = document.getElementById("uname").value;
	var psd = document.getElementById("psd").value;
	if(uname != null && uname != "") {
		if(psd != null && psd != "") {
			//用户名和密码都不为空提交表单
			var part = new RegExp("^[a-zA-Z0-9_]+$");
			//正则匹配密码：只能是字母数字下划线
			if(part.test(psd)) {
				return true;
			}
			else {
				alert("密码只能由：字母，数字，下划线组合构成");
				return false;
			}		
		}
		else {
			alert("密码不能为空");
			return false;
		}
	}
	else {
		alert("用户名不能为空");
		return false;
	}
}
</script>
</html>