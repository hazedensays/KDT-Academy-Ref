package jdbc02;

import java.util.List;

public class StudentService {
	// ** 전역변수 정의
	StudentDAO dao = new StudentDAO();
	
	// ** selectList
	public List<StudentVO> selectList() {
		return dao.selectList();
	}
	
	// ** selectOne
	public StudentVO selectOne(StudentVO sVO) {
		return dao.selectOne(sVO);
	}
	
	// ** Group 적용
	public List<GroupDTO> groupList() {
		return dao.groupList();
	}
	
} // StudentService
