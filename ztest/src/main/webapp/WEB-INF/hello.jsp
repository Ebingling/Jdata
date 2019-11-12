<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//Dth HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dth">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页面</title>
</head>
<body>
	
	Hello!
	顺便新增一条数据
	<div>--------------------------------------------------------------</div>
	<!-- <form action="xxxxxxxxxxx这里填写的是新增数据的方法路径xxxxxxxxxxxxxxxxx">  -->
	<form action="/main/insert">
		<div style="margin-right: 5px;">用户名：<input type="text" name="username" /></div>
		<div style="margin-right: 5px;">密码：<input type="text" name="password" /></div>
		<div style="margin-right: 5px;">年龄：<input type="text" name="age" /></div>
		<div style="margin-right: 5px;">地址：<input type="text" name="address" /></div>
		<div style="margin-right: 5px;"><input type="submit" value="提交"></div>
	</form>
	
	
</body>
</html>