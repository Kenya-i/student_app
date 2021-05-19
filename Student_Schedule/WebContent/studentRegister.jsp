<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% if(session.getAttribute("user") != null) { %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>生徒の登録</title>
<style>
.register {
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

.form-class {
	text-align: center;
}

.error {
	color: red;
	text-align: center;
	margin-bottom: 20px;
	margin-top: 20px;
}

.link {
	text-align: center;
	margin-bottom: 20px;
	margin-top: 20px;
}

table {
	width: 100%;
}

input[type=text] {
	width: 80%;
	height: 25px;
}

input[type=password] {
	width: 80%;
	height: 25px;
}

</style>
</head>
<body>
	<%@include file= "header.jsp" %>
	<div class="box">
		<div class="register">生徒の登録ページ</div>
		<form action="Student" method="post">
			<table>
				<tr>
					<th>
						生徒の名前
					</th>
					<td>
						<input type="text" name="name">
					</td>
				</tr>
				<tr>
					<th>
						学年
					</th>
					<td>
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
					</td>
				</tr>
				<tr>
					<th>
						性別
					</th>
					<td>
						<input type="radio" name="gender" value="man" checked>男
						<input type="radio" name="gender" value="woman">女
					</td> 
				</tr>
			</table>
			<input type="submit" value="登録">
		</form>
	</div>
	<div class="error">
	<% if(request.getAttribute("error") != null) { %>
		<%= request.getAttribute("error") %>
	<% } %>
	</div>
	<div class="link"><a href="home.jsp">homeに戻る</a></div>
</body>
</html>
<% } else { 
	response.sendRedirect("index.jsp");
} %>