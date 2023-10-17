<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Web_MVC2 Member List **</title>
</head>
<body>
	<h2>** Web_MVC2 Member List **</h2>
	<hr>

	<c:if test="${not empty requestScope.message}">${requestScope.message}</c:if>
	<hr>

	<table border="1" style="width: 90%">
		<tr bgcolor="hotpink">
			<th>id</th>
			<th>password</th>
			<th>name</th>
			<th>age</th>
			<th>jno</th>
			<th>info</th>
			<th>point</th>
			<th>birthday</th>
			<th>rid</th>
			<th>delete</th>
		</tr>


		<c:if test="${not empty requestScope.mlist}">
			<c:forEach var="list" items="${requestScope.mlist}">
				<tr>
					<td>${list.id}</td>
					<td>${list.password}</td>
					<td>${list.name}</td>
					<td>${list.age}</td>
					<td>${list.jno}</td>
					<td>${list.info}</td>
					<td>${list.point}</td>
					<td>${list.birthday}</td>
					<td>${list.rid}</td>
					<td align="center"><a href="/Web02/delete?id=${list.id}">삭제</a></td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty requestScope.mlist}">
			<tr>
				<td colspan="7">출력할 데이터 없음</td>
			</tr>
		</c:if>
	</table>
	<hr>

	<a href="/Web02/index.jsp">go home</a>
	<br> &nbsp;
</body>
</html>