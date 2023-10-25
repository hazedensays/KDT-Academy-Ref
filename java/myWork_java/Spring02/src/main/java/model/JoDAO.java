package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import domain.JoDTO;

@Repository
public class JoDAO {
	// ** 전역변수 정의 ==============================================================
	private static Connection cn = DBConnection.getConnection();
	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;
	private static String sql;

	// ** selectList ==============================================================
	public List<JoDTO> selectList() {
		sql = "select * from jo order by jno desc";
		List<JoDTO> list = new ArrayList<JoDTO>();

		try {
			st = cn.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				do {
					JoDTO dto = new JoDTO();
					dto.setJno(rs.getInt(1));
					dto.setJname(rs.getString(2));
					dto.setId(rs.getString(3));
					dto.setProject(rs.getString(4));
					dto.setSlogan(rs.getString(5));
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
	public JoDTO selectOne(JoDTO dto) {
		sql = "select * from jo where jno = ?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, dto.getJno());

			rs = pst.executeQuery();

			if (rs.next()) {
				// => data 존재 (rs을 dto에 담아서 return)
				dto.setJname(rs.getString(2));
				dto.setId(rs.getString(3));
				dto.setProject(rs.getString(4));
				dto.setSlogan(rs.getString(5));

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
	// => 입력 컬럼 : jno, jname, id, project, slogan

	public int insert(JoDTO dto) {
		sql = "insert into jo(jno, jname, id, project, slogan) values(?, ?, ?, ?, ?)";

		try {
			pst = cn.prepareStatement(sql);

			pst.setInt(1, dto.getJno());
			pst.setString(2, dto.getJname());
			pst.setString(3, dto.getId());
			pst.setString(4, dto.getProject());
			pst.setString(5, dto.getSlogan());

			return pst.executeUpdate(); // "처리 개수"를 따로 변수에 담지 않고 바로 return
		} catch (Exception e) {
			System.out.println("** insert Exception => " + e.toString());
			return 0;
		}
	}// insert

	// ** update ==============================================================
	// => jname, id, project, slogan만 수정 가능
	
	public int update(JoDTO dto) {
		sql = "update jo set jname = ?, id = ?, project = ?, slogan = ? where jno = ?";

		try {
			pst = cn.prepareStatement(sql);

			pst.setString(1, dto.getJname());
			pst.setString(2, dto.getId());
			pst.setString(3, dto.getProject());
			pst.setString(4, dto.getSlogan());
			pst.setInt(5, dto.getJno());

			return pst.executeUpdate(); // 처리 개수
		} catch (Exception e) {
			System.out.println("** update Exception => " + e.toString());
			return 0;
		}
	} // update

	// ** delete ==============================================================
	public int delete(JoDTO dto) {
		sql = "delete from jo where jno = ?";

		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, dto.getJno());

			return pst.executeUpdate(); // 처리 개수
		} catch (Exception e) {
			System.out.println("** delete Exception => " + e.toString());
			return 0;
		}
	} // delete

}
