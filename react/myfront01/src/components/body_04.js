// ** Props 와 State 
// => State 도 값이므로 Props 로 전달 가능
// => Body 에 Child 컴포넌트 만들고 전달 Test
// => 전달된 부모 State 값이 변하면 Child 컴포넌트도 리랜더링 됨.
// => state 를 전달하지않은 경우와 비교
//    부모가 리랜더링 되면 Child 컴포넌트도 리랜더링됨

import './body.css';
import {useState} from "react";

// ** Child 컴포넌트 만들기
//    => 부모로부터 전달받은 값이 짝수/홀수인지 출력
function Viewer(props) {
    console.log ("** Child 컴포넌트의 Update **");

/*     if (props.number % 2 == 0) {
        return (
            <div>
                <p>** 여기는 child 컴포넌트 (짝수라능) **</p>
            </div>
        );
    } else {
        return (
            <div>
                <p>** 여기는 child 컴포넌트 (홀수라능) **</p>
            </div>
        );
    } */

    return (
        <div>
            <p>
                ** 여기는 child 컴포넌트 **
                {(props.number % 2 == 0) ? <h3>짝수</h3> : <h3>홀수</h3>}
            </p>
        </div>
    );
}

//props 구조 분해
/* function Viewer({number}) {
    console.log ("** Child 컴포넌트의 Update **");

    return (
        <div>
            <p>
                ** 여기는 child 컴포넌트 **
                {(number % 2 == 0) ? <h3>짝수</h3> : <h3>홀수</h3>}
            </p>
        </div>
    );
} */


function Body() {

    const[number, setNumber] = useState(0);
    const onIncrese = () => {setNumber(number + 1)};
    const onDecrese = () => {setNumber(number - 1)};

    //컴포넌트의 업데이트 확인
    console.log ("** Body 컴포넌트의 Update **");

    return (
        <div className="body">
            <h1>** Props와 State Test **</h1>
            <h2>** state 변수 : number={number} **</h2>
            <p>Props로 number값을 child 컴포넌트에 전달</p>

            <Viewer number={number}></Viewer>

            <div>
                <button onClick={onIncrese}>💖</button>
                <button onClick={onDecrese}>💔</button>
            </div>
        </div>
        
    );
}

export default Body;