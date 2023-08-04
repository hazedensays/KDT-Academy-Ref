// => 컴포넌트는 개념적으로 props를 input으로 하고
//    UI가 어떻게 보여야 하는지 정의하는 React Element를 output으로 하는 함수.
// => UI를 구성하기 위해서는 화면에 컴포넌트를 그리고(Mounting), 갱신하고(Updating), 지워야(Unmounting) 함. 
// => 컴포넌트는 이 과정에서 각 프로세스 진행단계 별로 Lifecycle 함수로 불리는 특별한 함수가 실행됨.
//    개발자는 이를 재정의하여 컴포넌트를 제어할 수 있음.

// => Mounting : 컴포넌트를 페이지에 처음 랜더링 할때
// => Updating : State, Props 값이 바뀌거나 부모컴포넌트가 리랜더 하면서 자신도 리랜더 될때
// => Unmounting : 컴포넌트가 페이지에서 제거될때 (더이상 랜더링하지않음)

// => 함수 컴포넌트에서는 useEffect 를 이용하여 제어함.

// ** useEffect
// => 어떤 값이 변경될때 마다 특정코드를 실행하는 리액트훅이며
//    이것을 "특정값을 검사한다" 라고 표현함
// => 예를 들면 State 값이 바뀔때 마다 변경된 값을 콘솔에 출력하게 할 수 있음

// => useEffect(callback_함수, [deps]_의존성 배열)
//    두번쨰 인자인 의존성 배열요소의 값이 변경되면 첫번째 인자인 콜백함수를 실행함   

// ** Test
// => 1) State 변수인 count 값이 바뀌면 바뀐값을 콘솔로 출력한다.
// => 2) State 변수 text 추가후 확인하기.
// => 3) LifeCycle 제어
// => 4) Mount 제어
// => 5) Update(리랜더링)시에만 호출하도록 변경
// => 6) UnMount 제어

import logo from './logo.svg';
import './App.css';
import { useState, useEffect } from "react";
import Controllerr from './components/Controllerr';
import Viewer from './components/Viewer';

function App() {
  const[count, setCount] = useState(0); 
  const onChangeState = (num) => {
      setCount(count + num);
  }

  const[text, setText] = useState('');
  const onChangeText = (e) => {
      setText(e.target.value);
  }

/*   1. useEffect 적용
  => State 변수인 count 값이 바뀌면 바뀐 값을 콘솔로 출력한다.
  => count값 초기화할 때도 감지함 */
  useEffect(() => {console.log (`** useEffect test1 => count: ${count}**`);}, [count]);



/*   2. State 변수 text 추가 후 확인하기  */
  // useEffect(() => {console.log (`** useEffect test2 => count: ${count}, text: ${text} **`);}, [count, text]);
  // useEffect(() => {console.log (`** useEffect test2 => text: ${text}**`);}, [text]);

  useEffect(()=>{console.log(`useEffect test2) count = ${count} text = ${text}`);
  },[text]);

/*   3. 두번째 인수가 없는 useEffect 정의 후 비교
  => 콜백함수를 실행시켜주는 조건값이 제시되지 않은 경우
  => 랜더링 할때마다 호출됨 */
  useEffect(()=>{
    console.log(`useEffect test3) 배열없음 count = ${count} text = ${text}`);
  });


/*   4. Mount 제어
  => useEffect를 추가하고 두번째 인자는 빈 배열을 전달
  => useEffect 에 빈 배열을 전달하면 마운트 시점에만 콜백함수 실행
    ( 처음 한번만 실행됨 확인 )*/
  useEffect(() => {
    // alert("Hello, pingping");
    console.log(`useEffect test4) 빈배열 count = ${count}`)}
    , []);

/*   5. Update(리랜더링)시에만 호출하도록 변경
  => 콜백함수를 실행시켜주는 조건값이 제시되지 않은 경우
  => 랜더링 할때마다 호출됨 */







  // console.log ("** App Update !! **");

  return (
    <div className="App">
      <div>
        <div><input value={text} onChange={onChangeText}/></div>
        <Viewer count={count}/>
        <Controllerr onChangeState={onChangeState}/>
      </div>
    </div>
  );
}

export default App;
