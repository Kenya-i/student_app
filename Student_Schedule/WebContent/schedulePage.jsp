<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% response.setContentType("text/html;charset=UTF-8"); %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String studentName = (String)session.getAttribute("studentName"); %>
<% Integer num = (Integer)session.getAttribute("studentNumber"); %>
<% if(session.getAttribute("user") == null) {
	
		response.sendRedirect("index.jsp");
	
	} else if (studentName == null){
		
		response.sendRedirect("home.jsp");
	} else { 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= studentName %>さんの授業日程一覧</title>
<style>
.top-title {
	margin-top: 50px;
	text-align: center;
	font-size: 30px;
	font-weight: bold;
}

.schedule-box  {
	background-color: white;
	width: 80%;
	border-radius: 10px;
	text-align: center;
	margin: 10px auto;
}

.number {
	font-size: 20px;
}

.link {
	text-align: center;
	margin-bottom: 20px;
}
</style>
</head>
<body>
	<%@include file= "header.jsp" %>
	<div class="top-title">
		<%= studentName %>さんの授業日程一覧
	</div>
	<div class="link">
		<a href="scheduleRegisterPage.jsp">授業日程を追加する</a>
		<a href="studentUpdate.jsp">生徒情報の更新</a>
	</div>
	<div>
	<c:choose>
		<c:when test="${scheduleList[0] != null}">
			<c:forEach var="schedule" items="${scheduleList}">
				<div class="schedule-box" class="scheduleBox">
					<table>
						<tr>
							<td class="number">
								${schedule.number + 1}
							</td>
						</tr>
						
						<tr>
							<th>日程</th>
							<td>${schedule.date}</td>
						</tr>
						<tr>
							<th>時間</th>
							<td>${schedule.time}</td>
						</tr>				
						<tr>
							<th>教科</th>
							<td>${schedule.subject}</td>
						</tr>			
						<tr>
							<th>宿題</th>
							<td>${schedule.homework}</td>
						</tr>
						
						<tr>
							<th>メモ</th>
							<td>${schedule.memo}</td>
						</tr>
						<tr>
							<th></th>
							<td></td>
						</tr>
		    		</table>
		    		<div>
		    		<form action="scheduleUpdate.jsp" method="get">
						<input type="hidden" value="${schedule.scheduleId}" name="scheduleId">
						<input type="hidden" value="${schedule.number}" name="scheduleNumber">
						<input type="submit" value="スケジュールの更新"
						style="font-size:15px;border:none;background-color:transparent;color:blue;text-decoration:none;">
		    		</form>
					<form action="ScheduleDelete" method="post">
						<input type="hidden" value="${schedule.scheduleId}" name="scheduleId">							
						<input type="hidden" value="${schedule.number}" name="scheduleNumber">
						<input type="submit" value="日程の削除"
						style="font-size:15px;border:none;background-color:transparent;color:blue;text-decoration:none;">
			   		</form>
			   		</div>
	    		</div>
			</c:forEach>
		</c:when>
		<c:otherwise>
		<div class="link">
			授業日程がありません
		</div>
		</c:otherwise>
	</c:choose>
	</div>
	<div class="link"><a href="home.jsp">homeに戻る</a></div>
</body>
</html>
<% } %>