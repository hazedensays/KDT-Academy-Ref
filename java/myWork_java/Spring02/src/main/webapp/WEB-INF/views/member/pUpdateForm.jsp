<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_MVC2 Member PW 수정 **</title>
<script src="/Spring02/resources/myLib/jquery-3.2.1.min.js"></script>
</head>

<body>
	<h2>** Spring_MVC2 Member PW 수정 **</h2>

	<form action="pUpdateForm" method="get">
		<table border="1" style="width: 90%">
			<tr height="40">
				<th bgcolor="hotpink">pw</th>
				<td><input type="password" name="password"
					placeholder="영문, 숫자, 특수문자" size="20"></td>
			</tr>
			
			<tr height="40">
				<th bgcolor="hotpink">pw 확인</th>
				<td><input type="password" name="password"
					placeholder="pw를 재입력해주세요." size="20"></td>
			</tr>
	
			<tr height="40">
				<td colspan="2"><input type="submit" value="변경">&nbsp;&nbsp;&nbsp;
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
	<a href="/Spring02/home">go home</a>&nbsp;&nbsp;&nbsp;
</body>
</html>