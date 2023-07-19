/* ** Array **=========================================================================
=> 문자열의 중복을 허용하지 않는 배열 정의하기
   : 배열 정의
   : 중복 확인 기능 (함수로 만들기)
   : 배열에 자료 담기 */

//조원들의 이름을 배열에 담기 (중복을 허용하지 않음)
let arr = [];
// let arr = new Array();

//매개변수 text로 전달된 값을 배열 arr의 요소들과 비교해서
//중복된 값이 없는 경우 return true;, 있는 경우 return false;
const unique = (text) => {
    for (let name of arr) {
        if (text == name) {
            return false;
        }
    }//for

    return true;
}//unique

//str을 배열 arr에 담기 (중복 허용하지 않음)
let str = ['조현주', '김이지', '김찬미', '김진휘', '김이지', '김찬미'];

for (let name of str) {
    //중복 검사
    if (unique(name) == true) {
 // if (unique(name)) { 생략가능
        arr.push(name); // push : 마지막 인덱스에 데이터를 중첩해서 추가
    }
}

for (let name of arr) {
    console.log (`arr => ${name}`);
}

console.log (`arr.length => ${arr.length}`);



/* ** Set과 비교 **=========================================================================
=> str : mySet에 담기
   set의 메서드: add, delete, has, size */

//방법 1
/*  let mySet = new Set(str);

for (let mS of mySet) {
    console.log (`mySet => ${mS}`);
}

console.log (`mySet.size => ${mySet.size}`); */

//방법 2
let mySet = new Set();

for (let i of str) {
    mySet.add(i);
}

for (let mS of mySet) {
    console.log (`mySet => ${mS}`);
}

mySet.delete('김진휘');

console.log (`mySet.has => 김진휘 존재 유뮤: ${mySet.has('김진휘')}`);
console.log (`mySet.has => 김찬미 존재 유뮤: ${mySet.has('김찬미')}`);
console.log (`mySet.size => ${mySet.size}`);


/* ** Set 메서드 체이닝 **=========================================================================
=> 처리 후 Set Type을 return하는 메서드는 계속 '.'으로 연결해서 사용 가능
   단, delete, has 메서드는 boolean을 return하기 때문에 '.' 불가능 */
mySet.add('설수현').add('신혜진').add('연제승').add('설수현');
mySet.add('설수현').add('신혜진').add('연제승').add('설수현').delete('설수현'); //마지막에 한번 사용하는 것은 가능

for (let mS of mySet) {
    console.log (`mySet => ${mS}`);
}


// ** forEach **=========================================================================
  // ** forEach(CallBack함수) : 요소를 순회
    // => 이때 매개변수로 사용되는 CallBack함수 는 3개의 인수를 전달받음
    //    (현재 요소값, 현재 요소값, 현재 순회중인 set객체 자체)
    // => 배열의 forEach 메서드 Array.prototype.forEach 의 CallBack함수 인수 3개는
    //    (현재 요소값, 현재 인덱스, 현재 순회중인 배열객체 자체)
    // => Map의 forEach 메서드 Map.prototype.forEach 의 CallBack함수 인수 3개는
    //    (현재 value, 현재 key, 현재 순회중인 map객체 자체 )

    mySet2.forEach((v1, v2) => {
        console.log(`** forEach(함수) = ${v1}, ${v2}`);
      });
mySet.forEach(function(v1, v2) {
    console.log (`forEach(함수) => ${v1}, ${v2}`);
});

/* mySet.forEach((v1, v2) => {   //화살표 함수
    console.log (`forEach(함수) => ${v1}, ${v2}`);
}); */