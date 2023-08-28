// ** Redux 
// 실습1. Redux 를 사용하지 않는 코드
// 1) Root, Left1~3, Right1~3 완성
// 2) Right3에 + Button 추가하여 누르면 number 값을 증가 시켜주도록 구현한다.
// 3) 결과를 확인한다. (계속 number 를 전달받는 Left 의 값 변경됨)
// 4) 결론
//    - Props 로 각 계층간에 Data를 주고 받기위해서는 Props Drilling 문제 발생
//    - 계층이 깊어지면 이 문제는 심각해지며 이를 해결해주는 도구가 Redux 임.
//    - 이것을 부분적으로 해결해주는 것이 React의 Context, useContext, useReducer 임.

import './App.css';
import {useState} from 'react'

function App() {

  const [number, setNumber] = useState(1);

  return (
    <div id="container">
      <h1>Root</h1>

      <div id="grid">
        <Left1 number={number}/>
        <Right1 number={number}
                onIncrease = {() => setNumber(number + 1)}/>
      </div>

    </div>//최종div
  );
}

function Left1({number}) {
  return (
    <div>
      <h1>Left1</h1>
      <Left2 number={number}></Left2>
    </div>
  );
} //Left1

function Left2({number}) {
  return (
    <div>
      <h1>Left2</h1>
      <Left3 number={number}></Left3>
    </div>
  );
} //Left2

function Left3({number}) {
  return (
    <div>
      <h1>Left3: number={number}</h1>
    </div>
  );
} //Left3


function Right1({number, onIncrease}) {
  return (
    <div>
      <h1>Right1</h1>
      <Right2 number={number} onIncrease={onIncrease}></Right2>
    </div>
  );
} //Right1

function Right2({number, onIncrease}) {
  return (
    <div>
      <h1>Right2</h1>
      <Right3 number={number} onIncrease={onIncrease}/>
    </div>
  );
} //Right2

function Right3({number, onIncrease}) {
  return (
    <div>
      <h1>Right3: number={number}</h1>
       <input type='button' value='Increase' onClick={() => onIncrease()} />
    </div>
  );
} //Right3

export default App;
