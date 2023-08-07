import "../todoList.css";
import TodoItems from "./TodoItems";

const TodoList = () => {
    return(
        <div className="todoList">
            <h4>📙 todoList is｡｡｡</h4>
            <input className="searchBar" placeholder="검색어를 입력하세요."/>
            <div className="list_wrapper">
                <TodoItems/>
                <TodoItems/>
                <TodoItems/>
            </div>
        </div>
    );
};

export default TodoList;