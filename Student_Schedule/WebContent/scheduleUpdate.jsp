<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String id = request.getParameter("scheduleId"); %>
<% int scheduleId = Integer.parseInt(id); %>
<% session.setAttribute("scheduleId", scheduleId); %>
<% String number = request.getParameter("scheduleNumber"); %>
<% int scheduleNumber = Integer.parseInt(number); %>
<% session.setAttribute("scheduleNumber", scheduleNumber); %>
<% if(session.getAttribute("user") == null) {
	response.sendRedirect("index.jsp");
	} else {
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スケジュールの更新</title>
</head>
<body>
	<%@include file= "header.jsp" %>
	<c:choose>
    	<c:when test="${scheduleList[0] != null}">
    		<c:forEach var="schedule" begin="<%= scheduleNumber %>" end="<%= scheduleNumber %>" items="${scheduleList}">
    			<form action="ScheduleUpdate" method="post">
    				<div>
	    				授業日程
						<input type="date" value="${schedule.date}" name="date">
					</div>
					<div>
						授業開始時間
						<input type="time" value="${schedule.time}" name="time">
					</div>
					<div>
						教科
						<select name="subject">
							<c:choose>
								<c:when test="${schedule.subject == '国語'}">
									<option value="国語" selected>国語</option>
									<option value="算数">算数</option>
									<option value="数学">数学</option>
									<option value="英語">英語</option>
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
								</c:when>
								<c:when test="${schedule.subject == '算数'}">
									<option value="国語">国語</option>
									<option value="算数" selected>算数</option>
									<option value="数学">数学</option>
									<option value="英語">英語</option>
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
								</c:when>
								<c:when test="${schedule.subject == '数学'}">
									<option value="国語">国語</option>
									<option value="算数">算数</option>
									<option value="数学" selected>数学</option>
									<option value="英語">英語</option>
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
								</c:when>
								<c:when test="${schedule.subject == '英語'}">
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
								</c:when>
								<c:when test="${schedule.subject == '社会'}">
									<option value="国語">国語</option>
									<option value="算数">算数</option>
									<option value="数学">数学</option>
									<option value="英語">英語</option>
									<option value="社会" selected>社会</option>
									<option value="地理">地理</option>
									<option value="歴史">歴史</option>
									<option value="公民">公民</option>
									<option value="理科">理科</option>
									<option value="生物">生物</option>
									<option value="化学">化学</option>
									<option value="物理">物理</option>
									<option value="地学">地学</option>
									<option value="その他">その他</option>
								</c:when>
								<c:when test="${schedule.subject == '地理'}">
									<option value="国語">国語</option>
									<option value="算数">算数</option>
									<option value="数学">数学</option>
									<option value="英語">英語</option>
									<option value="社会">社会</option>
									<option value="地理" selected>地理</option>
									<option value="歴史">歴史</option>
									<option value="公民">公民</option>
									<option value="理科">理科</option>
									<option value="生物">生物</option>
									<option value="化学">化学</option>
									<option value="物理">物理</option>
									<option value="地学">地学</option>
									<option value="その他">その他</option>
								</c:when>
								<c:when test="${schedule.subject == '歴史'}">
									<option value="国語">国語</option>
									<option value="算数">算数</option>
									<option value="数学">数学</option>
									<option value="英語">英語</option>
									<option value="社会">社会</option>
									<option value="地理">地理</option>
									<option value="歴史" selected>歴史</option>
									<option value="公民">公民</option>
									<option value="理科">理科</option>
									<option value="生物">生物</option>
									<option value="化学">化学</option>
									<option value="物理">物理</option>
									<option value="地学">地学</option>
									<option value="その他">その他</option>
								</c:when>
								<c:when test="${schedule.subject == '公民'}">
									<option value="国語">国語</option>
									<option value="算数">算数</option>
									<option value="数学">数学</option>
									<option value="英語">英語</option>
									<option value="社会">社会</option>
									<option value="地理">地理</option>
									<option value="歴史">歴史</option>
									<option value="公民" selected>公民</option>
									<option value="理科">理科</option>
									<option value="生物">生物</option>
									<option value="化学">化学</option>
									<option value="物理">物理</option>
									<option value="地学">地学</option>
									<option value="その他">その他</option>
								</c:when>
								<c:when test="${schedule.subject == '理科'}">
									<option value="国語">国語</option>
									<option value="算数">算数</option>
									<option value="数学">数学</option>
									<option value="英語">英語</option>
									<option value="社会">社会</option>
									<option value="地理">地理</option>
									<option value="歴史">歴史</option>
									<option value="公民">公民</option>
									<option value="理科" selected>理科</option>
									<option value="生物">生物</option>
									<option value="化学">化学</option>
									<option value="物理">物理</option>
									<option value="地学">地学</option>
									<option value="その他">その他</option>
								</c:when>
								<c:when test="${schedule.subject == '生物'}">
									<option value="国語">国語</option>
									<option value="算数">算数</option>
									<option value="数学">数学</option>
									<option value="英語">英語</option>
									<option value="社会">社会</option>
									<option value="地理">地理</option>
									<option value="歴史">歴史</option>
									<option value="公民">公民</option>
									<option value="理科">理科</option>
									<option value="生物" selected>生物</option>
									<option value="化学">化学</option>
									<option value="物理">物理</option>
									<option value="地学">地学</option>
									<option value="その他">その他</option>
								</c:when>
								<c:when test="${schedule.subject == '化学'}">
									<option value="国語">国語</option>
									<option value="算数">算数</option>
									<option value="数学">数学</option>
									<option value="英語">英語</option>
									<option value="社会">社会</option>
									<option value="地理">地理</option>
									<option value="歴史">歴史</option>
									<option value="公民">公民</option>
									<option value="理科">理科</option>
									<option value="生物">生物</option>
									<option value="化学" selected>化学</option>
									<option value="物理">物理</option>
									<option value="地学">地学</option>
									<option value="その他">その他</option>
								</c:when>
								<c:when test="${schedule.subject == '物理'}">
									<option value="国語">国語</option>
									<option value="算数">算数</option>
									<option value="数学">数学</option>
									<option value="英語">英語</option>
									<option value="社会">社会</option>
									<option value="地理">地理</option>
									<option value="歴史">歴史</option>
									<option value="公民">公民</option>
									<option value="理科">理科</option>
									<option value="生物">生物</option>
									<option value="化学">化学</option>
									<option value="物理" selected>物理</option>
									<option value="地学">地学</option>
									<option value="その他">その他</option>
								</c:when>
								<c:when test="${schedule.subject == '地学'}">
									<option value="国語">国語</option>
									<option value="算数">算数</option>
									<option value="数学">数学</option>
									<option value="英語">英語</option>
									<option value="社会">社会</option>
									<option value="地理">地理</option>
									<option value="歴史">歴史</option>
									<option value="公民">公民</option>
									<option value="理科">理科</option>
									<option value="生物">生物</option>
									<option value="化学">化学</option>
									<option value="物理">物理</option>
									<option value="地学" selected>地学</option>
									<option value="その他">その他</option>
								</c:when>
								<c:when test="${schedule.subject == 'その他'}">
									<option value="国語">国語</option>
									<option value="算数">算数</option>
									<option value="数学">数学</option>
									<option value="英語">英語</option>
									<option value="社会">社会</option>
									<option value="地理">地理</option>
									<option value="歴史">歴史</option>
									<option value="公民">公民</option>
									<option value="理科">理科</option>
									<option value="生物">生物</option>
									<option value="化学">化学</option>
									<option value="物理">物理</option>
									<option value="地学">地学</option>
									<option value="その他" selected>その他</option>
								</c:when>
							</c:choose>
						</select>
					</div>
					<div>
						宿題
						<input type="text" value="${schedule.homework}" name="homework">
					</div>
					<div>
						学習記録
						<textarea name="memo">
						${schedule.memo}
						</textarea>
					</div>
					<input type="submit" value="登録">
    			</form>
			</c:forEach>
    	</c:when>
    </c:choose>
    <a href="schedulePage.jsp">授業日程一覧に戻る</a>
</body>
</html>
<% } %>