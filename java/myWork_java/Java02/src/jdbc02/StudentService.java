package jdbc02;

import java.util.List;

public class StudentService {
	// ** 전역변수 정의
	StudentDAO dao = new StudentDAO();
	
	// ** selectList
	public List<StudentDTO> selectList() {
		return dao.selectList();
	}
	
	// ** selectOne
	public StudentDTO selectOne(StudentDTO sVO) {
		return dao.selectOne(sVO);
	}
	
	// ** Group 적용
	public List<GroupDTO> groupList() {
		return dao.groupList();
	}
	
	// ** insert
	public int insert(StudentDTO dto) {
		return dao.insert(dto);
	}
	
	// ** update
	public int update(StudentDTO dto) {
		return dao.update(dto);
	}
	
	// ** delete
	public int delete(StudentDTO dto) {
		return dao.delete(dto);
	}
	
	// ** Transaction Test
	public void transactionTest() {
		dao.transactionTest();
	}
	
} // StudentService
