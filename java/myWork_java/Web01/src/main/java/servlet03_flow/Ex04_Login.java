package servlet03_flow;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvcTest.StudentDTO;
import mvcTest.StudentService;


@WebServlet("/login")
public class Ex04_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Ex04_Login() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청분석
		// 한글처리, request Parameter
		request.setCharacterEncoding("UTF-8");
		int sno=0;
		if(request.getParameter("sno")!=null && request.getParameter("sno").length()>0) {
			sno = Integer.parseInt(request.getParameter("sno"));
		}
		String name = request.getParameter("name");
		
		// 2. 서비스처리
		// => Service객체 생성
		// sno로 확인 (selectOne 메서드)
		// => 존재하면 name확인 (DTO의 name과 Parameter로 전달된 name과 비교
		StudentService service = new StudentService();
		StudentDTO dto = new StudentDTO();
		dto.setSno(sno);
		service.selectOne(dto);
//		dto = service.selectOne(dto);
		
		
		// 3. View(Response)
		// => 성공 : index.jsp로
		// => 실패 : loginForm으로 (재로그인 유도)
		String uri="";
		
		if(service.selectOne(dto) != null && dto.getName().equals(name) ) {
			uri="index.jsp";
			
			// 로그인 성공 시 ㅇㅇ님으로 index화면에 항상 표시되도록 하기
			request.getSession().setAttribute("loginName",name);
			request.getSession().setAttribute("loginID",sno);
			
		}else {
			uri="servletTestForm/flowEx04_LoginForm.jsp";
			
			// Attribute로 다른 servlet이나 jsp로 값 공유
			// => Attribute값이 메모리에서 유지되는 시간이 4종류이며 Scope이라고 함
			// => Scope 종류 : Page < Request < Session < Application
			request.setAttribute("message", "로그인 실패, 다시 시도해주세요.");
			
		}
		
		request.getRequestDispatcher(uri).forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("** doPost 실행 **");
		doGet(request, response);
	}

}





