<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** SpringBoot Member Login Form **</title>
</head>
<body>
	<h2>** SpringBoot Member Login Form **</h2>
	<form action="login" method="post">
		<table>
			<tr height="40">
				<td><label for="id">Id</label></td>
				<td><input type="text" id="id" name="id"></td>
			</tr>
			<tr height="40">
				<td><label for="password">Password</label></td>
				<td><input type="password" id="password" name="password"></td>
			</tr>
			<tr height="40">
				<td></td>
				<td><input type="submit" value="로그인">&nbsp;&nbsp; <input
					type="reset" value="취소"></td>
			</tr>
		</table>
	</form>
	<hr>

	<a href="/home">go home</a>
	<br> &nbsp;

	<c:if test="${not empty requestScope.message}">
	message : ${requestScope.message}
	</c:if>

</body>
</html>