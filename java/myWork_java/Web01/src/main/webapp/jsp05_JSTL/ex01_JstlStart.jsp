<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 디렉티브 설정 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<pre>
** JSTL Start **
=> Jstl Library 를 정의 (현재문서_Page 가 인식할 수 있도록)
   디렉티브 taglib 에 uri=".." prefix=".."
<b>
1. 출력 : out Tag
=> Java 의 out객체, 표현식 역할, EL을 대신할 수 있음
<c:out value="Hello JSTL!! 안녕하세요 행님" />
<hr>

2. 변수 정의
=> set
<c:set value="홍길동" var="name"></c:set>
<c:set value="22" var="age" />
<hr>

3. 변수 출력 (out_Tag, EL)
=> JSTL 의 out_Tag
* name = <c:out value="${name}" />
* age = <c:out value="${age}" />

=> EL로 할 경우
* name = ${name }
* age = ${age }
* (age * 100) = ${age * 100}

=> Java로 할 경우 (JSTL과 호환이 되는지 Test)
:Error 발생
<%-- * name = <%=name%> --%>
<hr>

4. 연산 적용
<c:set value = "${age + age * 5}" var = "add"></c:set>
\${add} = ${add}
<c:set value = "${name == age}" var = "bool"></c:set>
\${bool} = ${bool}
<c:set value = "${age>add ? age : add}" var = "max"></c:set>
\${max} = ${max}
<hr>


5. 변수 삭제
=> remove
<c:remove var="add"/>
\${empty_add} => ${empty add}
\${empty_age} => ${empty age}
\${empty_name} => ${empty name}

=> 정의하지 않는 변수 삭제 : 오류 발생 안됨
<c:remove var="maerong"/>
<hr>


6. 우선순위
=> jstl 변수 와 Attribute (pageScope) 
=> 동일하게 Page에 정의된 경우에는 나중에 정의된 값이 우선 적용됨
   page(set변수, attribute 중 나중에 정의된 값 우선) 
   -> request -> session -> application 
   
<% pageContext.setAttribute("name", "그린컴퓨터"); %>   

* Test1) name 정의 순서 : set -> p_Attribute
  \${name} = ${name}

* Test2) set name을 재정의 <c:set value = "뉴길동" var = "name"></c:set>
  \${name} = ${name} <!-- : set 우선 적용 -->

</b>
	</pre>
</body>
</html>