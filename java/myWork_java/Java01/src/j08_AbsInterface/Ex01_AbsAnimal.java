package j08_AbsInterface;

//** 추상 클래스 
//=> 추상메서드가 하나라도 정의되면 그 클래스는 반드시 추상클래스로 정의 해야 함 
//=> 직접 인스턴스를 생성하지 못함. ( new 사용불가 )
// 그러나 참조형 변수(인스턴스)의 타입으로 선언은 가능하다.
// 그리고 후손으로 인스턴스를 생성할 수 있음.
// 그러므로 후손은 반드시 추상 메서드 오버라이딩의 의무를 가짐

//** 추상 메서드
//=> Body 부분이 없고 Header 만 선언
//=> 앞쪽에 abstract, 매개변수 뒤에 ; 붙여야됨.
//=> Body 부분은 Child 클래스에서 반드시 재정의(오버라이딩) 해야 함.
//( 실행문이 없어도 공백으로 작성해야함 -> { } )
//=> 추상 메서드 목적 : 후손에게 오버라이딩 의 강제성을 부여 (메서드명의 통일성)

abstract class Animal {

	// ** 추상 클래스 생성자
	// => 생성자가 있어도 직접 생성은 불가능함.
	// => 후손에 의해 생성시 호출됨.

	String kind;

	Animal() {
		System.out.println("Animal default 생성자");
	}

	// ** 일반 메서드
	void breath() {
		System.out.println(kind + "는 숨을 쉰다.");
	}

	// ** 추상 메서드
	abstract void sound();

	abstract void special();

}// Animal

class Cat extends Animal {

	public Cat() {
		kind = "냐옹이";
	}

	@Override
	void sound() {
		System.out.println("야옹 야옹");
	}

	@Override
	void special() {
		System.out.println("** special : 냐옹이 is so special ~~ **");
	}

	void eyeColor() {
		System.out.println("냐옹이의 eyeColor은 오묘오묘");
	}
} // Cat

class Dog extends Animal {
	public Dog() {
		kind = "멍멍이";
	}

	@Override
	void sound() {
		System.out.println("멍멍 멍멍");
	}

	@Override
	void special() {
		System.out.println("** special : 크리미 is so special ~~ **");
	}

	void dogColor() {
		System.out.println("Cream");
	}

	void speed() {
		System.out.println("빠르게 달리는 중!");
	}

}// Dog

class Dinosaur extends Animal {
	public Dinosaur() {
		kind = "티라노사우르스";
	}

	@Override
	void sound() {
		System.out.println("쿠와아아아아악!!!!!!!!!!!!");
	}

	@Override
	void special() {
		System.out.println("** special : 튀롸노 is so special ~~ **");
	}

	void dinosaurColor() {
		System.out.println("Red and Black");
	}

	void speed() {
		System.out.println("jolla 빠르게 달리는 중!");
	}

}// Dinosaur

class Bear {		//조상에게 상속 안 받았을 경우
	void breath() {
		System.out.println("곰 세마리가 한 집에 있어~");
	}
	
	void sound() {
		System.out.println("아빠곰 엄마곰 애기곰");
	}
	
	void special() {
		System.out.println("애기곰 is me");
	}
}// Bear

public class Ex01_AbsAnimal {

	public static void main(String[] args) {
		// 1) Animal 생성하기
		// Animal animal = new Animal();
		// => 직접 인스턴스를 생성하지 못함. ( new 사용불가 )
		// => Animal default 생성자를 생성해도 직접 인스턴스 생성은 불가능 (Animal animal = new Animal();)
		// : 후손을 인스턴스 생성 가능 (후손은 반드시 추상 메서드 오버라이딩의 의무를 가짐)

		// 2) Cat 생성하기
		// => 후손 생성시, 추상클래스인 조상의 생성자 호출
		// 그렇다고 하더라도 인스턴스
		// 2-1) Animal Type으로 생성
		Animal c1 = new Cat();
		c1.breath();
		c1.sound();

		// 2-2) Cat Type으로 생성
		Cat c2 = new Cat();
		c2.breath();
		c2.sound();
		c2.eyeColor();

		// ** 결론
		// => Animal Type, Cat Type 모두 생성가능하지만,
		// 접근 가능한 맴버의 범위는 Type 에 정의된 범위로 제한됨
		// 즉, Cat 에만 정의된 메서드는 Animal Type 에서는 접근할 수 없음
		// => 그러나 실행은 Cat 의 메서드가 실행됨.
		// ( Animal 에는 header 부분만 있기 때문에 실행이 불가능함 )

		// => 장점
		// Animal Type으로 선언하는 경우, 우측을 Cat, Dog으로만 변경하면 되기 때문에 클래스 교체를 쉽게 할 수 있음
		// 같은 조상을 상속하는 후손들은 조상의 타입으로 정의하면 클래스 교체가 편리함

		// 2-3) Dog 생성하기
		Animal d1 = new Dog();
		d1.breath();
		d1.sound();
		// d1.speed(); // Error : The method speed() is undefined for the type Animal

		Dog d2 = new Dog();
		d2.breath();
		d2.sound();
		d2.speed();

		// 동일 Type이므로 성립 => 클래스 교체 편리
		d1 = c1;
		d1.breath();
		d1.sound();
		// 다른 Type이므로 성립 불가 => Type mismatch: cannot convert from Cat to Dog
		// d2 = c2;

		// 2.4) 다형성 적용
		// => 조상의 타입으로 정의하고 후손클래스로 인스턴스를 생성함
		// => 우측의 생성자만 교체하면 쉽게 클래스 교체 가능
		// => 코드 내에서 조상의 정의된 맴버만 사용 했다는 의미
		// => 추상 뿐만 아니라 상속관계에서는 모두 적용가능함
		// => 추상을 사용하면 의무구현의 강제성을 줄수있음 (메서드명을 일원화 할 수 있음)

		// => Animal Type 은 생성자의 종류에 따라 다른 객체가 될 수있다.
		// => Animal Type 으로 정의했다는 의미는 우측에 누가 오던
		// Animal 에 정의된 맴버만 사용했다는 의미이므로 클래스 교체 가능
		System.out.println("** 다형성 적용 Test **");
		Animal animal = new Dinosaur(); // Dog(), Cat(), Dinosaur()
																				// Bear() => Animal Type이 아니므로 Error : Type mismatch
		animal.breath();
		animal.sound();
		animal.special();
		
		
		// 2.5) 메서드 매개변수로 다형성 Test
		System.out.println("** 메서드 매개변수로 다형성 Test : 1) Animal **");
		animalUse(animal);
		animalUse(c1);	// Animal Type
		animalUse(c2);	// Cat Type
											// c2 아래와 동일 효과
											// Animal animal = new Cat()
		
		// Error => The method animalUse(Animal) in the type Ex01_AbsAnimal is not applicable for the arguments (Bear)
		// animalUse(Object animal)을 정의하지 않았을 경우에는 Bear은 조상에게 상속받지 않아 Error 발생
		// animalUse(Object animal)을 정의한 후에는 모든 클래스에서 사용 가능한 Object로 인해 Error 발생 안함
		System.out.println("** 메서드 매개변수로 다형성 Test : 2) Object **");
		 animalUse(new Bear()); 
		 
		System.out.println("** 메서드 매개변수로 다형성 Test : 3) Animal type 배열 **");
		 Animal[] animalsArr = {c1, c2, animal, new Dog()};
		 animalUse(animalsArr);
		 
		 // ** 연산자 instanceof
		 // => 인스턴스 확인 연산자
		 if (new Cat()  instanceof Animal) {
			 System.out.println("** c2는 Animal 인스턴스입니다.");
		 } else {
			 System.out.println("** c2는 Animal 인스턴스가 아닙니다.");
		 }
		 
		 // Animal처럼 추상 클래스 또는 클래스 Type을 확인하는 경우에는 컴파일 오류 발생
		 // instanceof 연산자의 필요성이 없지만, interface의 경우에는 런타임 시에 오류 발생하므로
		 // instanceof 연산자를 이용한 확인이 필요함
//		 if (new Bear() instanceof Animal) {
//			 System.out.println("** Bear는 Animal 인스턴스입니다.");
//		 } else {
//			 System.out.println("** Bear는 Animal 인스턴스가 아닙니다.");
//		 }
		
	}
	
	// ** animalUse(매개변수) 오버로딩
	// => Animal Type 배열, Animal, Object
	// 1. Animal
	public static void animalUse(Animal animal) {
	      animal.breath();
	      animal.sound();
	      animal.special();
	   }
	
	// 2. Object
	// ** 매개변수 type : Object
	// => 모든 클래스 사용 가능, Object에 정의된 멤버만큼만 사용 가능
	public static void animalUse(Object animal) {
		System.out.println("** Your Address => " + animal);
	}
	
	// 3. Animal type 배열
	public static void animalUse(Animal[] animals) {
		for (Animal a : animals) {
			a.breath();
			a.sound();
			a.special();
		}
	}
	

}
