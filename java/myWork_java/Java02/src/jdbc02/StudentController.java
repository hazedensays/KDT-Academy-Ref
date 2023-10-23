package jdbc02;

import java.util.List;

//** Controller
//=> 요청 : 요청분석 -> 담당 Service -> Service 는 DAO 
//=> 결과 : DAO -> Service -> Controller
//=> View : Controller -> View 담당 (Java:Console // Web:JSP, HTML.., React) 

public class StudentController {
	// ** 전역변수 정의 =================================================================
	StudentService service = new StudentService();
	
	// ** View 역할 메서드 ==============================================================
	public void printList(List<StudentDTO> list) {
		System.out.println("================= ** StudentList ** =================");
		
		if (list != null) {
			// => list 출력
			for (StudentDTO s:list) {
				System.out.println(s);
			}
		} else {
			System.out.println("** selectList : 출력 data가 존재하지 않음");
		}
	} // printList
	
	// => selectOne 호출 =============================================================
	public void printDetail(StudentDTO dto) {
		System.out.println("================= ** StudentList ** =================");
		
		if (dto != null) {
			System.out.println(dto);
		} else {
			System.out.println("** selectOne : 출력 data가 존재하지 않음");
		}
	}//printDetail
	
	// => groupList 호출 =============================================================
	public void printGroup(List<GroupDTO > list) {
		System.out.println("================= ** GroupList ** =================");
		
		if (list != null) {
			for (GroupDTO g:list) {
				System.out.println(g);
			}
		} else {
			System.out.println("** GroupList : 출력 data가 존재하지 않음");
		}
	} //printGroup
	
	public static void main(String[] args) {
		// StudentController 인스턴스 생성 ================================================
		StudentController sc = new StudentController();
		
		/* Transaction 확인을 위한 주석 처리
		 
		// ** StudentList ==============================================================
		// =>  요청에 해당하는 service.selectList() 메서드 실행
		// =>  위의 결과를 view에 처리하도록 전달
		sc.printList(sc.service.selectList());
		
		// ** Student_Detail ===========================================================
		StudentDTO dto = new StudentDTO();
		dto.setSno(22);
		sc.printDetail(sc.service.selectOne(dto));
		
		// ** Group 적용 ===============================================================
		sc.printGroup(sc.service.groupList());
		
		// ** insert ===================================================================
		// => dto에 입력값 담기 -> Service(-> DAO) -> 결과 출력
		dto.setName("바나나");
		dto.setAge(30);
		dto.setJno(7);
		dto.setInfo("== ** InsertTest ** ==");
		
		if (sc.service.insert(dto) > 0) {
			System.out.println("** insert 성공 **");
		} else {
			System.out.println("** insert 실패 **");
		}
		
		// ** update ==================================================================
		// => info, point, birthday 수정, sno = 26번
		dto.setSno(26);
		dto.setPoint(123.456);
		dto.setBirthday("2000-09-09");
		if (sc.service.update(dto) > 0) {
			System.out.println("** update 성공 & 확인 **");
			sc.printDetail(sc.service.selectOne(dto));
		} else {
			System.out.println("** update 실패 **");
		}
		
		// ** delete ===================================================================
		dto.setSno(26);
		if (sc.service.delete(dto) > 0) {
			System.out.println("** delete 성공 & 확인 **");
			sc.printDetail(sc.service.selectOne(dto));
		} else {
			System.out.println("** delete 실패 **");
		}
		
		*/
		
		// ** transaction  ==============================================================
		// => JDBC에서 적용 전/후 비교
		// => JDBC : Connection 객체가 관리
		//						기본값은 AutoCommit -> True
		//						setAutoCommit(false) -> Commit 또는 rollback
		
		// => 적용 전
		sc.service.transactionTest();
		
		// => 적용 후	
		
		
		
		
		
		
	}
	
} //StudentController
