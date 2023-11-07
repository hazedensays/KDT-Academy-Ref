<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** SpringBoot Board Insert **</title>
</head>
<body>
	<h2>** SpringBoot Board Insert **</h2>

	<form action="binsert" method="post">
		<table border="1" style="width: 90%">
			<tr height="40">
				<th bgcolor="skyblue">I D</th>
				<td><input type="text" name="id"
					value="${sessionScope.loginID}" size="50" readonly /></td>
			</tr>
			<tr height="40">
				<th bgcolor="skyblue">Title</th>
				<td><input type="text" name="title" size="50"></td>
			</tr>
			<tr height="40">
				<th bgcolor="skyblue">Content</th>
				<td><textarea rows="5" cols="52" name="content"></textarea></td>
			</tr>
			<tr height="40">
				<td colspan="2"><input type="submit" value="등록">&nbsp;<input
					type="reset" value="취소"></td>
			</tr>
		</table>
	</form>
	<hr>

	<c:if test="${not empty requestScope.message}">
		=> ${message}
	</c:if>
	<hr>

	<a href="javascript:history.go(-1)">go back</a>
	<a href="/home">go home</a>&nbsp;&nbsp;&nbsp;


</body>
</html>