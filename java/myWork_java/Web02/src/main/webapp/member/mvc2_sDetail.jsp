<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Web_MVC2 Student Detail **</title>
</head>
<body>
	<h2>** Web_MVC2 Student Detail **</h2>

	<table border="1" style="width: 90%">
		<c:if test="${not empty requestScope.apple}">
			<tr height="40">
				<th bgcolor="hotpink">sno</th>
				<td>${requestScope.apple.sno}</td>
			</tr>
			<tr height="40">
				<th bgcolor="hotpink">name</th>
				<td>${requestScope.apple.name}</td>
			</tr>
			<tr height="40">
				<th bgcolor="hotpink">age</th>
				<td>${requestScope.apple.age}</td>
			</tr>
			<tr height="40">
				<th bgcolor="hotpink">jno</th>
				<td>${requestScope.apple.jno}</td>
			</tr>
			<tr height="40">
				<th bgcolor="hotpink">info</th>
				<td>${requestScope.apple.info}</td>
			</tr>
			<tr height="40">
				<th bgcolor="hotpink">point</th>
				<td>${requestScope.apple.point}</td>
			</tr>
			<tr height="40">
				<th bgcolor="hotpink">birthday</th>
				<td>${requestScope.apple.birthday}</td>
			</tr>
		</c:if>

		<c:if test="${empty requestScope.apple}">
			<tr>
				<td colspan="2">출력할 데이터 없음</td>
			</tr>
		</c:if>
	</table>
</body>
</html>