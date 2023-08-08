import "../todoItems.css";

const TodoItems = ({id, isDone, content, createDate}) => {
    return(
        <div className="todoItems">
            <div>
                <input type="checkbox" checked={isDone}/>
            </div>
            <div className="title_col">{content}</div>
            <div className="date_col">{new Date(createDate).toLocaleDateString()}</div>
             {/* 타임스템프 형식을 Date 형식으로 변환하고, toLocaleDateString() 을 적용하여 문자열 로 랜더링 */}
            <div className="btn_col"><button>delete</button></div>
        </div>
    );
};

export default TodoItems;