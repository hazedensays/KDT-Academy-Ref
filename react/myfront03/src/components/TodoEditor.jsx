import "../todoEditor.css";

const TodoEditor = () => {
    return(
        <div className="todoEditor">
            <h4>📌 New todoList</h4>
            <div className="editor_wrapper">
                <input placeholder="새로운 todoList를 작성하세요." />
                <button>추가</button>
            </div>
        </div>
    );
};

export default TodoEditor;