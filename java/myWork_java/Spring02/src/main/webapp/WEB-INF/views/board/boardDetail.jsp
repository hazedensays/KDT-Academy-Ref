<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_MVC2 Board Detail **</title>
</head>
<body>
	<h2>** Spring_MVC2 Board Detail **</h2>

	<table border="1" style="width: 90%">
		<c:if test="${not empty requestScope.bDetail}">
			<tr height="40">
				<th bgcolor="skyblue">seq</th>
				<td>${requestScope.bDetail.seq}</td>
			</tr>
			<tr height="40">
				<th bgcolor="skyblue">id</th>
				<td>${requestScope.bDetail.id}</td>
			</tr>
			<tr height="40">
				<th bgcolor="skyblue">title</th>
				<td>${requestScope.bDetail.title}</td>
			</tr>
			<tr height="40">
				<th bgcolor="skyblue">content</th>
				<td>${requestScope.bDetail.content}</td>
			</tr>
			<tr height="40">
				<th bgcolor="skyblue">regdate</th>
				<td>${requestScope.bDetail.regdate}</td>
			</tr>
			<tr height="40">
				<th bgcolor="skyblue">조회수</th>
				<td>${requestScope.bDetail.cnt}</td>
			</tr>
		</c:if>

		<c:if test="${empty requestScope.bDetail}">
			<tr>
				<td colspan="2">출력할 데이터 없음</td>
			</tr>
		</c:if>
	</table>
	<hr>
	
	<!-- 로그인을 한 경우에는 새글등록, 답글등록 -->
	<a href="boardInsert">새글등록</a>
	<a href="replyInsert">답글등록</a>
	<br>
	
	<!-- 로그인id와 글쓴이id가 동일한 경우에는 수정, 삭제 가능 -->
		<c:if test="${sessionScope.loginID == requestScope.bDetail.id}">
		<a href="bdetail?jCode=U&seq=${requestScope.bDetail.seq}">글 수정</a>
		<a href="bdelete?seq=${requestScope.bDetail.seq}">글 삭제</a>
		<br>
	</c:if>
	
	<a href="javascript:history.go(-1)">go back</a>
	<a href="/best/home">go home</a>&nbsp;&nbsp;&nbsp;
	
	<br>
	<a href = "boardList">Board List</a><br>
</body>
</html>