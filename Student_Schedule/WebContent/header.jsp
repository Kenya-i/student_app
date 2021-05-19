<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
<style>
body {
	margin: 0;
	background-color: #F2FBFF;
}

.header {
	height: 80px;
	background-color: #E0F6FF;
	box-shadow: 0 3px 6px rgba(0, 0, 0, 0.05); /*これを付け足し*/
}

.logout {
	text-decoration: none;
	color: white;
	text-shadow:  2px  2px 10px #777;
	font-size: 20px;
	padding: 20px;
}

ul {
	margin: 0;
}

.title {
	font-weight: bold;
	font-size: 30px;
	line-height: 80px;
	display: flex;
	list-style: none;
	padding-left: 20px
}

li:first-child {
   margin-right: auto;
}
</style>
</head>
<% if(session.getAttribute("user") != null) { %>
<div class="header">
	<div class="container">
		<ul class="title">
			<li>
				生徒管理アプリ
			</li>
			<li>
				<a href="Logout" class="logout">ログアウト</a>
			</li>
		</ul>
	</div>
</div>
<% } else { %>
<div class="header">
	<div class="container">
		<div class="title">生徒管理アプリ</div>
	</div>
</div>
<% } %>