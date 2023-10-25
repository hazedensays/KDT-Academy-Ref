<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_MVC2 Board Update **</title>
</head>
<body>
	<h2>** Spring_MVC2 Board Update **</h2>

	<form action="bupdate" method="post">
		<table border="1" style="width: 90%">
		
		<c:if test="${not empty requestScope.bDetail}">
			<tr height="40">
				<th bgcolor="azure">seq</th>
				<td><input type="text" name="seq" size="20" value="${requestScope.bDetail.seq}" readonly></td>
			</tr>

			<tr height="40">
				<th bgcolor="azure">id</th>
				<td><input type="text" name="id" size="20" value="${requestScope.bDetail.id}" readonly></td>
			</tr>
			
			<tr height="40">
				<th bgcolor="skyblue">title</th>
				<td><input type="text" name="title" size="50" value="${requestScope.bDetail.title}"></td>
			</tr>
			
			<tr height="40">
				<th bgcolor="skyblue">content</th>
				<td><textarea rows="5" name="content" value="${request.bDetail.content}"></textarea></td>
			</tr>
			
			<tr height="40">
				<th bgcolor="azure">regdate</th>
				<td><input type="text" name="regdate" size="20" value="${requestScope.bDetail.regdate}" readonly></td>
			</tr>
			
			<tr height="40">
				<th bgcolor="azure">조회수</th>
				<td><input type="text" name="cnt" size="20" value="${requestScope.bDetail.cnt}" readonly></td>
			</tr>
			
			<tr height="40">
				<td colspan="2"><input type="submit" value="수정">&nbsp;&nbsp;&nbsp;
					<input type="reset" value="취소"></td>
			</tr>
		</c:if>
		
		<c:if test="${empty requestScope.bDetail}">
			<tr height="40">
				<td colspan="2">수정할 자료가 존재하지 않습니다.</td>
			</tr>
		</c:if>
		
		</table>
	</form>
	<hr>

	<c:if test="${not empty requestScope.message}">
		=> ${message}
	</c:if>
	<hr>

	<a href="javascript:history.go(-1)">go back</a>
	<a href="home">go home</a>&nbsp;&nbsp;&nbsp;


</body>
</html>