package j06_packageTest;

//** 클래스에 포함 가능한것 (맴버)
//=> 속성(변수, 필드_Field, Column), 기능.동작(메서드)
//=> 멤버변수(전역변수), 맴버메서드 
//=> 멤버메서드 종류 (역할이 정해져있는 메서드들)
//- main, 생성자(Constructor), toString, setter, getter

//** 클래스명                                                                              
//=> 대문자로 시작, 예약어 사용불가 , API 라이브러리의 클래스명 비추
//=> 클래스는 객체의 설계도

//** 객체의 주기 (LifeCycle)
//=> 생성 -> 사용 -> 소멸  (in Memory, RAM)
//=> 클래스(in HDD) -> 생성(in Memory) -> 객체화 (인스턴스 생성)
//-> 사용 -> 소멸(Memory 반납)

//** 클래스, 객체, 인스턴스(instance : 사례, 경우) 
// 클래스와 인스턴스는 설계도와 제품이라고 할수있다.
// 그럼 객체는 클래스일까 인스턴스일까? 
// Java 프로그래밍에서는 설계도인 클래스가
// 메모리상의 구체적인 실체인 인스턴스가 되었을때 객체라고 부른다. 

// 그러므로 클래스와 인스턴스는 구별되고, 클래스와 객체도 구별되지만, 
// 객체와 인스턴스는 구분없이 포괄적으로 객체라는 말을 쓰기도 한다.

//class System { ... }
//System과 같이 이미 자바 표준 라이브러리에 정의된 클래스명을 사용하면 안 됨 => 라이브러리 충돌

class Car {
	// package test용 변수 선언
	public static int ddd = 100;
	
	
	
	// ** 멤버변수, 필드(field) : 속성
	// => 클래스의 전역변수
	// 클래스 내에 있는 모든 메서드에서 사용가능
	// 다른 클래스 내에서도 접근 가능
	public int speed;
	public int mileage;
	public String color = "pink";

	// ** 멤버메서드 (Method, function, procedure)
	// => 동작 또는 기능을 구현
	public void speedUp() {
		speed += 10;
	}

	public void speedDown() {
		speed -= 10;
	}

	// => String (return Type) : 문자열을 반환(return) -> 메서드 처리 결과로 문자열을 제공
	// => toString (메서드명) : 객체의 속성(맴버필드,맴버변수) 의 값을 문자로 제공하는 역할에 주로 사용됨

	// ** toString 메서드
	// => 출력문에서 인스턴스명만 사용했을때 자동호출됨
	// => Object 에 정의됨 ( 객체의 주소를 String Type으로 return )
	// => 대부분의 클래스에서 속성 출력용도로 재정의하여 사용함.
	public String toString() {
		return "[ speed = " + speed + ", mileage = " + mileage + ", color = " + color + " ]";
	}

}

public class Ex01_CarPackageTest_ {

	public static void main(String[] args) {
		System.out.println("**Car class Test **");
		System.out.println();

		// ** 객체 사용
		// => 생성 -> 사용 -> 소멸
		// => 생성 : "인스턴스화 한다", "인스턴스를 생성한다"
		Car myCar = new Car();

		myCar.color = "skyblue";
		myCar.mileage = 1000;
		myCar.speed = 500;
		myCar.speedUp();

		System.out.println("** myCar.toString() => " + myCar.toString());
		System.out.println("** myCar => " + myCar);
		System.out.println();

		// ** 소멸 : 메모리청소
		// => 더이상 사용되지않는 값들은 자동제거해줌
		// => Garbage Collector (쓰레기 수집기)
		// => 정해진 알고리즘에 의해 작동됨 ( 일정시간동안 또는 더이상 참조되지않는등등... )
		// => 참조형 변수에 null 값을 주면 소멸 (더이상 참조되지않음)
		myCar = null;
		// myCar.color; //=> 접근 불가 : 컴파일 오류
		// myCar.speedDown // => 실행 오류 : java.lang.NullPointerException

		// ====================================================
		Car mySecCar = new Car();

		mySecCar.color = "red";
		mySecCar.mileage = 2000;
		mySecCar.speed = 600;
		mySecCar.speedUp();

		System.out.println("** mySecCar.toString() => " + mySecCar.toString());
		System.out.println("** mySecCar => " + mySecCar);
		System.out.println();

		// ====================================================
		Car myThirdCar = new Car();

		myThirdCar.color = "black";
		myThirdCar.mileage = 3000;
		myThirdCar.speed = 700;
		myThirdCar.speedUp();

		System.out.println("** myThirdCar.toString() => " + myThirdCar.toString());
		System.out.println("** myThirdCar => " + myThirdCar);
		System.out.println();

		// ====================================================
		Car newCar = mySecCar;
		System.out.println("** newCar => " + newCar);

	}

}
