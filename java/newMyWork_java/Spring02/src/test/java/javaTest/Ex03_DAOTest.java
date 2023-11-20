package javaTest;

import static org.junit.Assert.*;

import org.junit.Test;

import domain.MemberDTO;
import model.MemberDAO;

//** DAO Test 시나리오
//=> Detail 정확성 
//-> Test Data
//-> 정확한 id 를 사용하면 not null : Green_Line
//-> 없는 id 를 사용하면 null : Red_Line

//=> Insert 정확성
//-> 입력 가능한 Data 적용 : 1 return : Green_Line
// -> 입력 불가능한 Data 적용 : 0 return : Red_Line

public class Ex03_DAOTest {
	
	MemberDAO dao = new MemberDAO();
	MemberDTO dto = new MemberDTO();
	
	//@Test
	// 1) Detail 정확성
	public void detailTest() {
		dto.setId("sonny"); // 있는 data : not null, Green_line
		//dto.setId("messi"); // 없는 data : null, Red_line
		assertNotNull(dao.selectOne(dto));
		System.out.println("dto => " + dto);
	}
	
	@Test
	// 2) insert 정확성
	public void insertTest() {
		dto.setId("junit");
		dto.setPassword("12345!");
		dto.setName("유니트");
		dto.setAge(22);
		dto.setJno(9);
		dto.setInfo("junit test");
		dto.setPoint(100);
		dto.setBirthday("2023-11-03");
		dto.setRid("zzaeminy");
		dto.setUploadfile("resources/uploadImages/xxx.gif");
		// => 성공 : 1, 실패 : 0
		assertEquals(dao.insert(dto), 1);
	}

}
