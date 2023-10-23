<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Web_MVC2 StudentList **</title>
</head>
<body>
<h2>** Web_MVC2 StudentList **</h2>
<c:if test="${!empty requestScope.message}">
	=> ${requestScope.message}
</c:if>
<hr>
<table border=1 style="width:90%">
	<tr bgcolor="Lime">
		<th>sno</th>
		<th>name</th>
		<th>age</th>
		<th>jno</th>
		<th>info</th>
		<th>point</th>
		<th>birthday</th>
		<th></th>
	</tr>
	
	<c:if test="${not empty requestScope.banana}">
		<c:forEach var="s" items="${requestScope.banana}" >
			<tr>
				<td>${s.sno}</td>
				<td>${s.name}</td>
				<td>${s.age}</td>
				<td>${s.jno}</td>
				<td>${s.info}</td>
				<td>${s.point}</td>
				<td>${s.birthday}</td>
				<td><a href="/Web01/delete?sno=${s.sno}">삭제하기</a></td>
			</tr>
		</c:forEach>
	</c:if>
	<c:if test="${empty requestScope.banana}">
		<tr>
			<td colspan="7">출력할 Data가 없습니다.</td>
		</tr>
	</c:if>
</table>
<hr>
&nbsp;<a href="/Web01/">Home</a>
</body>
</html>