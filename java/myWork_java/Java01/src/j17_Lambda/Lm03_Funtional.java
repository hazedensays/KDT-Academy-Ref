package j17_Lambda;

//** @FunctionalInterface Test
//=> 이를 적용한 인터페이스는 한개의 추상메서드만을 선언할수있다.
//=> 그러나 static, default 선언이 붙은 메서드는 무관함.

@FunctionalInterface
interface Value {
	int num(int a, int b);
	//String myString(int a, int b); // 추상메서드 하나만 허용
}

class Computer {
	public void inValue(Value v) {
		int result = v.num(5, 10);
		// => num 메서드의 처리 내용은 구현이 안되어 있음
		// 		inValue 메서드 호출시 넣어주는 인자 (Value 인터페이스 구현체)에 의해 결정됨
		System.out.println("** inValue, result => " + result);
	}
}

public class Lm03_Funtional {

	public static void main(String[] args) {
		// 1. 람다식 사용 X, 익명 클래스 사용 ("+" 연산으로 구현)
		Computer cp = new Computer();
		System.out.println("1. 람다식 사용 X, 익명 클래스 사용 (\"+\" 연산으로 구현)");
		
		cp.inValue(new Value() {
			@Override
			public int num(int a, int b) {
				return a + b;
			}
		});
		
		// 2. 람다식 사용 ("*" 연산으로 구현)
		// => Value Type의 매개변수를 람다식으로 정의
		System.out.println("2. 람다식 사용 (\"*\" 연산으로 구현)");
		cp.inValue((a, b) -> {
			System.out.printf("num: a = %d, b = %d%n", a, b);
			return a * b;
		});
		
		// 3. 생략형 람다식 ("-" 연산으로 구현)
		System.out.println("생략형 람다식 (\"-\" 연산으로 구현)");
		cp.inValue((a, b) -> a - b);
		
		
	}

}
