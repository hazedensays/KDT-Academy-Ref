package com.green.best;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import domain.MemberDTO;
import service.MemberService;

// => 하나의 클래스 안에 메서드 단위로 컨트롤러를 여러 개 만들 수 있음
@Controller
public class MemberController {

	@Autowired
	MemberService service;

	// ** MemberList
	@RequestMapping(value = "/mlist", method = RequestMethod.GET)
	public String mlist(Model model) {
		model.addAttribute("mList", service.selectList());
		return "member/memberList";
	}

	// ** MemberDetail
	@RequestMapping(value = "/mdetail", method = RequestMethod.GET)
	public String mdetial(Model model, MemberDTO dto) {
		// dto.setId("검색 id");
		model.addAttribute("mDetail", service.selectOne(dto));
		return "member/memberDetail";
	}

	// ** Member Login
	// => LoginForm : Get
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		return "member/loginForm";
	}

	// => Login처리 : Post
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpSession session, Model model, MemberDTO dto) {
		// ** 로그인 Service처리

		// 1. 요청 분석
		// => request로 전달되는 id, password 처리 :
		// 메서드 매개변수로 MemberDTO를 정의해주면 자동 처리
		// (Parameter name과 일치하는 setter를 찾아 값을 할당해줌)
		// => 전달된 password 보관
		String password = dto.getPassword();
		String uri = "redirect:home";
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
		return "redirect:home";
	}

	// ** Join 기능
	// => JoinForm : Get
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String memberJoin() {
		return "member/memberJoin";
	}

	// ** Join Service 처리 : Post
	@RequestMapping(value = "/join", method = RequestMethod.POST)
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
	// Member Delete : 회원 탈퇴
	// -> 삭제 대상 : Parameter로 전달, dto에 자동 set
	@RequestMapping(value = "mdelete", method = RequestMethod.GET)
	public String mdelete(MemberDTO dto, Model model, HttpSession session, RedirectAttributes rttr) {
		
		// 1) 본인 탈퇴
		// 결과 : message(삭제 성공/실패), home.jsp, session 무효화
		
		// 2) 관리자에 의한 강제 탈퇴
		// 결과 : message(삭제 성공/실패), memberList.jsp
		
		// => 본인 탈퇴 or 관리자에 의한 강제 탈퇴 구분 필요
		//    : dto의 id와 session의 loginID와 같으면 -------> 본인 탈퇴
		//    : dto의 id와 session의 loginID와 다르면서
		//      loginID의 값이 "admin"일 경우 --------------> 강제 탈퇴
		
		String uri = "home";
		
		if (service.delete(dto) > 0) {
			rttr.addFlashAttribute("message", "회원탈퇴 되었습니다.");
			if (((String)session.getAttribute("loginID")).equals("admin")) {
				// => 관리자에 의한 강제 탈퇴
				uri = "redirect:mlist";
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