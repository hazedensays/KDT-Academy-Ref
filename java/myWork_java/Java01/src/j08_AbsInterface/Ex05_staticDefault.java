package j08_AbsInterface;

//** interface 4.
//=> 상수, 추상메서드
//=> static, default 메서드 (구현부가 있는 메서드, Java8 부터 추가됨)

//** static, default
//=> 반드시 바디를 구현 해야함
//=> 구현클래스의 오버라이딩 의무 없음

interface NewInter {
	// ** 추상메서드
	// => 반드시 헤더부분(선언부)만 정의, 바디부분(실행부)는 없어야 한다.
	void test();

	// ** static 메서드
	// => 반드시 바디부분(실행부)까지 구현해야함
	// static void staticTest(); -> Error
	static void staticTest() {
		System.out.println("** Interface staticTest() **");
	}

	// ** default 메서드
	// => interface에만 있음, 오버라이딩 의무 없지만, 필요시에는 가능
	// default void defaultTest(); -> Error
	default void defaultTest() {
		System.out.println("** Interface defaultTest() **");
	}

} // NewInter

class NewTest implements NewInter {
	@Override
	public void test() {
		System.out.println("** NewTest test() Override");
	}

	// Test1) static
	static void staticTest() {
		System.out.println("** NewTest staticeTest() **");
	}

	// Test2) default
	// => 의무는 아니지만, 오버라이딩 허용
	// => 오버라이딩 주의사항
	// : default는 사용 금지(default는 interface에만 사용 가능하기 때문)
	// : 접근 범위 -> 조상과 같거나 더 넓은 범위를 가져야 함

	@Override
	public void defaultTest() {
		// ** 조상의 default 메서드 호출
		NewInter.super.defaultTest();
		// super은 조상 클래스의 인스턴스를 의미하는데 NewInter은 인스턴스가 아니라 인터페이스이기 때문에
		// 그냥 super로 접근하면 안되고, NewInter.super(의미: interface인 조상)로 접근해야 함.
		System.out.println("** NewTest defaultTest() Override **");
	}

	// => 메서드 오버로딩
	public void defaultTest(int i) {
		System.out.println("** NewTest defaultTest() i*i => " + i * i);
	}

}// NewTest

public class Ex05_staticDefault {

	public static void main(String[] args) {
		// 1) 클래스 타입으로 생성
		NewTest n1 = new NewTest();
		n1.test();
		n1.defaultTest(); // 메서드 오버라이딩 전/후 비교
		n1.defaultTest(123);
		NewTest.staticTest();
		NewInter.staticTest(); // interface의 static 메서드 접근

		// 2) 인터페이스 타입으로 생성
		NewInter n2 = new NewTest();
		n2.test();
		n2.defaultTest();
//		n2.defaultTest(123);	//인터페이스에 정의된 멤버만 접근 가능
		NewTest.staticTest();
		NewInter.staticTest();

	}

}