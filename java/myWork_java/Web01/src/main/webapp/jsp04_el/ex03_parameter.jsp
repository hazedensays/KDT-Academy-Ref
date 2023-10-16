<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<pre><h3>
** Parameter 활용 **
=> 동질성 비교, null 확인
1. 동질성 비교
* I D : ${param.id}
* P W : ${param.pw}

\${param.id == 'admin'} => ${param.id == 'admin'}
\${param.pw == '12345'} => ${param.pw == '12345'}

2. null 확인 : empty, ==
=> empty : 해당하는 Parameter가 존재하지않거나, 존재하지만 값이 없는 경우 모두 true 
\${empty_param.id} => ${empty param.id}
\${empty_param.pw} => ${empty param.pw}

=> ==null : 해당하는 Parameter가 존재하지않으면 true, 존재하지만 값이 없는 경우에는 false
\${param.id == null} => ${param.id == null}
\${param.pw == null} => ${param.pw == null}

<!--  
http://localhost:8080/Web01/jsp04_el/ex03_parameter.jsp?id=admin&pw=12345
=> 쿼리 스트링으로 확인
-->


3. pageContext
=> JSP 페이지에 대한 정보를 저장한다.
=> 기본 객체를 return 하는 메서드를 제공.
* 요청 URL: ${pageContext.request.requestURL}
* 요청 URI: ${pageContext.request.requestURI}
</h3></pre>
</body>
</html>