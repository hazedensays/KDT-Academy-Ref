package controllerF;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MemberDTO;
import service.MemberService;

public class Ex05_MDetail implements Ex04_Controller {
	
	@Override
	public String doUser(HttpServletRequest request, HttpServletResponse response) {
		// ** Member Detail
		MemberService service = new MemberService();
		MemberDTO vo = new MemberDTO();
		vo.setId((String)request.getSession().getAttribute("loginID"));
		
		request.setAttribute("mDetail", service.selectOne(vo));
		return "member/memberDetail.jsp";
	} //doUser

} //class
