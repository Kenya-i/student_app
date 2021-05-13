<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</body>
</html>
<% } else {
	response.sendRedirect("home.jsp"); 
} %>