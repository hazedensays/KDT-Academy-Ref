import React from "react";

/* const Viewer = (props) => {
    return(
        <div>
            <h2>🤑엄마, 내 용돈 얼마야?🤑</h2>
            <h3>{props.count}</h3>
        </div>
    );
} */

// => 객체 구조분해 적용
const Viewer = ({count}) => {

    // console.log ("** Viewer Update !! **");

    return(
        <div>
            <h2>🤑엄마, 내 용돈 얼마야?🤑</h2>
            <strong>🤦‍♀️ : <span>{count}</span>달러다 임마!!</strong>
        </div>
    );
}

export default Viewer;