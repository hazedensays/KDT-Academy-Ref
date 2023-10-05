package jdbc01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ex01_StudentTest {
	// ** 전역변수 정의
	private static Connection cn = DBConnection.getConnection();
	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;
	private static String sql;

	// ** Student List
	public static void selectList() {
		// 1) Connection
		// => 전역변수로 전달받음

		// 2) SQL 구문 처리
		sql = "select * from student";
		try {
			st = cn.createStatement();
			rs = st.executeQuery(sql);

			// 3) 결과 출력
			// => select 결과 존재 여부 확인 & 출력
			// => ResultSet 객체는 이를 위한 메서드 제공
			// => next() : 다음 data가 존재하면 true, 현재 data 제공
			System.out.println("============== ** Student List  ** ==============");

			if (rs.next()) {
				// => selectList 존재
				do {
					System.out.print(rs.getInt(1) + " ");
					System.out.print(rs.getString("name") + " ");
					System.out.print(rs.getInt(3) + " ");
					System.out.print(rs.getInt(4) + " ");
					System.out.print(rs.getString(5) + " ");
					System.out.print(rs.getFloat(6) + " ");
					System.out.print(rs.getString(7) + " ");
					System.out.print(rs.getString(8) + "\n");
				} while (rs.next());
			} else {
				System.out.println("** selectList : 출력 데이터가 존재하지 않음");
			}
		} catch (Exception e) {
			System.out.println("** selectList Exception => " + e.toString());
		}
	} // selectList

	public static void joList() {
		sql = "select * from jo";
		try {
			st = cn.createStatement();
			rs = st.executeQuery(sql);

			System.out.println("============== ** Jo List  ** ==============");

			if (rs.next()) {
				do {
					System.out.print(rs.getInt(1) + " ");
					System.out.print(rs.getString("jname") + " ");
					System.out.print(rs.getInt(3) + " ");
					System.out.print(rs.getString("project") + " ");
					System.out.print(rs.getString("slogan") + "\n");
				} while (rs.next());
			} else {
				System.out.println("** joList : 출력 데이터가 존재하지 않음");
			}
		} catch (Exception e) {
			System.out.println("** joList Exception => " + e.toString());
		}
	} // joList

	// ** 조별 studentList  =============================================================
	// => 출력 jno는 매개변수로 전달
	// select sno, name, jno, point + age as bonus from student where jno = 1, 2, 3,
	// 4, 5, 7
	public static void studentList(int jno) {
		sql = "select sno, name, jno, point + age as bonus from student where jno=" + jno;
		try {
			st = cn.createStatement();
			rs = st.executeQuery(sql);

			System.out.println("============== ** studentList  ** ==============");

			if (rs.next()) {
				do {
					System.out.print(rs.getInt(1) + " ");
					System.out.print(rs.getString("name") + " ");
					System.out.print(rs.getInt(3) + " ");
					System.out.print(rs.getInt(4) + "\n");
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("** studentList Exception => " + e.toString());
		}
	} // studentList

	// ** insert  =====================================================================
	// => insert into student(name, age, jno, info) values ("홍길동", 22, 7,
	// "InsertTest");
	// => Statement로 처리하면 아래 코드와 같이 매우 복잡하고 오류 가능성 높음
	// => 따라서 위 같은 문제를 해결한 객체 : PrepareStatement 사용 (바인딩 변수 "?" 제공)
	// "insert into student values (?, ?, ?, ? , ..., ?)"
	// "?" 해결 : Query 구문 실행 전에
	public static void insert(String name, int age, int jno, String info) {
		// => 1) Statement 적용
		// sql="insert into student(name, age, jno, info) values
		// ('"+name+"',"+age+","+jno+",'"+info+"')";

		// => 2) PrepareStatement 적용
		// Statement는 쿼리문을 실행할 때 sql문을 제공하지만 PrepareStatement는 쿼리문 구문 실행 전에 미리 제공
		sql = "insert into student(name, age, jno, info) values (?, ?, ?, ?)";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, name);
			pst.setInt(2, age);
			pst.setInt(3, jno);
			pst.setString(4, info);

			int count = pst.executeUpdate();
			// executeUpdate()는 성공한 횟수를 반환
			// 따라서 count > 0일 경우, insert 성공 / else인 경우는 실패
			// 위에서 sql을 PrepareStatement의 매개변수로 담아
			// 정의를 이미 했기 때문에 위 경우에는 매개변수가 없어야 함

			if (count > 0)
				System.out.println("*** insert 성공 ***");
			else
				System.out.println("*** insert 실패 ***");
		} catch (Exception e) {
			System.out.println("** insert Exception => " + e.toString());
		}
	} // insert

	// ** PrepareStatement 연습 =============================================================
	// => "?"가 필요없는 selectList에 적용하기
	public static void selectList2() {
		sql = "select * from student";
		try {
			pst = cn.prepareStatement(sql) ;
			rs = pst.executeQuery();

			System.out.println("============== ** PrepareStatement : selectList2 적용  ** ==============");

			if (rs.next()) {
				do {
					System.out.print(rs.getInt(1) + " ");
					System.out.print(rs.getString("name") + " ");
					System.out.print(rs.getInt(3) + " ");
					System.out.print(rs.getInt(4) + " ");
					System.out.print(rs.getString(5) + " ");
					System.out.print(rs.getFloat(6) + " ");
					System.out.print(rs.getString(7) + " ");
					System.out.print(rs.getString(8) + "\n");
				} while (rs.next());
			} else {
				System.out.println("** PrepareStatement - selectList : 출력 데이터가 존재하지 않음");
			}
		} catch (Exception e) {
			System.out.println("** PrepareStatement - selectList Exception => " + e.toString());
		}
	} // selectList2

	public static void main(String[] args) {
		/*
		 * . Student List => MySQL 작업 순서 1. 로그인 2. DB 선택 3. SQL 구문 실행 4. 결과출력
		 */

		// 1) DB 연결
		System.out.println("** DB 연결 확인 => " + cn);

		// 2) SQL 구문 실행 & 결과 출력
		selectList();

		// 3) joList 실습
		joList();

		// 4) studentList 실습
		studentList(4);

		// 5) insert와 PreparedStatement Test
		insert("관리자", 99, 7, "PrepareStatement Test");
		
		// 6) PrepareStatement - selectList에 적용하기
		selectList2();

	}

}
