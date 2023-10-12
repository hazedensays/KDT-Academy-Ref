<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>** Hello Dynamic Web_Project **</h2>

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
	<hr>

	<img alt="" src="./images/SSC_20231008110757.jpg" width="400"
		height="300">
	<hr>
	&nbsp;
	<a href="/Web01/servletTestForm/flowEx04_LoginForm.jsp">Login Form</a>
	<br> &nbsp;
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
	<a href="/Web01/logout">Logout</a>
	<br>
</body>
</html>