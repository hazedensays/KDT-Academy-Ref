"use strict"

// Test1
let ajaxP = new Promise((resolve, reject) => {
    //1.1 Ajax 요청
    let xhrObj = new XMLHttpRequest();
    xhrObj.open("Get", "n01_promise.htm", "true"); //true 생략 가능

    //1.2 response 처리
    xhrObj.onload = () => {     //xhrObj.onload = function() {}
        //정상실행, 거절(실패,오류)
        if (xhrObj.status == 200) {
            resolve(xhrObj.response);
        } else {
            reject(xhrObj.status);
        }
    }

    //1.3 요청실행
    xhrObj.send(null);
})

ajaxP. then((response) => {
    alert("Test1 : 성공입니다.");
    document.getElementById("resArea").innerHTML = (`Test1 : 서버 response => ${response}`);
}).catch((error) => {
    alert(`Test1 : 실패했어요. status: ${error}`);
});


// Test2
// then(f1, f2)
// => f1: 성공 / f2: 실패
ajaxP.then((response) => {
    alert("Test2 : 성공입니다.");
    document.getElementById("resArea").innerHTML = (`Test2 : 서버 response => ${response}`);
}, (error) => {
    alert(`Test2 : 실패했어요. status: ${error}`);
});