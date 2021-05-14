<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page import="java.util.List" %> --%>
<%@ page import="model.UserDto" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% System.out.println("入ったよ"); %>
<%-- <%@ page import="model.StudentDto" %> --%>
<%-- <% 
   @SuppressWarnings("unchecked")
   List<StudentDto> studentList = (List<StudentDto>)session.getAttribute("studentList");
 %> --%>
<% if(session.getAttribute("user") == null) {
	response.sendRedirect("index.jsp");
	} else {
%>
<%-- <% UserDto userWithSession = (UserDto)session.getAttribute("user"); %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>homeです</div>
	<div>${user.name}さんの生徒一覧</div>
	<%-- <% if(studentList != null) {
		for(int i = 1; i <= studentList.size(); i++) { %> --%>
	<div>
		<c:choose>
			<c:when test="${studentList != null}">
				<c:forEach var="student" items="${studentList}" >
					<div>名前: 
					<form action="schedulePage.jsp" method="post">
						<input type="hidden" value="${student.id}">
						<input type="submit" value="${student.name}">
					</form>
					</div>
					<div>学年: ${student.schoolGrade}</div>
					<div>性別: ${student.gender}</div>
				</c:forEach>
			</c:when>
		</c:choose>
	<%-- <c:if test="${studentList != null}" >
		<c:forEach var="student" items="${studentList}" >
			<div>名前: ${student.name}</div>
			<div>学年: ${student.schoolGrade}</div>
			<div>性別: ${student.gender}</div>
		</c:forEach>
	</c:if> --%>
	</div>
	<%-- <%  }
	 }  %> --%>
	<div><a href="studentRegister.jsp">生徒の登録</a></div>
	<div><a href="Logout">ログアウト</a></div>
</body>
</html>
<% } %> 