package jdbc02;

import java.util.List;

//** Controller
//=> 요청 : 요청분석 -> 담당 Service -> Service 는 DAO 
//=> 결과 : DAO -> Service -> Controller
//=> View : Controller -> View 담당 (Java:Console // Web:JSP, HTML.., React) 

public class StudentController {
	// ** 전역변수 정의
	StudentService service = new StudentService();
	
	// ** View 역할 메서드
	public void printList(List<StudentVO> list) {
		System.out.println("================= ** StudentList ** =================");
		
		if (list != null) {
			// => list 출력
			for (StudentVO s:list) {
				System.out.println(s);
			}
		} else {
			System.out.println("** selectList : 출력 data가 존재하지 않음");
		}
	} // printList
	
	// => selectOne 호출
	public void printDetail(StudentVO sVO) {
		System.out.println("================= ** StudentList ** =================");
		
		if (sVO != null) {
			System.out.println(sVO);
		} else {
			System.out.println("** selectOne : 출력 data가 존재하지 않음");
		}
	}//printDetail
	
	// => groupList 호출
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
		// StudentController 인스턴스 생성
		StudentController sc = new StudentController();
		
		// ** StudentList
		// =>  요청에 해당하는 service.selectList() 메서드 실행
		// =>  위의 결과를 view에 처리하도록 전달
		sc.printList(sc.service.selectList());
		
		// ** Student_Detail
		StudentVO sVO = new StudentVO();
		sVO.setSno(22);
		sc.printDetail(sc.service.selectOne(sVO));
		
		// ** Group 적용
		sc.printGroup(sc.service.groupList());
		
		
	}
} //StudentController
