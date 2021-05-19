<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% if(session.getAttribute("user") == null) {
	
	response.sendRedirect("index.jsp");
	
	} else if(request.getParameter("scheduleId") == null || request.getParameter("scheduleNumber") == null) {
		
		response.sendRedirect("home.jsp");
	
	} else {
%>
<% String id = request.getParameter("scheduleId"); %>
<% int scheduleId = Integer.parseInt(id); %>
<% session.setAttribute("scheduleId", scheduleId); %>
<% String number = request.getParameter("scheduleNumber"); %>
<% int scheduleNumber = Integer.parseInt(number); %>
<% session.setAttribute("scheduleNumber", scheduleNumber); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スケジュールの更新</title>
<style>
.top-title {
	margin-top: 50px;
	text-align: center;
	font-size: 30px;
	font-weight: bold;
	margin-bottom: 20px;
}

table {
	
	width: 100%;
}

.box {
	margin: auto;
	margin-top: 20px ;
	width: 60%;
	background-color: white;
	text-align: center;
	border-radius: 5px;
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
		<div class="top-title">スケジュールの更新</div>
		<c:choose>
	    	<c:when test="${scheduleList[0] != null}">
	    		<c:forEach var="schedule" begin="<%= scheduleNumber %>" end="<%= scheduleNumber %>" items="${scheduleList}">
	    			<form action="ScheduleUpdate" method="post">
	    				<table>
		    				<tr>
		    					<th>
		    						授業日程
		    					</th>
		    					<td>
									<input type="date" value="${schedule.date}" name="date">
								</td>
							</tr>
							<tr>
								<th>
									授業開始時間
								</th>
								<td>
									<input type="time" value="${schedule.time}" name="time">
								</td>
							</tr>
							<tr>
								<th>
									教科
								</th>
								<td>
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
								</td>
							</tr>
							<tr>
								<th>
									宿題
								</th>
								<td>
									<input type="text" value="${schedule.homework}" name="homework">
								</td>
							</tr>
							<tr>
								<th>
									学習記録
								</th>
								<td>
									<textarea name="memo">
									${schedule.memo}
									</textarea>
								</td>
							</tr>
						</table>
						<input type="submit" value="登録">
	    			</form>
				</c:forEach>
	    	</c:when>
	    </c:choose>
	</div>
	<div class="back">
    	<a href="schedulePage.jsp">授業日程一覧に戻る</a>
    </div>
</body>
</html>
<% } %>