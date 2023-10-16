package mvcTest;

import java.io.IOException;
import java.util.List;

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
		// 1) 요청 분석 & Service
		// => 검색 대상의 id(sno) 필요 -> 로그인 시 sno id(sno) 보관해둠
		int sno = (Integer)request.getSession().getAttribute("loginID");
		
		StudentService service = new StudentService();
		StudentDTO dto = new StudentDTO();
		dto.setSno(sno);
		dto = service.selectOne(dto);

		// 2) View 준비
		// => 결과를 View가 인식 가능하도록 setAttribute
		// => Forward
		request.setAttribute("apple", dto);
		request.getRequestDispatcher("jsp99_mvcTest/mvc2_sDetail.jsp").forward(request, response);
		
		
		
		
	}//doGet

}//class MVC2_sDetail
