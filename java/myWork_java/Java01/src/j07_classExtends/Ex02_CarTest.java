package j07_classExtends;

//** 상속 : extends
//=> 기능을 확장해서 업그레이드 버젼 만듦.
//=> 기존(조상) 클래스의 맴버들(필드와 메소드)을 재사용 & 일부변경도 가능 

//** 생성순서
//=> JVM은 extends 키워드가 있으면 조상생성후 후손생성
// 이때 기본은 조상의 default 생성자를 실행하고,
// 특별히 후손 생성자에서 조상생성자_super(...)를 호출해 놓으면 그생성자를 실행함.
//=> 상속을 허용하는 클래스는 default 생성자를 반드시 작성하는것이 바람직함.

//** 조상 : Super (Parent, Base) class  
//=> super.  : 조상의 인스턴스를 의미 (조상의 맴버에 접근 가능)
//=> super()
// 조상의 생성자를 의미 (조상의 생성자에 접근 가능).
// this() 처럼 생성자 메서드 내에서 첫줄에 위치해야함.

//=> 생성자메서드_super(), this() 호출은 생성자 내에서만 가능 

//** 후손 : Sub ( Child, Derived ) class
//=> super class 를 포함

class SportsCar extends Ex01_Car {
	int turbo;
	int speed; // 조상과 동일한 이름의 멤버변수

	// 1) ==================================================================
	SportsCar() {
		// super()
		// => 묵시적 호출
		// => 넣어주지 않아도 컴파일러가 조상의 default 생성자를 의미하는 super()를 자동으로 넣어줌
		System.out.println("** SportsCar default 생성자");
	}

	// 2) ==================================================================
	SportsCar(int turbo) {
		this.turbo = turbo;
		System.out.println("** SportsCar 초기화 생성자");
	}

	// 3) ==================================================================
	// => 조상의 멤버들도 모두 초기화 하는 생성자
	SportsCar(int turbo, int speed, int mileage, String color) {
		super(speed, mileage, color);
		// 조상 생성자 호출, 항상 첫 줄에 위치해야 함
		this.turbo = turbo;
		System.out.println("** SportsCar 초기화 생성자");
		// COUNTRY = "Korea"; //상수는 수정 불가능
	}

	// 4) ==================================================================
	// => Car 클래스에 생성자를 추가하지 않고,
	// super(speed , mileage) -> 없음(호출 불가능)
	// turbo, speed , mileage 를 초기화 하는 생성자를 추가하세요~~
	// -> 조상의 speed , mileage 에 매개변수의 값을 전달
	SportsCar(int turbo, int speed, int mileage) {
		this.turbo = turbo;
		super.speed = speed;
		super.mileage = mileage;
		System.out.println("** turbo, speed, mileage 초기화 생성자");
	}

	public int powerUp(int turbo) {
		return this.turbo += turbo;
	}

	// 5) ==================================================================
	// 조상과 동일한 이름, 매개변수, return값의 메서드
	// 메서드 오버라이딩 (=> 조상 클래스로부터 상속받은 메서드의 내용을 변경하는 것)
	// 조상에 정의된 메서드의 기능을 업그레이드 하는 경우 주로 이용됨
	// : 조상에 정의된 기능 + 추가 기능

	// 오버로딩 vs 오버라이딩
	// 오버로딩 : 한 클래스 안에서 발생
	// : 기존에 없는 새로운 메서드를 정의하는 것 (new)
	// 오버라이딩 : 상속 관계에서 발생
	// : 상속받은 메서드의 내용을 변경하는 것 (modify, change)

	@Override
	public void speedUp() {
		super.speedUp();
		this.speed += 100;
	}

	// @Override => 매개변수가 다르기 때문에 overriding 아니고 overloading에 해당됨
	public void speedUp(int speed) {
		this.speed += speed; // SportsCar_speed
		super.speed += speed; // Car_speed
		System.out.printf("** speed = %d, this.speed = %d, super.speed = %d, COUNTRY = %s", speed, this.speed,
				super.speed, Ex01_Car.COUNTRY); // final은 모든 class가 공유하는 값이고 수정할 수 없는 값이기 때문에 보통 static으로 선언
												// : 따라서 static하게 접근해야 함
	}

	// 6) ==================================================================
	// => final Test
	// : overriding 금지
	// public void speedDown() {
	// speed -= 100;
	// }

	// : overloading은 허용 (매개변수 다름)
	public void speedDown(int i) {
		speed -= i;
	}

	// 조상과 동일한 이름의 메서드
	// => 조상(super)/자식(this) 구별 필요
	@Override
	public String toString() {
		// => 조상의 toString 메서드 호출
		return super.toString() + "\nSportsCar [ turbo : " + turbo + " ]";
	}

}

public class Ex02_CarTest {

	public static void main(String[] args) {
		// 1) 상속 Test
		// => 조상의 멤버에 접근 가능함
		// => SportsCar 멤버 추가 전/후 비교
		// 이름이 같은 경우 현재(자식) 클래스에 정의된 멤버 우선 적용
		// => 생성자 추가 후 출력순서 확인
		// 조상 생성자 -> 자식 생성자 실행

		// 1) ==================================================================
		SportsCar sc1 = new SportsCar();
		sc1.color = "blue";
		System.out.println("sc1 => " + sc1);
		System.out.println("sc1.color => " + sc1.color);
		System.out.println();

		// 2) ==================================================================
		// => 생성자 Test
		// 사용자 클래스에서 조상의 생성자를 선택할 수 없음 : 조상은 default 생성자 호출됨
		SportsCar sc2 = new SportsCar(100);
		System.out.println("** 생성자 Test sc2 => " + sc2);
		System.out.println();

		// 3) ==================================================================
		// => 조상 포함 모든 멤버변수를 초기화하는 생성자
		SportsCar sc3 = new SportsCar(300, 100, 100, "green");
		System.out.println("** 생성자 Test sc3 => " + sc3);
		System.out.println();

		// 4) ==================================================================
		// => super 접근 Test
		SportsCar sc4 = new SportsCar(500, 500, 500);
		System.out.println("** 생성자 Test sc4 => " + sc4);
		System.out.println();

		// 5) ==================================================================
		// => 멤버 변수 Test

		// : speed 추가 전 출력
		// System.out.println("** Test : speed 추가 전 => " + sc4.speed); //** Test : speed
		// 추가 전 => 500

		// : speed 추가 후 출력
		System.out.println("** Test : speed 추가 후 => " + sc4.speed); // ** Test : speed 추가 후 => 0

		// : speedUp (조상과 이름이 동일한 메서드) 추가 후 출력
		sc4.speedUp();
		System.out.println("** Test : speedUp() 추가 후 speed => " + sc4.speed);
		// 조상과 동일한 이름의 멤버변수를 선언했기 때문에 500 + 100 = 600 이 출력되는 것이 아닌
		// 0 + 100 = 100 이 출력됨을 확인할 수 있음

		// speed / this.speed / super.speed 비교
		sc4.speedUp(123);

	}

}
