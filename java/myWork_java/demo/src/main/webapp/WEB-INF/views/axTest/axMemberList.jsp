<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/resources/myLib/axTest02.js"></script>
<title>** SpringBoot Axios_MemberList **</title>
</head>
<body>
	<h2>** SpringBoot Axios_MemberList **</h2>
	<hr>

	<c:if test="${not empty requestScope.message}">${requestScope.message}</c:if>
	<hr>

	<table border="1" style="width: 90%">
		<tr bgcolor="hotpink">
			<th>id</th>

			<th>name</th>
			<th>age</th>
			<th>jno</th>
			<th>info</th>
			<th>point</th>
			<th>birthday</th>
			<th>rid</th>
			<th>img</th>
			<!-- <th>Download</th> -->
			<!-- 관리자 기능 추가 -->
			<c:if test="${sessionScope.loginID == 'admin'}">
				<th>delete</th>
			</c:if>

		</tr>


		<c:if test="${not empty requestScope.mList}">
			<c:forEach var="list" items="${requestScope.mList}">
				<tr>
					<td><a href="mdetail?id=${list.id}">${list.id}</a></td>
					<td>${list.name}</td>
					<td>${list.age}</td>
					<td>${list.jno}</td>
					<td>${list.info}</td>
					<td>${list.point}</td>
					<td>${list.birthday}</td>
					<td>${list.rid}</td>

					<!-- img추가 -->
					<td><img alt="MyImage" src="/${list.uploadfile}" height="100"></td>
					
					<!-- File Download ** 
         				=> download 요청을 받으면 서버는 해당화일을 찾아 response 에 담아보내면,
               				웹브라우져가 받아 download 시켜줌 
         				=> 최종적 처리를 웹브라우져가 해주기때문에 일반적으로 a Tag 로 처리함     
               				(즉, 비동기 처리_Ajax 를 하지 않음, 비동기처리에서는 response를 웹브라우져가 받지않기때문)		-->
					<%-- <td><a href="download?dnfile=${list.uploadfile}">${list.uploadfile}</a></td> --%>
					
					<!-- 관리자 (Delete) : axios로 처리하기
					     => 삭제할 대상을 function에 전달 : 매개변수 활용
					        axiDelete("banana") -> axi~.. (${s.id}) -> axiDelete("banana")					        
					
					-->
					<c:if test="${sessionScope.loginID == 'admin'}">
						<td align="center">
							<span class="textlink" style="cursor:pointer" onclick = "axiDelete('${list.id}')" id="${list.id}">Delete</span>
						</td>
					</c:if>

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

	<a href="/home">go home</a>
	<br> &nbsp;
</body>
</html>