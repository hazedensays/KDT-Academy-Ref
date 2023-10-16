<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>** Hello Dynamic Web_Project **</h2>

<%--아래 JSTL과 비교
	<%
	if (session.getAttribute("loginName") != null) {
	%>
	<%=session.getAttribute("loginName")%>님, 환영합니다.
	<br>
	<%
	} else {
	%>
	로그인 후 이용바랍니다.
	<br>
	<%
	}
	%>
--%>



<c:if test="${empty sessionScope.loginName}">로그인 후 이용바랍니다.</c:if>
<c:if test="${not empty sessionScope.loginName}">${sessionScope.loginName}님, welcome!</c:if>
<hr>
<%-- <c:if test = "${sessionScope.loginName != null }"></c:if> --%>

	<img alt="" src="./images/SSC_20231008110757.jpg" width="400"height="300">
	<hr>
	
	&nbsp;
	<c:if test="${not empty sessionScope.loginName}">
	<a href = "/Web01/logout">Logout</a>
	<br>&nbsp;&nbsp;<a href = "/Web01/detail">Myinfo</a>
	</c:if>
	<c:if test="${empty sessionScope.loginName}"><a href = "/Web01/servletTestForm/flowEx04_LoginForm.jsp">Login</a>&nbsp;</c:if>
	<br> &nbsp;
	<a href = "/Web01/jsp99_mvcTest/mvc2_sJoin.jsp">Join</a>
	<br>&nbsp;
	<a href="/Web01/helloS">Hello Servlet</a>
	<br> &nbsp;
	<a href="/Web01/lifecycle">Servlet LifeCycle</a>
	<br> &nbsp;
	<a href="/Web01/flow01">flow01</a>
	<br> &nbsp;
	<a href="/Web01/servletTestForm/flow02_TestForm.jsp">flow02_TestForm.jsp</a>
	<br> &nbsp;
	<a href="/Web01/sessioni">SessionInfo</a>
	<br> &nbsp;
	<a href="/Web01/01set">Scope Test</a>
	<br> &nbsp;
	<a href="/Web01/list2">List2</a>
	<br> &nbsp;
</body>
</html>