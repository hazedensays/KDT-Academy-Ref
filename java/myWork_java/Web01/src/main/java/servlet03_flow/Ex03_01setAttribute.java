package servlet03_flow;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/01set")
public class Ex03_01setAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex03_01setAttribute() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) request 처리
		// => 한글 처리 (post 요청 시에만 필요), Parameter 처리
		// => form 태그 없이 queryString(쿼리스트링)으로 Test
		// => ~~/01set?id=banana&name=홍길동&age=22 같은 데이터가 넘어온다고 가정
		
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		// 간편한 Test를 위해 String 처리
		//int age = Integer.parseInt(request.getParameter("age"));
		String age = request.getParameter("age");
		
		System.out.println("** setAttribute Test **");
		//System.out.printf("** Parameter => id : %s, name : %s, age : %d %n", id, name, age);
		System.out.printf("** Parameter => id : %s, name : %s, age : %s %n", id, name, age);
		
		// 2) setAttribute로 보관
		// => 보관 가능한 scope : page < request < session < application
		// => 2-1) request / 2-2) session
		
		// 2-1) request
		request.setAttribute("rId", id);
		request.setAttribute("rName", name);
		request.setAttribute("rAge", age);
		
		// 2-2) session
		request.getSession().setAttribute("sId", id);
		request.getSession().setAttribute("sName", name);
		request.getSession().setAttribute("sAge", age);
		
		// 3) 이동 후 getAttribute
		// => 이동 방법
		//		: 3-1) forward /  3-2) redirect
		String uri = "02get";
		
		// 3-1) forward
//		request.getRequestDispatcher(uri).forward(request, response);
		
		// 3-2) redirect
		response.sendRedirect(uri);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
