package mvcTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/join")
public class MVC2_sJoin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MVC2_sJoin() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		int jno = Integer.parseInt(request.getParameter("jno"));
		String info = request.getParameter("info");
		double point = Double.parseDouble(request.getParameter("point"));
		String birthday = request.getParameter("birthday");
		
		StudentService service = new StudentService();
		StudentDTO dto = new StudentDTO();
		dto.setName(name);
		dto.setAge(age);
		dto.setJno(jno);
		dto.setInfo(info);
		dto.setPoint(point);
		dto.setBirthday(birthday);
		
		String uri;
		if(service.insert(dto) > 0) {
			// 성공 : 로그인유도(LoginForm으로)
			uri = "servletTestForm/flowEx04_LoginForm.jsp";
			request.setAttribute("message", "회원가입 성공, 로그인 후 이용하세요.");
			
		}else {
			// 실패 : 재가입유도(JoinForm으로)
			uri = "jsp99_mvcTest/mvc2_sJoin.jsp";
			request.setAttribute("message", "회원가입 실패, 다시 시도하세요.");
		}
		
		request.getRequestDispatcher(uri).forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
