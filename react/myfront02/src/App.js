import logo from './logo.svg';
import './App.css';
import { useState } from "react";
import Controllerr from './components/Controllerr';
import Viewer from './components/Viewer';
import LifecycleExample from './components/LifecycleExample';

function App() {
  const[count, setCount] = useState(0);  //destructuring, 비구조할당
  // => Controller,  Viewer 모두 필요하므로 부모에 정의
  // => State Lifting (끌어올리기) : State 를 여러 컴포넌트에서 사용하도록 하기위해 부모에 정의하는것 

  // ** 결론 (React 앱의 특징)
  // => State : 자식 컴포넌트와 데이터, 이벤트 공유
  // => 데이터 (Props) : 부모 -> 자식
  // => 이벤트 (함수)  : 자식 -> 부모
  // => 이러한 점을 고려해서 앱을 설계한다


  // ** 이벤트핸들러
  //    => Data의 한 종류이므로 자식 컴포넌트에 전달 가능
  const onChangeState = (num) => {
      setCount(count + num);
  }

  console.log ("** App Update !! **");
  // count가 바뀌면서 App 컴포넌트가 리랜더링 된다.
  // App의 자식 컴포넌트인 Viewer와 Controllerr도 같이 리랜더링 된다.

  return (
    <div className="App">
      <div>
        <Viewer count={count}/>
        <Controllerr onChangeState={onChangeState}/>
      </div>
      
      <div>
        <h2>** LifeCycle Test**</h2>
        <LifecycleExample/>
      </div>
    </div>
  );
}

export default App;
