<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% if(session.getAttribute("user") == null) {
	response.sendRedirect("index.jsp");
	} else {
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= session.getAttribute("studentName") %>さんのスケジュール登録ページ</title>
</head>
<body>
	<%@include file= "header.jsp" %>
	<form action="Schedule" method="post">
		<div>
		授業日程
		<input type="date" name="date">
		</div>
		<div>
		授業開始時間
		<input type="time" name="time">
		</div>
		<div>
		教科
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
		</div>
		<div>
		宿題
		<input type="text" name="homework">
		</div>
		<div>
		学習記録
		<textarea name="memo">
		</textarea>
		<input type="submit" value="登録">
		</div>
	</form>
	<a href="schedulePage.jsp">授業日程一覧に戻る</a>
</body>
</html>
<% } %>