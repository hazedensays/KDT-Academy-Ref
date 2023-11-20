<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_MVC2 Member Update **</title>
<script src="/Spring02/resources/myLib/jquery-3.2.1.min.js"></script>
</head>
<body>
	<h2>** Spring_MVC2 Member Update **</h2>

	<form action="mupdate" method="post" enctype="multipart/form-data">
		<table border="1" style="width: 90%">
		
		<c:if test="${not empty requestScope.mDetail}">
			<tr height="40">
				<th bgcolor="hotpink">id</th>
				<td><input type="text" name="id" size="20" value="${requestScope.mDetail.id}" readonly></td>
			</tr>
			<!-- id : 화면 출력, 서버로 전송, 수정은 불가 (즉, input Tag의 입력불가)
					: readonly -> 서버로 전송 o
					: disabled -> 서버로 전송 x			-->
			
			<tr height="40">
				<th bgcolor="hotpink">password</th>
				<td><input type="password" name="password" size="20" value="${requestScope.mDetail.password}"></td>
			</tr>
			<!-- password 수정 : 기본적으로 복호화가 불가능한 방식으로 암호화가 되어있기 때문에 별도 처리
							  : 본인 재인증 후, 새 암호를 발송 -> 새 암호로 본인이 로그인 후 수정       -->
			
			
			<tr height="40">
				<th bgcolor="hotpink">name</th>
				<td><input type="text" name="name" size="20" value="${requestScope.mDetail.name}"></td>
			</tr>
			
			<tr height="40">
				<th bgcolor="hotpink">age</th>
				<td><input type="text" name="age" size="20" value="${requestScope.mDetail.age}"></td>
			</tr>
			
			<tr height="40">
				<th bgcolor="hotpink">jno</th>
				<td><select name="jno">
						<option value="1" ${requestScope.mDetail.jno==1 ? "selected" : ""}>1 : 119조</option>
						<option value="2" ${requestScope.mDetail.jno==2 ? "selected" : ""}>2 : 여우조</option>
						<option value="3" ${requestScope.mDetail.jno==3 ? "selected" : ""}>3 : i4조</option>
						<option value="4" ${requestScope.mDetail.jno==4 ? "selected" : ""}>4 : 최고조</option>
						<option value="5" ${requestScope.mDetail.jno==5 ? "selected" : ""}>5 : 오조</option>
						<option value="9" ${requestScope.mDetail.jno==9 ? "selected" : ""}>9 : test조</option>
				</select></td>
			</tr>
			
			<tr height="40">
				<th bgcolor="hotpink">info</th>
				<td><input type="text" name="info" size="20" value="${requestScope.mDetail.info}"></td>
			</tr>
			
			<tr height="40">
				<th bgcolor="hotpink">point</th>
				<td><input type="text" name="point" size="20" value="${requestScope.mDetail.point}"></td>
			</tr>
			
			<tr height="40">
				<th bgcolor="hotpink">birthday</th>
				<td><input type="text" name="birthday" size="20" value="${requestScope.mDetail.birthday}"></td>
			</tr>
			
			<tr height="40">
				<th bgcolor="hotpink">rid</th>
				<td><input type="text" name="rid" size="20" value="${requestScope.mDetail.rid}"></td>
			</tr>
			
			<!-- Image Update 추가 
         => form Tag : method, enctype 확인
         => new Image 를 선택하는 경우 -> uploadfilef 사용
         => new Image 를 선택하지않는 경우 
            -> 본래 Image 를 사용 -> uploadfile 값이 필요함
   -->   
			
			<tr height="40">
				<th bgcolor="hotpink">img</th>
				<td>
					<img class="select_img" alt="img" src="/Spring02/${requestScope.mDetail.uploadfile}" width="80" height="100">
					<input type="hidden" name="uploadfile"><br>
					<input type="file" name="uploadfilef" id="uploadfilef" size="20">
				</td>
			</tr>

			<script>
				document.getElementById('uploadfilef').onchange = function(e) {
					//$('#uploadfilef').change(function(){
					if (this.files && this.files[0]) {
						let reader = new FileReader;
						reader.readAsDataURL(this.files[0]);
						reader.onload = function(e) {
							$(".select_img").attr("src", e.target.result)
									.width(70).height(90);
						} // onload_function
					} // if   
				}; //change  -> }); JQ 사용시
			</script>

				<tr height="40">
				<td colspan="2"><input type="submit" value="수정">&nbsp;&nbsp;&nbsp;
					<input type="reset" value="취소"></td>
			</tr>
		</c:if>
		
		<c:if test="${empty requestScope.mDetail}">
			<tr height="40">
				<td colspan="2">수정할 자료가 존재하지 않습니다.</td>
			</tr>
		</c:if>
		
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