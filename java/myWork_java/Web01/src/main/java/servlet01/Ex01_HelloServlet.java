package servlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/helloS")
public class Ex01_HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex01_HelloServlet() {
		super();
	} // Ex01_HelloServlet

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ** 출력문 (response 객체에 html 문서를 담아줌)
		// => 출력객체 생성 -> html 문서작성
		// => 한글처리 해야함 (출력객체 생성전에 해야함)

		response.setContentType("text/html; charset=UTF-8");
		// => 웹브라우져에게 처리할 데이터의 MIME 타입을 알려줌
		// => MIME : Multipurpose Internet Mail Extensions
		// => 데이터 송.수신시 자료의 형식에 대한 정보
		// => Jsp 의 page 디렉티브의 contentType 속성값과 동일

		response.getWriter().append("Served at: ").append(request.getContextPath()).append(" : I'm sick")
				.append(" => 나는 아파요");

		PrintWriter out = response.getWriter();
		String name = "귀여워";
		out.print("<html><body>");
		out.print("<h2 style = 'color : blue;'> ** Hello Servlet ** </h2>");
		out.print("<h2 style = 'color : hotpink;'>크림해 사랑아~</h2>");
		out.print("<h3>치이카와는 " + name + "</h3>");
		out.print("</body></html>");
		
		// ** Servlet 장단점
		// 장점 : Java Code 매우 편리
		// 단점 : HTML 매우 불편
	} // doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	} // doPost

}
