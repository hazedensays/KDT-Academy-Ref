package servlet02_form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/check")
public class Ex03_CheckBox extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Ex03_CheckBox() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] gift = request.getParameterValues("gift");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<h2 style = 'color : hotpink;'> ** CheckBox Test ** </h2>");

		out.print("<h3> 당신의 선택은?</h3>");
		if (gift != null && gift.length > 0) {
			for (String s : gift) {
				out.printf("<h4>%s</h4>", s);
			}
		} else {
			out.printf("<h4>선택 항목 없음</h4>");
		}

	}


}
