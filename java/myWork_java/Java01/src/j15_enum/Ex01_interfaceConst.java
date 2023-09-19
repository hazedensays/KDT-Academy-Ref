package j15_enum;

interface ScaleI {
	// ** 상수 정의
	// => Public static final String
	// => 상수만 정의 가능하므로 생략
	int DO = 0;
	int RE = 1;
	int MI = 2;
	int FA = 3;
	int SO = 4;
	int RA = 5;
	int SI = 6;
} // interface

//(정석기초 475p)
//** 열거형(enum) 상수 사용
//=> 정의 : 열거형은 서로 연관된 상수들의 집합
//=> interface 와 비교

//** 열거형의 특징
//=> 상수의 사용을 편리하게 지원.
//=> 의미가 있는 단어를 상수로 사용하기 편리함.
//=> 값과 타입을 동시에 확인하기때문에 안전한 코딩 가능
//=> 열거형 내부에 생성자, 필드, 메소드를 가질 수 있어서 단순히 상수가 아니라 더 많은 역할이 가능함. 
enum ScaleE {
	DO, RE, MI, FA, SO, RA, SI
}

public class Ex01_interfaceConst {

	public static void main(String[] args) {
		// ** Test1) interface에 정의된 상수 사용하기
		// => switch case에 적용하기
		int key = ScaleI.MI;
		switch (key) {
		case 0:
			System.out.println("도도도도도");
			break;
		case 1:
			System.out.println("레레레레레");
			break;
		case 2:
			System.out.println("미미미미미");
			break;
		case 3:
			System.out.println("파파파파파");
			break;
		case 4:
			System.out.println("솔솔솔솔솔");
			break;
		case 5:
			System.out.println("라라라라라");
			break;
		case 6:
			System.out.println("시시시시시");
			break;
		default:
			System.out.println("동렝밍팡솔랑싱");
		}
		
		// ** Test2) enum 사용하기
		// => 의미있는 단어를 상수로 사용하기 편리
		// => 값과 타입을 동시에 확인하기 때문에 안전하고 효율적인 코딩 가능
		ScaleE ekey = ScaleE.RA;
		System.out.println("** eKey => " + ekey);
		
		//ekey = null; 
		// 컴파일 오류는 없음
		// default로 가지 않고 런타임 오류 발생 => 안전하게 enum ScaleE에 정의된 값만 사용 가능
		//  : Error - java.lang.NullPointerException
		
		switch (ekey) {    //ekey는 ScaleE 타입
		case DO:
			System.out.println("도도도도도");
			break;
		case RE:
			System.out.println("레레레레레");
			break;
		case MI:
			System.out.println("미미미미미");
			break;
		case FA:
			System.out.println("파파파파파");
			break;
		case SO:
			System.out.println("솔솔솔솔솔");
			break;
		case RA:
			System.out.println("라라라라라");
			break;
		case SI:
			System.out.println("시시시시시");
			break;
		default:
			System.out.println("동렝밍팡솔랑싱");
		}
	}

}
