<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% response.setContentType("text/html;charset=UTF-8"); %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String studentName = (String)session.getAttribute("studentName"); %>
<% Integer num = (Integer)session.getAttribute("studentNumber"); %>
<% if(session.getAttribute("user") == null) {
	response.sendRedirect("index.jsp");
	} else {
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= studentName %>さんの授業日程一覧</title>
<style>
.scheduleBox  {
	background-color: white;
	width: 40%;
	border-radius: 10px;
	margin: 0 10px 10px 10px;
}
</style>
</head>
<body>
	<%@include file= "header.jsp" %>
	<div>
		<%= studentName %>さんの授業日程一覧
		<a href="studentUpdate.jsp">生徒情報の更新</a>
		<form action="StudentDelete" method="post">
			<input type="submit" value="生徒(<%= studentName %>)の削除"
			style="font-size:15px;border:none;background-color:transparent;color:blue;text-decoration:none;">
	    </form>
	</div>
	<a href="scheduleRegisterPage.jsp">授業日程を追加する</a>
	<div>
	<c:choose>
		<c:when test="${scheduleList[0] != null}">
			<c:forEach var="schedule" items="${scheduleList}">
				<div class="scheduleBox" class="scheduleBox">
					<div>
					${schedule.date}
					${schedule.time}
					</div>
					${schedule.subject}
					${schedule.homework}
					${schedule.memo}
					<form action="scheduleUpdate.jsp" method="get">
						<input type="hidden" value="${schedule.scheduleId}" name="scheduleId">
						<input type="hidden" value="${schedule.number}" name="scheduleNumber">
						<input type="submit" value="スケジュールの更新"
						style="font-size:15px;border:none;background-color:transparent;color:blue;text-decoration:none;">
		    		</form>
		    		<!-- <a href="scheduleUpdate.jsp">スケジュールの更新</a> -->
					<form action="ScheduleDelete" method="post">
						<input type="hidden" value="${schedule.scheduleId}" name="scheduleId">
						
						<input type="hidden" value="${schedule.number}" name="scheduleNumber">
						<input type="submit" value="日程の削除"
						style="font-size:15px;border:none;background-color:transparent;color:blue;text-decoration:none;">
		    		</form>
		    		<%-- <% number++; %> --%>
	    		</div>
			</c:forEach>
		</c:when>
		<c:otherwise>
		授業日程がありません
		</c:otherwise>
	</c:choose>
	</div>
	<div><a href="home.jsp">homeに戻る</a></div>
</body>
</html>
<% } %>