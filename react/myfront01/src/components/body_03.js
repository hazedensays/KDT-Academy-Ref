import './body.css';
import {useState} from "react";

function Body() {
/*     // ** State Test1 : 개별적으로 관리 **
    const [name, setName] = useState('');
    const [gender, setGender] = useState('');
    const [birth, setBirth] = useState('');
    const [info, setInfo] = useState('');

    const onChangeName = (e) => {setName(e.target.value)};
    const onChangeGender = (e) => {setGender(e.target.value)};
    const onChangeBirth = (e) => {setBirth(e.target.value)};
    const onChangeInfo = (e) => {setInfo(e.target.value)};
    
    //컴포넌트의 업데이트 확인
    console.log ("** 컴포넌트의 Update **");

    return (
        <div className="body">
            <h1>** Body State Test1 : 개별적으로 관리 **</h1>
            
            <div>
                <input value={name} onChange={onChangeName} placeholder='이름 입력'/>
            </div>

            <select value={gender} onChange={onChangeGender}>
                <option key={"선택"}>선택</option>
                <option key={"boy"}>boy</option>
                <option key={"girl"}>girl</option>
            </select>

            <div>
                <textarea value={info} onChange={onChangeInfo}></textarea>
            </div>

            <div>
                <input type="date" value={birth} onChange={onChangeBirth} />
            </div>
        </div>
    ); */

    // ** State Test2 : input Tag를 객체화해서 하나의 State로 관리 **
    //                  => 코드가 간결해지고 효율적이게 됨
    //                  => 수정사항
    //                     - State 객체 생성, 이벤트핸들러 1개로 통일
    //                     - 엘리먼트들의 value 속성값,name 속성 추가, 이벤트핸들러


    const [state, setState] = useState ({
        name: '', gender: '', birth: '', info: ''
    });

    const onChangeState = (e) => {
        console.log (`수정 대상 : ${e.target.name}`);
        console.log (`수정 값 : ${e.target.value}`);

        setState({

        });
    }

    // => setState에 새로운 객체 전달
    //    스프레드로 기존객체 stat 값 나열
    //    객체 괄호표기법으로 name 속성을 key로 e.target.value 를 value 로 저장
    //    (객체 괄호표기법: 속성명을 괄호('[]')로 감싸서 표현

    //컴포넌트의 업데이트 확인
    console.log ("** 컴포넌트의 Update **");

    return (
        <div className="body">
            <h1>** Body State Test1 : 개별적으로 관리 **</h1>
            
            <div>
                <input name='name' value={state.name} onChange={onChangeState} placeholder='이름 입력'/>
            </div>

            <select name='gender' value={state.gender} onChange={onChangeState}>
                <option key={"선택"}>선택</option>
                <option key={"boy"}>boy</option>
                <option key={"girl"}>girl</option>
            </select>

            <div>
                <textarea name='info' value={state.info} onChange={onChangeState}></textarea>
            </div>

            <div>
                <input name='date' type="date" value={state.birth} onChange={onChangeState} />
            </div>
        </div>
    );
}

export default Body;