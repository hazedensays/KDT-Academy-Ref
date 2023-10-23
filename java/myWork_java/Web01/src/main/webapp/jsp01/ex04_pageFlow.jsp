<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** JSP Page Flow **</title>
</head>
<body>
	<h2>** JSP Page Flow **</h2>
	<h3>1. Forward</h3>
	=> jsp Action Tage를 이용한 이동
<script type="text/javascript">
	alert("~~HelloJSP로 이동합니다~~~");
</script>
<h3>2. Include</h3>	
<hr>
-> 2.1) JSP Action Tag <br>
Jsp 문서의 완성된 웹페이지가 포함됨, 변수공유 불가능 (코드호환이 안됨)<br>
<%-- <jsp:forward page="ex01_HelloJSP.jsp"></jsp:forward> --%>
<jsp:include page="ex01_HelloJSP.jsp"></jsp:include>

-> 2.2) Directive include Test <br>
Jsp문서의 소스코드가 포함됨, 변수공유 가능 (코드호환이 됨)<br>
<%@ include file ="ex01_HelloJSP.jsp" %>

</body>
</html>