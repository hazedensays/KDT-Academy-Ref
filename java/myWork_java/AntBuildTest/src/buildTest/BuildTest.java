package buildTest;

import com.ncs.domain.UserDTO;
import com.ncs.green.service.DTOService;

public class BuildTest {

	public static void main(String[] args) {
		// 1) UserDTO 생성
		UserDTO dto = new UserDTO();
		dto.setId("apple");
		dto.setName("신애플");
		dto.setLoginTime("2023/11/03/pm 5:34");

		// 2) 직접 출력
		System.out.println("** 직접 출력 => " + dto);

		// 3) DTOService로 출력
		DTOService service = new DTOService();
		service.setUserDTO(dto);
		System.out.println("** jar 사용 Test **");
		System.out.println("** DTOService => " + service.getUserDTO());

	}

}
