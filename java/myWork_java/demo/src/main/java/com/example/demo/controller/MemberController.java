package com.example.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.domain.MemberDTO;
import com.example.demo.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

// ** MemberController
// => SpringBoot, JSP 사용, 계층적 uri 적용

@Controller
@RequestMapping("/member")
@Log4j2 //@Log4j : Boot에서는 2015년 이후 지원 중단
@AllArgsConstructor // 모든 멤버변수 생성자 주입하므로 각각 @AutoWired할 필요없음
public class MemberController {
	MemberService service;
	PasswordEncoder passwordEncoder;
	
	@GetMapping("/memberList")
	public void memberList(Model model) {
		model.addAttribute("mList", service.selectList());
		log.info("** MemberList 성공 **");
	}
	
	// ** MemberDetail  =========================================
	// @RequestMapping(value = "/mdetail", method = RequestMethod.GET)
	@GetMapping(value = "/mdetail")
	public String mdetial(HttpServletRequest request, Model model, MemberDTO dto) {
		model.addAttribute("mDetail", service.selectOne(dto));

		if ("U".equals(request.getParameter("jCode"))) {
			return "member/memberUpdate";
		} else {
			return "member/memberDetail";
		}
	}

	// ** Member Login  =========================================
	
	@GetMapping(value = "/loginForm")
	public void loginForm() {

	}

	@PostMapping(value = "/login")
	public String login(HttpSession session, Model model, MemberDTO dto) {
		
		String password = dto.getPassword();
		String uri = "redirect:/";

		dto = service.selectOne(dto);

		if (dto != null && passwordEncoder.matches(password, dto.getPassword())) {
			session.setAttribute("loginID", dto.getId());
			session.setAttribute("loginName", dto.getName());
			session.setAttribute("loginJno", dto.getJno());
		} else {
			uri = "member/loginForm";
			model.addAttribute("message", "[로그인 실패] 다시 시도해주세요.");
		}
		return uri;
	}

	// ** Member Logout  =========================================

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session, Model model, RedirectAttributes rttr) {
		session.invalidate();

		rttr.addFlashAttribute("message", "로그아웃 되었습니다.");
		return "redirect:/";
	}

	// ** Join 기능  =========================================

	@GetMapping(value = "/memberJoin")
	public void memberJoin() {
		// viewName 생략
	}

	@PostMapping(value = "/join")
	public String join(HttpServletRequest request, MemberDTO dto, Model model) throws IOException {

		String uri = "member/loginForm";
		
		// ** PasswordEncoder 적용 =================
		dto.setPassword(passwordEncoder.encode(dto.getPassword()));

		// ** MultipartFile ***********************

		String realPath = request.getRealPath("/");
		System.out.println("** realPath => " + realPath);

		if (realPath.contains(".eclipse.")) { // 개발 중(배포 전 : eclipse 개발 환경)
			realPath = "D:\\hazedensays\\hazedensays_Ref\\java\\myWork_java\\demo\\src\\main\\webapp\\resources\\uploadImages\\";
		} else {
			realPath += "resources\\uploadImages\\";
			// 필요한 경로 : C:\apache-tomcat-9.0.80\webapps\demo\resources\~uploadImages
		}

		File f1 = new File(realPath);
		if (!f1.exists()) {
			f1.mkdir();
			// => realPath가 존재하지 않으면 생성
		}

		f1 = new File(realPath + "basicman4.png"); // uploadImages 폴더에 파일이 존재하는지 확인하기 위함
		if (!f1.isFile()) { // 존재하지 않는 경우
			String basicImagePath = "D:\\hazedensays\\hazedensays_Ref\\java\\myWork_java\\demo\\src\\main\\webapp\\resources\\images\\basicman4.png";
			FileInputStream fi = new FileInputStream(new File(basicImagePath));
			// => basicImage 읽어 파일 입력바이트스트림 생성
			FileOutputStream fo = new FileOutputStream(f1);
			// => 목적지 파일(realPath+"basicman4.png") 출력바이트스트림 생성
			FileCopyUtils.copy(fi, fo);
			// fi에서 가져와서 fo에 넣어줌
		}

		// => 기본 이미지 지정하기
		String file1, file2 = "resources/uploadImages/basicman4.png";

		// ** MultipartFile

		MultipartFile uploadfilef = dto.getUploadfilef();

		if (uploadfilef != null && !uploadfilef.isEmpty()) {
			// => image_File을 선택함 -> 저장 (저장경로 : realPath + 파일명)
			// 1-3.1) 물리적 위치 저장 (file1)
			file1 = realPath + uploadfilef.getOriginalFilename(); // 저장경로 완성
			uploadfilef.transferTo(new File(file1)); // 해당 경로에 저장 (붙여넣기)

			// 1-3.2) 물리적 위치 저장 (file2)
			file2 = "resources/uploadImages/" + uploadfilef.getOriginalFilename();
		} // img 선택한 경우
		
		// 1-4) 완성된 경로를 dto에 set
		dto.setUploadfile(file2);
		
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

	// ** Member Update  =========================================

	// @RequestMapping(value = "mupdate", method = RequestMethod.POST)
	@PostMapping(value = "/mupdate")
	public String memberUpdate(MemberDTO dto, Model model, HttpServletRequest request) throws IOException {
		model.addAttribute("mDetail", dto);
		String uri = "member/memberDetail";

		dto.setPassword(null);
		
		String realPath = request.getRealPath("/");
		
		if (realPath.contains(".eclipse.")) {
			realPath = "D:\\hazedensays\\hazedensays_Ref\\java\\myWork_java\\demo\\src\\main\\webapp\\resources\\uploadImages\\";
		} else {
			realPath += "resources\\uploadImages\\";
		}
		
		File f1 = new File(realPath);
		if (!f1.exists()) {
			f1.mkdir();
		}
		
		f1 = new File(realPath + "basicman4.png");
		if (!f1.isFile()) {
			String basicImagePath = "D:\\hazedensays\\hazedensays_Ref\\java\\myWork_java\\demo\\src\\main\\webapp\\resources\\images\\basicman4.png";
			FileInputStream fi = new FileInputStream(new File(basicImagePath));
			FileOutputStream fo = new FileOutputStream(f1);
			// => 목적지 파일(realPath+"basicman4.png") 출력바이트스트림 생성
			FileCopyUtils.copy(fi, fo);
		}
		
		// => 기본 이미지 지정하기
		String file1, file2 = "resources/uploadImages/basicman4.png";

		MultipartFile uploadfilef = dto.getUploadfilef();

		if (uploadfilef != null && !uploadfilef.isEmpty()) {
			//dto.setUploadfile("resources/uploadImages/" + uploadfilef.getOriginalFilename());
			
			file1 = realPath + uploadfilef.getOriginalFilename();
			uploadfilef.transferTo(new File(file1));

			file2 = "resources/uploadImages/" + uploadfilef.getOriginalFilename();
		}
		
		dto.setUploadfile(file2);

		// => Service 처리
		if (service.update(dto) > 0) {
			model.addAttribute("message", "회원정보 수정이 완료되었습니다.");
		} else {
			model.addAttribute("message", "[회원정보 수정 실패] 다시 시도하세요.");
			uri = "member/memberUpdate";
		}

		return uri;
	}

	// ** Member Delete : 회원 탈퇴  =========================================

	@GetMapping(value = "/mdelete")
	public String mdelete(MemberDTO dto, Model model, HttpSession session, RedirectAttributes rttr) {

		String uri = "redirect:/";

		if (service.delete(dto) > 0) {
			rttr.addFlashAttribute("message", "회원탈퇴 되었습니다.");
			if (((String) session.getAttribute("loginID")).equals("admin")) {
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
	

	@GetMapping(value = "/pUpdateForm")
	public void pUpdateForm() {
		// viewName 생략
	}

	// ** Password 수정  =========================================
	@PostMapping(value = "/passwordUpdate")
	public String passwordUpdate(HttpServletRequest request, MemberDTO dto, Model model) {
		
		String id = (String)request.getSession().getAttribute("loginID");
		
		// => id가 존재하지 않는 경우 : 로그인 유도, 메서드 종료
		if (id==null) {
			model.addAttribute("message", "로그인 정보가 없습니다.");
			return "member/loginForm";
		}
		
		// => id가 존재하는 경우 수정
		System.out.println("변경 전 패스워드: " + dto.getPassword());
		dto.setId(id);
		dto.setPassword(passwordEncoder.encode(dto.getPassword()));

		System.out.println("변경 후 패스워드: " + dto.getPassword());
		String uri = "member/loginForm";
		
		if (service.update(dto) > 0) {
			// password 수정 성공, session 무효화, loginForm으로
			request.getSession().invalidate();
			model.addAttribute("message", "password가 변경되었습니다.");
		} else {
			model.addAttribute("message", "[password 변경실패] 다시 시도하세요.");
			uri = "member/pUpdateForm";
		}
		
		return uri;
	}
	
	
	// ** ID 중복확인  =========================================
	@GetMapping("/idDupCheck")
	public String idDupCheck(MemberDTO dto, Model model) {
		// 1) newID 확인
		// idUse가 F면 사용 불가, T면 사용 가능
		if (service.selectOne(dto) != null) {
			// => 존재할 경우 : 사용 불가
			model.addAttribute("idUse", "F");
		} else {
			// => 존재하지 않을 경우 : 사용 가능
			model.addAttribute("idUse", "T");
		}
		
		return "member/idDupCheck";
	}

}//class MemberController
