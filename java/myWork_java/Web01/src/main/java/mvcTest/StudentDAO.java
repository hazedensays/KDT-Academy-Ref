package mvcTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	public List<StudentDTO> selectList() {
		sql = "select * from student";
		List<StudentDTO> list = new ArrayList<StudentDTO>();
		// StudentDTO dto = new StudentDTO();
		// => 현재 위치에서 위 코드를 작성할 경우 StudentDTO dto가 하나만 생성되기 때문에
		// 제일 마지막 입력된 데이터 값만 출력됨

		try {
			st = cn.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				// => selectList 결과 존재
				// => 결과를 list에 담기 (list = rs; -> 불가능 : 1 Row 단위로 옮겨야 함)
				// -> 1 Row는 StudentDTO Type
				do {
					StudentDTO dto = new StudentDTO();
					// => 현재 위치에서 위 코드를 작성할 경우 StudentDTO dto를 데이터값이 존재할 때마다
					// 생성되기 때문에 모든 데이터 값을 출력할 수 있음
					dto.setSno(rs.getInt(1)); // rs.getInt로 꺼내면서 바로 dto에 담아주기
					dto.setName(rs.getString(2));
					dto.setAge(rs.getInt(3));
					dto.setJno(rs.getInt(4));
					dto.setInfo(rs.getString(5));
					dto.setPoint(rs.getFloat(6));
					dto.setBirthday(rs.getString(7));
					list.add(dto);
				} while (rs.next());
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
	public StudentDTO selectOne(StudentDTO dto) {
		sql = "select * from student where sno = ?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, dto.getSno());

			rs = pst.executeQuery();

			if (rs.next()) {
				// => data 존재 (rs을 dto에 담아서 return)
				dto.setName(rs.getString(2));
				dto.setAge(rs.getInt(3));
				dto.setJno(rs.getInt(4));
				dto.setInfo(rs.getString(5));
				dto.setPoint(rs.getFloat(6));
				dto.setBirthday(rs.getString(7));

				return dto;
			} else {
				System.out.println("** selectOne : 출력 data가 존재하지 않음");
				return null;
			}
		} catch (Exception e) {
			System.out.println("** selectOne Exception => " + e.toString());
			return null;
		}
	} // selectOne

	// ** insert ==============================================================
	// => 입력 컬럼 : name, age, jno, info
	public int insert(StudentDTO dto) {
		sql = "insert into student (name, age, jno, info) values (?, ?, ?, ?)";

		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, dto.getName());
			pst.setInt(2, dto.getAge());
			pst.setInt(3, dto.getJno());
			pst.setString(4, dto.getInfo());

			// int count = pst.executeUpdate();
			// return count;
			return pst.executeUpdate(); // "처리 개수"를 따로 변수에 담지 않고 바로 return
		} catch (Exception e) {
			System.out.println("** insert Exception => " + e.toString());
			return 0;
		}
	}

	// ** update ==============================================================
	// => info, point, birthday 수정, sno = 26번
	public int update(StudentDTO dto) {
		sql = "update student set info = ?, point = ?, birthday = ? where sno = ?";

		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, dto.getInfo());
			pst.setDouble(2, dto.getPoint());
			pst.setString(3, dto.getBirthday());
			pst.setInt(4, dto.getSno());

			return pst.executeUpdate(); // 처리 개수
		} catch (Exception e) {
			System.out.println("** update Exception => " + e.toString());
			return 0;
		}
	} // update

	// ** delete ==============================================================
	public int delete(StudentDTO dto) {
		sql = "delete from student where sno = ?";

		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, dto.getSno());

			return pst.executeUpdate(); // 처리 개수
		} catch (Exception e) {
			System.out.println("** delete Exception => " + e.toString());
			return 0;
		}
	} // delete

	// ** transaction ==============================================================
	// => 기본값은 AutoCommit true 임.
	// => setAutoCommit(false) -> commit 또는 rollback
	// => Test 사항
	// - 동일자료를 2번 입력 -> 2번째 입력에서 p.key 중복 오류발생

	// 1) Transaction 적용 전
	// => 동일자료를 2번 입력
	// - 1번째는 입력완료 되고, 2번째 입력에서 p.key 중복 오류발생
	// - Rollback 불가능
	// - MySql Command 로 1번째 입력 확인 가능

	// 2) Transaction 적용 후
	// => 동일자료를 2번 입력
	// - 1번째는 입력완료 되고, 2번째 입력에서 p.key 중복 오류발생
	// - Rollback 가능 -> 둘다 취소됨

	public void transactionTest() {
		sql = "insert into student(sno, name, age, jno, info) values (26, '오렌지', 20, 7, 'transaction')";

		/*
		// 1) Transaction 적용 전
		try {
			pst = cn.prepareStatement(sql);
			pst.executeUpdate();		// 첫번째는 table에 입력 완료
			pst.executeUpdate();		// 두번째는 p.key 중복 오류
		} catch (Exception e) {
			System.out.println("** Transaction 적용 전 Exception => " + e.toString());
		}
		*/
		
		// 2) Transaction 적용 후
		try {
			cn.setAutoCommit(false);  // MySQL의 start Transaction; 과 같음
			pst = cn.prepareStatement(sql);
			pst.executeUpdate();		// 첫번째는 Buffer에 입력 완료
			pst.executeUpdate();		// 두번째는 p.key 중복 오류 -> Exception -> Rollback
			cn.commit();
		} catch (Exception e) {
			System.out.println("** Transaction 적용 후 Exception => " + e.toString());
			
			// => rollback
			try {
				cn.rollback();
				System.out.println("** Rollback 성공");
			} catch (Exception e2) {
				System.out.println("** Rollback Exception => " + e.toString());
			}
		}
		
		
	} //transactionTest

}
