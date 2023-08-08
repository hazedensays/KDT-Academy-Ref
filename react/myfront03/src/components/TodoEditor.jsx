// ** 3.2) 입력 (Create)
// => new 일정(content) 을 담을 state 생성
// => new 일정 처리할  onChangeContent 이벤트 핸들러 작성
// => input 엘리먼트 속성 지정


import { useState, useRef } from "react";
import "../todoEditor.css";

const TodoEditor = ({onCreate}) => {

    const[content, setContent] = useState('');
    // => new 일정 처리할  onChangeContent 이벤트 핸들러 작성
    const onChangeContent = (e) => {
        setContent(e.target.value);
    };

    const inputRef = useRef();

// => new 일정을 onCreate(content) 함수를 이용해
//    부모의 state 변수인 배열 todo 에 저장 
    const onSubmit = (e) => {

    // ** 기능 업그레이드 1
    // => 입력값 무결성 확인
    //    content 값이 비어있으면 input 에 focus 가 머물게 하여
    //    빈 Data 입력방지 기능
        if (!content) {
            e.preventDefault();
            inputRef.current.focus();
            return;
        } else {
            onCreate(content); //부모로부터 전달받은 함수
        }

        setContent('');
    };

    // ** 기능 업그레이드 2
    // => input 에서 일정 입력 후 엔터키 눌렀을때에도 submit 이 가능하도록함
    const onkeydown = (e) => {
        if (e.key == 13) {
            onSubmit();
        }
    }


    return(
        <div className="todoEditor">
            <h4>📌 New todoList</h4>
            <div className="editor_wrapper">
                <input placeholder="새로운 todoList를 작성하세요." onKeyDown={onkeydown} ref={inputRef} value={content} onChange={onChangeContent}/>
                <button onClick={onSubmit}>add</button>
            </div>
        </div>
    );
};

export default TodoEditor;