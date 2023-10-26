<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_MVC2 Board List **</title>
</head>
<body>
	<h2>** Spring_MVC2 Board List **</h2>
	<hr>

	<c:if test="${not empty requestScope.message}">${requestScope.message}</c:if>
	<hr>

	<c:if test="${not empty sessionScope.loginID}">
		<a href="boardInsert" style="text-align:right">새글 등록</a>
	</c:if>

	<table border="1" style="width: 90%">
		<tr bgcolor="skyblue">
			<th>Seq</th>
			<th>Title</th>
			<th>Id</th>
			<th>Regdate</th>
			<th>조회수</th>
		</tr>


		<c:if test="${not empty requestScope.bList}">
			<c:forEach var="list" items="${requestScope.bList}">
				<tr>
					<td>${list.seq}</td>
			<!--    Title
					=> 로그인한 경우에만 글 내용을 볼 수 있도록 Link 추가
					=> 댓글 작성 후에는 indent값에 따른 들여쓰기 기능						-->
					<td>
						<c:if test="${list.indent > 0 }">
							<c:forEach begin="1" end="${list.indent}">
								<span>&nbsp;&nbsp;</span>
							</c:forEach>
							<span style="color:blue">↳</span>
						</c:if>
					
						<c:if test="${not empty sessionScope.loginID}">
							<a href = "bdetail?seq=${list.seq}">${list.title}</a>
						</c:if>
						<c:if test="${empty sessionScope.loginID}">
							${list.title}
						</c:if>
					</td>
				
					<td>${list.id}</td>
					<td>${list.regdate}</td>
					<td>${list.cnt}</td>
				</tr> 
			</c:forEach>
		</c:if>
		<c:if test="${empty requestScope.bList}">
			<tr>
				<td colspan="5">출력할 데이터 없음</td>
			</tr>
		</c:if>
	</table>
	<hr>

	<a href="/best/home">go home</a><br>
</body>
</html>