<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/regist.css">
</head>
<title>注册</title>
<body>
<h1>填写以下信息完成注册</h1>
<form action="regist" method="post" onsubmit="return checkForm()">
<div class="div1">
<div><span>用&nbsp;户&nbsp;名：</span><input type="text" name="uname" id="uname"/></div>
<div><span>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</span><input type="password" name="psd" id="psd"/></div>
<div class="div3"><span>确认密码：</span><input type="password" name="repsd" id="repsd"/></div>
<div class="div2"><input type="submit" value="提交"><input type="button" value="登录" onclick="window.location.href='login.jsp'"></div>
</div>
</form>
<%= (request.getAttribute("msg")==null)?"":request.getAttribute("msg") %>
</body>

<script type="text/javascript">
function checkForm() {
	var uname = document.getElementById("uname").value;
	var psd = document.getElementById("psd").value;
	var repsd = document.getElementById("repsd").value;
	if(uname != null && uname != "") {
		if(psd != null && psd != "") {
			if(repsd !=null && repsd != "") {
				if(psd==repsd) {
					var patt = new RegExp("^[a-z0-9A-Z_]+$");
					if(patt.test(psd)) {
						return true;
					}
					else {
						alert("密码只能由:字母数字下划线组成");
						return false;
					}
				}
				else {
					alert("两次密码输入不一致！");
					return false;
				}
			}
			else {
				alert("请输入确认密码");
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