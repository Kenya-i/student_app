<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% if(session.getAttribute("user") == null) { %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>生徒管理アプリ</title>
	<style>
	.container {
		width: 100%;
  		/* max-width: 1200px; */
  		/* margin-right: auto; */
  		/* margin-left: auto; */
  		/* margin-left: 60px; */
  		margin-right: 60px;
	}
	
	.box {
		margin: auto;
		margin-top: 100px ;
		width: 40%;
		background-color: white;
	}
	
	.btn-arrangement {
		display: flex;
	}
	
	.btn {
		margin-right: 50px;
	}
	</style>
	</head>
	<body>
		<%@include file= "header.jsp" %>
		<div class="container">
			<div class="box">
				<div class="btn-arrangement">
					<div class="btn">
						<a href="signupPage.jsp">サインアップ</a>
					</div>
					<div>
						<a href="loginPage.jsp">ログイン</a>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
<% } else { 
	response.sendRedirect("home.jsp");
} %>