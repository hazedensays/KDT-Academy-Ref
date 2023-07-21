// ** 나머지 매개변수(Rest Parameter) **
// => 두번째 인자가 있는 경우 arguments 활용

function test1(pp) {
    if (arguments[1]) {
        return pp + arguments[1];
    } else {
        return pp;
    }
}

console.log (`Test1: 인자 1개 사용 => ${test1(11)}`);
console.log (`Test1-1: 인자 2개 사용 => ${test1(11, 22)}`);
console.log (`Test1-2: 인자 3개 사용 => ${test1(11, 22, 33)}`);