package j09_innerClass;

//** 실습
//추상 메서드가 2개 있는 interface 를 정의하고 
//이를  main 메서드에서 익명 클래스를 이용해서 구현하고
//실행 시켜 보세요 ~~ 

//** 복습(숙제)
//=> 교재 연습문제 (284~288p)
//   7-3 ~ 7-8

//** 예습(숙제)
//=> 293 p 예외클래스의 계층구조 참고
//=> Exception, Error, RuntimeException, IOException 의 차이점을 요약해오세요~~

interface RemoteControl {
	void turnOn();
	void turnOff();
}

public class Ex06_Test {

	public static void main(String[] args) {
		// ** 익명 클래스를 이용해서 구현하기
		RemoteControl rc = new RemoteControl() {
			@Override
			public void turnOn() {
				System.out.println(" ~~ turnOn ~~");
			}
			@Override
			public void turnOff() {
				System.out.println(" ~~ turnOff ~~");
			}
			// ** new 메서드
			// => 정의 는 가능하지만 사용은 불가능 
			// => 조상의 인스턴스로는 접근 불가능하므로
			public void myTest() {
				System.out.println(" ~~ myTest ~~");
			}
		}; // 익명클래스 종료 반드시 ; 필요함.
		rc.turnOn();
		rc.turnOff();
	} //main
} //class
