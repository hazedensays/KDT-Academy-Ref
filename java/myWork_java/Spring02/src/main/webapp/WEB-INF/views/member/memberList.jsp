<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Web_MVC2 Member List **</title>
</head>
<body>
	<h2>** Web_MVC2 Member List **</h2>
	<hr>

	<c:if test="${not empty requestScope.message}">${requestScope.message}</c:if>
	<hr>

	<table border="1" style="width: 90%">
		<tr bgcolor="hotpink">
			<th>id</th>
			<th>password</th>
			<th>name</th>
			<th>age</th>
			<th>jno</th>
			<th>info</th>
			<th>point</th>
			<th>birthday</th>
			<th>rid</th>
			<th>img</th>
			<th>Download</th>

			<!-- 관리자 기능 추가 -->
			<c:if test="${sessionScope.loginID == 'admin'}">
				<th>delete</th>
			</c:if>


		</tr>


		<c:if test="${not empty requestScope.mList}">
			<c:forEach var="list" items="${requestScope.mList}">
				<tr>
					<td><a href = "mdetail?id=${list.id}">${list.id}</a></td>
					<td>${list.password}</td>
					<td>${list.name}</td>
					<td>${list.age}</td>
					<td>${list.jno}</td>
					<td>${list.info}</td>
					<td>${list.point}</td>
					<td>${list.birthday}</td>
					<td>${list.rid}</td>
					<c:if test="${sessionScope.loginID == 'admin'}">
						<td align="center"><a href="mdelete?id=${list.id}">삭제</a></td>
					</c:if>
					<!-- img추가 -->
					<td>
						<img alt="MyImage" src="/Spring02/${list.uploadfile}" height="100">
					</td>
		<!-- File Download ** 
         	=> download 요청을 받으면 서버는 해당화일을 찾아 response 에 담아보내면,
               웹브라우져가 받아 download 시켜줌 
         	=> 최종적 처리를 웹브라우져가 해주기때문에 일반적으로 a Tag 로 처리함     
               (즉, 비동기 처리_Ajax 를 하지 않음, 비동기처리에서는 response를 웹브라우져가 받지않기때문)		-->
					<td>
						<a href="download?dnfile=${list.uploadfile}">${list.uploadfile}</a>
					</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty requestScope.mList}">
			<tr>
				<td colspan="7">출력할 데이터 없음</td>
			</tr>
		</c:if>
	</table>
	<hr>

	<a href="/Spring02/home">go home</a>
	<br> &nbsp;
</body>
</html>