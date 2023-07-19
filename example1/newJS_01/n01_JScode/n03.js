// 1. Function: Default Parameter

/* function test(name, activity) {
    console.log (`${name}씨는 ${activity}를(을) 좋아합니다.`)
}//test

test("김찬미", "축구");
test();  //undefined씨는 undefined를(을) 좋아합니다.

function testDefault(name = "Aimyon", activity = "기타") {
    console.log (`${name}씨는 ${activity}를(을) 좋아합니다.`)
}//testDefault

testDefault("Eve", "노래");
testDefault(); */



// 2. 화살표 함수와 this
//    => 일반함수
let gangwon = {
    resorts: ["강릉", "속초", "동해", "설악산"],
    print: function(delay = 1000) {
        console.log("printTest1 => " + this.resorts.join(","));
        // this는 현재 객체 gangwon을 인식
        setTimeout(function() {
                    console.log("printTest2 => " + this.resorts.join(","));
                    //}, delay); // bind 사용 전 코드 (에러발생)
                    // 일반함수는 this 값을 새로 바인딩(값을 할당)한다. 이 경우에는 window 객체를 가르킴
                    // 함수1 안에서 콜백함수로 사용된 일반 함수로 정의된 함수2에 this 사용 시에는
                    // this 가 새롭게 정의되어 에러가 발생한다.
                    // Uncaught TypeError: Cannot read properties of undefined (reading 'join')
                    }.bind(this), delay);
                    // 위 에러를 해결하기 위한 것이 bind라는 메서드이다.
                    // bind 사용 후 코드 : 객체 gangwon을 this에 바인딩(binding)해줌
    }//print
}//gangwon

gangwon.print();


// 2. 화살표 함수와 this
//    => 화살표 함수 (콜백(callback)함수는 화살표 함수 사용 가능)
let jeju = {
    resorts: ["한라산", "오름", "만장굴", "성산일출봉"],
    print: function(delay = 1000) {
        console.log("printTest1 => " + this.resorts.join(","));
        // this는 현재 객체 jeju를 인식
        setTimeout(() => {
                    console.log("printTest2 => " + this.resorts.join(",")); //this는 jeju 객체를 가르킴
                    }, delay);
    }//print
}//jeju

jeju.print();