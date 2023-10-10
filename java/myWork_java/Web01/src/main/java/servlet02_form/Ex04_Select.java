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
public class Ex04_Select extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex04_Select() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String job = request.getParameter("job");
		String[] interest = request.getParameterValues("interest");

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<h2 style = 'color : hotpink;'> ** Select Test ** </h2>");

		if (job != "" && interest != null) {
			out.printf("<h4>직업 : %s</h4>", job);
			out.printf("<h3>관심 분야 : %s</h3>", Arrays.toString(interest));
		} else {
			out.printf("<h4>선택 항목 없음</h4>");
		}


//		for (String s2 : interest) {
//		out.printf("<h3>관심 분야 : %s</h3>", s2);
//	}
	}

}
