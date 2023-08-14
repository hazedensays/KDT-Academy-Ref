import logo from './logo.svg';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;


/* import '../../../styles/customerService/InquiryProduct.css'
import Modal_cs1on1 from '../Modal_cs1on1';
import { useState } from 'react';

//모달을 노출하는 페이지
const InquiryProduct = () => {

    const [showPopup, setShowPopup] = useState(false);

    const openPopup = () => {
        setShowPopup(true);
    };

    return (
        <div>
            <section id="cs1on1_ask_id" className="cs1on1_ask">
                <h3><strong>상품 문의</strong></h3>
                <div className="btn_cs1on1">
                    <div className='openCS1on1' onClick={openPopup}><strong>1&#58;1 문의하기</strong></div>
                    {showPopup && <Modal_cs1on1 setShowPopup={setShowPopup} />}
                </div>
                <hr />
        
                <div>
                    <p>작성한 게시물이 없습니다.</p>
                </div>
            </section>
        </div>//최종div
    )
}; //InquiryProduct

export default InquiryProduct; */


/* import '../../styles/customerService/Modal_cs1on1.css';



//모달창 컴포넌트
const Modal_cs1on1 = ({setShowPopup}) => {

    //모달창 끄기 구현 ("취소" 버튼 onClick 이벤트 핸들러)
    const closeModal = () => {
        setShowPopup(false);
    };

    return (
        <div>
            {/* =====================팝업창 코드 - 1:1 문의========================= */}
            <div className="modal_cover modal_1">
                <div className="modal_cs1on1">
                    <div className="title_route">
                        <h2><strong>CUSTOMER SERVICE</strong></h2>
                        <ul>
                            <li>HOME</li>
                            <li>&nbsp;&gt;&nbsp;</li>
                            <li>CUSTOMER SERVICE</li>
                            <li>&nbsp;&gt;&nbsp;</li>
                            <li>1 &#58; 1 문의</li>
                        </ul>
                    </div>

                {/* ==========1:1 문의 입력 정보창=========== */}
                    <form className="subtitle_1on1" action="#">
                        <figure>
                            <figcaption><strong>1&#58;1 문의</strong></figcaption>

                            <p>
                            문의하신 사항은 성실하게 답변 드리겠습니다.
                            문의하기 전에 FAQ를 참고해주세요.
                            </p>

                            <table>
                                <tbody>
                                    <tr className="tr_custInfo">
                                        <th>
                                            회원정보
                                            <span className="spanRed">&#42;</span>
                                        </th>
                                        <td>
                                            <input type="text" maxLength="13" required/>
                                        </td>
                                    </tr>

                                    <tr className="tr_inquiry">
                                        <th>
                                            문의유형
                                            <span className="spanRed">&#42;</span>
                                        </th>
                                        <td>
                                            <select required>
                                                <option value="문의유형선택">문의 유형 선택</option>
                                                <option value="취소문의">취소문의</option>
                                                <option value="배송문의">배송문의</option>
                                                <option value="반품문의">반품문의</option>
                                                <option value="교환문의">교환문의</option>
                                                <option value="환불문의">환불문의</option>
                                                <option value="AS문의">AS문의</option>
                                                <option value="오류문의">오류문의</option>
                                            </select>

                                            <span>
                                                &#8903; 구매 전 상품문의는 상품페이지 하단 상품 Q&#38;A로 문의해주시기 바랍니다.
                                            </span>
                                        </td>
                                    </tr>

                                    <tr className="tr_replyAlert">
                                        <th>
                                            답변 알림
                                            <span className="spanRed">&#42;</span>
                                        </th>
                                        <td>
                                            <select required>
                                                <option value="선택">선택</option>
                                                <option value="010">010</option>
                                                <option value="011">011</option>
                                                <option value="016">016</option>
                                                <option value="017">017</option>
                                                <option value="018">018</option>
                                                <option value="070">070</option>
                                            </select>
                                            &ndash;&nbsp;<input type="text" maxLength="4" required/>
                                            &ndash;&nbsp;<input type="text" maxLength="4" required/>

                                            <div>
                                                <span>
                                                    &#8903; 답변이 등록되면 휴대폰 SMS로 알려드립니다.
                                                </span>

                                                <label htmlFor="answerYes">
                                                    <input type="radio" name="answer" id="answerYes" value="yes" checked required/>예
                                                </label>

                                                <label htmlFor="answerNo">
                                                    <input type="radio" name="answer" id="answerNo" value="no" required/>아니오
                                                </label>
                                            </div>
                                        </td>
                                    </tr>

                                    <tr className="tr_inqTitle">
                                        <th>
                                            제목
                                            <span className="spanRed">&#42;</span>
                                        </th>
                                        <td>
                                            <input type="text" maxLength="13" required/>
                                        </td>
                                    </tr>

                                    <tr className="tr_inqContent">
                                        <th>
                                            문의 내용
                                            <span className="spanRed">&#42;</span>
                                        </th>
                                        <td>
                                            <div>
                                                <textarea name="inqContent" cols="120" rows="30" minLength={20} maxLength="500" placeholder="20자 이상 작성하세요. (최대 500자)"></textarea>
                                            </div>
                                        </td>
                                    </tr>

                                    <tr className="tr_fileRef">
                                        <th>
                                            파일첨부
                                        </th>
                                        <td>
                                            {/* input에 type="file" 추가하기 (추가했을 때 오류떴었음) */}
                                            <input name="btn_fileRef" id="btn_fileRef" value="파일선택" multiple/>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </figure>

                        <div className="privacy_Agree">
                            <input type="radio" required/>
                            개인정보 수집 및 이용에 대한 동의 &#40;필수&#41;
                        </div>

                        <div className="btn_submit">
                            <button onClick={closeModal}>취소</button>
                            <button>등록</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>//최종div
    );
};

export default Modal_cs1on1; */