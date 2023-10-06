<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Hello JSP **</title>
</head>
<body>
<h2>** Hello JSP **</h2>
<h3>요세하뇽안 ㅋㅋ</h3>
<h3>=> Java Code</h3>
<pre>
1) Scriptlet : 자바코드
2) Expression : 표현식 (출력문)
3) Declaration : 선언부 (메서드 등)
</pre>

<%! // Declaration : 선언부
public int multiply(int a, int b) {
	return a*b;
}

String name = "치이카와";
int i = 100;
int j = 200;
%>

** 표현식 (Expression) Test **<br>
=> multiply(4, 5)의 결과는 <%=multiply(4, 5)%><br>
=> 변수 출력 : i = <%=i%>, j = <%=j%>, name = <%=name%><br>
=> 연산 적용 : i + j = <%=i+j%><br>
<br>
=> Scriptlet : 자바코드<br>
<%
int result = multiply(i, j);
%>

=> result = <%=result%>
=> name = <%=name%>




</body>
</html>