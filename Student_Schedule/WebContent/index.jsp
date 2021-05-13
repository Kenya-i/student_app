<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% if(session.getAttribute("user") == null) { %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	<title>生徒管理アプリ</title>
	</head>
	<body>
		<div>
			<div>
				<div>生徒管理アプリ</div>
			</div>
			<div>
				<a href="signupPage.jsp">サインアップ</a>
				<a href="loginPage.jsp">ログイン</a>
			</div>
		</div>
	</body>
</html>
<% } else { 
	response.sendRedirect("home.jsp");
} %>