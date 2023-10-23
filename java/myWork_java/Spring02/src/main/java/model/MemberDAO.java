package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import domain.MemberDTO;

//** DAO(Data Access Object)
//=> SQL 구문 처리
//=> CRUD 구현 
// Create(Insert), Read(selectList, selectOne), Update, Delete

@Repository
public class MemberDAO {
	// ** 전역변수 정의 ==============================================================
	private static Connection cn = DBConnection.getConnection();
	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;
	private static String sql;

	// ** selectList ==============================================================
	public List<MemberDTO> selectList() {
		sql = "select * from member";
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		// MemberDTO dto = new MemberDTO();
		// => 현재 위치에서 위 코드를 작성할 경우 MemberDTO dto가 하나만 생성되기 때문에
		// 제일 마지막 입력된 데이터 값만 출력됨

		try {
			st = cn.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				// => selectList 결과 존재
				// => 결과를 list에 담기 (list = rs; -> 불가능 : 1 Row 단위로 옮겨야 함)
				// -> 1 Row는 MemberDTO Type
				do {
					MemberDTO dto = new MemberDTO();
					// => 현재 위치에서 위 코드를 작성할 경우 MemberDTO dto를 데이터값이 존재할 때마다
					// 생성되기 때문에 모든 데이터 값을 출력할 수 있음
					dto.setId(rs.getString(1));
					dto.setPassword(rs.getString(2));
					dto.setName(rs.getString(3));
					dto.setAge(rs.getInt(4));
					dto.setJno(rs.getInt(5));
					dto.setInfo(rs.getString(6));
					dto.setPoint(rs.getDouble(7));
					dto.setBirthday(rs.getString(8));
					dto.setRid(rs.getString(9));
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
	public MemberDTO selectOne(MemberDTO dto) {
		sql = "select * from member where id = ?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, dto.getId());

			rs = pst.executeQuery();

			if (rs.next()) {
				// => data 존재 (rs을 dto에 담아서 return)
				dto.setPassword(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setAge(rs.getInt(4));
				dto.setJno(rs.getInt(5));
				dto.setInfo(rs.getString(6));
				dto.setPoint(rs.getDouble(7));
				dto.setBirthday(rs.getString(8));
				dto.setRid(rs.getString(9));

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
	public int insert(MemberDTO dto) {
		sql = "insert into member values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			pst = cn.prepareStatement(sql);

			pst.setString(1, dto.getId());
			pst.setString(2, dto.getPassword());
			pst.setString(3, dto.getName());
			pst.setInt(4, dto.getAge());
			pst.setInt(5, dto.getJno());
			pst.setString(6, dto.getInfo());
			pst.setDouble(7, dto.getPoint());
			pst.setString(8, dto.getBirthday());
			pst.setString(9, dto.getRid());

			// int count = pst.executeUpdate();
			// return count;
			return pst.executeUpdate(); // "처리 개수"를 따로 변수에 담지 않고 바로 return
		} catch (Exception e) {
			System.out.println("** insert Exception => " + e.toString());
			return 0;
		}
	}// insert

	// ** update ==============================================================
	// => info, point, birthday 수정, sno = 26번
	public int update(MemberDTO dto) {
		sql = "update member set naem = ?, age = ?, jno = ?, info = ?, point = ?, birthday = ?, rid = ? where id = ?";

		try {
			pst = cn.prepareStatement(sql);

			pst.setString(1, dto.getId());
			pst.setString(2, dto.getPassword());
			pst.setString(3, dto.getName());
			pst.setInt(4, dto.getAge());
			pst.setInt(5, dto.getJno());
			pst.setString(6, dto.getInfo());
			pst.setDouble(7, dto.getPoint());
			pst.setString(8, dto.getBirthday());
			pst.setString(9, dto.getRid());

			return pst.executeUpdate(); // 처리 개수
		} catch (Exception e) {
			System.out.println("** update Exception => " + e.toString());
			return 0;
		}
	} // update

	// ** delete ==============================================================
	public int delete(MemberDTO dto) {
		sql = "delete from member where id = ?";

		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, dto.getId());

			return pst.executeUpdate(); // 처리 개수
		} catch (Exception e) {
			System.out.println("** delete Exception => " + e.toString());
			return 0;
		}
	} // delete

}
