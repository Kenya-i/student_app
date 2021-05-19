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
.top-title {
	margin-top: 50px;
	text-align: center;
	font-size: 30px;
	font-weight: bold;
	margin-bottom: 20px;
}

.top-sub {
	text-align: center;
}

.student-wrapper {
	text-align: center;
}

.no-register {
	text-align: center;
	margin-top: 20px;
	font-weight: bold;
}

.student-box {
	background-color: white;
	width: 40%;
	border-radius: 10px;
	text-align: center;
	margin: 10px auto;
	
}

.student-wrapper {
	display: flex;
}
</style>
</head>
<body>
	<%@include file= "header.jsp" %>
	<div>
		<div class="top-title">
			${user.name}さんの生徒一覧
		</div>
		<div class="top-sub">
			<a href="studentRegister.jsp">生徒の登録</a>
		</div>
	</div>
	<c:choose>
		<c:when test="${studentList[0] != null}">
			<div class="student-wrapper">
				<c:forEach var="student" items="${studentList}" >
					<!-- <div class="student-wrapper"> -->
						<div class="student-box">
							<table>
								<tr>
									<th>
										名前
									</th>
									<td>
										<form action="PreSchedulePage" method="post">
											<input type="hidden" value="${student.name}" name="studentName">
											<input type="hidden" value="${student.studentId}" name="studentId">   <!-- 生徒のID -->
											<input type="hidden" value="${student.number}" name="studentNumber">
											<input type="submit" value="${student.name}"
											style="font-size:15px;border:none;background-color:transparent;color:blue;text-decoration:none;">
										</form>
									</td>
								</tr>
								<tr>
									<th>
										学年
									</th>
									<td>
										${student.schoolGrade}
									</td>
								</tr>
								<tr>
									<th>
										性別
									</th>
									<td>
										${student.gender}
									</td>
								</tr>
							</table>
						</div>
					</div>
				</c:forEach>
			</div>
		</c:when>
		<c:otherwise>
			<div class="no-register">
				生徒は登録されていません
			</div>
		</c:otherwise>
	</c:choose>
</body>
</html>
<% } %> 