package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.domain.BoardDTO;
import com.example.demo.service.BoardService;

import criTest.PageMaker;
import criTest.SearchCriteria;
import lombok.AllArgsConstructor;

//@Log4j
@AllArgsConstructor  //Autowired를 사용하지 않아도 됨
@RequestMapping(value = "/board") // "/board"로 시작하는 모든 요청을 처리
// => 하나의 클래스 안에 메서드 단위로 컨트롤러를 여러 개 만들 수 있음
@Controller
public class BoardController {
	BoardService service;
	 
	// ** Board_Cri_Paging
	@GetMapping(value="/bcriList")
	public void bcriList(Model model, SearchCriteria cri, PageMaker pageMaker) {
		// 1) Criteria 처리
		// => ver01 : currPage, rowsPerPage 값들은 Parameter 로 전달되어 자동으로 cri에 set
		// => ver02 : ver01 + searchType, keyword도 동일하게 cri에 set
		cri.setSnoEno();
		
		// 2) Service 처리
		// => ver01, ver02 모두 같은 서비스 사용
		//    단, Mapper interface에서 사용하는 sql 구문만 변경해서 사용
		//    BoardMapper.xml에 SQL 구문 추가, interface 수정
		model.addAttribute("bList", service.bcriList(cri));

		// 3) View 처리 : PageMaker 필요
		// => cri, totalRowsCount (DB 에서 Read)
		pageMaker.setCri(cri);
		pageMaker.setTotalRowsCount(service.criTotalCount(cri));
		// => ver01 : 전체 rows 개수
		//    ver02 : 검색 조건에 해당하는 rows 개수
		model.addAttribute("pageMaker", pageMaker);
	}
	
	// ** replyInsert =====================================================================
	// => replyInsert Form 출력 메서드
	//    bdetail 화면에서 요청시 퀴리스트링으로 보낸 부모글의 root, step, indent 를 
	//    replyInsert Form 으로 전달
	// => replyInsert Form 에서는 이값들을 hidden 으로 숨겨놓음 (rinsert 위해 필요함)
	   
	// => 매핑메서드의 인자로 정의된 dto 는 request.setAttribute 와 동일 scope
	//    그러므로 response 출력 전까지는 사용가능
	//    단, 클래스명의 첫글자를 소문자로 ...  ${boardDTO.root}
	//      그러므로 아래와같은 구문은 필요없음.
	//     model.addAttribute("apple", dto);
	
	@GetMapping(value="/replyInsert")
	public void replyInsert(BoardDTO dto) {
		// viewName 생략
	}
	
	@PostMapping(value="/rinsert")
	public String rinsert(BoardDTO dto, Model model, RedirectAttributes rttr) {
		// ** 답글 등록
		// => SQL 구문 : reply_insert, step_update
		// => 성공 : boardList
		//    실패 : replyInsert 입력폼으로
		String uri = "redirect:boardList";
		
		// => dto의 값
		//    : id, title, content -> 사용 가능
		//    : 부모글의 root -> 동일
		//    : 부모글의 step, indent -> 1씩 증가
		dto.setStep(dto.getStep()+1);
		dto.setIndent(dto.getIndent()+1);
		
		if(service.rinsert(dto) > 0) {
			rttr.addFlashAttribute("message", "답글이 등록되었습니다.");
		} else {
			uri = "board/replyInsert";
			model.addAttribute("message", "[답글 등록실패] 다시 시도하세요.");
		}

		return uri;
	}
	
	// ** BoardList =====================================================================
	@GetMapping(value = "/boardList")
	public void blist(Model model) {
		model.addAttribute("bList", service.selectList());
	}
	
	// ** BoardDetail
	// => 조회수 증가 조건
	//   -> 글보는이(loginID)와 글쓴이가 다를때 
	//   -> 글보는이(loginID)가 "admin" 이 아닌경우 
	//   -> 수정요청이 아닌경우
	// => 조회수 증가 처리 
	//   -> Table 의 cnt=cnt+1
	//   -> Update 메서드 활용
	//      - mapper 의 xml 수정 (Mybatis)
	//      - bUpdateForm 에서 cnt값 전달 가능하도록 수정
	
	// ** BoardDetail ===================================================================
	@GetMapping(value = "/bdetail")
	public String bdetial(HttpServletRequest request, Model model, BoardDTO dto) {
		// 1) Detail Service 처리
		dto = service.selectOne(dto);

		// 2) 조회수 증가
		// => get loginID
		String loginID = (String)request.getSession().getAttribute("loginID");
		
		// => 조회수 증가 조건
		//    : loginID가 관리자가 아닐 경우
		//    : loginID가 로그인한 아이디와 다를 경우
		//    : 게시물을 수정할 경우에는 카운트하지 않음
		if (!"admin".equals(loginID) &&
				!dto.getId().equals(loginID) &&
				!"U".equals(request.getParameter("jCode"))) {
			// => 조회수 증가 처리
			dto.setCnt(dto.getCnt()+1);
			service.update(dto);
		}
		
		// 3) model & view 처리
		// => 글 수정화면 요청인 경우를 구분
		model.addAttribute("bDetail", dto);
		
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