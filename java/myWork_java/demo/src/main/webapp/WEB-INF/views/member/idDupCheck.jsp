<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** id 중복 확인 **</title>
<script src="/resources/myLib/inCheck.js"></script>
<script>

function idOK() {
	// 1) 
	//opener.document.getElementById('id').value=document.getElementById('id').value;
	// => 현재창의 input Tag 의 id 값을 부모창의 id 값으로 전달
	opener.document.getElementById('id').value='${param.id}';
	// => EL 활용: jsp 문서에서는 script 구문의 문자열 내부에 있는 EL은 처리해줌
	
	// 2)
	opener.document.getElementById('idDup').disabled = "disabled";
	opener.document.getElementById('submitTag').disabled = "";
	
	// 3)
	// => readonly 속성 사용시 주의
		//    Tag 의 속성은 readonly로 정의되어 있지만, (readonly="readonly")
		//    DOM 의 node 객체에서는 readOnly 로 정의되어있으므로
		//    JS 코딩시에는 readOnly 로 사용해야함
	//opener.document.getElementById('id').readonly="readonly"; --> 불가능
	//opener.document.getElementById('id').readOnly="readOnly"; --> 가능
	opener.document.getElementById('id').readonly=true;      /* --> 가능 */
	opener.document.getElementById('password').focus();
	
	// 4)
	close();
	// => window.close(), self.close()와 동일
	}
</script>

<style>
   body {
      background-color: pink;
      font-family: 맑은고딕;
   }
   #wrap {
      margin-left: 0;
      text-align: center;
   }
   h3 { color: navy; }   
</style>
</head>
<body>
	<div id = "wrap">
		<h3>** id 중복 확인 **</h3>
		<h4>parameter id값 확인</h4>
		=> Parameter_ID : ${param.id}<br>
		=> MemberDTO_ID : ${membverDTO.id}<br>
		
		
		<form action="idDupCheck" method="get">
			User_ID : 
			<input type="text" name="id" id="id" >
			<input type="submit" value="ID중복확인" onclick="return idCheck()">
		
			<!-- inCheck.js 의  idCheck() 의 결과에 따라 submit 결정 -->
			<span id="iMessage" class="eMessage"></span>
		</form>
		<br><br>
		
		<!-- 서버의 처리결과 : idUse 의 값 'T'/'F' 에 따른 화면 -->
         <div id="msgBlock">
            <c:if test="${idUse=='T'}">
               ${memberDTO.id}는(은) 사용가능합니다. &nbsp;&nbsp;
               <button onclick="idOK()">ID선택</button>
            </c:if>
            <c:if test="${idUse=='F'}">
               ${memberDTO.id}는(은) 사용 불가능합니다. &nbsp;&nbsp;
               
               <!-- 부모창(mJoinForm, opener)에 남아있는 사용자가 입력한 id는 지워주고,  
          		현재(this)창 에서는 id 에 focus 를 주고 재입력 유도 -> script 필요    -->
               <script>
               		document.getElementById("id").focus();
               		opener.document.getElementById('id').value='';
               </script>
            </c:if>
         </div>
		
		
	</div>


</body>
</html>