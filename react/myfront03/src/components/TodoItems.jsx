import "../todoItems.css";

const TodoItems = () => {
    return(
        <div className="todoItems">
            <div>
                <input type="checkbox"/>
            </div>
            <div className="total_col">해야할 일(일정)</div>
            <div className="date_col">{new Date().toLocaleDateString()}</div>
            <div className="btn_col"><button>delete</button></div>
        </div>
    );
};

export default TodoItems;