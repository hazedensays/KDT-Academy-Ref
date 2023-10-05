package jdbc02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc01.DBConnection;

//** DAO(Data Access Object)
//=> SQL 구문 처리
//=> CRUD 구현 
// Create(Insert), Read(selectList, selectOne), Update, Delete

//=> 첫번째 예제 Ex01_~~~ 와 DAO 와 다른점
//  - 요청 처리 결과를 제공
// - 즉, 메서드의 역할별로 처리 결과를 return 해야 함
// - 그러므로 특히 select 결과를 전달하기 위해 결과를 담는 작업이 필요함  

public class StudentDAO {
	// ** 전역변수 정의 ==============================================================
	private static Connection cn = DBConnection.getConnection();
	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;
	private static String sql;
	
	// ** selectList ==============================================================
	public List<StudentVO> selectList() {
		sql = "select * from student";
		List<StudentVO> list = new ArrayList<StudentVO>();
		// StudentVO sVO = new StudentVO();
		// => 현재 위치에서 위 코드를 작성할 경우 StudentVO sVO가 하나만 생성되기 때문에
		//		제일 마지막 입력된 데이터 값만 출력됨
		
		try {
			st = cn.createStatement();
			rs = st.executeQuery(sql);
			
			if (rs.next()) {
			// => selectList 결과 존재
			// => 결과를 list에 담기 (list = rs; -> 불가능 : 1 Row 단위로 옮겨야 함)
			//										 -> 1 Row는 StudentVO Type	
				do {
					StudentVO sVO = new StudentVO();
					// => 현재 위치에서 위 코드를 작성할 경우 StudentVO sVO를 데이터값이 존재할 때마다
					//		생성되기 때문에 모든 데이터 값을 출력할 수 있음
					sVO.setSno(rs.getInt(1));  // rs.getInt로 꺼내면서 바로 sVO에 담아주기
					sVO.setName(rs.getString(2));
					sVO.setAge(rs.getInt(3));
					sVO.setJno(rs.getInt(4));
					sVO.setInfo(rs.getString(5));
					sVO.setPoint(rs.getFloat(6));
					sVO.setBirthday(rs.getString(7));
					list.add(sVO);
				} while(rs.next());
			} else {
				list = null;
			}
			
		} catch (Exception e) {
			System.out.println("** selectList Exception => " + e.toString());
			list = null;
		}
		return list;
	} // selectList
	
	// ** selectOne ==============================================================
	public StudentVO selectOne(StudentVO sVO) {
		sql = "select * from student where sno = ?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, sVO.getSno());
			
			rs = pst.executeQuery();
			
			if (rs.next()) {
				// => data 존재 (rs을 sVO에 담아서 return)
				sVO.setName(rs.getString(2));
				sVO.setAge(rs.getInt(3));
				sVO.setJno(rs.getInt(4));
				sVO.setInfo(rs.getString(5));
				sVO.setPoint(rs.getFloat(6));
				sVO.setBirthday(rs.getString(7));
				
				return sVO;
			} else {
				System.out.println("** selectOne : 출력 data가 존재하지 않음");
				return null;
			}
		} catch (Exception e) {
			System.out.println("** selectOne Exception => " + e.toString());
			return null;
		}
	} // selectOne
	
	// ** Group 적용 ==============================================================
	public List<GroupDTO> groupList() {
		sql = "select jno, count(*), sum(age), avg(age), max(age), min(age) from student Group by jno Order by jno";
		
		List<GroupDTO> list = new ArrayList<>();
		try {
			pst = cn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			if (rs.next()) {
				do {
					GroupDTO dto = new GroupDTO();
					dto.setJno(rs.getInt(1));
					dto.setCount(rs.getInt(2));
					dto.setSum(rs.getInt(3));
					dto.setAvg(rs.getDouble(4));
					dto.setMax(rs.getInt(5));
					dto.setMin(rs.getInt(6));
					
					list.add(dto);
				} while (rs.next());
			} else {
				list = null;
			}
		} catch (Exception e) {
			System.out.println("** groupList Exception => " + e.toString());
			list = null;
		}
		return list;
	} //groupList
	
	
	
	// ** insert ==============================================================
	
	// ** update ==============================================================
}
