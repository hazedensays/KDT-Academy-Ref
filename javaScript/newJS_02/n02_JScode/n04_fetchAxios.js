"use strict"

/* ** fetch ======================================================
=> response를 2번에 나누어 받음
   -> then 1단계
   : response의 header를 먼저 인지함
   : status 확인 후 성공/실패에 따른 처리를 함
   : 성공일 경우 - body 결과를 받아 전달함
   : 실패일 경우 - 오류를 발생시키고 오류코드를 전달함
   
   -> then 2단계
   : 1단계에서 전달받은 data를 처리함


=>형태
function fetchTest() {
    fetch(url, {method: "Post",
                headers: "",
                body: {
                    id: "",
                    password: "",
                    name: ""
                }
}). then(() => {

}).then(() => {

}).catch(() => {
    
})
} */

// 1) fetch Test ======================================================
let url = "../javaScript04/snowVillage.html";
function fetchTest() {
    fetch(url).then((response) => {   //status 확인 후 성공/실패에 따른 처리를 함
        if (!response.ok) {
            throw new Error(response.status);     //catch블럭으로 이동
        }
        return response.text();
    }).then((responsePage) => {
        document.getElementById("resultArea").innerHTML = (`서버 Response => ${responsePage}`);
    }).catch((error) => {
        document.getElementById("resultArea").innerHTML = (`서버 Response => status: ${error}`);
    })
}



// 2) Axios Test ======================================================
let url2 = "../javaScript04/snowVillage.html";

function axiosTest() {
/*     axios({url: url2,
           method: "Get" */

    // Method 형식 요청
    // get (url, data...,)
    axios.get(url2
    ).then((response) => {
        document.getElementById("resultArea").innerHTML = (`서버 response 성공 => ${response.data}`);
    }).catch((error) => {
        document.getElementById("resultArea").innerHTML = (`서버 response =>
                                                            error.response = ${error.response}<br>
                                                            error.response.status = ${error.response.status}<br>
                                                            error.response.headers = ${error.response.headers}<br>`)
    });
}