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
	} //selectList
	
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
				} while(rs.next());
			} else {
				System.out.println("** joList : 출력 데이터가 존재하지 않음");
			}
		} catch (Exception e) {
			System.out.println("** joList Exception => " + e.toString());
		}
	} //joList
	
	public static void main(String[] args) {
		/*.
		 		** Student List
		 		=> MySQL 작업 순서
		 				1. 로그인
		 				2. DB 선택
		 				3. SQL 구문 실행
		 				4. 결과출력
		 */
		
		// 1) DB 연결
		System.out.println("** DB 연결 확인 => " + cn);
		
		// 2) SQL 구문 실행 & 결과 출력
		selectList();
		
		// 3) joList 실습
		joList();

	}

}
