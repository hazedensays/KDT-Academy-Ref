"use Strict"

// 1) joinForm 요청
// => Request : jQuery Ajax, MemberController의 memberJoin 활용
// => Response : Page
// => window.jQuery 객체 -> 줄여서 window 생략하고 $ 기호로 표현

function rsJoinf() {
	let url = "/member/memberJoin";
	$.ajax({
		type: 'Get',
		url: url,
		success: function(resultPage) {
			// success 익명함수 인자값
			// 서버에서 Page를 전송하면 Page를 받고,
			// 서버에서 Data를 전송하면 Data를 받음.
			document.getElementById('resultArea1').innerHTML = resultPage;
		},
		error: function() {
			document.getElementById('resultArea1').innerHTML = "Ajax Error";
		}
	});

}//rsJoinf

// 2) join Service 요청   
// => form의 Data 처리방법
//   - 직접 입력 : uploadfilef 를 처리할 수 없음 
//   - Form 의 serialize()
//       -> input Tag 의 name 과 id 가 같아야 함.   
//       -> 직렬화 : multipart 타입은 전송안됨. 
//           처리하지 못하는 값(예-> file Type) 은 스스로 제외시킴 
//   - 객체화 : uploadfilef를 처리할 수 없음
//   - FormData 객체 활용
//     -> append 메서드 : uploadfilef 처리 불편 
//     -> 생성자 매개변수 이용 : uploadfilef 포함 간편한 처리 가능

function rsJoin() {
	// 1) Data 준비
	// => JS의 내장객체 FormData에 담아서 전송

	let formData = new FormData(document.getElementById("myform"));

	// 2) ajax 요청
	$.ajax({
		type: "Post",
		url: "/rest/rsjoin",
		data: formData,
		processData: false,
		contentType: false,

		success: (resultData) => {
			// => 결과는 Text로 받음
			document.getElementById('resultArea1').innerHTML = resultData;
		},
		error: () => {
			document.getElementById('resultArea2').innerHTML = "[Ajax error]";
		}

	}); //ajax

} //rsJoin


// ** Axios File Upload 포함 Join Test =============================
function axiJoin() {
	// 1) Data 준비
	// => JS의 내장객체 FormData에 담아서 전송
	let formData = new FormData(document.getElementById("myform"));


	// 2) axios 요청
	let url = "/rest/rsjoin";

	axios.post(url, formData, {
		headers: {"Content- Type" : "multipart / form - data"}
	}).then(response => {
			alert(`** response.data : ${response.data}`);
			location.reload();
		}).catch(err => {
			if (err.response.status == "502") {
				alert("[입력오류] 다시 시도하세요.");
			} else {
				alert("[시스템 오류] 잠시 후에 다시 시도하세요." + err.message);
			}
		});

	document.getElementById("resultArea2").innerHTML = "";
}//axiJoin()

// => 2. get =============================
// => 웹 Page (memberList) 요청 -> MemberController
function axiMList() {
	let url = "/member/axMemberList";
	axios.get(url
	).then(response => {
		alert("** Response 성공 **");
		document.getElementById("resultArea1").innerHTML = response.data;
	}).catch(err => {
		alert(`** Response 실패 => ` + err.message);
	});

	document.getElementById("resultArea2").innerHTML = "";
}//axiMList()

// => delete =============================
// => delete 요청 : 경로에 Request_Data를 연결
//    /rest/axidelete/banana

function axiDelete(id) {
	let url = "/rest/axidelete/" + id;
	axios.delete(url).then(response => {
		alert("** 삭제 성공 => " + response.data);

		// ** 삭제 성공후
		// => Delete -> Deleted, Gray_color, Bold 로
		// => onclick 이벤트 제거
		// => Style 제거 (removeclass, textlink)
		
		document.getElementById(id).innerHTML = "Deleted";
		document.getElementById(id).style.color = "Gray";
		document.getElementById(id).style.fontWeight = "bold";
		document.getElementById(id).classList.remove("textlink");
		document.getElementById(id).removeAttribute("onclick");

	}).catch(err => {
		if (err.response.status == "502") {
			alert(err.response.data);
		} else {
			alert("** 삭제 실패 => " + err.message);
		}
	});

}//axiDelete(id)






