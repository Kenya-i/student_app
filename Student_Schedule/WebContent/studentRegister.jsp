<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% if(session.getAttribute("user") != null) { %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>生徒の登録</title>
</head>
<body>
	<%@include file= "header.jsp" %>
	<div>生徒の登録ページ</div>
	<form action="Student" method="post">
		<input type="text" name="name">
		<select name="school-grade">
			<% for(int i = 1; i <= 6; i++) { %>
			<option value="小学<%= i %>年生">小学<%= i %>年生</option>
			<% } %>
			<% for(int i = 1; i <= 3; i++) { %>
			<option value="中学<%= i %>年生">中学<%= i %>年生</option>
			<% } %>
			<% for(int i = 1; i <= 3; i++) { %>
			<option value="高校<%= i %>年生">高校<%= i %>年生</option>
			<% } %>
			<option value="既卒">既卒</option>
		</select>
		<input type="radio" name="gender" value="man" checked>男
		<input type="radio" name="gender" value="woman">女   
		<input type="submit" value="登録">
	</form>
</body>
</html>
<% } else { 
	response.sendRedirect("index.jsp");
} %>