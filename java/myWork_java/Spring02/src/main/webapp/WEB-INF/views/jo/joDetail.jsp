<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_MVC2 Jo Detail **</title>
</head>
<body>
	<h2>** Spring_MVC2 Jo Detail **</h2>

	<table border="1" style="width: 90%">
		<c:if test="${not empty requestScope.jDetail}">
			<tr height="40">
				<th bgcolor="skyblue">jno</th>
				<td>${requestScope.jDetail.jno}</td>
			</tr>
			<tr height="40">
				<th bgcolor="skyblue">jname</th>
				<td>${requestScope.jDetail.jname}</td>
			</tr>
			<tr height="40">
				<th bgcolor="skyblue">id</th>
				<td>${requestScope.jDetail.id}</td>
			</tr>
			<tr height="40">
				<th bgcolor="skyblue">project</th>
				<td>${requestScope.jDetail.project}</td>
			</tr>
			<tr height="40">
				<th bgcolor="skyblue">slogan</th>
				<td>${requestScope.jDetail.slogan}</td>
			</tr>
		</c:if>

		<c:if test="${empty requestScope.jDetail}">
			<tr>
				<td colspan="2">출력할 데이터 없음</td>
			</tr>
		</c:if>
	</table>
	<hr>

	<h3>** ${mDetail.jno}조 MemberList **</h3>
	<table border="1" style="width: 90%">
		<tr bgcolor="skyblue" height="30">
			<th>ID</th>
			<th>Password</th>
			<th>Name</th>
			<th>Age</th>
			<th>Jno</th>
			<th>Info</th>
			<th>Point</th>
			<th>Birthday</th>
			<th>추천인</th>
		</tr>
		<c:if test="${not empty requestScope.mList}">
			<c:forEach var="m" items="${requestScope.mList}">
				<tr height="30">
					<td>
						<!-- 관리자기능 추가하기 --> <c:if test="${sessionScope.loginID=='admin'}">
							<a href="mdetail?id=${m.id}">${m.id}</a>
						</c:if> <c:if test="${sessionScope.loginID!='admin'}">
							${m.id}
						</c:if>
					</td>
					<td>${m.password}</td>
					<td>${m.name}</td>
					<td>${m.age}</td>
					<td>${m.jno}</td>
					<td>${m.info}</td>
					<td>${m.point}</td>
					<td>${m.birthday}</td>
					<td>${m.rid}</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty requestScope.mList}">
			<tr>
				<td colspan="9">출력할 데이터 없음</td>
			</tr>
		</c:if>
	</table>
	<hr>

	<c:if test="${not empty requestScope.message}">
		=> ${message}<br>
	</c:if>

	<!-- 로그인을 한 경우에는 새로운 조 등록 -->
	<a href="joInsert">새로운 조 등록</a>
	<br>


	<a href="jdetail?jCode=U&jno=${requestScope.jDetail.jno}">조 수정</a>
	<a href="jdelete?jno=${requestScope.jDetail.jno}">조 삭제</a>
	<br>



	<a href="javascript:history.go(-1)">go back</a>
	<a href="/best/home">go home</a>&nbsp;&nbsp;&nbsp;

	<br>
	<a href="joList">Jo List</a>
	<br>
</body>
</html>