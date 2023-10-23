package servlet01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 강사님 ip호출 Test
// http://192.168.0.17:8080/Web01/lifecycle

@WebServlet("/lifeCycle")
public class Ex04_LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	int cno=1; // 생성자메서드 호출 횟수
	int ino=1; // init메서드 호출 횟수
	int dno=1; // destroy메서드 호출 횟수
	int gno=1; // doGet메서드 호출 횟수

	// ** 생성자 : 메모리 생성
	// => 서버스타트 이후 첫요청 들어오면 WAS가 자동생성
    public Ex04_LifeCycle() {
        super();
        System.out.println("** 생성자 메서드 호출 횟수"+cno++);
    }

    // ** init(초기화) 메서드
    // => 인스턴스 생성 직후 자동 호출
	public void init(ServletConfig config) throws ServletException {
		System.out.println("** init 메서드 호출 횟수"+ino++);
	}

	// ** destroy 메서드 : 메모리 소멸
	// => server 종료 시 (서버는 모든 자원을 close)
	public void destroy() {
		System.out.println("** destroy 메서드 호출 횟수"+dno++);
	}

	// ** doGet 메서드
	// => 클라이언트로부터 Get방식의 요청이 들어오면 자동호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<h2>** Servlet LifeCycle **</h2>");
		out.print("<pre>");
		out.println("** 현재시간 : "+new Date());
		out.println("** doGet 메서드 호출 횟수 : "+gno);
		out.print("</pre>");

		System.out.println("** doGet 메서드 호출 횟수"+gno++);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
