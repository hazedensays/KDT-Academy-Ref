import {Routes,Route,NavLink} from "react-router-dom";

// ** Nested Routing
// 1) 자식 page 1,2,3 추가 ( Topics01 ) 
// => App.js의 라우트 path "/topics/*" 로 수정

// 2) 배열로 목록 정의 ( Topics )
// 3) Topic 컴포넌트 추가

// ** useParams()
// => 현재 URL에 포함되어 있는 key, value 형식의 객체를 반환
//   예) path /test/3 으로 이동한 경우 params의 값 {id:'3'}을 확인할 수 있고
//      path /test/something 으로 이동한 경우 params의 값 {id:'something'} 확인가능
// => "/user/:id" 라는 라우트가 있다면 useParams 로 :id 파라미터를 가져올 수 있음
// 2) 배열로 목록 정의
const contents = [
    {id:1, title:'HTML', description:'HTML 은 재미있다...'},
    {id:2, title:'JavaScript', description:'JavaScript 는 더 재미있다...'},
    {id:3, title:'React', description:'React 는 흥미롭다...'}
  ]
function Topics(){
    
    return(
        <div className="Topics">
            <h2>Topics</h2>
            <ul>
                {/* <li><NavLink to="/topics/1">일식</NavLink></li>
                <li><NavLink to="/topics/2">중식</NavLink></li>
                <li><NavLink to="/topics/3">한식</NavLink></li> */}
                {contents.map((it)=><li key={it.id}><NavLink to="/topics/{it.id}">{it.title}</NavLink></li>)}
            </ul>

            <Routes>
                {/* <Route path="/1" element={"일식은 초밥이지🍣"}/>
                <Route path="/2" element={"중식은 짜장면이지🍜"}/>
                <Route path="/3" element={"한식은 삼겹살이지🥓"}/> */}
                <Route path="/:topic_id" element={<Topic/>}/>
            </Routes>
        </div>
    );
}

export default Topics;