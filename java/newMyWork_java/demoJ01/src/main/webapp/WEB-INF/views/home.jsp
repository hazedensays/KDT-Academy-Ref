
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Home</title>
</head>
<body>
	<h1 style="color: hotpink">Hello, JPA!</h1>

	<P>** Server_Time => ${serverTime}</P>
	<hr>

	<c:if test="${not empty sessionScope.loginID}">
		<b style="color: pink">=> ${sessionScope.loginName}님, Welcome!</b>
		<br>
	</c:if>


	<c:if test="${not empty requestScope.message}">
	=> ${requestScope.message}
	</c:if>
	<hr>

	<img alt="mainImage"
		src="/resources/images/KakaoTalk_20231023_121144200.jpg" width="300"
		height="300">
	<hr>
	<!-- Login 전 -->
	<c:if test="${empty sessionScope.loginID}">
		&nbsp;<a href="member/loginForm">Login_Get</a>&nbsp;
		&nbsp;<a href="member/memberJoin">Join_Get</a>&nbsp;
	</c:if>

	<!-- Login 후 -->

	<c:if test="${not empty sessionScope.loginID}">
		&nbsp;<a href="member/logout">Logout</a>
		<br>
		&nbsp;<a href="member/mdetail?id=${sessionScope.loginID}">MyInfo
			조회</a>
		<br>
		&nbsp;<a href="member/mdetail?jCode=U&id=${sessionScope.loginID}">MyInfo
			수정</a>
		<br>
		&nbsp;<a href="member/pUpdateForm">Password 수정</a>
		<br>
		&nbsp;<a href="member/mdelete?id=${sessionScope.loginID}">회원 탈퇴</a>
		<br>
	</c:if>

	<!-- 	&nbsp;<a href = "mlist">Member List</a><br> -->
	&nbsp;
	<a href="member/memberList">Member List</a>
	<br>
	<hr>
	&nbsp;
	<a href="member/log4jTest">log4jTest</a>
	<br>
	<hr>
	&nbsp;
	<a href="board/boardList">Board List</a>
	<br>
	<hr>
	&nbsp;
	<a href="board/bcriList">B_Cri_List</a>
	<br>
	<hr>
	&nbsp;
	<a href="jo/joList">Jo List</a>
	<br>
	<hr>
	&nbsp;
	<a href="bcrypt">bcrypt</a>
	<br>
	<hr>
	&nbsp;
	<a href="/axtestform">axtestform</a>
	<br>
	<hr>
	&nbsp;
	<a href="/ginsert">GSave</a>
	<a href="/guestlist">GList</a> &nbsp;
	<a href="/gupdate">GUpdate</a> &nbsp;
	<a href="/metamong">메타몽 김찬미</a>
	<br>


</body>
</html>