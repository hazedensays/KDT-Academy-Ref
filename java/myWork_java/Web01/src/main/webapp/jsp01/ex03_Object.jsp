<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** JSP Object **</title>
</head>
<body>
	<h2>** Jsp Object **</h2>
	<pre>
=> Web 애플리케이션 기본 객체(implicit object)
=> JSP에서 별도의 인스턴스 선언 없이 사용 가능
=> request, response, out, session, 
   pageContext, application 등 9종류

	<h3>1) Request</h3>
* ContextPath => <%=request.getContextPath() %>
* RealPath => <%=request.getRealPath("/") %>
* RequestURI => <%=request.getRequestURI() %>

<h3> 2) Session</h3>
* Session_ID => <%=session.getId() %>

<h3> 3) out</h3>
* out 출력 => <%out.print("out 객체로 출력하기"); %>

<h3>4) Page Context</h3>
=> JSP 페이지에 대한 정보를 저장함
=> 기본 객체를 return하는 메서드 제공
   : request객체와 메서드가 return하는 객체와 동일성 비교
<%
HttpServletRequest req = (HttpServletRequest)pageContext.getRequest();
%>

-> 비교 결과 : <%= request == req %>
-> pageContext가 제공하는 out 객체로 출력하기
<%pageContext.getOut().print("pageContext가 제공하는 out 객체로 출력하기"); %>
   
<h3>5) Application</h3>   
* 서버정보 => <%=application.getServerInfo() %>
* 서블릿 메이저버전 => <%=application.getMajorVersion() %>   
* 서블릿 마이너버전 => <%=application.getMinorVersion() %>
* RealPath1 => <%=application.getRealPath("") %> : ("" 사용시에는 현 프로젝트의 RealPath return)
* RealPath2 => <%=application.getRealPath("/jsp01") %> : (지정한 경로의 RealPath)
  -> HDD상의 소스 위치가 아님을 주의
</pre>

</body>
</html>