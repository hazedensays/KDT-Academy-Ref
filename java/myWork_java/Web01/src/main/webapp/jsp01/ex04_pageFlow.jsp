<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>** JSP Page Flow **</h2>
<h3>1) forward</h3>
=> JSP Action Tag를 이용한 이동
<script type = "text/javascript">
	alert("Hello로 이동");
	// => forward test인 경우에는
	//    스크립트는 브라우저에서 실행되기 때문에 스크립트 코드 실행 X
	//    : 서버에서 forward된 화면이 response로 출력되기 때문
</script>
<%--
<jsp:forward page="ex01_Hellojsp.jsp"/>
--%>

<hr>
<h3>2) include</h3>
-> 2-1) JSP Action Tag <br>
JSP 문서의 완성된 웹페이지가 포함됨, 변수공유 불가능 (코드호환이 안됨)<br>
<jsp:include page="ex01_Hellojsp.jsp"/>


<hr>
-> 2-2) Directive include Test <br>
JSP 문서의 소스코드가 포함됨, 변수공유 가능 (코드호환이 됨)<br>
<%-- <%@ include file ="ex01_Hellojsp.jsp" %> --%>
<hr>


</body>
</html>