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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1) 요청 분석 & Service
		// => 삭제할 대상 (request의 Parameter로 전달됨)
		int sno = Integer.parseInt(request.getParameter("sno"));
		StudentService service = new StudentService();
		StudentDTO dto = new StudentDTO();
		dto.setSno(sno);
		//service.delete(dto);
		
		// 2) 결과
		// => 삭제 성공/실패 : list 출력 (-> MVC2_sList(/list2)로 Forward)
		// => message 출력
		// int count = service.delete(dto); -> 굳이 변수에 담지 않아도 됨
		if (service.delete(dto) > 0) {
			// 성공
			request.setAttribute("message", sno + "님의 정보가 삭제되었습니다.");
		} else {
			request.setAttribute("message", sno + "님, 다시 삭제를 시도하세요.");
		}
		
		request.getRequestDispatcher("list2").forward(request, response);
		
	}// doGet

}// class MVC2_sDelete
