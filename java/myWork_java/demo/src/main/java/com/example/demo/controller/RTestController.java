package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.JoDTO;
import com.example.demo.domain.UserDTO;
import com.example.demo.service.JoService;
import com.example.demo.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

//** JSON 제이슨, (JavaScript Object Notation) **
//=> 자바스크립트의 객체표기법으로, 데이터를 전달할때 사용하는 표준형식.
//  속성(key) 과 값(value) 이 하나의 쌍을 이룸

//** JAVA의 Data 객체 -> JSON 변환하기
//** 참고용어 
//=> 마샬링(Marshalling)
// - 메모리상에 형상화된 객체 데이터를 다른 데이터 형태로 변환하는 과정을 말함.
// - JAVA 객체를 JSON 포맷으로 변환하는것
//=> 언마샬링(UnMarshalling)
// - 변환된 데이터를 다시 원래의 객체 모양으로 복원하는 작업
// - JSON 포맷을 JAVA 객체로 변환하는것
//=> 직렬화(Serialization)
// - 객체 데이터를 일련의 byte stream으로 변환하는 작업
// - 반대로 일련의 byte stream을 본래 객체 모양으로 복원하는 작업은 역직렬화(Deserialization) 
// - 직렬화와 마샬링은 거의 같은개념이지만, 직렬화 작업이 프로그래밍적으로 보다더 전문화 된것이 마샬링.
//( 즉, 직렬화는 마샬링이 포함된 폭넓은 개념 )

//1) GSON
// : 자바 객체의 직렬화/역직렬화를 도와주는 라이브러리 (구글에서 만듦)
// 즉, JAVA객체 -> JSON 또는 JSON -> JAVA객체

//2) @ResponseBody (매핑 메서드에 적용)
// : 메서드의 리턴값이 View 를 통해 출력되지 않고 HTTP Response Body 에 직접 쓰여지게 됨.
// 이때 쓰여지기전, 리턴되는 데이터 타입에 따라 종류별 MessageConverter에서 변환이 이뤄진다.
// MappingJacksonHttpMessageConverter 를 사용하면 request, response 를 JSON 으로 변환
// view (~.jsp) 가 아닌 Data 자체를 전달하기위한 용도
// @JsonIgnore : VO 에 적용하면 변환에서 제외

//3) jsonView
//=> Spring 에서 MappingJackson2JsonView를 사용해서
//  ModelAndView를 json 형식으로 반환해 준다.
//=> 방법
// -> pom dependency추가
// -> 설정화일 xml 에 bean 등록 
// ( 안하면 /WEB-INF/views/jsonView.jsp 를 찾게되고  없으니 404 발생 )
// -> return할 ModelAndView 생성시 View_Name을 "jsonView"로 설정
// =======================================================================  

@RestController
@RequestMapping("/rest")
@Log4j2
@AllArgsConstructor
public class RTestController {
	MemberService service;
	JoService jservice;
	PasswordEncoder passwordEncoder;

	@GetMapping("/hello")
	// => test : 메뉴없이 직접 요청
	// : http://localhost:8080/rest/hello
	public String hello() {
		return "<h1>Hello! SpringBoot Rest API Test.</h1>";
	}

	// ** RestController 의 다양한 Return Type
	// 1) Text Return
	// => http://localhost:8080/rest/gettext
	// @GetMapping(value="/gettext", produces = "text/plain; charset=UTF-8")
	@GetMapping(value = "/gettext")
	// => produces 속성
	// - 해당 메서드 결과물의 MIME Type을 의미 ( UI Content-Type 에 표시됨 )
	// - 위처럼 문자열로 직접 지정할 수도 있고, 메서드 내의 MediaType 클래스를 이용할 수도 있음
	// - 필수 속성은 아님 (기본값은 text/html, 그러므로 적용하지 않은 경우 아래 <h1></h1> 적용 됨)
	public String getText() {
		log.info("** MIME Type, MediaType 클래스 적용 => " + MediaType.TEXT_PLAIN_VALUE);
		return "<h1>Rest API Test) 찬미 자리<br> 다 털렸네...</h1>";
	}

	// ** 객체 주의사항
	// => Java 의 객체를 UI 가 인식가능한 형태의 객체로 변환후 전송
	// => xml 또는 JSON 포맷
	// => 즉, Java <-> JSON 변환을 지원하는 API 필요함
	// 여기부터는 pom 에 dependency 추가 해야함

	// 2) 사용자 정의 객체
	// 2.1) 객체 Return1. : produces 지정한 경우
	@GetMapping(value = "/getdto1")
//			produces = { MediaType.APPLICATION_JSON_VALUE, 
//						 MediaType.APPLICATION_XML_VALUE })
	
	// => produces
	// - JSON 과 XML 방식의 데이터를 생성할 수 있도록 설정
	// - Response Data Type을 제한 함으로 오류를 줄임
	// - 입력값을 제한할때는 "consumes" 속성 사용
	// => 요청 url의 확장자에 따라 다른 타입으로 서비스
	// - Test1) 브라우져에서 /rest/getdto1 호출 -> 위 둘중 XML 전송(default)
	// - Test2) 브라우져에서 /rest/getdto1.json 호출 -> JSON 전송
	public UserDTO getDTO1() {
		return new UserDTO("mytoken", "banana", "홍길동", "banana@green.com", "12345!");
	}

	// 2.2) 객체 Return2. : produces 지정하지 않은 경우
	@GetMapping("getdto2")
	public UserDTO getDTO2() {
		return new UserDTO("mytoken222", "banana", "홍길동", "banana@green.com", "12345!");
	}
	
	
	// 3) Collection Return
	// 3.1) Map
	@GetMapping("/getmap")
	public Map<String, UserDTO> getMap() {
		Map<String, UserDTO> map = new HashMap<String, UserDTO>();
	
		map.put("one", new UserDTO("mytoken111", "banana", "홍길동", "banana@green.com", "12345!"));
		map.put("two", new UserDTO("mytoken222", "banana", "홍길동", "banana@green.com", "12345!"));
		map.put("three", new UserDTO("mytoken333", "banana", "홍길동", "banana@green.com", "12345!"));
		map.put("four", new UserDTO("mytoken444", "banana", "홍길동", "banana@green.com", "12345!"));
		
		return map;
	}
	

	// 3.2) List
	@GetMapping("/getlist")
	public List<JoDTO> getlist() {
		return jservice.selectList();
	}

	// ** ResponseEntity

    // ** params 속성
    // => 값에 상관없이 파라미터에 params 속성으로 정의한 "jno", "id"가 반드시 있어야 호출됨 
    //    만약 하나라도 전달받지 못하면 "400–잘못된 요청" 오류 발생
    // => Parameter name과 매개변수는 이름으로 매핑함. (즉, 같아야 함)
	
	// 4) ResponseEntity Test
	// => 실습
    //     전달된 jno값의 조건에 의하여 502(BAD_GATEWAY) 또는 200(OK) 상태코드와 데이터를 함께 전송하므로 
    //    요청 User가 이 응답결과(body값)의 정상/비정상 여부를 알수있도록 해준다
    // => 200 Test: http://localhost:8088/rest/incheck?jno=11&id=banana
    //            http://localhost:8088/rest/incheck.json?jno=11&id=banana
    // => 502 Test: http://localhost:8088/rest/incheck?jno=5&id=banana
	@GetMapping(value = "/incheck", params= {"jno", "id"})
	public ResponseEntity<JoDTO> incheck(int jno, String id) {
		// 1) 준비
		ResponseEntity<JoDTO> result = null;
		JoDTO dto = new JoDTO(1, "119", "bae87", "배정현", "펫밀리", "애완동물을 위한 홈페이지");
		
		// 2) Service 처리
		// => jno의 값이 11~20에 속하면 성공/ 아니면 오류
		if (jno > 10 && jno < 21) {
			result = ResponseEntity.status(HttpStatus.OK).body(dto);
		} else {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(dto);
		}
		return result;
	}

	// 5) @PathVariable

	// 6) @RequestBody

	// ** Ajax : 비동기 통신

}
