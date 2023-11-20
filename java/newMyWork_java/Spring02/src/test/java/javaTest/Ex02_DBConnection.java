package javaTest;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

//** @ 종류
//=> @Before - @Test - @After
// -> 하나의 클래스에서 @ 들을 반복사용하면 오류는 안나지만, 마지막 @만 실행됨
//=> @ 적용 테스트 메서드 : non static, void 로 정의 해야 함.


// => Test 메서드를 작성해서 test
//@Test -> 허용X
public class Ex02_DBConnection {
	
	// 1) static, return 값 있는 경우 Test
	// => Test 메서드를 작성해서 Test
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mydb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			Connection cn = DriverManager.getConnection(url, "root", "mysql");
			System.out.println("** JDBC Connection 성공");
			return cn;
		} catch (Exception e) {
			System.out.println("** JDBC Connection Exception => " + e.toString());
			return null;
		}
	}// getConnection()
	
	//@Test
	public void connectionTest() {
		System.out.println("** DB_Connection => " + getConnection());
		// 연결 성공 -> 주소 return
		// 연결 실패 -> null return
		assertNotNull(getConnection());
	}
		
	// 2) non static, void 로 정의
	// => finally를 추가하지 않으면 항상 GreenLine - True
	// => console에 에러메세지로만 확인 가능
	// => finally 추가 : cn값 확인
	
	@Test
	public void getConnectionVoid() {
		Connection cn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mydb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			cn = DriverManager.getConnection(url, "root", "mysql");
			System.out.println("** JDBC Connection 성공");
		} catch (Exception e) {
			System.out.println("** JDBC Connection Exception => " + e.toString());
		} finally {
			assertNotNull(cn);
		}
	}// getConnection()
	
	
	
	
	
	
	
}
