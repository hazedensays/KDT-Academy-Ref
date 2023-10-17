<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Web02 **</title>
</head>
<body>
	<h2>** Hello Dynamic Web02_Project **</h2>

	<c:if test="${empty sessionScope.loginName}">로그인 후 이용바랍니다.</c:if>
	<c:if test="${not empty sessionScope.loginName}">${sessionScope.loginName}님, welcome!</c:if>
	<hr>

	<img alt="" src="./images/SSC_20231008110757.jpg" width="400"
		height="300">
	<hr>

	&nbsp;
	<c:if test="${not empty sessionScope.loginName}">
		<a href="/Web02/logout">Logout</a>
		<br>&nbsp;&nbsp;<a href="/Web02/detail">Myinfo</a>
	</c:if>
	<c:if test="${empty sessionScope.loginName}">
		<a href="/Web02/member/loginForm.jsp">Login</a>&nbsp;</c:if>
	<br> &nbsp;
	<a href="/Web02/member/memberJoin.jsp">Join</a>
	<br>&nbsp;
	<a href="/Web02/mlist">List</a>
	<br> &nbsp;
</body>
</html>