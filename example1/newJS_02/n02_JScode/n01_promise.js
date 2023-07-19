"use strict"

// Test1 예전 방식 ====================================================================
let count1 = 0;

setTimeout(() => {count1++;}, 1000);
console.log(`Test1 예전방식 => count1 = ${count1}`);
//자바스크립트는 기본적으로 비동기 방식으로 운영되기 때문에 결과값은 '0'이 나온다.

/* Test2 Promise 방식 ====================================================================
   => promise 객체 생성 : Pending(대기) 상태
      - promise 객체를 생성하면 내부에서 executor 함수를 참조하여
      - 매개변수인 resolve, reject 를 전달받음
   => CallBack 함수 내에 실행코드 작성
      이 CallBack 함수의 매개 변수 resolve, reject들도 CallBack 함수임 */

// let count2 = 0;
let count2 = 1;

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
});

// 출력1: 개별적 메서드 작성
// promise.then((result) => {console.log(`Test2 Promise방식: 이행결정 => result = ${result}`);});
// promise.catch((error) => {console.log(`Test2 Promise방식: 이행거절 => error = ${error}`);});

// 출력2: 메서드 체이닝 적용
promise.then((result) => {console.log(`Test2 Promise방식: 이행결정 => result = ${result}`);})
       .catch((error) => {console.log(`Test2 Promise방식: 이행거절 => error = ${error}`);})
       .finally(() => {console.log("finally 부분 입니당.");});
