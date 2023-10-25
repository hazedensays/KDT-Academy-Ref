package com.green.best;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import domain.MemberDTO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import service.MemberService;


//** Spring 의 redirect ===================================================================

//** RedirectAttributes
//=> Redirect 할 때 파라메터를 쉽게 전달할 수 있도록 지원하며,
// addAttribute, addFlashAttribute, getFlashAttribute 등의 메서드가 제공됨.
//=> addAttribute
// - url에 퀴리스트링으로 파라메터가 붙어 전달됨. 
//  - 그렇기 때문에 전달된 페이지에서 파라메터가 노출됨.

//=> addFlashAttribute
// - Redirect 동작이 수행되기 전에 Session에 값이 저장되고 전달 후 소멸된다.
//  - Session을 선언해서 집어넣고 사용 후 지워주는 수고를 덜어주고,
//    -> url에 퀴리스트링으로 붙지 않기때문에 깨끗하고 f5(새로고침)에 영향을 주지않음.  
//    -> 주의사항 
//       받는쪽 매핑메서드의 매개변수로 parameter를 전달받는 VO가 정의되어 있으면
//         이 VO 생성과 관련된 500 발생 하므로 주의한다.
//      ( Test : JoController 의 jupdate 성공시 redirect:jdetail )
//      단, VO로 받지 않는 경우에는 url에 붙여 전달하면서 addFlashAttribute 사용가능함        

//=> getFlashAttribute
//    - insert 성공 후 redirect:jlist 에서 Test (JoController, 결과는 null)
//    - 컨트롤러에서 addFlashAttribute 가 session에 보관한 값을 꺼내는것은 좀더 확인이 필요함 

//** redirect 로 한글 parameter 전달시 한글깨짐
//=> 한글깨짐이 발생하는경우 사용함.
//=> url 파라메터 로 전달되는 한글값 을 위한 encoding
//    - String message = URLEncoder.encode("~~ member 가 없네용 ~~", "UTF-8");
//      mv.setViewName("redirect:mlist?message="+message);

//======================================================================================

//** Model & ModelAndView **

//=> Model(interface)
//-> controller처리 후 데이터(Model) 을 담아서 반환 
//-> 구현클래스 : ConcurrentModel, ExtendedModelMap 등.
//-> 아래 home 메서드 처럼, ModelAndView 보다 심플한 코드작성 가능하므로 많이사용됨. 
//mv.setViewName("~~~~~") 하지않고 viewName 을 return 

//=> ModelAndView (class)
//-> controller처리 후 데이터(Model) 와 viewName 을 담아서 반환
//-> Object -> ModelAndView

//======================================================================================

//** @RequestMapping
//=> DefaultAnnotationHandlerMapping에서 컨트롤러를 선택할 때 대표적으로 사용하는 애노테이션. 
//=> DefaultAnnotationHandlerMapping은 클래스와 메서드에 붙은 @RequestMapping 애노테이션 정보를 결합해 최종 매핑정보를 생성한다.
//=> 기본적인 결합 방법은 클래스 레벨의 @RequestMapping을 기준으로 삼고, 
//  메서드 레벨의 @RequestMapping으로 세분화하는 방식으로 사용된다.

//** @RequestMapping 특징
//=> url당 하나의 컨트롤러에 매핑되던 다른 핸들러 매핑과 달리 메서드 단위까지 세분화하여 적용할 수 있으며,
//url 뿐 아니라 파라미터, 헤더 등 더욱 넓은 범위를 적용할 수 있다. 
//=> 요청과 매핑메서드 1:1 mapping 
//=> value="/mlist" 
// : 이때 호출되는 메서드명과 동일하면 value 생략가능 그러나 value 생략시 404 (확인필요함)
//: 해당 메서드 내에서 mv.setViewName("...."); 을 생략 
//  또는 아래의 메서드를 사용하는 경우에는 void 로 작성 (view 를 return 하지않음) 하는 경우
//  요청명을 viewName 으로 인식 즉, mv.setViewName("mlist") 으로 처리함.

//** @RequestMapping 속성
//=> value : URL 패턴 ( 와일드카드 * 사용 가능 )
//  @RequestMapping(value="/post")
//  @RequestMapping(value="/post.*")
//  @RequestMapping(value="/post/**/comment")
//  @RequestMapping(value={"/post", "/P"}) : 다중매핑 가능

//=> method 
// @RequestMapping(value="/post", method=RequestMethod.GET)
// -> url이 /post인 요청 중 GET 메서드인 경우 호출됨
// @RequestMapping(value="/post", method=RequestMethod.POST)
// -> url이 /post인 요청 중 POST 메서드인 경우 호출됨
//    GET, POST, PUT, DELETE, OPTIONS, TRACE 총 7개의 HTTP 메서드가 정의되어 있음.
//    ( 이들은 아래 @GetMapping ... 등으로도 좀더 간편하게 사용가능
//    그러나 이들은 메서드 레벨에만 적용가능    )  

//=> params : 요청 파라미터와 값으로도 구분 가능함.
// @RequestMapping(value="/post", params="useYn=Y")
// -> /post?useYn=Y 일 경우 호출됨
// @RequestMapping(value="/post", params="useYn!=Y")
// ->  not equal도 가능
// @RequestMapping(value="/post", parmas="useYn")
// > 값에 상관없이 파라미터에 useYn이 있을 경우 호출됨
// @RequestMapping(value="/post", params="!useYn")
// > 파라미터에 useYn이 없어야 호출됨

//======================================================================================

//** Lombok 지원 로그메시지  
//=> @Log4j Test
// -> dependency 필요함 (pom.xml 확인)
// -> 로깅레벨 단계 준수함 ( log4j.xml 의 아래 logger Tag 의 level 확인)
//    TRACE > DEBUG > INFO > WARN > ERROR > FATAL(치명적인)
//    <logger name="com.ncs.green">
//        <level value="info" />
//    </logger>   

// -> Logger 사용과의 차이점 : "{}" 지원안됨, 호출명 log

//======================================================================================

@Log4j
@AllArgsConstructor
@RequestMapping(value = "/member") // "/member"로 시작하는 모든 요청을 처리
// => 하나의 클래스 안에 메서드 단위로 컨트롤러를 여러 개 만들 수 있음
@Controller
public class MemberController {

	// @Autowired
	// => service 인스턴스를 초기화
	//    MemberService service = new MemberService();
	//    String name = "홍길동";
	// => 모든 값을 초기화하는 생성자인 @AllArgsConstructor를 사용하면
	//    @Autowired를 사용하지 않아도 됨
	// => 차이점
	//    : @AllArgsConstructor : 클래스에 1개만 적용하면 됨 (1:N)
	//    : @Autowired : 멤버들마다 모두 적용해야 함 (1:1)
	MemberService service;
	
	// ** Lombok의 Log4j Test
	@GetMapping(value = "/log4jTest")
	public String log4jTest() {
		String name = "원숭이바나나맛있어";
		log.error(" Log Level Error of Lombok : name = " + name);
		log.warn(" Log Level Warn of Lombok : name = " + name);
		log.info(" Log Level Info of Lombok : name = " + name);
		log.debug(" Log Level Debug of Lombok : name = " + name);
		log.trace(" Log Level Trace of Lombok : name = " + name);
		
		return "redirect:/";
	}

	// ** MemberList
//	@RequestMapping(value = "/mlist", method = RequestMethod.GET)
//	public String mlist(Model model) {
//		model.addAttribute("mList", service.selectList());
//		return "member/memberList";
//	}
	
//  => 계층적 url 적용
//	   : home에서의 요청명은 "member/memberList"
//	   : viewName 생략 시, 요청명을 viewName으로 처리
//	   -> @RequestMapping 대신 @GetMapping 사용 가능	
	@GetMapping(value = "/memberList")
	public void mlist(Model model) {
		model.addAttribute("mList", service.selectList());
	}

	// ** MemberDetail
	//@RequestMapping(value = "/mdetail", method = RequestMethod.GET)
	@GetMapping(value = "/mdetail")
	public String mdetial(HttpServletRequest request, Model model, MemberDTO dto) {
		// dto.setId("검색 id");
		model.addAttribute("mDetail", service.selectOne(dto));
		
		if("U".equals(request.getParameter("jCode"))) {
			return "member/memberUpdate";
		} else {
			return "member/memberDetail";
		}
	}

	// ** Member Login
	// => LoginForm : Get
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String loginForm() {
//		return "member/loginForm";
//	}
	
//  => 계층적 url 적용
//	   : home에서의 요청명은 "member/memberJoin"
//	   : viewName 생략 시, 요청명을 viewName으로 처리
//	   -> @RequestMapping 대신 @GetMapping 사용 가능
	@GetMapping(value = "/loginForm")
	public void loginForm() {
		
	}
	

	// => Login처리 : Post
	//@RequestMapping(value = "/login", method = RequestMethod.POST)
	@PostMapping(value = "/login")
	public String login(HttpSession session, Model model, MemberDTO dto) {
		// ** 로그인 Service처리

		// 1. 요청 분석
		// => request로 전달되는 id, password 처리 :
		// 메서드 매개변수로 MemberDTO를 정의해주면 자동 처리
		// (Parameter name과 일치하는 setter를 찾아 값을 할당해줌)
		// => 전달된 password 보관
		String password = dto.getPassword();
		String uri = "redirect:/";
		// "home" : home.jsp(성공)
		// "redirect:home" -> home을 재요청, 그러므로 HomeController의 home 메서드로

		// 2. 서비스 처리
		// => id 확인
		// => 존재하면 Password 확인
		// => 성공: id, name은 session에 보관, home 으로
		// => 실패: 재로그인 유도
		dto = service.selectOne(dto);

		if (dto != null && dto.getPassword().equals(password)) {
			session.setAttribute("loginID", dto.getId());
			session.setAttribute("loginName", dto.getName());
			session.setAttribute("loginJno", dto.getJno());
		} else {
			uri = "member/loginForm";
			model.addAttribute("message", "[로그인 실패] 다시 시도해주세요.");
		}
		return uri;
	}

	// ** Member Logout
	// => Logout처리
	// => session 무효화
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session, Model model, RedirectAttributes rttr) {
		session.invalidate();
		// model.addAttribute("message", "로그아웃 되었습니다.");

		// => 단, request에 보관한 값들은 사라지므로 위의 메세지 처리를 고려해야 함
		// => session에 보관(이미 세션을 무효화했으므로 500 발생)
		// => 그리고 session 무효화를 하지 않더라도 이 메세지는 사용 후 삭제를 해야 함
		// : session.setAttribute("message", "로그아웃 되었습니다.");
		// => 이렇게 redirect하는 경우 메세지 처리 등을 편리하게 지원해주는 객체 : RedirectAttributes
		rttr.addFlashAttribute("message", "로그아웃 되었습니다.");
		return "redirect:/";
	}

	// ** Join 기능
	// => JoinForm : Get
//	@RequestMapping(value = "/join", method = RequestMethod.GET)
//	public String memberJoin() {
//		return "member/memberJoin";
//	}
	
//  => 계층적 url 적용
//	   : home에서의 요청명은 "member/memberJoin"
//	   : viewName 생략 시, 요청명을 viewName으로 처리
//	   -> @RequestMapping 대신 @GetMapping 사용 가능
	@GetMapping(value = "/memberJoin")
	public void memberJoin() {
		// viewName 생략
	}
	
	// ** Join Service 처리 : Post
	//@RequestMapping(value = "/join", method = RequestMethod.POST)
	@PostMapping(value = "/join")
	public String join(MemberDTO dto, Model model) {
		// 1) 요청분석 & Service
		// => 한글처리 필수 : web.xml에서 filter로 처리
		// => request Parameter 처리 : 매개변수로 MemberDTO 정의하면 자동으로 set
		// => 성공 : 로그인 유도 (loginForm으로, member/loginForm.jsp)
		// => 실패 : 재가입 유도 (joinForm으로, member/memberJoin.jsp)
		String uri = "member/loginForm";

		// 2) Service 처리
		if (service.insert(dto) > 0) {
			model.addAttribute("message", "[회원가입 성공] 로그인 후 이용하세요.");
		} else {
			model.addAttribute("message", "[회원가입 실패] 다시 시도하세요.");
			uri = "member/memberJoin";
		}

		// 3) View
		return uri;
	}

	// ** Member Update
	// => 요청 : home에서 내정보수정 -> 내정보수정 Form 출력
	// => 수정 후 submit -> 수정 Service
	//    : 성공 -> detail 출력
	//    : 실패 -> 재시도 유도 (memberUpdate.jsp)
	//@RequestMapping(value = "mupdate", method = RequestMethod.POST)
	@PostMapping(value = "/mupdate")
	public String memberUpdate(MemberDTO dto, Model model) {
		// => 처리 결과에 따른 화면 출력을 위해서 dto의 값을 Attribute에 보관
		model.addAttribute("mDetail", dto);
		String uri = "member/memberDetail";
		
		// => Service 처리
		if (service.update(dto) > 0) {
			model.addAttribute("message", "회원정보 수정이 완료되었습니다.");
		} else {
			model.addAttribute("message", "[회원정보 수정 실패] 다시 시도하세요.");
			uri = "member/memberUpdate";
		}
		
		return uri;
	}
	
	// ** Member Delete : 회원 탈퇴
	// -> 삭제 대상 : Parameter로 전달, dto에 자동 set
	//@RequestMapping(value = "mdelete", method = RequestMethod.GET)
	@GetMapping(value = "/mdelete")
	public String mdelete(MemberDTO dto, Model model, HttpSession session, RedirectAttributes rttr) {
		
		// 1) 본인 탈퇴
		// 결과 : message(삭제 성공/실패), home.jsp, session 무효화
		
		// 2) 관리자에 의한 강제 탈퇴
		// 결과 : message(삭제 성공/실패), memberList.jsp
		
		// => 본인 탈퇴 or 관리자에 의한 강제 탈퇴 구분 필요
		//    : dto의 id와 session의 loginID와 같으면 -------> 본인 탈퇴
		//    : dto의 id와 session의 loginID와 다르면서
		//      loginID의 값이 "admin"일 경우 --------------> 강제 탈퇴
		
		String uri = "redirect:/";
		
		if (service.delete(dto) > 0) {
			rttr.addFlashAttribute("message", "회원탈퇴 되었습니다.");
			if (((String)session.getAttribute("loginID")).equals("admin")) {
				// => 관리자에 의한 강제 탈퇴
				uri = "redirect:memberList";
			} else {
				// => 본인 탈퇴
				session.invalidate();
			}
		} else {
			model.addAttribute("message", "[탈퇴 실패] 다시 시도하세요.");
		}
		
		return uri;
	}

}