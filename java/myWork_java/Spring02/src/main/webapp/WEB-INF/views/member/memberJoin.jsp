<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_MVC2 Member Join **</title>
<script src="/best/resources/myLib/jquery-3.2.1.min.js"></script>
</head>

<body>
	<h2>** Spring_MVC2 Member Join**</h2>


<!--  ** FileUpLoad Form **
=> form 과 table Tag 사용시 주의사항 : form 내부에 table 사용해야함
   -> form 단위작업시 인식안됨
   -> JQ 의 serialize, FormData 의 append all 등 

=> method="Post" : 255 byte 이상 대용량 전송 가능 하므로

=> <form enctype="속성값">
   <form> 태그의 데이터 (input 의 value)가 서버로 제출될때 해당 데이터가 인코딩되는 방법을 명시함.  
 
=> enctype="multipart/form-data" : 화일 upload 를 가능하게 해줌 
   ** multipart/form-data는 파일업로드가 있는 입력양식요소에 사용되는 enctype 속성의 값중 하나이고, 
       multipart는 폼데이터가 여러 부분으로 나뉘어 서버로 전송되는 것을 의미
       이 폼이 제출될 때 이 형식을 서버에 알려주며, 
       multipart/form-data로 지정이 되어 있어야 서버에서 정상적으로 데이터를 처리할 수 있다.     
-->

	<form action="join" method="post" enctype="multipart/form-data">
		<table border="1" style="width: 90%">
			<tr height="40">
				<th bgcolor="hotpink">id</th>
				<td><input type="text" name="id" placeholder="영문, 10글자 이내"
					size="20"></td>
			</tr>
			<tr height="40">
				<th bgcolor="hotpink">password</th>
				<td><input type="password" name="password"
					placeholder="영문, 숫자, 특수문자" size="20"></td>
			</tr>
			<tr height="40">
				<th bgcolor="hotpink">name</th>
				<td><input type="text" name="name" placeholder="한/영문 입력"
					size="20"></td>
			</tr>
			<tr height="40">
				<th bgcolor="hotpink">age</th>
				<td><input type="text" name="age" placeholder="숫자 입력" size="20"></td>
			</tr>
			<tr height="40">
				<th bgcolor="hotpink">jno</th>
				<td><select name="jno">
						<option value="1">1 : 119조</option>
						<option value="2">2 : 여우조</option>
						<option value="3">3 : i4조</option>
						<option value="4">4 : 최고조</option>
						<option value="5">5 : 오조</option>
						<option value="9">9 : test조</option>
				</select></td>
			</tr>
			<tr height="40">
				<th bgcolor="hotpink">info</th>
				<td><input type="text" name="info" placeholder="자기소개 & 희망사항"
					size="20"></td>
			</tr>
			<tr height="40">
				<th bgcolor="hotpink">point</th>
				<td><input type="text" name="point" placeholder="실수 입력"
					size="20"></td>
			</tr>
			<tr height="40">
				<th bgcolor="hotpink">birthday</th>
				<td><input type="text" name="birthday" size="20"></td>
			</tr>
			<tr height="40">
				<th bgcolor="hotpink">rid</th>
				<td><input type="text" name="rid" placeholder="추천인 입력"
					size="20"></td>
			</tr>
			<tr height="40">
				<th bgcolor="hotpink">img</th>
				<td>
					<img src="" class="select_img"><br>
					<input type="file" name="uploadfilef" id="uploadfilef" size="20">
				</td>
			</tr>
			<script>
				// 해당 파일의 서버상의 경로를 src로 지정하는것으로는 클라이언트 영역에서 이미지는 표시될수 없기 때문에
				// 이를 해결하기 위해 FileReader이라는 Web API를 사용
				// => 이 를 통해 url data를 얻을 수 있음.
				//    ( https://developer.mozilla.org/ko/docs/Web/API/FileReader)
				// ** FileReader
				// => 웹 애플리케이션이 비동기적으로 데이터를 읽기 위하여,
				//    읽을 파일을 가리키는File 혹은 Blob 객체를 이용해 파일의 내용을(혹은 raw data버퍼로) 읽고 
				//    사용자의 컴퓨터에 저장하는 것을 가능하게 해줌.   
				// => FileReader.readAsDataURL()
				//     지정된 Blob의 내용 읽기를 시작하고, 완료되면 result 속성에 파일 데이터를 나타내는 data: URL이 포함됨.
				// => FileReader.onload 이벤트의 핸들러.
				//    읽기 동작이 성공적으로 완료 되었을 때마다 발생.
				// => e.target : 이벤트를 유발시킨 DOM 객체
				// => type="file" 은 복수개의 파일을 업로드할수 있도록 설계됨
				//    그러므로 files[] 배열 형태의 속성을 가짐

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
				<td colspan="2"><input type="submit" value="가입">&nbsp;&nbsp;&nbsp;
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
	<a href="/best/home">go home</a>&nbsp;&nbsp;&nbsp;
</body>
</html>