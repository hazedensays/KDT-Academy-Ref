package servlet02_form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/radio")
public class Ex02_Radio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Ex02_Radio() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청분석
		String gender = request.getParameter("gender");
		String mailcheck = request.getParameter("mailcheck");
		String content = request.getParameter("content");
		
		// 2. Service 처리
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.printf("<h3>성별 : %s, 메일수신 : %s</h3><hr>",gender,mailcheck);
		out.println("<strong>"+content+"</strong>");
	}



}
