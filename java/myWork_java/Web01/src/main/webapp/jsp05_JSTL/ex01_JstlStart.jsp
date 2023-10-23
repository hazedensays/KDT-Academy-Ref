<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** JSTL Start **</title>
</head>
<body>
<pre>
** JSTL Start **
=> Jstl Library 를 정의 (현재문서_Page 가 인식할 수 있도록)
   디렉티브 taglib 에 uri=".." prefix=".."
<b>
1. 출력 : out Tag
=> Java 의 out객체, 표현식 역할, EL을 대신할 수 있음
<c:out value="~~Hello JSTL !!!, 안녕 제이에스 ~~"/>

2. 변수 정의
=> set
<c:set value="조현주" var="name"/>
<c:set value="28" var="age"/>

3. 변수 출력 (out_Tag, EL)
=> JSTL 의 out_Tag
*name = <c:out value="${name}"/>
*age = <c:out value="${age}"/>

=> EL
*name = ${name}
*age = ${age}

=> Java는 JSTL과 호환이 안된다. 
<%-- *name = <%=name%> --%>


4. 연산 적용
age*100 = ${age*100}
=> 더하기 연산
<c:set value="${age+age*5}" var="add"/>
\${add} = ${add}

=> boolean값
<c:set value="${add==3}" var="bool"/>
\${bool} = ${bool}

=> 삼항식
<c:set value="${age>add ? age:add}" var="max"/>
\${max} = ${max}

5. 변수 삭제
=> remove
<c:remove var="add"/>
\${empty add} => ${empty add}
\${empty age} => ${empty age}
\${empty name} => ${empty name}

=> 정의하지 않은 변수 삭제 : 오류 발생하지 않음
<c:remove var="add2"/>


6. 우선순위
=> jstl 변수 와 Attribute (pageScope) 
=> 동일하게 Page에 정의된 경우에는 나중에 정의된 값이 우선 적용됨
   page(set변수, attribute 중 나중에 정의된 값 우선) 
   -> request -> session -> application
<% pageContext.setAttribute("name", "한지민 너무 예뻐"); %>
* Test1) name정의 순서 : set -> p_Attribute
\${name} = ${name}

* Test1) set의 name을 재정의
<c:set value="한소희 너무 예뻐" var="name"/>
\${name} = ${name}

</b></pre>
</body>
</html>