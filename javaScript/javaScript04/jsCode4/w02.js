let newWindow = null;

// ** window Open
function load(url) {
    newWindow = window.open(url, 'myWin', 'left = 30, top = 30, width = 500px, height = 500px');
}

// ** window Close
function unload() {
// => newWindow의 open 상태 확인 후에 close 실행
    if (newWindow == null || newWindow.closed) {
        // if (newWindow == null || newWindow.closed == true) 와 같음
        return;
        // return 단독 사용 시, 현재 위치에서 함수 종료
    } else {
        newWindow.close();
    }
    //닫혀있는 브라우저를 또 닫으라고 하면 에러 발생
}



