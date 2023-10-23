package mvcTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/delete")
public class MVC2_sDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MVC2_sDelete() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청분석 & Service
		// => 삭제할 대상 (request의 Parameter로 전달됨
		StudentService service = new StudentService();
		StudentDTO dto = new StudentDTO();

		int sno = Integer.parseInt(request.getParameter("sno"));
		
		dto.setSno(sno);
//		service.delete(dto);
		
		// 2.결과
		// => 삭제 성공
		if(service.delete(dto)>0) {
			request.setAttribute("message", "삭제성공");
			
		}else {
			request.setAttribute("message", "삭제실패");
		}
		
		request.getRequestDispatcher("list2").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
