package servlet03_flow;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/01set")
public class Ex03_01setAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Ex03_01setAttribute() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. request 처리
		// => 한글처리, Parameter처리
		request.setCharacterEncoding("UTF-8");
		// => form없이 쿼리스트링으로 Test
		//    ~~/01set?id=banana&name=홍길동&age=22
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		System.out.println("** setAttribute Test**");
		System.out.printf("** Parameter : id=%s, name=%s, age=%s \n",id,name,age);
		// 2. setAttribute로 보관
		// => 보관 가능한 Scope : Page(페이지 이동 전까지 유지) < Request(응답) < Session(유저) < Application
		// => Request
		request.setAttribute("rid", id);
		request.setAttribute("rname", name);
		request.setAttribute("rage", age);
		// => Session	
		// => 정의 후 사용
		HttpSession session = request.getSession();
		session.setAttribute("sid", id);
		// => 정의 없이 사용
		request.getSession().setAttribute("sname", name);
		request.getSession().setAttribute("sage", age);

		
		// 3. 이동 후 getAttribute
		String uri = "02get";
		// 3.1) forward
		request.getRequestDispatcher(uri).forward(request, response);
		
		// 3.2) redirect
//		response.sendRedirect(uri);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
