<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_MVC2 Member PW 수정 **</title>
<script src="/Spring02/resources/myLib/jquery-3.2.1.min.js"></script>
<script>
	function pCheck() {
		let pvalue = document.getElementById('password').value; 
		
		if ( pvalue.length < 4 ) {
			alert('~~ Password 를 4자 이상 입력 하세요 ~~');
			return false;
		}else if ( pvalue != document.getElementById('password2').value ) {
			alert('~~ Password 가 일치하지 않습니다 ~~') ;
			return false;
		}else return true; 
	} //pCheck

</script>
</head>

<body>
	<h2>** Spring_MVC2 Member PW 수정 **</h2>

	<form action="passwordUpdate" method="post">
		<table border="1" style="width: 90%">
			<tr height="40">
				<th bgcolor="hotpink">pw</th>
				<td><input type="password" name="password" id="password"
					placeholder="영문, 숫자, 특수문자" size="20"></td>
			</tr>
			
			<tr height="40">
				<th bgcolor="hotpink">pw 확인</th>
				<td><input type="password" id="password2"
					placeholder="pw를 재입력해주세요." size="20" onblur="pCheck()"></td>
			</tr>
	
			<tr height="40">
				<td colspan="2"><input type="submit" value="변경" onclick="return pCheck()">&nbsp;&nbsp;&nbsp;
					<input type="reset" value="취소"></td>
			</tr>
		</table>
	</form>
	<hr>

	<c:if test="${not empty requestScope.message}">
		=> ${message}
	</c:if>
	<hr>

	<a href="javascript:history.go(-1)">go back</a>
	<a href="/Spring02/home">go home</a>&nbsp;&nbsp;&nbsp;
</body>
</html>