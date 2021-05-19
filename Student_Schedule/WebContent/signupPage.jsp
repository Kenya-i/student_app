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
<style>
.signup {
	margin-top: 50px;
	text-align: center;
	font-size: 30px;
	font-weight: bold;
}

.box {
	margin: auto;
	margin-top: 20px ;
	width: 60%;
	background-color: white;
	text-align: center;
	border-radius: 5px;
}

table {
	
	width: 100%;
}

.form-class {
	text-align: center;
}


input[type=text] {
	width: 80%;
	height: 25px;
}

input[type=password] {
	width: 80%;
	height: 25px;
}

.error {
	color: red;
	text-align: center;
	margin-bottom: 20px;
	margin-top: 20px;
}

.link-btn {
	text-align: center;
	margin-top: 10px;
}

.link {
	text-decoration: none;
}

</style>
</head>
<body>
	<%@include file= "header.jsp" %>
	<div class="link-btn">
		<a href="loginPage.jsp" class="link">ログインページ</a>
	</div>
	<div class="box">
		<div class="signup">サインアップ</div>
		<form action="Signup" method="post">
			<table>
				<tr>
					<th>
						名前
					</th>
					<td>
						<input type="text" name="name" maxlength="20">
					</td>
				</tr>
				<tr>
					<th>
						パスワード
					</th>
					<td>
						<input type="password" name="password" maxlength="20">
					</td>
				</tr>
				<tr>
					<th>
						パスワード確認
					</th>
					<td>
						<input type="password" name="password-confirmation" maxlength="20">
					</td>
				</tr>
			</table>	
			<input type="submit" value="ログイン">
		</form>
	</div>
	<div class="error">
		
		<% if(nameErrorMsg != null) { %>
			<div><%= nameErrorMsg %></div>	
		<% } %>
		
		<% if(passErrorMsg != null) { %>
			<div><%= passErrorMsg %></div>
		<% } %>
		
		<% if(passConfirmErrorMsg != null) { %>
			<div><%= passConfirmErrorMsg %></div>
		<% } %>
		
		<% if(registerErrorMsg != null) { %>
			<div><%= registerErrorMsg %></div>
		<% } %>
	</div>
</body>
</html>
<% } else {
	response.sendRedirect("home.jsp"); 
} %>