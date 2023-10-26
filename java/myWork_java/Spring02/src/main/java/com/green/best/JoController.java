package com.green.best;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import domain.JoDTO;
import lombok.AllArgsConstructor;
import service.JoService;
import service.MemberService;

//@Log4j
@AllArgsConstructor // Autowired를 사용하지 않아도 됨
@RequestMapping(value = "/jo") // "/jo"로 시작하는 모든 요청을 처리
// => 하나의 클래스 안에 메서드 단위로 컨트롤러를 여러 개 만들 수 있음
@Controller
public class JoController {
	//@Autowired
	JoService service;

	//@Autowired
	MemberService mservice;

	// ** JoList
	// =====================================================================
	@GetMapping(value = "/joList")
	public void jlist(Model model) {
		model.addAttribute("jList", service.selectList());
	}

	// ** JoDetail
	// => 아랫쪽에 조원목록 출력 (추가기능) -> joDetail.jap 에 Member_List 출력 코드 추가
	// => jo Table에서 selectOne -> mDetail
	// => member Table에서 조건검색 jno=#{jno} -> mList
	@GetMapping(value = "/jdetail")
	public String jdetail(HttpServletRequest request, Model model, JoDTO dto) {

		String uri = "jo/joDetail";
		model.addAttribute("jDetail", service.selectOne(dto));
		// => 수정요청 시엔 수정폼으로
		if ("U".equals(request.getParameter("jCode")))
			uri = "jo/joUpdate";

		// ** 조원목록 출력하기 추가
		// => MemberService 실행
		// -> joList 메서드 추가 : service, DAO
		// -> 실행결과는 mList 로
		model.addAttribute("mList", mservice.joList(dto.getJno()));

		return uri;
	} // jdetail
	
	
	// ** Jo Insert ===================================================================
	// => 새 글 등록
	@GetMapping(value = "/joInsert")
	public void joInsert() {
		// viewName 생략 -> 요청명이 viewName이 됨
	}

	// => Insert Service 처리 : Post
	@PostMapping(value = "/jinsert")
	public String jinsert(JoDTO dto, Model model, RedirectAttributes rttr) {
		// 1) 요청분석 & Service
		// : 성공 -> joList
		// : 실패 -> 재입력 유도 (입력폼으로, jo/joInsert.jsp)

		String uri = "redirect:joList"; // 성공

		// 2) Service 처리
		if (service.insert(dto) > 0) {
			rttr.addFlashAttribute("message", "조가 등록되었습니다.");
		} else {
			model.addAttribute("message", "[조 등록실패] 다시 시도하세요.");
			uri = "jo/joInsert";
		}

		return uri;
	}

	// ** Jo Update ==================================================================
	// => 성공 : joDetail
	// => 실패 : joUpdate
	@PostMapping(value = "/jupdate")
	public String jUpdate(JoDTO dto, Model model, RedirectAttributes rttr) {
		// => 처리 결과에 따른 화면 출력을 위해서 dto의 값을 Attribute에 보관
		model.addAttribute("jDetail", dto);
		String uri = "redirect:jdetail?jno=" + dto.getJno();

		// => Service 처리
		if (service.update(dto) > 0) {
			rttr.addFlashAttribute("message", "조가 수정되었습니다.");
		} else {
			model.addAttribute("message", "[조 수정실패] 다시 시도하세요.");
			uri = "jo/joUpdate";
		}

		return uri;
	}

	// ** Jo Delete : 회원 탈퇴 ==================================================================
	@GetMapping(value = "/jdelete")
	public String jdelete(JoDTO dto, Model model, RedirectAttributes rttr) {

		String uri = "redirect:joList";

		if (service.delete(dto) > 0) {
			rttr.addFlashAttribute("message", "조가 삭제되었습니다.");
		} else {
			rttr.addAttribute("message", "[조 삭제실패] 다시 시도하세요.");
		}

		return uri;
	}

}