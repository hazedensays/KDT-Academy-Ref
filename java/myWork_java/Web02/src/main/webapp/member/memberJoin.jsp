<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Web_MVC2 Member Join **</title>
</head>
<body>
	<h2>** Web_MVC2 Member Join**</h2>

	<form action="/Web01/join" method="get">
		<table border="1" style="width: 90%">
			<tr height="40">
				<th bgcolor="hotpink">name</th>
				<td><input type="text" name="name" placeholder="한/영문 입력"
					size="20"></td>
			</tr>
			<tr height="40">
				<th bgcolor="hotpink">age</th>
				<td><input type="text" name="age" placeholder="숫자 입력" size="20"></td>
			</tr>
			<tr height="40">
				<th bgcolor="hotpink">jno</th>
				<td><select name="jno">
						<option value="1">1 : 119조</option>
						<option value="2">2 : 여우조</option>
						<option value="3">3 : i4조</option>
						<option value="4">4 : 최고조</option>
						<option value="5">5 : 오조</option>
						<option value="9">9 : test조</option>
				</select></td>
			</tr>
			<tr height="40">
				<th bgcolor="hotpink">info</th>
				<td><input type="text" name="info" placeholder="자기소개 & 희망사항"
					size="20"></td>
			</tr>
			<tr height="40">
				<th bgcolor="hotpink">point</th>
				<td><input type="text" name="point" placeholder="실수 입력"
					size="20"></td>
			</tr>
			<tr height="40">
				<th bgcolor="hotpink">birthday</th>
				<td><input type="text" name="birthday" size="20"></td>
			</tr>
			<tr height="40">
				<td colspan = "2">
					<input type="submit" value="가입">&nbsp;&nbsp;&nbsp;
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
	<hr>
	
	<c:if test="${not empty message}">
		=> ${message}
	</c:if>
	<hr>
	
	<a href="/Web01/javascript:history.go(-1)">go back</a>
	<a href="/Web01/index.jsp">go home</a>&nbsp;&nbsp;&nbsp;
	
	
</body>
</html>