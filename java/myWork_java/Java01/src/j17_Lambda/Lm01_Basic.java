package j17_Lambda;

//** Lambda 식 표현 (자바8 부터 추가)
//=> 인터페이스가 하나의 추상메서드만 가지고 있는 경우
//이를 함수형 인터페이스(Functional Interface) 라 하며
//이러한 함수형 인터페이스를 구현하는 경우
//짧은 코드로 완성할수 있도록 지원하는것이 람다식.

//** @FunctionalInterface (예제 Lm01_03~~ 참고 )
//=> 함수형 인터페이스임을 확인하는 애너테이션
//=> 그러므로 위의 애너테이션이 붙은 인터페이스에 둘이상의 추상메서드가 존재하면 컴파일오류
//=> 그러나 구현부가 있는 static, default 선언이 붙은 메서드는 무관함.
//=> 미리 정의된 표준 함수형 인터페이스 (java.util.function 패키지 열혈 674p)
// Predicate<T>, Supplier<T>, Consumer<T>, Function<T,R>
// 이들은 다양하게 활용할수있도록 각각 추상메서드를 정의해놓고 있으므로
// 필요에 따라 이용.

interface Printable {
	void myTest(String s);
} // Printable

// 1. 일반적인 방법
// => interface Printable의 구현 클래스 Printer를 작성해놓고 사용
class Printer implements Printable {
	@Override
	public void myTest(String s) {
		System.out.println("** LambdaTest1. 일반적인 방법 => " + s);
	}
}// Printer

public class Lm01_Basic {

	public static void main(String[] args) {
		// 1. 일반적인 방법
		Printable p1 = new Printer();
		p1.myTest("람다람다람다~");

		// 2. 익명클래스
		// => 구현 클래스를 일회적으로 필요한 경우
		Printable p2 = new Printable() {
			@Override
			public void myTest(String s) {
				System.out.println("** LambdaTest2. 익명클래스 적용 => " + s);
			}
		};
		p2.myTest("집가고 싶다.");

		// 3. Lambda식으로 표현
		// => 인터페이스의 추상메서드가 유일하므로 메서드명 생략 가능
		// => 매개변수의 타입도 이미 정의되어 알 수 있으므로 생략 가능
		// => 매개변수가 하나이면 () 생략 가능
		
//		Printable p3 = (String s) -> {
//			System.out.println("** LambdaTest3. 익명클래스 적용 => " + s);
//		};
		
//		Printable p3 = (s) -> {
//			System.out.println("** LambdaTest3. 익명클래스 적용 => " + s);
//		};
		
		Printable p3 = s -> {
			System.out.println("** LambdaTest3. Lambda Expression => " + s);
		};
		p3.myTest("람다는 편리하다잉");
		
		// 4. 메서드 참조 Lambda Expression
		Printable p4 = System.out::println;
		p4.myTest("** LambdaTest4. 메서드 참조 Lambda Expression");
		
		
		
		
		
		
	}

}
