<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.UserDto" %>
<% if(session.getAttribute("user") == null) {
	response.sendRedirect("index.jsp");
	} else {
 %>
 <% UserDto userWithSession = (UserDto)session.getAttribute("user"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>homeです</div>
	<div><%= userWithSession.getName() %>さんの生徒一覧</div>
	<div><a href="studentRegister.jsp">生徒の登録</a></div>
	<div><a href="Logout">ログアウト</a></div>
</body>
</html>
<% } %> 