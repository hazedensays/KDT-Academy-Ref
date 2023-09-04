package j05_classMethod;

//** 맴버메서드(Method)
//=> 함수(Function), 프로시져(Procedure)

//J06_  15,16 p
//1) 정의 , 실행

//2) return 값
//=> return 이 있으면 Type 을 지정, 없으면 무조건 void  
//=> 메서드 실행결과 return Type에 해당하는 결과값을 제공
//=> return 명령어를 void 메서드 에서 사용하면 메서드 종료

//3) 매개변수
//=> 매개변수(Argument, 인자), Parameter
//=> 메서드의 지역변수이며, 모든타입 정의 가능
//=> 매개변수의 값 전달방법
//CallByValue (기본자료형, String -> 매개변수의 값 전달)
//CallByReference (참조자료형: 배열, 인스턴스 -> 주소전달)   

//** 기본자료형 : Primitive Data Type (int, double, boolean....)
//** 참조자료형 : Reference Data Type (String, 배열 등 클래스타입) 

public class Ex03_Method {

	// 1. 메서드 종류별 4종 정의
	// 2. return Test
	// => return 값 활용 (main 에서 Test)
	// => void 메서드 에서 사용 : 메서드 종료
	// 3. 매개변수 전달방법
	// => CallByValue (기본자료형, String -> 매개변수의 값 전달됨)
	// => CallByReference (참조자료형, 주소값을 전달 -> 배열, 인스턴스)

	int price = 5000; // 전역/멤버 변수 (global)

	// 1) 매개변수 (X), return (X) =========================================
	public void starbucks() { // => 메서드의 헤더
		System.out.println("What do you want to drink?"); // => { ... } 메서드의 바디
	}

	// ** 메서드명
	// => 일반적인 식별자 규칙을 준수
	// => 소문자로 시작
	// => 동일한 이름의 메서드명 허용 (매개변수의 개수, 타입이 다른 경우)
	public void starbucks(int n) {
		System.out.println("** 메서드명 Test => " + n);
	}

	// 2) 매개변수 (O), return (X) ========================================
	// => 5잔 미만 주문 시, 종료하기
	// => void 메서드에서 return 사용하면 종료
	public void orderList(String s, int n) {

		if (n < 5) {
			System.out.println("5잔 이상 주문 바랍니다.");
			return;
		}

		System.out.println(" ********* 주문 내용 ********* ");
		System.out.printf("%s, %d잔 %n", s, n);

		// ** 매개변수 전달 Test (CallByValue)
		// => kind 에 의해 전달된 s의 값을 변경
		s = "바나나";
		System.out.println("** CallByValue Test => " + s);

	}

	// 3) 매개변수 (X), return (O) ========================================
	public String priceList() {
		return "1잔 당 " + price + "원 입니다.";
	}

	// 4) 매개변수 (O), return (O) ========================================
	public int totalPrice(String s, int n) {
		System.out.printf("=> %s, %d잔 총액 : ", s, n);
		return price * n;
	}

	// 5) 참조자료형 => 매개변수 (O), return (O) ==============================
	public int carTest(Car car, int speed) {
		System.out.println("** carTest car1 => " + car);
		car.color = "white";
		System.out.println("** carTest car2 => " + car);
		return car.speed + speed;
	}

	public static void main(String[] args) {
		// ** 메서드 호출
		// => 같은 클래스에서도 접근하기 위해서는 인스턴스가 필요함
		// starbucks(); price = 9000; => 인스턴스 없이 호출 불가
		Ex03_Method ex03 = new Ex03_Method();
		ex03.starbucks();

		ex03.orderList("자바칩프라프치노", 7);
		System.out.println("** ex03.priceList() => " + ex03.priceList());
		System.out.println(ex03.totalPrice("돌체콜드브루", 24));

		ex03.starbucks(12345);

		// ** 매개변수 전달 Test1 (CallByValue)
		String kind = "딸기";
		ex03.orderList(kind, 12);
		System.out.println("** main kind => " + kind);
		
		// ** 매개변수 전달 Test2 (CallByReference)
		Car mylastCar = new Car();
		mylastCar.color = "navy";
		mylastCar.speed = 5555;
		mylastCar.mileage = 5555;
		
		System.out.println("** main Before => " + mylastCar);
		ex03.carTest(mylastCar, 500);
		System.out.println("** main After => " + mylastCar);
		
		// => 참조형 매개변수 사용 비교
		//      : 매개변수 위치에서 바로 생성해도 됨
		//      : Car를 일회성 매개변수로만 사용하는 경우 적당
		System.out.println("** main 바로 생성 : return값 => " + ex03.carTest(new Car(), 9999));
		
		
	}

}
