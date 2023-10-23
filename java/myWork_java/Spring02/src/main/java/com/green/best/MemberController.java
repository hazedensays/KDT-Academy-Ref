package com.green.best;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		String uri = "home";

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

}