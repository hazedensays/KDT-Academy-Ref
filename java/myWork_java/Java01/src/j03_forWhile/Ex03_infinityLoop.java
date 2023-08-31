package j03_forWhile;

public class Ex03_infinityLoop {

	public static void main(String[] args) {
		// 1) for
		int count = 0;
		
		for ( ; ;) {	//무한 반복
			System.out.println("for : count => " + count++);
			if (count > 5) break;
		}
		
		// 2) while
		count = 0;
		
		while (true) {
			System.out.println("while : count => " + count++);
			if (count > 5) break;
		}
		
		// 3) do-while
		count = 0;
		
		do {
			System.out.println("do-while : count => " + count++);
			if (count > 5) break;
		} while(true);
		
		
		// 4) 조건문 : 무조건 실행
		if (true) {
			System.out.println("조건문 : 무조건 실행 => true 입니당");
		}
//		else {
//			System.out.println("false 입니당");
//		}	// if의 조건이 true일 경우 else가 실행될 일이 없기 때문에 오류가 뜸
	}

}
