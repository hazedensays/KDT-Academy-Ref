"use strict"

// Test1 예전 방식 ====================================================================
/* let count1 = 0;

setTimeout(() => {count1++;}, 1000);
console.log(`Test1 예전방식 => count1 = ${count1}`); */
//자바스크립트는 기본적으로 비동기 방식으로 운영되기 때문에 결과값은 '0'이 나온다.


// <20230720> - 연습
//  => 1초 후에 1부터 100까지 더한 값을 출력하는 코드 작성

/* let total = 0;

setTimeout(() => {
    for (let i = 1; i <= 100; i++) {
        total += i;
    }
}, 1000);

console.log(`1부터 100까지 더한 값 => total: ${total}`); */

//  => 위의 for 구문을 Promise 적용 / 동기식으로 구현
let total = 0;

let prom = new Promise(function(resolve, reject) {
    setTimeout(() => {
        for (let i = 1; i <= 100; i++) {
            total += i;
        }

        if (total >= 100) {
            resolve(total);
            
        } else {
            reject("Failed : 실패했습니다.💦💦");
        }}, 1000);
}).then((result) => {
    console.log(`1부터 100까지의 합 => total: ${result}`);
    return result;
}).then((result) => {
    console.log(`1부터 100까지의 합의 평균 => avg: ${result / 100}`);   //첫번째 then에서 받은 result를 return 받음 (따라서 매개변수명이 달라도 됨)
}).catch((err) => {
    console.log(`Error 발생 => err: ${err}`);
}).finally(() => {
    console.log("금요일은 언제 오나요? 😷😷");
});




/* Test2 Promise 방식 ====================================================================
   => promise 객체 생성 : Pending(대기) 상태
      - promise 객체를 생성하면 내부에서 executor 함수를 참조하여
      - 매개변수인 resolve, reject 를 전달받음
   => CallBack 함수 내에 실행코드 작성
      이 CallBack 함수의 매개 변수 resolve, reject들도 CallBack 함수임 */
    
    //Promise 생성자함수 : Promise(CallBack함수 (CallBack_resolve, CallBack_reject));

// let count2 = 0;
/* let count2 = 1;

let promise = new Promise(function(resolve, reject) {
    // 지연함수를 1초 후에 순차적으로 실행하고 결과에 따른 이행 CallBack 함수를 호출
    setTimeout(() => {
        count2++;

        //count2의 값이 짝수인 경우 이행결정, 홀수인 경우 이행거절 처리
        if (count2 % 2 == 0) {
            resolve(count2);    //이행 결정에 해당하는 CallBack함수 호출
        } else {
            reject("Failed : 실패했습니다.💦💦");    //이행 거절에 해당하는 CallBack함수 호출, 매개변수를 이용한 에러메세지 전달
        }}, 1000);
}); */

// 출력1: 개별적 메서드 작성
// promise.then((result) => {console.log(`Test2 Promise방식: 이행결정 => result = ${result}`);});
// promise.catch((error) => {console.log(`Test2 Promise방식: 이행거절 => error = ${error}`);});

// 출력2: 메서드 체이닝 적용
/* promise.then((result) => {console.log(`Test2 Promise방식: 이행결정 => result = ${result}`);})
        //then의 매개변수 result에 resolve의 매개변수인 count2가 전달됨
       .catch((error) => {console.log(`Test2 Promise방식: 이행거절 => error = ${error}`);})
        //catch의 매개변수 error에 reject의 매개변수가 전달됨
       .finally(() => {console.log("finally 부분 입니당.");}); */



// => jQuery 구문과 비교해보세요 ~~
/*
$.ajax({
           type:'Get',  // Get/Post
           url:'ax03_parameterResult.jsp',
           data: {
              id:document.getElementById('id').value,
              password:$('#password').val(),
              name:$('#name').val()
           },
           success:function(result) {
              alert('** Ajax jQuery Test 성공 **');
              $('#resultArea').html('** 서버의 Response_JQuery => <br>'+result);
           },
           error:function() {
              alert('** Ajax jQuery Test 실패 **');
              $('#resultArea').html('** 서버의 Response_JQuery => Error !!!<br>');
           }
          }); //ajax
*/