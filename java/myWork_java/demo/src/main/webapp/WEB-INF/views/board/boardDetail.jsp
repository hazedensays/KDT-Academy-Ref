<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** SpringBoot Board Detail **</title>
</head>
<body>
	<h2>** SpringBoot Board Detail **</h2>

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
	
	<!-- 댓글 등록을 위해 (부모)글의 root, step, indent 값이 필요하기 때문에 서버로 보내주어야 함
		 => 쿼리스트링으로 작성 														-->
	<a href="replyInsert?root=${requestScope.bDetail.root}&step=${requestScope.bDetail.step}&indent=${requestScope.bDetail.indent}">답글등록</a>
	<br>
	
	<!-- 로그인id와 글쓴이id가 동일한 경우에는 수정, 삭제 가능 -->
		<c:if test="${sessionScope.loginID == requestScope.bDetail.id}">
		<a href="bdetail?jCode=U&seq=${requestScope.bDetail.seq}">글 수정</a>
		<a href="bdelete?seq=${requestScope.bDetail.seq}&root=${requestScope.bDetail.root}">글 삭제</a>
		<br>
	</c:if>
	
	<a href="javascript:history.go(-1)">go back</a>
	<a href="/home">go home</a>&nbsp;&nbsp;&nbsp;
	
	<br>
	<a href = "boardList">Board List</a><br>
</body>
</html>