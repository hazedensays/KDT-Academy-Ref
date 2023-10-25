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

import domain.BoardDTO;
import domain.MemberDTO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import service.BoardService;

@Log4j
@AllArgsConstructor  //Autowired를 사용하지 않아도 됨
@RequestMapping(value = "/board") // "/board"로 시작하는 모든 요청을 처리
// => 하나의 클래스 안에 메서드 단위로 컨트롤러를 여러 개 만들 수 있음
@Controller
public class BoardController {
	BoardService service;

	// ** BoardList =====================================================================
	@GetMapping(value = "/boardList")
	public void blist(Model model) {
		model.addAttribute("bList", service.selectList());
	}

	// ** BoardDetail ===================================================================
	@GetMapping(value = "/bdetail")
	public String bdetial(HttpServletRequest request, Model model, BoardDTO dto) {
		model.addAttribute("bDetail", service.selectOne(dto));
		
		// => 글 수정화면 요청인 경우를 구분
		if("U".equals(request.getParameter("jCode"))) {
			return "board/boardUpdate";
		} else {
			return "board/boardDetail";
		}
	}
	
	// ** Board Insert ===================================================================
	// => 새 글 등록
	@GetMapping(value = "/boardInsert")
	public void boardInsert() {
		// viewName 생략 -> 요청명이 viewName이 됨
	}
	
	// => Insert Service 처리 : Post
	@PostMapping(value = "/binsert")
	public String binsert(BoardDTO dto, Model model, RedirectAttributes rttr) {
		// 1) 요청분석 & Service
		//    : 성공 -> boardList
		//    : 실패 -> 재입력 유도 (입력폼으로, board/boardInsert.jsp)
		
		String uri = "redirect:boardList"; // 성공
		
		// 2) Service 처리
		if (service.insert(dto) > 0) {
			rttr.addFlashAttribute("message", "게시물이 등록되었습니다.");
		} else {
			model.addAttribute("message", "[게시물 등록실패] 다시 시도하세요.");
			uri = "board/boardInsert";
		}
		
		return uri;
	}
	
	// ** Board Update ==================================================================
	// => 성공 : boardDetail
	// => 실패 : boardUpdate
	@PostMapping(value = "/bupdate")
	public String bUpdate(BoardDTO dto, Model model) {
		// => 처리 결과에 따른 화면 출력을 위해서 dto의 값을 Attribute에 보관
		model.addAttribute("bDetail", dto);
		String uri = "board/boardDetail";
		
		// => Service 처리
		if (service.update(dto) > 0) {
			model.addAttribute("message", "게시물이 수정되었습니다.");
		} else {
			model.addAttribute("message", "[게시물 수정실패] 다시 시도하세요.");
			uri = "board/boardUpdate";
		}
		
		return uri;
	}
	
	// ** Board Delete : 회원 탈퇴
	@GetMapping(value = "/bdelete")
	public String bdelete(BoardDTO dto, Model model, RedirectAttributes rttr) {

		String uri = "redirect:boardList";
		
		if (service.delete(dto) > 0) {
			rttr.addFlashAttribute("message", "게시물이 삭제되었습니다.");
		} else {
			rttr.addAttribute("message", "[게시물 삭제실패] 다시 시도하세요.");
		}
		
		return uri;
	}

}