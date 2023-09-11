package j08_AbsInterface;

class MyChild1 implements Ex03_MyInterface {

	public MyChild1() {
		System.out.println("** MyChild1 default 생성자 **");
	}

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public int getNum() {
		return NUM;
	}

	void child1() {
		System.out.println("** MyChild1 child1() 메서드 **");
	}
} // MyChild1

class MyChild2 implements Ex03_MyInterface {

	String name = "지드래곤";
	int num;

	public MyChild2() {
		System.out.println("** MyChild2 default 생성자 **");
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getNum() {
		return NUM * num;
	}

	void child2() {
		System.out.println("** MyChild2 child2() 메서드 **");
	}
} // MyChild2

public class Ex03_MyInterTest {

	public static void main(String[] args) {

		Ex03_MyInterface ch1 = new MyChild1();
		System.out.println("main ch1.getName() => " + ch1.getName());
		System.out.println("main ch1.getNum() => " + ch1.getNum());
		// ch1.child1(); // Ex03_MyInterface에 정의되지 않은 child1()는 오류

		Ex03_MyInterface ch2 = new MyChild2();
		System.out.println("main ch2.getName() => " + ch2.getNum());
		System.out.println("main ch2.getNum() => " + ch2.getNum());
		// ch2.child2(); // Ex03_MyInterface에 정의되지 않은 child2()는 오류

		// ** 정리
		// MyChild1, MyChild2는 서로 무관하지만 interface로 인해 같은 type으로 사용 가능함
		// 다형성 적용 가능 -> 클래스 교체 가능

		ch2 = ch1;
		System.out.println("main ch2.getName() => " + ch2.getNum());
		System.out.println("main ch2.getNum() => " + ch2.getNum());

		MyChild1 mc1 = new MyChild1();
		MyChild2 mc2 = new MyChild2();

		// mc2 = mc1; // 서로 다른 type이므로 오류 발생

	}

}
