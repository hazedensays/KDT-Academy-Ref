package j05_classMethod;

//** 생성 과정
//=> new 연산자가 해당되는 클래스를 메모리에 로드해서 생성함.
//=> 이때 생성직후 생성자 메서드를 호출함

//** 생성자(Constructor) 메서드
//=> 클래스와 이름 동일하고, return 값이 없음. (void 조차도 생략됨)
//그러나 매개변수는 개수, Type 제한 없음
//=> 생성시에 단한번 호출가능 
//=> 한 클래스의 생성자는 여러개 가능 (생성자 오버로딩) 
//=> 생성자를 작성하지 않으면 컴파일러가 자동으로 기본생성자를 만들어줌(Default Constructor)
//(단, 하나라도 생성자 메서드를 작성하면 Default 생성자는 자동으로 만들어지지않음)

//** 생성자 메서드에서 생성자 메서드 호출 가능 
//=> this(?,?,...)
//=> this(...) 은 반드시 생성자 메서드 내에서 첫줄에 위치해야함.

// 1) 기본(Default) 생성자
// => 매개변수 없고, 생성자를 전혀 작성하지 않으면 자동제공됨
//   ( 컴파일시에 추가해줌 )
// => 그러나 생성자를 1개라도 작성하면 기본(Default) 생성자 자동생성은 안됨  

// 2) 변수를 초기화하는 생성자
// => this : 지역변수, 전역변수 구별
//           현재클래스의 인스턴스 
// => this()
//      - 생성자메서드에서 생성자메서드 호출
//       - 생성자의 반복적인 코드의 재사용성
//      - 생성자 메서드 내에서 반드시 첫줄에 위치해야하고,
//        한번만 호출가능
//        -> 한 생성자 내에 this(..)를 여러개 사용하는것은 불가능

class Phone {
	String company;
	String number;
	int price;
	static int count;

	// 1) Default 생성자 확인
	public Phone() {
	} // 다른 생성자를 추가하면 Default 생성자는 자동으로 생성되지 않는다는 이유로
		// 필요시에 Default 생성자도 추가해야 함

	
	// 2) 매개변수가 있는 생성자 : this() 사용
	public Phone(String company, int count) {
		
		//this(1000);
		this(company, null, 0, 100);	// 매개변수가 동일한 생성자 호출
		
		// => 전역변수명과 매개변수명이 같을 때, 전역변수에 this를 붙여줌
		//this.company = company;	// 인스턴스 종속
		//Phone.count = count;	// 클래스 종속
		//System.out.println("** company 생성자 호출");
	}

//	=> 매개변수가 동일한 type이고 개수가 같으면 허용하지 않음
//	public Phone(String number) {
//		this.number = number;
//	}
	
//	=> 매개변수가 다른 type이거나 개수가 다르면 허용
	public Phone(int price) {
		this.price = price;
	}

	
	// 3) 변수를 모두 초기화하는 생성자
	public Phone(String company, String number, int price, int count) {
		this.company = company;
		this.number = number;
		this.price = price;
		Phone.count = count;
	}

	public int dateUp(int i) {
		return i * 100;
	}

	public String toString() {
		return "[ company : " + company + ", number : " + number + ", price : " + price + ", count : " + Phone.count + " ]\n" ;
	}
}

public class Ex07_Constructor {

	public static void main(String[] args) {

		// 1) Default 생성자 확인
		// => 다른 생성자를 추가하면 Default 생성자는 자동으로 생성되지 않음
		Phone p1 = new Phone();

		p1.company = "samsung";
		p1.number = "010.1234-5678";
		p1.price = 10000000;
		System.out.println("** p1 => " + p1);

		// 2) 매개변수가 있는 생성자
		Phone p2 = new Phone("apple", 123);
		System.out.println("** p2 => " + p2);

		// 3) 변수를 모두 초기화하는 생성자
		Phone p3 = new Phone("LG", "010-9876-5432", 500000, 123);
		System.out.println("** p3 => " + p3);

	}

}
