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


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Session 인스턴스 생성
		// => Session 객체는 클라이언트가 접속과 동시에 서버에서 자동 생성됨
		//    이 값을 코드 내에서 사용하기 위해 전달을 받는다.
		HttpSession session = request.getSession();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		
		// 2. Session Info 출력
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print("<h2>** Session Info **</h2>");
		out.print("<h3>session_ID : "+session.getId()+"</h3>");
		out.print("<h3>현재시간 : "+formatter.format(now)+"</h3>");
		now.setTime(session.getCreationTime());
		out.print("<h3>session 생성시간(CreationTime) : "+formatter.format(now)+"</h3>");
		now.setTime(session.getLastAccessedTime());
		out.print("<h3>마지막 접근시간(LastAccessedTime) : "+formatter.format(now)+"</h3>");

		// 3. Session Time 설정(제한시간 설정)
		// => 메서드 활용
		session.setMaxInactiveInterval(10); // 단위 : 초/1시간(60*60)
		// => 설정파일 활용(web.xml)
		// Tag session-config 의 subTag session-timeout 
		
		// 4. Session 무효화(종료)
		// => invalidate : 무효화
		// 세션객체 자체를 소멸시키는것이 아니라, 세션을 초기화하고 무효화시킴.
		// session 이 null 이 아니고 session = ""
		
		// => 쿼리스트링으로 테스트 ( ~~/session?jCode=D )
		// => 주의 : jCode라는 Parameter가 없는 경우 null을 return
		//          -> NullPointerException 예방 하도록 작성 해야함
		if("D".equals(request.getParameter("jCode"))) {
			session.invalidate();
			System.out.println("** session 무효화 성공 **");
			out.print("<h2>** Session이 종료되었습니다.**</h2>");
			return;
		}
		out.print("<h2>-----Session 정상 종료-----</h2>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
