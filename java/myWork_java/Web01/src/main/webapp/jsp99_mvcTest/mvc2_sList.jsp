<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Web_MVC2 Student List **</title>
</head>
<body>
	<h2>** Web_MVC2 Student List **</h2>
	<hr>

	<c:if test="${not empty requestScope.message}">${requestScope.message}</c:if>
	<hr>

	<table border="1" style="width: 90%">
		<tr bgcolor="hotpink">
			<th>sno</th>
			<th>name</th>
			<th>jno</th>
			<th>info</th>
			<th>point</th>
			<th>birthday</th>
			<th>delete</th>
		</tr>


		<c:if test="${not empty requestScope.banana}">
			<c:forEach var="list" items="${requestScope.banana}">
				<tr>
					<td>${list.sno}</td>
					<td>${list.name}</td>
					<td>${list.jno}</td>
					<td>${list.info}</td>
					<td>${list.point}</td>
					<td>${list.birthday}</td>
					<td align="center"><a href="/Web01/delete?sno=${list.sno}">삭제</a></td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty requestScope.banana}">
			<tr>
				<td colspan="7">출력할 데이터 없음</td>
			</tr>
		</c:if>
	</table>
	<hr>

	<a href="/Web01/index.jsp">go home</a>
	<br> &nbsp;
</body>
</html>