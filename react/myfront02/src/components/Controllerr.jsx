// ** Counter App
// => 숫자 더하기, 빼기만 있는 초간단 앱

// ** 요구사항 분석
// => UI
//    -> 1 Page 에 Count 버튼이 있는 Controller 와 결과를 출력하는 Viewer 2개 영역으로 
//       즉, App.js 외에 Controller,  Viewer 2개의 컴포넌트로 구성
//    -> Controller : 6개의 버튼 ( -1, -10, -100, +100, +10, +1 )
//    -> css : 적절하게 중앙에 위치하도록 App.css 수정

// => 기능구현
//    -> State 이용
//    -> Controller 의 버튼을 클릭하면 State값 변경 -> Viewer에 전달되어 출력됨
//    -> State 정의 위치 비교
//       ( Controller,  Viewer 는 Props 로 전달 불가, 그러므로 부모인 App 에 정의 )

import React from "react";

//방법 1
/* function Controller() {
    return (
        <div>
            <button>-1</button>
            <button>-10</button>
            <button>-100</button>
            <button>+100</button>
            <button>+10</button>
            <button>+1</button>
        </div>
    );
} */

//방법 2 : 익명함수, 화살표함수



const Controllerr= ({onChangeState}) => {
// ** 이벤트 핸들러
// => State가 정의된 부모 컴포넌트에 정의해야 함
// => 이를 전달받아 사용
/*  const onChangeState = (num) => {
    setCount(count + num);
} */

// ** onClick 이벤트 핸들러
// => onClick={ ()=> onChangeState(-1) }
// => 비교
/*    function buttonClick(n) {
          onChangeState(n);
      }
      => onClick 에 buttonClick(n) 을 call 하는 코드
         onClick={ buttonClick  } 
         ---> 어차피 매개변수 사용못함, 그러므로 직접 코드 작성
      => 익명함수, 화살표함수로 변경
      (n) => { onChangeState(n); }
*/

    // console.log ("** Controllerr Update !! **");

    return (
        <div>
            {/* ** 매개변수를 전달하기 위해 onClick 이벤트핸들러를 작성해서 전달받은 함수를 call(호출)함
            <button onClick={onChangeState}>-$1</button> */}

            <button onClick={() => onChangeState(-1)}>-$1</button>
            <button onClick={() => onChangeState(-10)}>-$10</button>
            <button onClick={() => onChangeState(-100)}>-$100</button>
            <button onClick={() => onChangeState(100)}>+$100</button>
            <button onClick={() => onChangeState(10)}>+$10</button>
            <button onClick={() => onChangeState(1)}>+$1</button>
        </div>
    );
}

export default Controllerr;