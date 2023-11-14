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
                        <th>등록시간</th>
                        <th>조회수</th>      
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

}
