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
<table>
	<c:if test="${!empty requestScope.loginUser}">
		<tr height="40px">
			<th bgcolor="pink">Sno</th>
			<td>${requestScope.loginUser.sno}</td>
		</tr>
		<tr height="40px">
			<th bgcolor="pink">Name</th>
			<td>${requestScope.loginUser.name}</td>
		</tr>
		<tr height="40px">
			<th bgcolor="pink">Age</th>
			<td>${requestScope.loginUser.age}</td>
		</tr>
		<tr height="40px">
			<th bgcolor="pink">Jno</th>
			<td>${requestScope.loginUser.jno}</td>
		</tr>
		<tr height="40px">
			<th bgcolor="pink">Info</th>
			<td>${requestScope.loginUser.info}</td>
		</tr>
		<tr height="40px">
			<th bgcolor="pink">Point</th>
			<td>${requestScope.loginUser.point}</td>
		</tr>
		<tr height="40px">
			<th bgcolor="pink">Birthday</th>
			<td>${requestScope.loginUser.birthday}</td>
		</tr>
	</c:if>
	<c:if test="${empty requestScope.loginUser}">
		<tr>
			<td colspan="2">출력할 Data가 없습니다.</td>
		</tr>
	</c:if>
</table>
</body>
</html>