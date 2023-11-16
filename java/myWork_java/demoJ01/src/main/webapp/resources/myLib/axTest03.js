"use strict"

// Ajax_REST API, Axios Test
// 1. axMemberList 의 id 를 클릭하면 본인이 등록한 글 목록을  resultArea2 에 출력
// => get요청, @PathVariable 사용, response는 JSON
// => 성공 : JSON 객체로 전달된 List 출력문 JS로 만들기
// => 실패 : 오류 메세지 출력
// => 서버
//   - RTestController, SQL구문은 ~Mapper 인터페이스 @ 으로 작성
//   - @PathVariable 사용, respinse는 JSON

function idbList(id) {

	let url = "/rest/idblist/" + id;

	axios.get(url
	).then(response => {
		alert("** List 성공 **");

		let list = response.data;
		for (let b of list) {
			console.log(b);
		}

		let resultHtml = `<table border="1" style="width:100%">
                     <tr bgcolor="skyblue">
                        <th>Seq</th>
                        <th>Title</th>
                        <th>ID</th>
                        <th>Regdate</th>
                        <th>Count</th>      
                     </tr>`;

		for (let b of list) {
			resultHtml += `
            <tr>
               <td>${b.seq}</td>
               <td>${b.title}</td>
               <td>${b.id}</th>
               <td>${b.regdate}</td>
               <td>${b.cnt}</td>      
            </tr>`;

		}

		resultHtml += "</table>";

		document.getElementById("resultArea2").innerHTML = resultHtml;

		// => Object -> JSON형태로 DATA를 나열해줌( 즉, 문자 Type이 됨)
		// => fetch에서 Post 요청 시 서버로 전송하는 Data를 JSON 포맷화 할 때 사용,
		//    또는 console.log로 response.data의 내용을 확인 할 때 사용 
		let list2 = JSON.stringify(response.data); //Object -> JSON 형태로 Data를 나열해줌


	}).catch(err => {
		if (err.response.status == '502') alert(err.response.data);
		else alert("시스템 오류 " + err.message);
	})

}//idbList()

// JoDetail
// 1) showJoDetail(${m.jno})
// => jno 에 onmouseover : jno 의 detail 을 div(content) 에 출력
// => Request : axios, get, RTestController 에 jodetail 요청
// => Response : JoDTO 객체

function showJoDetail(e,jno) {
	// ** 이벤트객체 활용
	// => 마우스포인터 위치 확인          
	//     - event객체 (이벤트핸들러 첫번째 매개변수) 가 제공
	//    - e.pageX, e.pageY : 전체 Page 기준
	//     - e.clientX, e.clientY : 보여지는 화면 기준-> page Scroll 시에 불편함

	console.log(`** e.pageX = ${e.pageX}, e.pageY = ${e.pageY}`);
	console.log(`** e.clientX = ${e.clientX}, e.clientY = ${e.clientY}`);

	let url = "/rest/jodetail?jno=" + jno;
	let mleft = e.pageX;
	let mtop = e.pageY;
	
	document.getElementById('content').style.left = mleft+"px";
	document.getElementById('content').style.top = mtop+"px";

	axios.get(url
	).then(response => {
		console.log("** response 성공 => " + response.data);
		let jo = response.data;
		console.log("** Data: jo.jno => " + jo.jno);
		let resultHtml = `
      <table>
         <tr height="20"><td>Jno</td><td>${jo.jno}</td></tr>
         <tr height="20"><td>JoName</td><td>${jo.jname}</td></tr>
         <tr height="20"><td>CaptainID</td><td>${jo.id}</td></tr>
         <tr height="20"><td>Project</td><td>${jo.project}</td></tr>
         <tr height="20"><td>Slogan</td><td>${jo.slogan}</td></tr>
      </table>`;
		document.getElementById('content').innerHTML = resultHtml;
		document.getElementById('content').style.display = 'block';

	}).catch(err => {
		if (err.response.status == '502') alert(err.response.data);
		else alert("~~ 시스템 오류, 잠시후 다시하세요 => " + err.message);
	});
} //showJoDetail

// 2.2.2) MouseOut: hideJoDetail
// => 화면에 표시되어있는 content div 가 사라짐. 

function hideJoDetail() {
	document.getElementById('content').style.display = 'none';
} //hideJoDetail()














