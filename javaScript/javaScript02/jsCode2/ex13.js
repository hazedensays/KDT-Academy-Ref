function scriptTest(e) {
    alert("test2. 인라인 + 스크립트" + "e.type = " + e.type +
    "e.defaultPrevented() = " + e.defaultPrevented);
}
//이 function에서 첫번째 매개변수로 무엇을 쓸건지 전달해주지 않았기 때문에 (event라는 걸 모르기 때문에)
// <button onclick="scriptTest(event)">에 event로 매개변수를 설정하지 않고
// e.type을 출력했을 때 에러가 발생함

//onload 감싸는 이유
/* 위에서부터 코드를 순차적으로 읽을 때 script 코드를 만났을 때
body보다 먼저 script를 만나게 됨
그러면 id나 class명 등등 만들어지지 않아서 정보를 가져오지 못하게 되기 때문에
onload라는 이벤트리스너를 사용하여 모든 html이 준비가 다 됐을 때 script를 실행한다 */



// ==================================================================
// 고전적 방식과 this, 이벤트 객체 활용 (마우스 위치값, target)
onload = function() {
    let t = document.getElementById("trad");
    t.onclick = function(e) {
        alert("test3. 고전적 방식");


        //this : 이벤트 핸들러에서 이벤트가 발생된 객체
        this.style.background="pink";
        this.style.border="none";
        this.style.color="hotpink";

        // => 마우스포인터 위치인식
        //    - e.pageX, e.pageY : 전체 Page 기준
        //    - e.clientX, e.clientY : 보여지는 화면 기준-> page Scroll 시에 불편함
        console.log (`e.pageX = ${e.pageX}, e.pageY = ${e.pageY}`);
        console.log (`e.clientX = ${e.clientX}, e.clientY = ${e.clientY}`);
        e.target.innerHTML = "이벤트 target Test complete";
        //this.innerHTML = "이벤트 target Test complete";  //this도 사용가능
        //e.target
    }

    
    
    
// =====================================================================
    //기본 이벤트 제거와 이벤트 객체
    //=>이벤트 핸들러의 첫 매개변수는 이벤트 객체를 전달
    //  단, 선언적 함수를 이벤트 핸들러로 사용하느 경우에는
    //  호출 시에 매개변수를 전달해야 함. ( Test2 참고)

    let a = document.getElementById("removeEvent");
    a.onclick = function(e) {
        e.preventDefault();   //e.preventDefault(); 메서드 위치에 따라 alert의 e.defaultPrevented
                            // 출력값이 바뀜을 확인할 수 있음.
        alert("test4. 기본 이벤트 제거 (remove)" + "e.type = " + e.type + "e.target = " + e.target +
                "e.defaultPrevented() = " + e.defaultPrevented);
        //위 코드까지만 작성했을 때 기본 이벤트가 제거되지 않고 alert가 뜨고 다른 창으로 넘어간다.
        // return false;
        //return 값을 false로 줘서 기본 이벤트를 제거하여 alert의 문구만 띄우고 실행이 멈춤
        // true : 진행 / false : 무효화
        //return false 는 e.preventDefault() + e.stopPropagation()

        // 이벤트 객체의 preventDefault() 메서드 : 기본 이벤트 제거
        //e.preventDefault();  //기본이벤트 제거
                                //e.defaultPrevented의 false->제거안됨
                                //                     true ->제거됨
        e.stopPropagation(); // 이벤트 흐름 중단
    }
}
