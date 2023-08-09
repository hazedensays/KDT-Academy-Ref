// ** 검색기능 추가
// => 검색어처리 위한 state 변수 추가
// => input 엘리먼트에 속성추가
// => 검색어처리 위한 필터링 기능

// ** Array.prototype.filter()
// => filter() 메서드는 주어진 콜백함수의 테스트를 통과하는 모든 요소를 모아 새로운 배열로 반환.
// => arr.filter(callback(element[, index[, array]])[, thisArg])

// => callback 함수: 각 요소를 시험할 함수, true 반환하면 요소를 유지하고, false 반환하면 버림.
//    -> element : 처리할 현재 요소.
//    -> index 선택적 : 처리할 현재 요소의 인덱스.
//    -> array 선택적 : filter를 호출한 배열.
// => thisArg 선택적 : callback을 실행할 때 this 로 사용하는 값.
// => return(반환) 값
//    -> 테스트를 통과한 요소로 이루어진 새로운 배열
//    -> 어떤 요소도 테스트를 통과하지 못하면 빈 배열을 반환

import { useState } from "react";
import "../todoList.css";
import TodoItems from "./TodoItems";

const TodoList = ({todo, onUpdate, onDelete}) => {
    const[search, setSearch] = useState('');
    const onChangeSearch = (e) => {
        setSearch(e.target.value);
    }

// => 검색어처리 위한 필터링 기능
// => 필터링 완료가 된 배열을 map()으로 전달하도록 함
// => 검색어가 있으면 filter 적용, 대소문자 구별하지 않도록 함
//    (삼항식으로 구현)

const getSearchResult = () => {
    return (
        search === '' ? todo : todo.filter((it) => { return (it.content.toLowerCase().includes(search))})
    );
}

    return(
        <div className="todoList">
            <h4>📙 todoList is｡｡｡</h4>
            <input className="searchBar" placeholder="검색어를 입력하세요." value={search} onChange={onChangeSearch}/>
            <div className="list_wrapper">
                {/* 1. 배열 전달받기 전에 출력하기 위해 작성
                <TodoItems/>
                <TodoItems/>
                <TodoItems/> 
                */}

                {/* 2. 배열(todo) 전달 후 */}
                {/* {todo.map((it) => (<TodoItems key={it.id} {...it}/>))}      */}
                {/* {todo.map((it) => { return (<TodoItems key={it.id} {...it}/>)})}      */}
{/*             => key
                - 각각의 컴포넌트 구분을 위해 사용되며 반드시 지정해야 함 (경고메세지)
                - 일정 수정 삭제시 사용됨
                => 펼침(Spread)연산자로 객체형인 it을 TodoItems로 전달
                    {...it} -> {id:"", isDone:...} */}

                {/* 3. 배열(todo)에 filter() 적용 */}
                {/* => TodoItems로 전달하기 전, filter() 처리하고, 처리된 배열을 map()으로 전달 */}
                {getSearchResult().map((it) => {return (<TodoItems key={it.id} {...it}
                                                                   onUpdate={onUpdate}
                                                                   onDelete={onDelete}/>)})}
            </div>
        </div>
    );
};

export default TodoList;