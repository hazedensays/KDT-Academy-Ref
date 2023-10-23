package servlet02_form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/check")
public class Ex03_check extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Ex03_check() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청분석
		String gift[] = request.getParameterValues("gift");
		
		// 2. Service 처리
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h1 style='color:blue'>당신의 선택은 ~!</h1>");
		
		if(gift==null) {
			out.print("<h2>선택항목 없음</h2>");
		}else {
			for(String g:gift) {
				out.printf("<h2>%s</h2>",g);
			}
		}

	}



}
