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
  		margin-right: 60px;
	}
	
	.box {
		margin: auto;
		margin-top: 100px ;
		width: 20%;
		background-color: white;
	}
	
	a {
		text-decoration: none;
	}
	
	.link-btn {
		display: block;
	}
	
	.btn-arrangement {
		display: flex;
	}
	
	.btn {
		text-align: center;
		margin-right: auto;
		margin: 10px;
		width: 30%;
	}
	
	
	.btn-wrapper {
		display: flex;
		text-alugn: center;
		margin-right: auto;
		margin-top: 150px;
	}
	
	.btn {
	  display: inline-block;
	  border-radius: 10px;
	  font-size: 18px;
	  text-align: center;
	  padding: 12px 12px;
	  background: #3399FF	;
	  color: white;
	  line-height: 1em;
	  width: 50%;
	  margin: 0 50px;
	}
	</style>
	</head>
	<body>
		<%@include file= "header.jsp" %>
		<!-- <div class="container">
			<div class="box">
				<div class="btn-arrangement">
					<div class="btn">
						<a href="signupPage.jsp" class="link-btn">サインアップ</a>
					</div>
					<div class="btn">
						<a href="loginPage.jsp" class="link-btn">ログイン</a>
					</div>
				</div>
			</div>
		</div> -->
		<div class="btn-wrapper">
			<a href="signupPage.jsp" class="btn">サインアップ</a>
			<a href="loginPage.jsp" class="btn">ログイン</a>
		</div>
	</body>
</html>
<% } else { 
	response.sendRedirect("home.jsp");
} %>