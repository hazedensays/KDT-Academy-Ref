package j10_Exception;

import java.util.Scanner;

//** AgeException 1 : UnChecked
//=> 즉, 컴파일러가 예외처리(try~catch~)를 확인하지 않음
//=> 주로 프로그래머의 실수로 발생 가능한 오류들
//=> 나이의 값이 범위를 벗어나면 Exception 발생

class AgeException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	AgeException() {
		super("나이 값이 범위를 벗어남");
	}

	AgeException(String message) {
		super(message);
	}
} //class AgeException

class AgeExceptionCK extends Exception {
	private static final long serialVersionUID = 1L;
	
	AgeExceptionCK() {
		super("Age_Error_Checked");
	}

	AgeExceptionCK(String message) {
		super(message);
	}
	
}

public class Ex08_MyExceptionUn {
	static Scanner sc = new Scanner(System.in);

	// ** 나이 입력받아 return 하는 메서드 만들기
	// => 예외처리코드를 컴파일시에 확인하지않음
	public static int readAge() {
		System.out.printf("나이를 입력하세요 > ");
		int age = Integer.parseInt(sc.nextLine());
		if (age < 1 || age > 200) throw new AgeException();
		else return age;
	}//readAge
	
	public static int readAgeCK() throws AgeExceptionCK {
		System.out.printf("나이를 입력하세요 > ");
		int age = Integer.parseInt(sc.nextLine());		//문자 입력시 -> NumberFormatException
		if (age < 1 || age > 200) throw new AgeExceptionCK();
		else return age;
	}//readAgeCK
	

	public static void main(String[] args) {
		// Test1) Unchecked Test
		// => 예외처리코드를 컴파일시에 확인하지 않음
		// 		그러나 런타임시에 오류가 발생하면 비정상 종료함
//		System.out.println("** main Test1) age" + readAge());
		
		
		// Test2) Checked Test
		// 예외처리 코드를 컴파일 시에 확인함
		// 그러므로 반드시 작성해야 함 (아니면 main도 throws 할 수 있음)
		//System.out.println("** main Test2) ageCK" + readAgeCK());
		
		
		
		
		// => 예외 처리 적용
		try {
			System.out.println("** main Test1) age => " + readAge());		
			System.out.println("** main Test2) ageCK => " + readAgeCK());
		} catch (AgeExceptionCK e) {
			System.out.println("** main AgeExceptionCK => " + e.toString());
		}
		
		catch (Exception e) {
			System.out.println("** main Exception => " + e.toString());
		}
		
		
		System.out.println("** Program 정상 종료 **");
		sc.close();

	}

}
