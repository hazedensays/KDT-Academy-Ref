// try ~ catch ~ finally

// 1) 적용하지 않은 경우
console.log ("Test Start");

// foo();  // Uncaught ReferenceError: foo is not defined: 비정상 종료

// 2) 적용
let age = 200;

try {
    //foo();
    //error 생성
    if (age >= 200) {
        //오류 상황 : Error 객체 생성 후에 객체 던져줌 (throw) -> catch 블럭으로 가기
        throw new Error('💥💥Error 발생💥💥');
    }
} catch (error) {
    //error : try 코드 블록에서 발생한 Error 객체가 전달됨
    console.log (`Error 발생 => ${error}`);
} finally {
    console.log ("finally => 무조건 실행");
}

console.log ("Test End");