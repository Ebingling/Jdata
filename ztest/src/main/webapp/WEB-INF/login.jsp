<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//Dth HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dth">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页面</title>
</head>
<body>
	
	<form action="/main/login"><!-- 视情况修改你的提交登录信息的访问地址 -->
		<div>欢迎登陆！</div>
		<div>用户名：<input type="text" name="username"></div>
		<div>密码：<input type="text" name="password"></div>
		<div><input type="submit"></div>
	</form>
</body>
</html>