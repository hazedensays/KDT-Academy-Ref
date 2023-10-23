<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mvcTest.StudentDTO,mvcTest.StudentService"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Student List_MVC01</title>
</head>
<body>
	<h2>JSP Student List_MVC01</h2>
<pre>
=> Service 실행 -> 결과 가져오기 -> 출력
</pre>
<%
	StudentService service = new StudentService();
	List<StudentDTO> list = service.selectList();
%>
<table border=1 style="width:90%">
	<tr bgcolor="Lime">
		<th>sno</th>
		<th>name</th>
		<th>age</th>
		<th>jno</th>
		<th>info</th>
		<th>point</th>
		<th>birthday</th>
	</tr>
<%
// list에서 출력
if (list != null) {
	for (StudentDTO s : list) {%>
	<tr>
		<td><%=s.getSno()%></td>
		<td><%=s.getName()%></td>
		<td><%=s.getAge()%></td>
		<td><%=s.getJno()%></td>
		<td><%=s.getInfo()%></td>
		<td><%=s.getPoint()%></td>
		<td><%=s.getBirthday()%></td>
	</tr>
<%	}
} else {%>
	<h2>출력데이터 없음</h2>
<%}
%>
</table>
</body>
</html>