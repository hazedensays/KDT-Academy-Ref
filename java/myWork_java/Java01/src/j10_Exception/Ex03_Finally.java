package j10_Exception;

//** try ~ catch ~ finally

//=> finally 블럭은 무조건 시행
//		: 1. 정상실행
//		: 2. Exception
//		: 3. 반복문 제어할 수 있는 구문 return, break, coutinue


public class Ex03_Finally {

	public static void main(String[] args) {
		int[] price = { 100, 200, 300 };

		// Test1)
		// for (int i = 0; i < price.length; i++) {
		
		// Test2)
		for (int i = 0; i <= price.length; i++) {
			if (i == 1) return; //비교 : finally와 무관
			try {
				// Test3) continue, break, return
				// => try 블럭에 진입하면 무조건 finally는 실행함
				if (i == 1) {
					return;
				} // void 메서드에서 return 사용시 무조건 종료
				if (i == 2) {
					break;
				} // 무조건 반복문 종료
				if (i == 3) {
					continue;
				} // 나머지 문장 실행하지 않고 다음 반복문 진행, 그러나 i가 4가 되면 반복문 종료
				System.out.printf("** price[%d] = %d%n", i, price[i]);
			} catch (Exception e) {
				System.out.println("** Exception => " + e.toString());
			} finally {
				System.out.println("** finally 무조건 실행 i => " + i);
			}
			System.out.println("** for_endline, i => " + i);
		} // for

		System.out.println("** Program 정상 종료");
	}

}
