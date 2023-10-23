package servlet02_form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adder")
public class Ex01_Adder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex01_Adder() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1) 요청 분석
		// => request의 Parameter 처리
		request.setCharacterEncoding("UTF-8");
		int num1 = Integer.parseInt( request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));

		// 2) Service 처리
		// 3) 결과(View) 처리
		// => 한글, 출력객체 생성 & response에 담기
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		//out.print("num1 + num2 => " + (num1 + num2));
		out.print("<h2>** Adder Test</h2>");
		out.printf("<h2>%d + %d = %d</h2>", num1, num2, (num1 + num2));
		
	}//doGet

}//class Ex01_Adder
