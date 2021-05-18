<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.UserDto" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% if(session.getAttribute("user") == null) {
	response.sendRedirect("index.jsp");
	} else {
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.user-name {
	margin: 20px 0;
}

.studentBox {
	background-color: white;
	width: 40%;
	border-radius: 10px;
	margin: 0 10px 10px 10px;
}

.student-wrapper {
	display: flex;
}
</style>
</head>
<body>
	<%@include file= "header.jsp" %>
	<div class="user-name">${user.name}さんの生徒一覧</div>
	<!-- <div class="student-wrapper"> -->
		<c:choose>
			<c:when test="${studentList != null}">
				<c:forEach var="student" items="${studentList}" >
					<div class="studentBox">
						名前: 
						<form action="PreSchedulePage" method="post">
							<input type="hidden" value="${student.name}" name="studentName">
							<input type="hidden" value="${student.studentId}" name="studentId">   <!-- 生徒のID -->
							<input type="hidden" value="${student.number}" name="studentNumber">
							<input type="submit" value="${student.name}"
							style="font-size:15px;border:none;background-color:transparent;color:blue;text-decoration:none;">
						</form>
						<div>学年: ${student.schoolGrade}</div>
						<div>性別: ${student.gender}</div>
					</div>
				</c:forEach>
			</c:when>
		</c:choose>
	<!-- </div> -->
	<div><a href="studentRegister.jsp">生徒の登録</a></div>
	<div><a href="Logout">ログアウト</a></div>
</body>
</html>
<% } %> 