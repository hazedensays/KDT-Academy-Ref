package mvcTest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/detail")
public class MVC2_sDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MVC2_sDetail() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.요청분석 & Service
		// => 검색 대상의 id(login한 sno) 필요
		int sno = (Integer)request.getSession().getAttribute("loginID");
		StudentService service = new StudentService();
		StudentDTO dto = new StudentDTO();
		dto.setSno(sno);
		dto = service.selectOne(dto);
		
		// 2. View준비
		// => 결과를 View가 인식 가능하도록 setAttribute
		// => View로 넘어가기(forward)
		request.setAttribute("loginUser", dto);
		request.getRequestDispatcher("jsp99_mvcTest/mvc2_sDetail.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
