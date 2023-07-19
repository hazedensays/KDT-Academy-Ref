"use strict"

// 아래 코드의 print function()을 Promise에 적용하기 ===============================
/* let jeju = {
    resorts: ["한라산", "오름", "만장굴", "성산일출봉"],
    print: function(delay = 1000) {
        console.log("printTest1 => " + this.resorts.join(","));
        // this는 현재 객체 jeju를 인식
        setTimeout(() => {
                    console.log("printTest2 => " + this.resorts.join(",")); //this는 jeju 객체를 가르킴
                    }, delay);
    }//print
}//jeju

jeju.print(); */

// Promise.ver ===================================================================
let resorts = ["한라산", "오름", "만장굴", "성산일출봉"];
// let resorts = ["한라산", "오름", "만장굴", "성산일출봉", "한라산", "오름", "만장굴", "성산일출봉"];

let promise = new Promise((resolve, reject) => {
    setTimeout(() => {
        let text = resorts.join('-');
        
        //완성된 문자열의 길이가 30 이하일 경우라면 이행결정, 초과일 경우라면 이행거절
        if (text.length <= 30) {
            resolve(text);
        } else {
            reject("Failed : 실패했습니다.💦💦");
        }
    }, 1000);
}).then((result) => {
    console.log(`Test 이행결정 => result: ${result}`);
}).catch((err) => {
    console.log(`Test 이행거절 => err: ${err}`);
}).finally(() => {
    console.log("finally 부분 입니당.");
});
