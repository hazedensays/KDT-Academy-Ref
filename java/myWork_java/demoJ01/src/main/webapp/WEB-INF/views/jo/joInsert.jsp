<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** SpringBoot Jo Join **</title>
</head>
<body>
	<h2>** SpringBoot Jo Join**</h2>

	<form action="jinsert" method="post">
		<table border="1" style="width: 90%">
			<tr height="40">
				<th bgcolor="skyblue">jno</th>
				<td><input type="text" name="jno" size="20"></td>
			</tr>

			<tr height="40">
				<th bgcolor="skyblue">jname</th>
				<td><input type="text" name="jname" size="20"></td>
			</tr>

			<tr height="40">
				<th bgcolor="skyblue">id</th>
				<td><input type="text" name="id" size="20"></td>
			</tr>

			<tr height="40">
				<th bgcolor="skyblue">project</th>
				<td><input type="text" name="project" size="20"></td>
			</tr>

			<tr height="40">
				<th bgcolor="skyblue">slogan</th>
				<td><input type="text" name="slogan" size="20"></td>
			</tr>

			<tr height="40">
				<td colspan="2"><input type="submit" value="등록">&nbsp;&nbsp;&nbsp;
					<input type="reset" value="취소"></td>
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