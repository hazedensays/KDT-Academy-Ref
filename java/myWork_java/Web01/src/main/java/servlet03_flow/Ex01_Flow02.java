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
public class Ex01_flow02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Ex01_flow02() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//** PageFlow 실습
		//=> testForm: servletTestForm/flow02_TestForm.jsp
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int page = Integer.parseInt(request.getParameter("page"));
		String send = request.getParameter("send");
		String uri="";
		switch(page) {
			case 1: uri = "helloS"; break;
			case 2: uri = "lifeCycle"; break;
			case 3: uri = "servletTestForm/form03_Check.jsp"; break;
			case 4: uri = "servletTestForm/form04_Select.jsp"; break;
		}
		/*
		if(send.equals("f")) {
			request.getRequestDispatcher(uri).forward(request, response);
		}else {			
			response.sendRedirect(uri);
		}
		*/
		
		// 위 코드는 NullPointExeption이 발생할 수 있음
		// 예방 방법
		if ( "f".equals(request.getParameter("send"))) {
			request.getRequestDispatcher(uri).forward(request, response);
		} else {
			response.sendRedirect(uri);
		}
		
		
		
		
	}



}
