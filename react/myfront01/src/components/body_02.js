// ** State
// => 값을 저장하거나 변경 할 수 있는 객체로 이벤트와 함께 주로 사용됨.
//   - 즉, 버튼 클릭시 버튼의 컬러를 변경할때 등에 사용됨
//   - 이벤트 발생 -> 이로 인하여 화면에 리렌더링이 필요한 경우 리렌더링이 자동 실행
//      : State 변수로 지정된 변수의 값에 변화가 일어나면 리액트에서는 리랜더링 해줌
// => useState 생성자함수로 State 생성
//    const [text_State변수, setText_set함수] = useState("초기값");
// => useState 를 호출하면 현재상태값과 이 State변수의 값을 변경하는 set함수를 담은 배열을 return.

import './body.css';
import {useState} from "react";

function Body() {
    //state test 1
    // => 1) state 변수 count를 출력
    // => 2) count2를 1씩 증가시키는데, 5가 증가하면 리랜더링 하도록 수정
    let count2 = 0;
    const [count, setCount] = useState(0);
    const onIncrease = () => {
        setCount(count + 1); //count+=1; setCount(count + 1)의 count 값에는 영향이 없음

        if (count2 >= 100) {
            alert (`나랑 결혼할래? 👰💗🤵`);
            setCount(0);
            count2 = 0;
        } else {
            // test.1
            count2 += 1;
            console.log (`state_count Test => ${count2}`);

            // test.2 : count2의 값 5의 배수일 때 setCount() 호출
            if (count2 % 5 == 0) {
                setCount(count2);
            }

        }
    }

    //state test 1-1
    const onDecrease = () => {
        setCount(count - 1);

        if (count <= 0) {
            alert (`0으로 내려가면 헤어지는거야!!!!!!🤬🤬🤬`);
            setCount(0);
            count2 = 0;
        } else {
            // test.1
            count2 -= 1;
            console.log (`state_count Test => ${count2}`);

            // test.2 : count2의 값 5의 배수일 때 setCount() 호출
            if (count2 % 5 == 0) {
                setCount(count2);
            }
        }
    }
 

    //state test 2 - 다양한 input Tag
    //text (textarea도 동일함, value 속성값으로 전달)
    const [text, setText] = useState('');
    const textChange = (e) => {
        setText(e.target.value); //e.target = input태그 : 이벤트가 일어난 태그
    }

    //state test 3
    const [date, setDate] = useState('');
    const datePrint = (e) => {
        setDate(e.target.value);
        console.log (`date = ${e.target.value}`);
    }

    //state test 4
    const [option, setOption] = useState('');
    const jobChange = (e) => {
        setOption(e.target.value);
        console.log (`dreamJob = ${e.target.value}`);
    }



    // 컴포넌트의 Update 확인
    console.log (`컴포넌트의 Update`);

    return (
        <div className="body">
            <h1>** Love Test **</h1>
            <p>** 우리의 사랑은 몇 퍼센트?! **</p>

            <button onClick={onIncrease}>+💖</button>
            <span>Love💕 = {count2}%</span>
            <button onClick={onDecrease}>-💔</button>

            <div>
                <input value={text} onChange={textChange}/>
                <p>{text}</p>

                {/* 연습 => input Tag의 type date 활용해서 값이 변경될 때마다 그 값을 console 출력 */}
                <input type='date' value={date} onChange={datePrint}/>

                <select value={option} onChange={jobChange}>
                    <option key={"선택"}>선택</option>
                    <option key={"이재용 자녀"}>이재용 자녀</option>
                    <option key={"워런버핏 자녀"}>워런버핏 자녀</option>
                    <option key={"정용진 자녀"}>정용진 자녀</option>
                    <option key={"일론 머스크 자녀"}>일론 머스크 자녀</option>
                    <option key={"빌게이츠 자녀"}>빌게이츠 자녀</option>
                </select>

{/*                 01// => select
                // -> html 과 차이점
                //    selected 대신 value를 사용해 기본값 할당. (아래코드에서는 애플)
                //    선택된 option 값을 가져오려면, onChange를 사용해야하며,
                //    option 의 컨텐츠가 select 의 value 에 전달됨.
                const [option, setOption] = useState('애플');
                const jobChange = (e) => {
                console.log('** select : value='+e.target.value);
                // => select option 의 컨텐츠 값이 자동으로 value 속성에 전달됨.
                setOption(e.target.value);
                } */}
            </div>
        </div>
    );
}

export default Body;