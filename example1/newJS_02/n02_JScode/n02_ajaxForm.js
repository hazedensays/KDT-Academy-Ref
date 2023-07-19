"use strict"

/* ** XMLHttpRequest Test

 1. 통신 담당 객체 준비
 => XMLHttpRequest 객체 생성
 2. 요청을 실행
 => 클라이언트로부터 요청 이벤트 발생시 실행되는 메서드:startMethod() 작성 
       -> 생성된  XMLHttpRequest 객체 를 이용해서
            요청준비 (결과처리를 담당할 메서드를 지정) -> 요청 설정 -> 보냄
 3. 결과처리
 => 결과처리 담당 메서드 작성
 => 응답 결과가 오면 자동 실행 */

// ** 실습
// A. XMLHttpRequest 객체 생성
let xhrObj;     //XMLHttpRequest 객체의 인스턴스를 보관할 변수를 전역으로 선언

function creatXHR() {
    xhrObj = new XMLHttpRequest();
}




// B-1. ajaxBasic.ver
function startMethod() {
    // 1. 객체생성
    creatXHR();

    // 2. Response를 담당할 메서드 지정
    //=> 응답 처리를 위한 이 메서드는 ()없이 이름만 기술해야 함
    xhrObj.onreadystatechange = resultFunc;

    // 3. 요청설성 : open(매개변수 3개/ "전송방식", "URL", boolean)
    xhrObj.open("Get", "n01_promise.html", "true");
     // => 전송방식(Get), 요청페이지(url), 비동기적 통신이면 "true"

    // 4. 요청전송
    xhrObj.send(null);
}

// B-2. ajaxBasic.ver
//=> Make QueryString
function getParameterValues(){
    let id=document.getElementById('id').value;
    let password=document.getElementById('password').value;
    let name=document.getElementById('name').value;
    return 'id='+id+'&password='+password+'&name='+name; 
    // id=banana&password=12345!&name=바나나
}//getParameterValues

// => Get
function startMethodG( ) {
   createXHR();
   xhrObj.onreadystatechange=resultF;
   // => 요청설정
   //    parameter : url 퀴리스트링으로 처리
   let url='n09_03parameterResult.html?'+getParameterValues();
   // n09_03parameterResult.html?id=banana&password=12345!&name=바나나
   xhrObj.open('Get',url,'true');
   // => 요청전송
   xhrObj.send(null);
} //startMethodG

// => Post : DataValue 를 body 영역에 담아 전송
function startMethodP( ) {
   createXHR();
   xhrObj.onreadystatechange=resultF;
   // => 요청설정
   let url='n09_03parameterResult.html';
   xhrObj.open('Post',url,'true');
   // => 요청전송 : parameter 를 매개변수로 전달 , request Header 값 처리
   xhrObj.setRequestHeader('Content-Type','application/x-www-form-urlencoded;charset=utf-8');
   xhrObj.send(getParameterValues());
} //startMethodP



// C.resultFunc 함수 정의
function resultFunc() {
    if (xhrObj.readyState == 4) {
        // 요청 객체의 상태가 모든 데이터를 받을 수 있는 상태로 완료된 경우
        if (xhrObj.status == 200) {
            // respense 성공을 의미
            document.getElementById("resultArea").innerHTML
            = (`서버 Response => ${xhrObj.responseText}`);
        } else {
            document.getElementById("resultArea").innerHTML
            = (`서버 Response => 찾을 수가 없어요 ❌❌❌`);
        }
    }
}
