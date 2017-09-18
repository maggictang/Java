<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<title>注册</title>
<body style="background-color:PowderBlue;text-align:center;">
<h1>完成以下信息成为煎饼侠一员</h1>
<form action="RegistServlet" method="post">  
	<table align="center">	
		<tr>
			<td>用户名:</td>
			<td><input type="text" name="user" placeholder="请输入用户名" ></td>
		</tr>
		<tr>
			<td>昵称:</td>
			<td><input type="text" name="nickname" placeholder="请输入昵称"></td>
		</tr>
		<tr>
			<td>密码:</td>
			<td><input type="password" name="password" placeholder="请输入密码"></td>
		</tr>
		<tr>
			<td>确认密码:</td>
			<td><input type="password" name="repassword" placeholder="请再次输入密码"></td>
		</tr>
	</table>
	<input type="submit" value="提交">
</form>
<font color="red" size="2"> ${msg }</font> 
</body>
</html>