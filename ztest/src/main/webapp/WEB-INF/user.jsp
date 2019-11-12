<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//Dth HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dth">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页面</title>
</head>
<body>
	<div>
		<form action="/main/selectByUsername">
			姓名查询：<input type="text" name="username">
			<input type="submit" value="查询">
		</form>
	</div>
	<div>--------------------------------------------------------------</div>
	<div>
		<table border="1px" width="1200px"> 
			<tr>
				<td width="6%">姓名</td>
				<td width="14%">密码</td>
				<td width="14%">年龄</td>
				<td width="32%">地址</td>
			</tr>
			<c:forEach var="list" items="${list}" varStatus="c1">
				<tr>
					<td>${list.username}</td>
					<td>${list.password}</td>
					<td>${list.age}</td>
					<td>${list.address}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div>--------------------------------------------------------------</div>
	<form action="/main/hello" method="post">
		<input type="submit" value="跳转你好页面" >
	</form>
	<div>--------------------------------------------------------------</div>
	<form action="/main/delete">
		请输入你需要删除的id：<input type="text" name="userid">
		<input type="submit" value="点击按钮立即删除" >
	</form>
</body>
</html>