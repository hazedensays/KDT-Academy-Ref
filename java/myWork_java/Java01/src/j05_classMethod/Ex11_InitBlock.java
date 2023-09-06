package j05_classMethod;

import java.util.Arrays;

//** 맴버 변수 초기화
//=> 선언과 동시에 초기화 (간단한 경우): 명시적 초기화(explicit initialization) 
//=> 초기화블럭 또는 생성자 (복잡한 경우) 

//** 수행순서
//=> 프로그램 로딩-> 클래스초기화블럭 -> main 메서드실행 
// -> 인스턴스 생성 (new) -> 인스턴스초기화 블럭 -> 생성자 실행
// 그러므로 인스턴스 초기화 블럭은 인스턴스 생성시마다 실행 됨   

public class Ex11_InitBlock {

	static int[] arr = new int[10];
	static int count = 100; // 선언과 동시에 명시적 초기화
	String color;
	double num = 123.456; // 선언과 동시에 명시적 초기화

	// ** 초기화 블럭
	// => 초기화 하는데 코드가 필요한 경우 작성 가능
	// 그러므로 초기화 블럭 내부에서는 실행문 작성 가능

	static {
		System.out.println("** static 초기화 블럭 **");
		System.out.println("static { ... }");
		System.out.println();

		// => 배열 arr 초기화 : 1~10 사이의 임의의 수 를 저장, Math.random()이용
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 10) + 1;
		}
	} // static 초기화 블럭

	{
		System.out.println("** instance 초기화 블럭 **");
		System.out.println("{ ... }");
		System.out.println();

		color = "pink";
		num += (Math.random() * 10 + 1);
	} // non_static 초기화 블럭

	public Ex11_InitBlock() {
		System.out.println("** default 생성자 **");
		System.out.println();
	}

//	 System.out.println("** 실행문 작성 Test 안됨 **");

	// ** 실행순서
	// => 클래스초기화블럭 -> main 메서드실행
	// -> 인스턴스 생성 (new) & 인스턴스변수에 주소값 할당 -> 인스턴스초기화 블럭
	// -> 생성자 실행 (그러므로 생성자 내에서 this 사용가능)

	public static void main(String[] args) {
		System.out.println("** Main 시작 **");
		System.out.println();

		// => static 값 출력
		System.out.println("** main count => " + count);
		System.out.println("** main arr => " + Arrays.toString(arr));
		System.out.println();

		// => instance 값 출력
		Ex11_InitBlock ex11 = new Ex11_InitBlock();
		System.out.println(" ** main color => " + ex11.color);
		System.out.println(" ** main num => " + ex11.num);
		System.out.println();

		// => 새로운 instance 생성
		Ex11_InitBlock ex22 = new Ex11_InitBlock();
		System.out.println(" ** main color => " + ex22.color);
		System.out.println(" ** main num => " + ex22.num);
		System.out.println();

	}

}
