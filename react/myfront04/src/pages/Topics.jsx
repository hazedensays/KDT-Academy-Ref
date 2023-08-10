import { NavLink, Route, Routes } from "react-router-dom";

function Topics() {
    return (
        <div>
            <ul>
                <li><NavLink to="/topics/1">HTML</NavLink></li>
                <li><NavLink to="/topics/2">JS</NavLink></li>
                <li><NavLink to="/topics/3">React</NavLink></li>
            </ul>

            <Routes>
                <Route path="/1" element={"HTML은 아무 쓸모 없었다."}/>
                <Route path="/2" element={"JS는 예외가 너무 많다."}/>
                <Route path="/3" element={"React를 내가 할 수 있을까?"}/>
            </Routes>
        </div>
    );
}

export default Topics;