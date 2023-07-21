"use strict";

// ** 과제
     // 배열 arr 을 전달하여 0 ~ 6 값을 가지는 배열을 완성하는 함수를 작성한다.
     // 단, 매개변수를 사용하지않고 arguments 객체를 사용한다.

let arr = [2, 3, 4];

function myTest(){
    let test = [0,1, ...arguments, 5, 6];
    // 함수 호출 시 적용하는 인자의 값이  arguments객체에 배열의 원소로 정의됨
     console.log(`** Test1 함수 내부의 test => ${test}`);
}
myTest(arr);

let names = ['김','나', '박', '이'];
myTest(names);


//  Test2) 펼침연산자 ...

names = ['banana', 'apple', ...arr, 'coffee'];
console.log(`** Test2 펼침연산자 test => ${names}`);