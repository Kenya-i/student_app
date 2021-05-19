<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% if(session.getAttribute("user") == null) {
	response.sendRedirect("index.jsp");
	} else if (session.getAttribute("studentName") == null){
		
		response.sendRedirect("home.jsp");
	} else { 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= session.getAttribute("studentName") %>さんのスケジュール登録ページ</title>
<style>
.login {
	margin-top: 50px;
	text-align: center;
	font-size: 30px;
	font-weight: bold;
	padding-top: 20px;
}

.box {
	margin: 0 auto;
	margin-top: 20px;
	padding-bottom: 20px;
	width: 60%;
	background-color: white;
	text-align: center;
	border-radius: 5px;
}

table {
	
	width: 100%;
}

.back {
	text-align: center;
	margin-top: 30px;
}


input[type=text] {
	width: 80%;
	height: 25px;
}

input[type=date] {
	width: 80%;
	height: 25px;
}


input[type=time] {
	width: 50%;
	height: 25px;
}

select {
	width: 30%;
	height: 25px;
}

textarea {
　　resize: none;
	width: 100%;
	height: 120px;
}
</style>
</head>
<body>
	<%@include file= "header.jsp" %>
	<div class="box">
		<div class="login"><%= session.getAttribute("studentName") %>さんの授業を登録する</div>
		<form action="Schedule" method="post">
			<table>
				<tr>
					<th>
						授業日程
					</th>
					<td>
						<input type="date" name="date">
					</td>
				</tr>
				<tr>
					<th>
						授業開始時間
					</th>
					<td>
						<input type="time" name="time">
					</td>
				</tr>
				<tr>
					<th>
						教科
					</th>
					<td>
						<select name="subject">
							<option value="国語">国語</option>
							<option value="算数">算数</option>
							<option value="数学">数学</option>
							<option value="英語" selected>英語</option>
							<option value="社会">社会</option>
							<option value="地理">地理</option>
							<option value="歴史">歴史</option>
							<option value="公民">公民</option>
							<option value="理科">理科</option>
							<option value="生物">生物</option>
							<option value="化学">化学</option>
							<option value="物理">物理</option>
							<option value="地学">地学</option>
							<option value="その他">その他</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>
						宿題
					</th>
					<td>
						<input type="text" name="homework">
					</td>
				</tr>
				<tr>
					<th>
						学習記録
					</th>
					<td>
						<textarea name="memo">
						</textarea>
					</td>
				</tr>
			</table>
		</form>
		<input type="submit" value="登録">
	</div>
	<div class="back">
		<a href="schedulePage.jsp">授業日程一覧に戻る</a>
	</div>
</body>
</html>
<% } %>