<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% if(session.getAttribute("user") == null) { %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action="Login" method="post">
	<div>
	名前:
		<input type="text" name="name" maxlength="20">
	</div>
	<div>
	パスワード:
		<input type="password" name="password" maxlength="20">
	</div>
		<input type="submit" value="ログイン">
	</form>
	<c:if test="${errorMsg != null}">
		<div>${errorMsg}</div>
	</c:if>
</body>
</html>
<% } else {
	response.sendRedirect("home.jsp"); 
} %>