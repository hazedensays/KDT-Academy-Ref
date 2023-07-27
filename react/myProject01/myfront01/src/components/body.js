// ** JSX 컴포넌트 기본규칙
// => 컴포넌트명은 대문자로 시작 (컴포넌트 1개에, 1개 파일)
// => {JS 표현식} : 기본자료형, 산술식,..객체, 배열 등
// => 단, 객체, 배열명 직접사용은 불허
// => class 속성은 class가 JS 예약어 이므로 className 으로 사용
// => 모든 Tag 는 닫힘 규칙 
// => 최상위 Tag 규칙 (필요시 <div> 또는 <React.Fragment> Tag 로 감싸줌)
// => 조건부 랜더링 : 삼항식({}내에서 가능), 조건문(JSX 에서는 사용불가능)

// ** Css, 스타일 적용하기
// => 인라인 스타일링 : style={{스타일...}}
//    HTML의 경우, <h1 style="color: palevioletred; background-color: paleturquoise;">
// => 스타일파일 분리 : Body.css(컴포넌트 파일명과 동일) , import './Body.css'

// ** import
//    => 컴포넌트는 MyComp from real_File_path;
//       내부 코드에서 MyComp 이름으로 인식
//    => CSS는 real_File_path만 명시함 ⭐



// ** Props, 컴포넌트에 값 전달하기
// => Props(properties) 객체 : 부모에서 자식으로 값 전달
// => 그러므로 Body 컴포넌트 Props로 값을 전달하기 위해서는
//    APP 컴포넌트에서 전달해야 함 (name 값을 Body로 전달)


// ** Event 
// ** State

import "./body.css";
import img1 from "../myImges/manju4.gif";
import React from "react";

function Body(props) {
    // 부모로부터 전달받는 매개변수명은 자유롭게 사용 가능하지만,
    // 일반적으로 props로 사용함

    let n1 = 10, n2 = 20;
    let s1 = "Hello", s2 = "world";
    //let b1 = "true", b2 = "false";
    let b1 = true, b2 = false;  //현재 오류, 추후 수정
    let obj = {id: "maerong", name: "메롱"};
    let res = (n1 + n2) % 2;

    // 부모로부터 전달된 props 확인
    //console.log (`Body, props : ${props}`);

    //***이벤트 핸들러
    function btnTest() {
        alert ("** Event Test... 응 구라야~ ㅋㅋ **");
    }






    // 조건문: JSX에서는 사용 불가능, 컴포넌트에서는 사용 가능
    //컴포넌트에서 최종적으로 return되는 것은 무조건 한 덩어리이어야 한다.
    if (b2) {
        return (
            <div className = "body">
                <h1 style = {{color: "palevioletred", backgroundColor: "paleturquoise", paddingTop: "10px", paddingBottom: "10px"}}>
                    ** Body : JSX TEST **</h1>

                <p>** props.name: {props.name}, props.contry: {props.contry} </p>
                <p>** 산술식: n1 + n2 = {n1 + n2}</p>
                <p>** 문자식: s1 + s2 = {s1 + s2}</p>
                <p>** 논리식: OR = {b1 || b2}, AND = {b1 && b2}</p>
    
                {/* 
                <p>** Object: obj = {obj}</p>
                    => Uncaught Error : Objects are not valid as a React child
                    => { }내에서는 객체, 배열명 직접 사용 불가능
                */}
                <p>Object: obj.id = {obj.id}, obj.name = {obj.name}</p>
                <br></br>
    
                <p>삼항식으로 n1 + n2의 값이 짝수면 "짝수", 아니면 "홀수" 출력하기</p>
                <p>** 짝수일까? 홀수일까? {res == 0 ? "짝수" : "홀수"} **</p>
                <br></br>

            </div>
        );
    } else {
        return (
            <React.Fragment>
                <div>
                    <h1>** Body : JSX TEST **</h1>
                    <p>집 가고 싶어요~</p>
                    <img src={img1}/>
                    <button onClick={btnTest}>클릭 한번으로 집가기</button>
                </div>
                
                <div>"최상위 Tag 규칙 : React.Fragment Tag로 감싸줌"</div>
            </React.Fragment>
        )
    }
}

export default Body;