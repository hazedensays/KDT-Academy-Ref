package servlet02_form;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/select")
public class Ex04_select extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Ex04_select() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청분석
		String job = request.getParameter("job");
		String[] interest =request.getParameterValues("interest");
		
		// 2. Service 처리
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(interest!=null && job!="") {
			out.printf("<h3>직업은 %s고 좋아하는 디저트는 %s입니다.</h3>",job,Arrays.toString(interest));
		}else {
			out.print("<h2>두 항목을 모두 선택하시오</h2>");
		}
		
		

	}



}
