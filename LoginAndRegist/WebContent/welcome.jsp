<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="wuan.User"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<title>煎饼系统</title>
<body style="background-color:PowderBlue; text-align:center">
<%
	User user = (User)session.getAttribute("user");
%>
		<p>欢迎！<%= user.getUname()%></p>
		

</body>
</html>