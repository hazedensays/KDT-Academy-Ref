<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AjaxTest Main Form</title>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="/resources/myLib/jquery-3.2.1.min.js"></script>
<script src="/resources/myLib/axTest01.js"></script>
<script src="/resources/myLib/axTest02.js"></script>
</head>

<body>
	<h2>** AjaxTest Main Form **</h2>
	<hr>

	<c:if test="${not empty sessionScope.loginID}">
		<b style="color: pink">=> ${sessionScope.loginName}님, Welcome!</b>
		<br>
	</c:if>

	<c:if test="${not empty requestScope.message}">
	=> ${requestScope.message}
	</c:if>
	<hr>

	&nbsp;
	<span style="cursor: pointer" onclick="rsLoginf()">rsLogin</span>&nbsp;
	<span style="cursor: pointer" onclick="rsJoinf()">rsJoin</span>&nbsp;
	&nbsp;
	<a href="/home">[HOME]</a>

	<div id="resultArea1"></div>
	<div id="resultArea2"></div>

</body>
</html>