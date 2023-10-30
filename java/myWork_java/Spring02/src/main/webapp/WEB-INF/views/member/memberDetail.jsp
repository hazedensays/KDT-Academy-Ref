<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring Member Detail **</title>
<script src="/best/resources/myLib/jquery-3.2.1.min.js"></script>
</head>

<body>
	<h2>** Spring Member Detail **</h2>

	<table border="1" style="width: 90%">
		<c:if test="${not empty requestScope.mDetail}">
			<tr height="40">
				<th bgcolor="hotpink">id</th>
				<td>${requestScope.mDetail.id}</td>
			</tr>
			<tr height="40">
				<th bgcolor="hotpink">password</th>
				<td>${requestScope.mDetail.password}</td>
			</tr>
			<tr height="40">
				<th bgcolor="hotpink">name</th>
				<td>${requestScope.mDetail.name}</td>
			</tr>
			<tr height="40">
				<th bgcolor="hotpink">age</th>
				<td>${requestScope.mDetail.age}</td>
			</tr>
			<tr height="40">
				<th bgcolor="hotpink">jno</th>
				<td>${requestScope.mDetail.jno}</td>
			</tr>
			<tr height="40">
				<th bgcolor="hotpink">info</th>
				<td>${requestScope.mDetail.info}</td>
			</tr>
			<tr height="40">
				<th bgcolor="hotpink">point</th>
				<td>${requestScope.mDetail.point}</td>
			</tr>
			<tr height="40">
				<th bgcolor="hotpink">birthday</th>
				<td>${requestScope.mDetail.birthday}</td>
			</tr>
			<tr height="40">
				<th bgcolor="hotpink">rid</th>
				<td>${requestScope.mDetail.rid}</td>
			</tr>
			<tr height="40">
				<th bgcolor="hotpink">img</th>
				<td>
					<img alt="img" src="/best/${requestScope.mDetail.uploadfile}">
				</td>
			</tr>
		</c:if>

		<c:if test="${empty requestScope.mDetail}">
			<tr>
				<td colspan="2">출력할 데이터 없음</td>
			</tr>
		</c:if>
	</table>
	<hr>
	
	<a href="javascript:history.go(-1)">go back</a>
	<a href="/best/home">go home</a>&nbsp;&nbsp;&nbsp;
</body>
</html>