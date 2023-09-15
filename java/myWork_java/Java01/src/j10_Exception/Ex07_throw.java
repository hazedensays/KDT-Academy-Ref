package j10_Exception;

//** 예외생성
//=> throw : 예외(Exception) 생성하기 (던지다)
//=> throws: 예외(Exception) 전달하기 (떠넘기기, 던지다)

//=> extends Exception => Checked Exception 
//=> extends RuntimeException => UnChecked 예외 (예외처리를 강제하지 않음)

public class Ex07_throw {

	public static void main(String[] args) {
		// 1) Exception 생성하기
		// 1 - 1 ) Unchecked
//		 throw new RuntimeException();
		// => UnChecked Exception 이므로 컴파일러가 예외처리(try~catch) 를 확인하지 않지만,
		// 		무조건 RuntimeException 발생으로 비정상종료

		// 1 - 2 ) Checked
		 // throw new Exception();
		//  => Checked Exception 이므로 try 블럭
//		try {
//			throw new Exception("** throw Test **");
//		} catch (Exception e) {
//			System.out.println("** Exception1 => " + e.toString());
//		}

		// 2) MyException
		// => 특정상황에 대해 Exception 으로 정의할 수 있음
		// => 인스턴스를 정의 할 수 있고, 일회적으로 사용한다면 인스턴스 정의 없이 가능
		try {
			double res = 1.5 / 0.0;
			if (Double.isInfinite(res)) {
				Exception myE = new Exception("** 의도적 MyException : res => " + res);
				throw myE;
			}
		} catch (Exception e) {
			System.out.println("** Exception2 => " + e.toString());
		}
		
		System.out.println("**Program 정상 종료**");
	}

}
