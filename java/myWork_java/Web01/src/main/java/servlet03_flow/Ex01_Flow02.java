package servlet03_flow;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//** PageFlow
//=> 서버내에서 웹페이지(Html, Jsp) 또는 Servlet 간의 이동   
//=> 서버외 : 클라이언트의 요청으로 이동 ( a Tag , submit 등 )    
//=> 경우
//  servlet -> servlet
//  servlet <-> jsp , html
//  jsp -> jsp   

//** Forward 와 Redirect
//** Forward : 웹브라우져의 주소창이 안바뀜
//  => 현재의 요청에 대해 서버내에서 page만 이동함.
//** Redirect: 웹브라우져의 주소창이 바뀜
//  => 현재의 요청에 대해 응답 -> 재요청 -> 처리

@WebServlet("/flow02")
public class Ex01_Flow02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex01_Flow02() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 요청 분석
		// => uri가 forward 방식인가 redirect인가 확인
		int pageNum = Integer.parseInt(request.getParameter("page"));
		String send = request.getParameter("send");
		String uri = "";

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<h2 style = 'color : hotpink;'> ** Forward / Redirect Test ** </h2>");

		switch (pageNum) {
		case 1:
			uri = "helloS";
			break;
		case 2:
			uri = "lifecycle";
			break;
		case 3:
			uri = "servletTestForm/form03_Check.jsp";
			break;
		case 4:
			uri = "servletTestForm/form04_Select.jsp";
			break;
		}
		
		// 2. Forward or Redirect
		// ** NullPointExeption 예방
		// => request.getParameter("send")가 값이 없는경우 NullPointExeption 발생 
		//    if ( "f".equals(request.getParameter("send")) )
		
		if ("f".equals(request.getParameter("send"))) {
			request.getRequestDispatcher(uri).forward(request, response);
		} else {
			response.sendRedirect(uri);
		}

		// => console로 확인
		System.out.println("** flow02 Test **");

	}// doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}// class Ex01_Flow01
