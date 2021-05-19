<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% if(session.getAttribute("user") == null) { %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style>
.top-title {
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

.error {
	text-align: center;
	margin-bottom: 20px;
	margin-top: 20px;
	color: red;
}

input[type=text] {
	width: 80%;
	height: 25px;
}

input[type=password] {
	width: 80%;
	height: 25px;
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
		<a href="signupPage.jsp" class="link">サインアップページ</a>
	</div>
	<div class="box">
		<div class="top-title">ログイン</div>
		<form action="Login" method="post">
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
			</table>	
			<input type="submit" value="ログイン">
		</form>
	</div>
	<c:if test="${errorMsg != null}">
		<div class="error">${errorMsg}</div>
	</c:if>
</body>
</html>
<% } else {
	response.sendRedirect("home.jsp"); 
} %>