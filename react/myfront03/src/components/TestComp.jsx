// *** useReducer
// => 컴포넌트 외부에서 state 를 관리 할 수 있도록 해주는 React Hook. 
// => 상태변화코드
//    아래 onIncrease, onDecrease 처럼 상태(State) 값을 변경하는 코드 
// => 상태변화코드 분리
//    컴포넌트 내부에 있는 상태변화코드를 컴포넌트 외부에 작성한다는 의미 
//    이를 통해 가독성 과 유지보수성을 높여줌
// => 그러나 useState 는 반드시 컴포넌트 내부에 있어야 하므로 분리할 수 없으며
//    useReducer 는 분리가능.
//    파일로도 분리가능 하여 컴포넌트 내부를 간결하게 해줌.
// => state 와 useReducer
//    state 의 복잡 정도에 따라 state 또는 useReducer 사용.

// *** useReducer 적용
// => 생성문 형식
//    const [count_State변수, dispatch_상태변화촉발 함수] 
//                  = useReducer(reducer_상태변화함수, 0_초기값);
// => 컴포넌트 외부에 reducer 함수 만들기
// => 컴포넌트 내부에서 useReducer 호출

import { useReducer, useState } from "react";
import "../testComp.css";

// 2. useReducer 적용 
// 2.1) reducer 함수 만들기
// => 2개의 인자를 가짐
//  -> state: 현재의 state값 전달
//  -> action: dispatch 호출시 인자로 전달한 action 객체  
// => reducer 함수가 return 하는 값이 새로은 state 값이 됨
// => 초기화버튼 추가하기 
// => 상태 변화 함수 : 내부에서 상태값 변경

function reducer(state, action) {
    //상태값 변경 구현
    // => action.type이 "Increase"면 return state + action.data
    switch(action.type) {
        case "Increase" : return state + action.data;
        case "Decrease" : return state - action.data;
        case "Reset" : return 0;
        default: return state;
    };
};

// 2.2) 컴포넌트 내부에서 useReducer 적용
// => useReducer 생성
// => Button 클릭시 dispatch 호출하고,
//    dispatch 는 인자로 객체(type, data 값) 전달
//    이 객체는 state의 변경정보를 담고 있으며 action객체 라함.

function TestComp() {

/*  dispatch 사용 안하고 onClick={onIncrease} 라고 썻을 경우
    const[count, setCount] = useState(0);

    const onIncrease = () => {
        setCount(count + 1);
    }

    const onDecrease = () => {
        setCount(count - 1);
    } */

    const[count, dispatch] = useReducer(reducer, 0);

    return(
        <div className="reducerDiv">
            <h3>** useReducer Test **</h3>
            <h4>{count}</h4>
            <div className="btn">
                {/* <button onClick={onIncrease}>+</button> */}
                {/* <button onClick={onDecrease}>-</button> */}
                <button onClick={() => dispatch({type:'Increase', data: 1})}>+</button>
                <button onClick={() => dispatch({type:'Decrease', data: 1})}>-</button>
                <button onClick={() => dispatch({type:'Reset', data: 0})}>reset</button>
            </div>
        </div>//최종div
    );
};



export default TestComp;