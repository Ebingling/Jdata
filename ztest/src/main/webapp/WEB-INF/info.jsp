<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//Dth HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dth">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页面</title>
<script type="text/javascript" >
	function del() { 
		var msg = "是否切换状态";
		if (confirm(msg)==true){
			return true;
		} else {
			return false;
		}
	}
</script>
</head>
<body>
	<div>--------------------------------------新闻显示区---------------------------------------</div>
	<table border="0px" width="1200px"> 
			<c:forEach var="info" items="${info}" varStatus="c1">
				<tr>
					<td>${info.title}</td>
					<td>${info.text}</td>
					<td>${info.city}</td>
				</tr>
			</c:forEach>
	</table>
	<div>--------------------------------------后台处理区---------------------------------------</div>
	<div>
		<table border="1px" width="1200px"> 
			<tr>
				<td width="6%">id</td>
				<td width="14%">标题</td>
				<td width="34%">正文</td>
				<td width="12%">状态</td>
				<td width="12%">城市</td>
				<td width="12%">操作</td>
			</tr>
			<c:forEach var="user" items="${user}" varStatus="c1">
				<tr>
					<td>${user.id}</td>
					<td>${user.title}</td>
					<td>${user.text}</td>
					<td>${user.state}</td>
					<td>${user.city}</td>
					<td width="6%">
						<form action="/enfo/update" method="post" >
							<input type="hidden" name="id" value="${user.id}" />
							<input type="hidden" name="state" value="${user.state}" />
							<input id="bi1" type="submit" value="切换上线/下线" >
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div>--------------------------------------------------------------</div>
	
</body>
</html>