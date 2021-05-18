<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String nameErrorMsg = (String)request.getAttribute("nameErrorMsg"); %>
<% String passErrorMsg = (String)request.getAttribute("passErrorMsg"); %>
<% String passConfirmErrorMsg = (String)request.getAttribute("passConfirmErrorMsg"); %>
<% String registerErrorMsg = (String)request.getAttribute("registerErrorMsg"); %>
<% if(session.getAttribute("user") == null) { %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
</head>
<body>
	<%@include file= "header.jsp" %>
	<form action="Signup" method="post">
	<div>
	名前:
		<input type="text" name="name" maxlength="20">
		<% if(nameErrorMsg != null) { %>
		<%= nameErrorMsg %>
		<% } %>
	</div>
	<div>
	パスワード:
		<input type="password" name="password" maxlength="20">
		<% if(passErrorMsg != null) { %>
		<%= passErrorMsg %>
		<% } %>
	</div>
	<div>
	パスワード確認:
		<input type="password" name="password-confirmation" maxlength="20">
		<% if(passConfirmErrorMsg != null) { %>
		<%= passConfirmErrorMsg %>
		<% } %>
	</div>
	<% if(registerErrorMsg != null) { %>
	<%= registerErrorMsg %>
	<% } %>
		<input type="submit" value="サインアップ">
	</form>
</body>
</html>
<% } else {
	response.sendRedirect("home.jsp"); 
} %>