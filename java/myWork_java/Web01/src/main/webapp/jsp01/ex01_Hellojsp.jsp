<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello JSP</title>
</head>
<body>
	<h1>Hello JSP</h1>
	<h2>안녕하세요</h2>
	<h3>=> Java Code</h3>
<pre>
1) Scriptlet : 자바코드
2) Expression : 표현식 (출력문)
3) Declaration : 선언부 (메서드 등)
</pre>
<%!	
// Declaration : 선언부
	public int multiply(int a, int b){
		return a+b;
	}
	
	String name="조현주";
	int i=100;
	int j=200;
%>



=> Expression : 표현식 Test<br/>
=> multiply의(4,5)의 결과는 <%= multiply(4,5) %><br/>
=> 변수출력 : i=<%=i %>, j=<%=j%>, name=<%=name%><br/>
=> 연산적용 : i+j=<%=i%>, j=<%=j%><br/>



=> Scriptlet : 자바코드 Test<br/>
<% 
	int result=multiply(i,j); 
	name="한지민";
%>
=> result=<%=result%><br/>
=> name=<%=name%><br/>
</body>
</html>