"use strict";

//Test1) 배열 =================================================================================
// => 배열 원소의 값들을 a, b, c 변수에 할당
// => 차례대로 할당

let list = [1, 2, 3, 4, 5];
// 일반적 표기: let a = list[0], b = list[1], c = list[2]
// => 비구조할당: 변수들을 한번에 나열하고 할당한다.

//let [a, b, c] = list;   // 왼편[] 내부 변수들의 순서대로 1, 2, 3 차례대로 할당되고 나머지는 무시.
//let [a, , b, , c] = list;   //1, 3, 5
let [a, , b, , c, d, e, f, g, h] = list

//console.log (`** Test1 -> a = ${a}, b = ${b}, c = ${c}`);
console.log (`** Test1 -> a = ${a}, b = ${b}, c = ${c}, f = ${f}`);     //undefined



//Test2) 인자에 비구조할당 적용 ==================================================================
//2-1) 배열형
function testParam([a, b, c = a + b, d = a * b]) {
    console.log (`Test2-1 배열형 -> a = ${a}, b = ${b}, c = ${c}, d = ${d}`);
}

testParam([100, 200]);
testParam([100, 200, 999]);     //call하면서 세번째 값을 전달하면 연산식 무시 우선 적용

//2-2) 객체형
function testObj({a, b, c = a + b, d = a * b}) {
    console.log (`Test2-2 객체형 -> a = ${a}, b = ${b}, c = ${c}, d = ${d}`);
}

testObj({a: 100, b: 200});  //인자를 리터럴 객체로 전달
testObj({a: 100, b: 200, c: "ObjectTest"}); //호출 시 전달된 값이 우선
testObj({a: 100, b: 200, t: "없는 인자 Test", c: "ObjectTest"}); //인자값이 이름으로 전달되기 때문에 't'는 무시됨
