<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_MVC2 jo List **</title>
</head>
<body>
	<h2>** Spring_MVC2 jo List **</h2>
	
	<c:if test="${not empty requestScope.message}">${requestScope.message}</c:if>
	<hr>

	<c:if test="${not empty sessionScope.loginID}">
		<a href="joInsert">새로운 조 등록</a>
	</c:if>
	<hr>

	<table border="1" style="width: 90%">
		<tr bgcolor="skyblue">
			<th>jno</th>
			<th>jname</th>
			<th>id</th>
			<th>name</th>
			<th>project</th>
			<th>slogan</th>
		</tr>


		<c:if test="${not empty requestScope.jList}">
			<c:forEach var="list" items="${requestScope.jList}">
				<tr>
					<td>${list.jno}</td>
					<!-- Title => 로그인한 경우에만 글 내용을 볼 수 있도록 Link 추가 -->
					<td>
						<c:if test="${not empty sessionScope.loginID}">
							<a href = "jdetail?jno=${list.jno}">${list.jname}</a>
						</c:if>
						<c:if test="${empty sessionScope.loginID}">
							${list.jname}
						</c:if>
					</td>
				
					<td>${list.id}</td>
					<td>${list.name}</td>
					<td>${list.project}</td>
					<td>${list.slogan}</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty requestScope.jList}">
			<tr>
				<td colspan="5">출력할 데이터 없음</td>
			</tr>
		</c:if>
	</table>
	<hr>

	<a href="/best/home">go home</a><br>
</body>
</html>