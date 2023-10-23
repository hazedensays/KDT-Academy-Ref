package controllerM;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MemberDTO;
import service.MemberService;

@WebServlet("/login")
public class MVC2_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MVC2_Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) 요청분석
		// => request의 Parameter 처리
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String uri = "";
		
		
		// 2) 서비스 처리
		// => Service, DTO 객체 생성
		// => sno로 확인 : (selectOne 메서드 사용)
		// => 존재하면 name 확인 (DTO의 name과 Parameter로 전달된 name과 비교)
		MemberService service = new MemberService();
		MemberDTO dto = new MemberDTO();
		
		dto.setId(id);
		dto = service.selectOne(dto);
		
		if (dto != null && dto.getPassword().equals(password)) {
			// => dto 객체에는 해당 학생의 detail 정보가 모두 담겨있음
			// => password의 일치 확인
			// => 성공 : index.jsp로
			// => index 화면에 항상 이름이 표시 되도록 : ~님, 로그인 성공했습니다
			// => : 그러므로 로그인 정보 보관 (session에)
			request.getSession().setAttribute("loginName", dto.getName());
			request.getSession().setAttribute("loginID", id);
			
			System.out.println("** 로그인 성공 **");
			uri = "index.jsp";
		} else {
			// => 실패 : loginForm으로 (재로그인 유도)
			// => loginForm에 "로그인 실패! 다시 입력하세요" 출력
			// => 이러한 값들을 다른 서블릿 또는 jsp 문서와 공유하기 위한 방법이 Attribute
			//		이 Attribute 값이 메모리에서 유지되는 시간이 4 종료 -> Scope
			// -> Scope : page < request < session < application
			request.setAttribute("message", "[로그인 실패] 다시 입력하세요.");
			uri = "member/loginForm.jsp";
		}
		
		// 3) View (Response) : forward
		request.getRequestDispatcher(uri).forward(request, response);
		//response.sendRedirect(uri); =>redirect 방식

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("** doPost 실행 **");
		doGet(request, response);
	}

}