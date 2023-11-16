// ** Ajax_REST API Test **

// 1) rsLogin
// => form 출력
function rsLoginf() {
   let resultHtml =
      `<table border=1 align=center width=80%>
          <caption><h3>** Ajax Login  **<h3></caption>
          <tr height="40"><td bgcolor="salmon"><label for="id">ID</label></td>
             <td><input type="text" id="id" name="id"></td>
          </tr>
          <tr height="40"><td bgcolor="salmon"><label for="password">Password</label></td>
             <td><input type="password" id="password" name="password"></td>
          </tr>
          <tr height="40"><td></td>
             <td>
                   <button style="cursor:pointer;" class="textlink" onclick="rsLogin()">rsLogin</button>&nbsp;&nbsp;
                   <button style="cursor:pointer;" class="textlink" onclick="rsLoginJJ()">rsLoginJJ</button>&nbsp;&nbsp;
                   <button style="cursor:pointer;" class="textlink" onclick="axiLoginJJ()">axiLoginJJ</button>&nbsp;&nbsp;
                   <input type="reset" value="취소">
             </td>
          </tr>
        </table>
        `;
   document.getElementById("resultArea1").innerHTML = resultHtml;


}

// => login기능 Service 요청처리
//    Ajax 요청

function rsLogin() {
   let url="/rest/rslogin";

   fetch(url, {
      method: 'Post', body: JSON.stringify({
         id: document.getElementById('id').value,
         password:  document.getElementById('password').value,
      }),
      headers: { 'Content-Type': 'application/json' }
      // => POST 요청에서는 반드시 headers 형식 작성 
      //    (JSON 포맷을 사용함을 알려줘야함)
   }).then(response => {
      // ** then 1 단계
      // => status 확인 -> Error catch 블럭으로 또는 Response Body-reading Data return
      // => Response Body의 Data-reading & return

      if (!response.ok) throw new Error(response.status);
      // => Error 임을 인지시켜 catch 블럭으로 
      //   - fetch는 네트워크 장애가 발생한 경우에만 promise를 거부(reject -> catch 블럭으로) 하므로,
      //     .then절(1단계) 에서 수동으로 HTTP 에러를 처리함.
      //     그러나 axios는 상태코드가 2xx의 범위를 넘어가면 거부(reject)함.

      return response.text();
      // => 서버에서 Text형식으로 보냈으므로 text() 메서드 사용
      //    (Type별로 Data Reading method를 적용함)
   }).then(responseData => {
      // ** then 2 단계
      // => 1단계에서 return 한 Data 처리
      alert(`** responseData => ${responseData}`);
      location.reload();
      // => reload() 호출 구문 이전에 작성한 console message는 출력 안되므로 alert 사용함. 
   }).catch(err => {
      console.error(`** Error => ${err.message}`);
      if (err.message == '502') alert('id 또는 password 오류입니다. 다시 시도하세요.');
      else alert('시스템 오류, 잠시 후 다시 시도하세요.');
   });
}

// 1.3) rsLoginJJ
// => JSON -> JSON (성공시 id, name을 JSON으로 전송)
function rsLoginJJ() {
   let url = "/rest/rsloginjj";

   fetch(url, {
      method: 'Post', body: JSON.stringify({
         id: document.getElementById('id').value,
         password: document.getElementById('password').value,
      }),
      headers: { 'Content-Type': 'application/json' }
   }).then(response => {
      if (!response.ok) throw new Error(response.status);
      return response.json();
      // => 서버에서 JSON 형식으로 보냈으므로 json() 메서드 사용
      //    UserDTO를 사용했으므로 사용 시 멤버 변수명 주의(id, username..)
   }).then(responseData => {
      alert(`** responseData => id=${responseData.id}, name=${responseData.username}`);
      location.reload();
   }).catch(err => {
      console.error(`** Error => ${err.message}`);
      if (err.message == '502') alert('id 또는 password 오류입니다. 다시 시도하세요.');
      else alert('시스템 오류, 잠시 후 다시 시도하세요.');
   });
}

// 2. Axios Login
// => 라이브러리 추가(cdn으로..axTest01.js 에)
// =>  서버요청은 위 "1.3) rsloginJJ"와 동일하게 rsloginJJ
// => JSOn -> JSON
function axiLoginJJ() {
   let url = "/rest/rsloginjj";

   axios({
      url: url,
      method: 'Post',
      headers: { 'Content-Type': 'application/json'  },
      data: {
         id: document.getElementById('id').value,
         password: document.getElementById('password').value,
      }
   }).then(response => {
      alert(`** response.data : ${response.data}`);
      alert(`** response: id=${response.data.id}, name=${response.data.username}`);
      location.reload();
   }).catch(err => {
      console.error(`** err.response=${err.response},
                    err.response.status=${err.response.status},
                    err.message=${err.message}`);
      if(err.message.status=='502') alert("~~ id 또는 password 오류!! 다시하세요 ~~");
      else alert("~~ 시스템 오류, 잠시 후 다시하세요 => " + err.response);
   });
}