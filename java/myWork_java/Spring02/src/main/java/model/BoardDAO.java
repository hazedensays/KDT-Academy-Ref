package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import domain.BoardDTO;

//** DAO(Data Access Object)
//=> SQL 구문 처리
//=> CRUD 구현 
// Create(Insert), Read(selectList, selectOne), Update, Delete

@Repository
public class BoardDAO {
	// ** 전역변수 정의 ==============================================================
	private static Connection cn = DBConnection.getConnection();
	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;
	private static String sql;
	
	// ** replyInsert ==============================================================
	// => 댓글등록, seq는 IFNULL 이용
	// => stepUpdate 가 필요함
	//    댓글 입력 성공후 실행
	//     -> 현재 입력된 답글의 step 값은 수정되지 않도록 sql 구문의 조건 주의    
	// => JDBC subQuery 구문 적용시 주의사항
	//     -> MySql: select 구문으로 한번더 씌워 주어야함 (insert 의 경우에도 동일)
	public int rinsert(BoardDTO dto) {
		sql="insert into board(seq,id,title,content,root,step,indent)"
				+ "values((select * from(select IFNULL(max(seq),0)+1 from board) as temp)"
				+ ",?,?,?,?,?,?)";
		
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, dto.getId());
			pst.setString(2, dto.getTitle());
			pst.setString(3, dto.getContent());
			pst.setInt(4, dto.getRoot());
			pst.setInt(5, dto.getStep());
			pst.setInt(6, dto.getIndent());
			
			pst.executeUpdate(); //댓글 입력 성공 -> stepUpdate
			System.out.println("** stepUpdate Count => " + stepUpdate(dto));
			// => 만약 rinsert도중 오류 발생시에는 catch블럭으로 이동
			return 1;
		} catch (Exception e) {
			System.out.println("** Reply_Insert Exception => " + e.toString());
			return 0;
		}
	}
	
	// ** step 값 증가
	public int stepUpdate(BoardDTO dto) {
		sql ="update board set step=step+1 where root=? and step>=? "
	            + "and seq <> (select * from (select IFNULL(max(seq),0)from board) as temp)";
		try {
			pst=cn.prepareStatement(sql);
			pst.setInt(1, dto.getRoot());
			pst.setInt(2, dto.getStep());
			
			return pst.executeUpdate(); //수정된 data 개수 return
		} catch (Exception e) {
			System.out.println("**stepUpdate Exception => " + e.toString());
			return 0;
		}
	}
	
	// ** selectList ==============================================================
	public List<BoardDTO> selectList() {
		sql = "select * from board order by root desc, step asc;";
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		// BoardDTO dto = new BoardDTO();
		// => 현재 위치에서 위 코드를 작성할 경우 BoardDTO dto가 하나만 생성되기 때문에
		// 제일 마지막 입력된 데이터 값만 출력됨

		try {
			st = cn.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				// => selectList 결과 존재
				// => 결과를 list에 담기 (list = rs; -> 불가능 : 1 Row 단위로 옮겨야 함)
				// -> 1 Row는 BoardDTO Type
				do {
					BoardDTO dto = new BoardDTO();
					// => 현재 위치에서 위 코드를 작성할 경우 BoardDTO dto를 데이터값이 존재할 때마다
					// 생성되기 때문에 모든 데이터 값을 출력할 수 있음
					dto.setSeq(rs.getInt(1));
					dto.setId(rs.getString(2));
					dto.setTitle(rs.getString(3));
					//dto.setContent(rs.getString(4));
					dto.setRegdate(rs.getString(5));
					dto.setCnt(rs.getInt(6));
					dto.setRoot(rs.getInt(7));
					dto.setStep(rs.getInt(8));
					dto.setIndent(rs.getInt(9));
					
					list.add(dto);
				} while (rs.next());
			} else {
				list = null;
			}

		} catch (Exception e) {
			System.out.println("** Board selectList Exception => " + e.toString());
			list = null;
		}
		return list;
	} // selectList

	// ** selectOne ==============================================================
	public BoardDTO selectOne(BoardDTO dto) {
		sql = "select * from board where seq = ?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, dto.getSeq());

			rs = pst.executeQuery();

			if (rs.next()) {
				// => data 존재 (rs을 dto에 담아서 return)
				dto.setId(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegdate(rs.getString(5));
				dto.setCnt(rs.getInt(6));
				dto.setRoot(rs.getInt(7));
				dto.setStep(rs.getInt(8));
				dto.setIndent(rs.getInt(9));

				return dto;
			} else {
				System.out.println("** Board selectOne : 출력 data가 존재하지 않음");
				return null;
			}
		} catch (Exception e) {
			System.out.println("** Board selectOne Exception => " + e.toString());
			return null;
		}
	} // selectOne

	// ** insert ==============================================================
	// => 입력 컬럼 : id, title, content
	//    default 값 : regdate, cnt
	// => Auto_Inc : seq (계산 : auto보다 max(seq)를 이용해서 직접 계산)
	
	// 댓글 입력 추가 후에는 수정해야 함 (root_seq와 동일한 값 추가)
	public int insert(BoardDTO dto) {
		// 댓글 입력 전
//		sql = "insert into board(seq, id, title, content) values ("
//				 + "(select * from (select IFNULL(max(seq), 0) + 1 from board) as temp)" // seq값
//				 // (select IFNULL(max(seq), 0) + 1 from board)의 값이 어차피 1개만 리턴되기 때문에
//				 // select ALL(*) 하는 것이 가능하고
//				 // 테이블의 형태로 리턴되기 때문에 엘리어스(temp)를 필수적으로 붙여줘야 함.
//				 + ", ?, ?, ?)";

		// 댓글 입력 후
		sql = "insert into board(seq, id, title, content, root) values ("
		 + "(select * from (select IFNULL(max(seq), 0) + 1 from board) as temp)" // seq값
		 + ", ?, ?, ?,"
		 + "(select * from (select IFNULL(max(seq), 0) + 1 from board) as temp))"; // seq와 동일한 root값
		
		try {
			pst = cn.prepareStatement(sql);

			pst.setString(1, dto.getId());
			pst.setString(2, dto.getTitle());
			pst.setString(3, dto.getContent());

			return pst.executeUpdate(); // "처리 개수"를 따로 변수에 담지 않고 바로 return
		} catch (Exception e) {
			System.out.println("** insert Exception => " + e.toString());
			return 0;
		}
	}// insert

	// ** update ==============================================================
	// => title, content만 수정 가능
	public int update(BoardDTO dto) {
		sql = "update board set title = ?, content = ?, cnt = ? where seq = ?";

		try {
			pst = cn.prepareStatement(sql);

			pst.setString(1, dto.getTitle());
			pst.setString(2, dto.getContent());
			pst.setInt(3, dto.getCnt());
			pst.setInt(4, dto.getSeq());

			return pst.executeUpdate(); // 처리 개수
		} catch (Exception e) {
			System.out.println("** update Exception => " + e.toString());
			return 0;
		}
	} // update

	// ** delete ==============================================================
	public int delete(BoardDTO dto) {
		sql = "delete from board where seq = ?";

		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, dto.getSeq());

			return pst.executeUpdate(); // 처리 개수
		} catch (Exception e) {
			System.out.println("** delete Exception => " + e.toString());
			return 0;
		}
	} // delete

}
