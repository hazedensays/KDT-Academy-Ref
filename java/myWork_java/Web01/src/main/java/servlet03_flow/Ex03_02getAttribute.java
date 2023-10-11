package servlet03_flow;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/02get")
public class Ex03_02getAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex03_02getAttribute() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) getAttribute 처리
		
		//=> request
		String rId = (String)request.getAttribute("rId");
		String rName = (String)request.getAttribute("rName");
		// => "rAge"가 존재하지 않아서 null을 return하면 Exception 발생
		//		그러므로 Test를 위해 String으로 처리
		// int rAge = (Integer)request.getAttribute("rAge");
		String rAge = (String)request.getAttribute("rAge");
		
		// => session
		String sId = (String)request.getSession().getAttribute("sId");
		String sName = (String)request.getSession().getAttribute("sName");		
		String sAge = (String)request.getSession().getAttribute("sAge");
		
		// 2) View
	      response.setContentType("text/html; charset=UTF-8");
	      PrintWriter out = response.getWriter();
	      out.print("<h2>** 1) Parameter 값 확인 **</h2>");
	      out.print("<h3>=> request객체에 담겨있는 Parameter값이 유지되고 있는지 확인</h3>");
	      out.print("<h3> ID  : "+request.getParameter("id")+"</h3>");
	      out.print("<h3> Name : "+request.getParameter("name")+"</h3>");
	      out.print("<h3> Age  : "+request.getParameter("age")+"</h3>");
	      
	      out.print("<h2>** 2) request.getAttribute 값 확인 **</h2>");
	      out.print("<h3> rID : "+rId+"</h3>");
	      out.print("<h3> rName: "+rName+"</h3>");
	      out.print("<h3> rAge : "+rAge+"</h3>"); 
	      
	      out.print("<h2>** 3) session.getAttribute 값 확인 **</h2>");
	      out.print("<h3> sID : "+sId+"</h3>");
	      out.print("<h3> sName: "+sName+"</h3>");
	      out.print("<h3> sAge : "+sAge+"</h3>"); 

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
