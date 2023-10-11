package servlet03_flow;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessioni")
public class Ex02_SessionInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex02_SessionInfo() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Session 인스턴스 생성
		// => Session 객체는 클라이언트가 접속함과 동시에 서버에서 자동 생성됨
		// 이 값을 코드 내에서 사용하기 위해 전달 받음
		HttpSession session = request.getSession();

		// 2. Session Info 출력
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<h2>** Session Info Test **</h2>");
		out.print("<h3>Session_ID : " + session.getId() + "</h3>");

		// 현재 시간
		out.print("<h3>현재 시간 : " + formatter.format(now) + "</h3>");

		// session의 생성 시간
		now.setTime(session.getCreationTime());
		out.print("<h3>Session_생성 시간 : " + formatter.format(now) + "</h3>");

		// 마지막 접근 시간
		now.setTime(session.getLastAccessedTime());
		out.print("<h3>마지막 접근 시간 : " + formatter.format(now) + "</h3>");

		// 3. Session Time 설정 (제한 시간 설정)
		// => 메서드 : setMaxInactiveInterval(10);, 단위는 초, 1시간 (60 * 60)
		// => 설정 파일 (web.xml) : Tag session-config 의 subTag session-timeout
		session.setMaxInactiveInterval(10); // 10초
		// 4FA77CD8A04D771EA4EDD097C3BC6FAF

		// 4. Session 무효화 (종료)
		// => invalidate : 무효화
		// 		세션 객체 자체를 소멸시키는 것이 아니라, 세션을 초기화하고 무효화 시킴
		//		session이 null이 아니고 session = ""
		
		// => 쿼리스트링으로 테스트 ( ... /session?jcode = D)
		// 주의 : jcode라는 parameter가 없는 경우 null을 return
		// -> NullPointerException 예방하도록 작성
		if ("D".equals(request.getParameter("jcode"))) {
			session.invalidate();
			System.out.println("** session 무효화");
			out.print("<h2>** Session 종료되었습니다. **</h2>");
			return;
		}

		out.print("<h2>** Session Info 정상 종료 **</h2>");

	}// doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

} // class Ex02_SessionInfo
