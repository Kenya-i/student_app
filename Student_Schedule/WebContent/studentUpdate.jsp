<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.StudentDto" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% Integer num = (Integer)session.getAttribute("studentNumber"); %>
<% if(session.getAttribute("user") == null) {
	response.sendRedirect("index.jsp");
	} else {
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>生徒情報更新</title>
</head>
<body>
	<%@include file= "header.jsp" %>
    <c:choose>
    	<c:when test="${studentList[0] != null}">
    		<c:forEach var="student" begin="<%= num %>" end="<%= num %>" items="${studentList}">
    			<form action="StudentUpdate" method="post">
    				<input type="text" value="${student.name}" name="name">
					<select name="school-grade">
						<c:choose>
							<c:when test="${student.schoolGrade == '小学1年生'}">
								<option value="小学1年生" selected>小学1年生</option>
								<option value="小学2年生">小学2年生</option>
								<option value="小学3年生">小学3年生</option>
								<option value="小学4年生">小学4年生</option>
								<option value="小学5年生">小学5年生</option>
								<option value="小学6年生">小学6年生</option>
								<option value="中学1年生">中学1年生</option>
								<option value="中学2年生">中学2年生</option>
								<option value="中学3年生">中学3年生</option>
								<option value="高校1年生">高校1年生</option>
								<option value="高校2年生">高校2年生</option>
								<option value="高校3年生">高校3年生</option>
								<option value="既卒">既卒</option>
							</c:when>
							<c:when test="${student.schoolGrade == '小学2年生'}">
								<option value="小学1年生">小学1年生</option>
								<option value="小学2年生" selected>小学2年生</option>
								<option value="小学3年生">小学3年生</option>
								<option value="小学4年生">小学4年生</option>
								<option value="小学5年生">小学5年生</option>
								<option value="小学6年生">小学6年生</option>
								<option value="中学1年生">中学1年生</option>
								<option value="中学2年生">中学2年生</option>
								<option value="中学3年生">中学3年生</option>
								<option value="高校1年生">高校1年生</option>
								<option value="高校2年生">高校2年生</option>
								<option value="高校3年生">高校3年生</option>
								<option value="既卒">既卒</option>
							</c:when>
							<c:when test="${student.schoolGrade == '小学3年生'}">
								<option value="小学1年生">小学1年生</option>
								<option value="小学2年生">小学2年生</option>
								<option value="小学3年生" selected>小学3年生</option>
								<option value="小学4年生">小学4年生</option>
								<option value="小学5年生">小学5年生</option>
								<option value="小学6年生">小学6年生</option>
								<option value="中学1年生">中学1年生</option>
								<option value="中学2年生">中学2年生</option>
								<option value="中学3年生">中学3年生</option>
								<option value="高校1年生">高校1年生</option>
								<option value="高校2年生">高校2年生</option>
								<option value="高校3年生">高校3年生</option>
								<option value="既卒">既卒</option>
							</c:when>
							<c:when test="${student.schoolGrade == '小学4年生'}">
								<option value="小学1年生">小学1年生</option>
								<option value="小学2年生">小学2年生</option>
								<option value="小学3年生">小学3年生</option>
								<option value="小学4年生" selected>小学4年生</option>
								<option value="小学5年生">小学5年生</option>
								<option value="小学6年生">小学6年生</option>
								<option value="中学1年生">中学1年生</option>
								<option value="中学2年生">中学2年生</option>
								<option value="中学3年生">中学3年生</option>
								<option value="高校1年生">高校1年生</option>
								<option value="高校2年生">高校2年生</option>
								<option value="高校3年生">高校3年生</option>
								<option value="既卒">既卒</option>
							</c:when>
							<c:when test="${student.schoolGrade == '小学5年生'}">
								<option value="小学1年生">小学1年生</option>
								<option value="小学2年生">小学2年生</option>
								<option value="小学3年生">小学3年生</option>
								<option value="小学4年生">小学4年生</option>
								<option value="小学5年生" selected>小学5年生</option>
								<option value="小学6年生">小学6年生</option>
								<option value="中学1年生">中学1年生</option>
								<option value="中学2年生">中学2年生</option>
								<option value="中学3年生">中学3年生</option>
								<option value="高校1年生">高校1年生</option>
								<option value="高校2年生">高校2年生</option>
								<option value="高校3年生">高校3年生</option>
								<option value="既卒">既卒</option>
							</c:when>
							<c:when test="${student.schoolGrade == '小学6年生'}">
								<option value="小学1年生">小学1年生</option>
								<option value="小学2年生">小学2年生</option>
								<option value="小学3年生">小学3年生</option>
								<option value="小学4年生">小学4年生</option>
								<option value="小学5年生">小学5年生</option>
								<option value="小学6年生" selected>小学6年生</option>
								<option value="中学1年生">中学1年生</option>
								<option value="中学2年生">中学2年生</option>
								<option value="中学3年生">中学3年生</option>
								<option value="高校1年生">高校1年生</option>
								<option value="高校2年生">高校2年生</option>
								<option value="高校3年生">高校3年生</option>
								<option value="既卒">既卒</option>
							</c:when>
							<c:when test="${student.schoolGrade == '中学1年生'}">
								<option value="小学1年生">小学1年生</option>
								<option value="小学2年生">小学2年生</option>
								<option value="小学3年生">小学3年生</option>
								<option value="小学4年生">小学4年生</option>
								<option value="小学5年生">小学5年生</option>
								<option value="小学6年生">小学6年生</option>
								<option value="中学1年生" selected>中学1年生</option>
								<option value="中学2年生">中学2年生</option>
								<option value="中学3年生">中学3年生</option>
								<option value="高校1年生">高校1年生</option>
								<option value="高校2年生">高校2年生</option>
								<option value="高校3年生">高校3年生</option>
								<option value="既卒">既卒</option>
							</c:when>
							<c:when test="${student.schoolGrade == '中学2年生'}">
								<option value="小学1年生">小学1年生</option>
								<option value="小学2年生">小学2年生</option>
								<option value="小学3年生">小学3年生</option>
								<option value="小学4年生">小学4年生</option>
								<option value="小学5年生">小学5年生</option>
								<option value="小学6年生">小学6年生</option>
								<option value="中学1年生">中学1年生</option>
								<option value="中学2年生" selected>中学2年生</option>
								<option value="中学3年生">中学3年生</option>
								<option value="高校1年生">高校1年生</option>
								<option value="高校2年生">高校2年生</option>
								<option value="高校3年生">高校3年生</option>
								<option value="既卒">既卒</option>
							</c:when>
							<c:when test="${student.schoolGrade == '中学3年生'}">
								<option value="小学1年生">小学1年生</option>
								<option value="小学2年生">小学2年生</option>
								<option value="小学3年生">小学3年生</option>
								<option value="小学4年生">小学4年生</option>
								<option value="小学5年生">小学5年生</option>
								<option value="小学6年生">小学6年生</option>
								<option value="中学1年生">中学1年生</option>
								<option value="中学2年生">中学2年生</option>
								<option value="中学3年生" selected>中学3年生</option>
								<option value="高校1年生">高校1年生</option>
								<option value="高校2年生">高校2年生</option>
								<option value="高校3年生">高校3年生</option>
								<option value="既卒">既卒</option>
							</c:when>
							<c:when test="${student.schoolGrade == '高校1年生'}">
								<option value="小学1年生">小学1年生</option>
								<option value="小学2年生">小学2年生</option>
								<option value="小学3年生">小学3年生</option>
								<option value="小学4年生">小学4年生</option>
								<option value="小学5年生">小学5年生</option>
								<option value="小学6年生">小学6年生</option>
								<option value="中学1年生">中学1年生</option>
								<option value="中学2年生">中学2年生</option>
								<option value="中学3年生">中学3年生</option>
								<option value="高校1年生" selected>高校1年生</option>
								<option value="高校2年生">高校2年生</option>
								<option value="高校3年生">高校3年生</option>
								<option value="既卒">既卒</option>
							</c:when>
							<c:when test="${student.schoolGrade == '高校2年生'}">
								<option value="小学1年生">小学1年生</option>
								<option value="小学2年生">小学2年生</option>
								<option value="小学3年生">小学3年生</option>
								<option value="小学4年生">小学4年生</option>
								<option value="小学5年生">小学5年生</option>
								<option value="小学6年生">小学6年生</option>
								<option value="中学1年生">中学1年生</option>
								<option value="中学2年生">中学2年生</option>
								<option value="中学3年生">中学3年生</option>
								<option value="高校1年生">高校1年生</option>
								<option value="高校2年生" selected>高校2年生</option>
								<option value="高校3年生">高校3年生</option>
								<option value="既卒">既卒</option>
							</c:when>
							<c:when test="${student.schoolGrade == '高校3年生'}">
								<option value="小学1年生">小学1年生</option>
								<option value="小学2年生">小学2年生</option>
								<option value="小学3年生">小学3年生</option>
								<option value="小学4年生">小学4年生</option>
								<option value="小学5年生">小学5年生</option>
								<option value="小学6年生">小学6年生</option>
								<option value="中学1年生">中学1年生</option>
								<option value="中学2年生">中学2年生</option>
								<option value="中学3年生">中学3年生</option>
								<option value="高校1年生">高校1年生</option>
								<option value="高校2年生">高校2年生</option>
								<option value="高校3年生" selected>高校3年生</option>
								<option value="既卒">既卒</option>
							</c:when>
							<c:when test="${student.schoolGrade == '既卒'}">
								<option value="小学1年生">小学1年生</option>
								<option value="小学2年生">小学2年生</option>
								<option value="小学3年生">小学3年生</option>
								<option value="小学4年生">小学4年生</option>
								<option value="小学5年生">小学5年生</option>
								<option value="小学6年生">小学6年生</option>
								<option value="中学1年生">中学1年生</option>
								<option value="中学2年生">中学2年生</option>
								<option value="中学3年生">中学3年生</option>
								<option value="高校1年生">高校1年生</option>
								<option value="高校2年生">高校2年生</option>
								<option value="高校3年生">高校3年生</option>
								<option value="既卒" selected>既卒</option>
							</c:when>
						</c:choose>
					</select>
					<c:choose>
						<c:when test="${student.gender == 'man'}">
						<input type="radio" name="gender" value="man" checked>男
						<input type="radio" name="gender" value="woman">女  
						</c:when>
						<c:when test="${student.gender == 'woman'}">
						<input type="radio" name="gender" value="man">男
						<input type="radio" name="gender" value="woman" checked>女   
						</c:when>
					</c:choose>
					<input type="submit" value="登録">
    			</form>
			</c:forEach>
    	</c:when>
    </c:choose>
    <a href="schedulePage.jsp">授業日程一覧に戻る</a>
</body>
</html>
<% } %>