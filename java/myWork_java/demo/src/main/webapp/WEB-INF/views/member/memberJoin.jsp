<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_MVC2 Member Join **</title>
<script src="/resources/myLib/jquery-3.2.1.min.js"></script>
<script src="/resources/myLib/inCheck.js"></script>
<script> "use strict"
	// ** ID 중복 확인 =============================================================
	function idDupCheck() {
		// 1) 입력값의 무결성 확인
		if (iCheck == false) {
			iCheck = idCheck();
		} else {
		// 2) 서버로 id 확인 요청 -> 결과는 새 창으로
			let url = "idDupCheck?id="+document.getElementById("id").value;
			window.open(url, "_blank", "width=400,height=300,resizable=yes,scrollbars=yes,toolbar=no,menubar=yes");
		}
	}//idDupCheck
	
	// ** 입력값의 무결성 점검 =========================================================

	// 1) 전역변수 정의
	let iCheck = false;
	let pCheck = false;
	let p2Check = false;
	let nCheck = false;
	let aCheck = false; // 정수확인
	let bCheck = false;
	let oCheck = false; // point 실수확인
	
	onload=function() {

	document.getElementById('id').focus();
	document.getElementById('id').addEventListener('keydown', 
		(e) => { 
			if ( e.which==13 ) {
				e.preventDefault();
				// => form 에 submit 이 있는경우
				// => enter 누르면 자동 submit 발생되므로 이를 제거함
				document.getElementById('password').focus();
			} //if
		});
	// -> 무결성 확인
	document.getElementById('id').addEventListener('focusout',
			()=>{ iCheck=idCheck(); }); 

	// => Password
	document.getElementById('password').addEventListener("keydown",
			(e)=> {
				if ( e.which==13 ) {
					e.preventDefault();
					document.getElementById('password2').focus();
				} //if 		
			});
	document.getElementById('password').addEventListener("focusout",
			()=> { pCheck=pwCheck(); });
	
	// => Password2
	document.getElementById('password2').addEventListener("keydown",
			(e)=> {
				if ( e.which==13 ) {
					e.preventDefault();
					document.getElementById('name').focus();
				} //if 		
			});
	document.getElementById('password2').addEventListener("focusout",
			()=> { p2Check=pw2Check(); });
	
	// => Name
	document.getElementById('name').addEventListener("keydown",
			(e)=> {
				if ( e.which==13 ) {
					e.preventDefault();
					document.getElementById('age').focus();
				} //if 		
			});
	document.getElementById('name').addEventListener("focusout",
			()=> { nCheck=nmCheck(); });
	
	// => Age
	document.getElementById('age').addEventListener("keydown",
			(e)=> {
				if ( e.which==13 ) {
					e.preventDefault();
					document.getElementById('jno').focus();
				} //if 		
			});
	document.getElementById('age').addEventListener("focusout",
			()=> { aCheck=agCheck(); });
	
	// => Point
	document.getElementById('point').addEventListener("keydown",
			(e)=> {
				if ( e.which==13 ) {
					e.preventDefault();
					document.getElementById('birthday').focus();
				} //if 		
			});
	document.getElementById('point').addEventListener("focusout",
			()=> { oCheck=poCheck(); });
	
	// => Birthday
	document.getElementById('birthday').addEventListener("keydown",
			(e)=> {
				if ( e.which==13 ) {
					e.preventDefault();
					document.getElementById('rid').focus();
				} //if 		
			});
	document.getElementById('birthday').addEventListener("focusout",
			()=> { bCheck=bdCheck(); });
	
	// => Jno, Info, Rid, Image 는 EnterKey 처리(선택사항)
	document.getElementById('jno').addEventListener("keydown",
			(e)=> {
				if ( e.which==13 ) {
					e.preventDefault();
					document.getElementById('info').focus();
				} //if 		
			});
	document.getElementById('info').addEventListener("keydown",
			(e)=> {
				if ( e.which==13 ) {
					e.preventDefault();
					document.getElementById('point').focus();
				} //if 		
			});	
	document.getElementById('rid').addEventListener("keydown",
			(e)=> {
				if ( e.which==13 ) {
					e.preventDefault();
					document.getElementById('uploadfilef').focus();
				} //if 		
			});
	document.getElementById('uploadfilef').addEventListener("keydown",
			(e)=> {
				if ( e.which==13 ) {
					e.preventDefault();
					document.getElementById('submitTag').focus();
				} //if 		
			});
	
}; //onload 
	
	//3) submit 실행 여부 판단 & 실행
	//=> 모든항목의 무결성을 확인
	//=> 오류가 없으면 : return true
	//=> 오류가 1항목이라도 있으면 : return false 
function inCheck() {
	if (iCheck==false) { document.getElementById('iMessage').innerHTML=' 필수입력, id 를 확인하세요~~'; }
	if (pCheck==false) { document.getElementById('pMessage').innerHTML=' 필수입력, password 를 확인하세요~~'; }
	if (p2Check==false) { document.getElementById('p2Message').innerHTML=' 필수입력, password 재입력을 확인하세요~~'; }
	if (nCheck==false) { document.getElementById('nMessage').innerHTML=' 필수입력, name 을 확인하세요~~'; }
	if (aCheck==false) { document.getElementById('aMessage').innerHTML=' 필수입력, age 를 확인하세요~~'; }
	if (oCheck==false) { document.getElementById('oMessage').innerHTML=' 필수입력, point 를 확인하세요~~'; }
	if (bCheck==false) { document.getElementById('bMessage').innerHTML=' 필수입력, birthday 를 확인하세요~~'; }
	
	if (iCheck && pCheck && p2Check && nCheck 
			   && aCheck && oCheck && bCheck ) {
		// => submit 확인
		if ( confirm(" 정말 가입 하십니까? (Yes:확인 / No:취소)") ) {
			// => submit 진행
			return true
		}else {
			alert("~~  가입이 취소 되었습니다 ~~");
			return false;
		} //alert
	}else {
		return false;
	}
} //inCheck
	
</script>
</head>

<body>
	<h2>** SpringBoot Member Join**</h2>

	<form action="join" method="post" enctype="multipart/form-data">
		<table border="1" style="width: 90%">
			<tr height="40">
				<th bgcolor="hotpink">id</th>
				<td><input type="text" name="id" id="id" placeholder="영문, 10글자 이내"
					size="20">
					<button type="button" id="idDup" onclick="idDupCheck()">ID 중복확인</button>
					<br>
					<span id="iMessage" class="eMessage" style="color:red"></span>
				</td>
			</tr>
			
			<tr height="40">
				<th bgcolor="hotpink">password</th>
				<td><input type="password" name="password" id="password"
					placeholder="영문, 숫자, 특수문자" size="20"><br>
					<span id="pMessage" class="eMessage" style="color:red"></span>
				</td>
			</tr>

			<tr height="40">
				<th bgcolor="hotpink">password 확인</th>
				<td><input type="password" name="password2" id="password2"
					placeholder="영문, 숫자, 특수문자" size="20"><br> <span
					id="p2Message" class="eMessage" style="color:red"></span></td>
			</tr>

			<tr height="40">
				<th bgcolor="hotpink">name</th>
				<td><input type="text" name="name" placeholder="한/영문 입력" id="name"
					size="20"><br>
					<span id="nMessage" class="eMessage" style="color:red"></span>
				</td>
			</tr>
			
			<tr height="40">
				<th bgcolor="hotpink">age</th>
				<td><input type="text" name="age" id="age" placeholder="숫자 입력" size="20"><br>
					<span id="aMessage" class="eMessage" style="color:red"></span>
				</td>
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
				<td><input type="text" name="point" placeholder="실수 입력" id="point"
					size="20"><br>
					<span id="oMessage" class="eMessage" style="color:red"></span>
				</td>
			</tr>
			
			<tr height="40">
				<th bgcolor="hotpink">birthday</th>
				<td><input type="date" name="birthday" id="birthday" size="20"><br>
					<span id="bMessage" class="eMessage" style="color:red"></span>
				</td>
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
				<td colspan="2"><input type="submit" value="가입" onclick="return inCheck()" id="submitTag" disabled>&nbsp;&nbsp;&nbsp;
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
	<a href="/home">go home</a>&nbsp;&nbsp;&nbsp;
</body>
</html>