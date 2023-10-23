package controllerM;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MemberDTO;
import service.MemberService;

@WebServlet("/detail")
public class MVC2_mDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MVC2_mDetail() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) 요청 분석 & Service
		// => 검색 대상의 id(sno) 필요 -> 로그인 시 sno id(sno) 보관해둠
		String id = (String)request.getSession().getAttribute("loginID");
		
		MemberService service = new MemberService();
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto = service.selectOne(dto);

		// 2) View 준비
		// => 결과를 View가 인식 가능하도록 setAttribute
		// => Forward
		request.setAttribute("mDetail", dto);
		request.getRequestDispatcher("member/memberDetail.jsp").forward(request, response);

	}//doGet

}//class MVC2_sDetail
