
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Home</title>
</head>
<body>
	<h1 style="color: hotpink">Hello Spring MVC</h1>

	<P>** Server_Time => ${serverTime}</P>
	<hr>

	<c:if test="${not empty sessionScope.loginID}">
	=> ${sessionScope.loginName}님, Welcome!<br>
	</c:if>


	<c:if test="${not empty requestScope.message}">
	=> ${requestScope.message}
	</c:if>
	<hr>
	
	<img alt="mainImage" src="/best/resources/images/KakaoTalk_20231023_121144200.jpg" width = "300" height = "300">
	<br/>
	<!-- Login 전 -->
	<c:if test="${empty sessionScope.loginID}">
		&nbsp;<a href = "login">Login_Get</a>&nbsp;
		&nbsp;<a href = "join">Join_Get</a>&nbsp;
	</c:if>
	
	<!-- Login 후 -->
	<hr>
	<c:if test="${not empty sessionScope.loginID}">
		&nbsp;<a href = "logout">Logout</a><br>
		&nbsp;<a href = "mdetail">MyInfo 조회</a><br>
		&nbsp;<a href = "mdetail">MyInfo 수정</a><br>
		&nbsp;<a href = "mdetail">회원 탈퇴</a><br>
	</c:if>
	
	&nbsp;<a href = "mlist">Member List</a><br>
	
</body>
</html>
