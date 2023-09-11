package j08_AbsInterface;

//*** 클래스의 형변환
//=> 자동 형변환 (형변환 생략가능)
// 조상 <- 자손 (Up_Casting)

//=> 명시적 형변환 (형변환 생략불가능)
// 자손 <- 조상 (Down_Casting)
// 실제적 클래스타입이 변환가능한 경우에만 적용됨 
// (변환불가능한 경우에는 컴파일 오류 없어도 런타임 오류(ClassCastException) 발생)

//Animal => Mammal 포유류  => PetAnimal
//Animal => Reptil 파충류 

class Animal2 {
	String name;
	public Animal2() {System.out.println("** Animal 생성자 **"); }
	void breath() {
		System.out.println(name +" 는 숨을 쉽니다 ~~");
	}
} // Animal

class Mammal extends Animal2 {
	String cry ;
	public Mammal() {System.out.println("** Mammal 생성자 **"); }
	void crying() {
		System.out.println(super.name+ " 은(는) "+cry + " 웁니다 ~~");
	}
} // Mammal

class PetAnimal extends Mammal {
	PetAnimal() { System.out.println("~~ PetAnimal 생성 ~~"); }
	void checking() { System.out.printf("** %s는 예방접종을 했습니다.\n", name);  } 
} //PetAnimal

class Reptile extends Animal2 {
} // Reptile


public class Ex07_classCasting {

	public static void main(String[] args) {
		// Test1
		PetAnimal dog = new PetAnimal();
		
		// => instanceof Test
		if (dog instanceof PetAnimal) {
			System.out.println("dog는 PetAnimal 입니다.");
		} else {
			System.out.println("dog는 PetAnimal이 아닙니다.");
		}
		if (dog instanceof Mammal) {
			System.out.println("dog는 Mammal 입니다.");
		} else {
			System.out.println("dog는 Mammal이 아닙니다.");
		}
		if (dog instanceof Animal2) {
			System.out.println("dog는 Animal2 입니다.");
		} else {
			System.out.println("dog는 Animal2이 아닙니다.");
		}
		
		// Test2 - class UpCasting Test
		Animal2 an1 = new PetAnimal();		//조상 <- 후손 : UpCasting (자동)
		//an1 = new Reptile();		// 모든 후손은  교체 가능 (다형성 적용 가능)
		
		//PetAnimal pa = new Animal2();		//조상 -> 후손 : DownCasting (안됨)
		
		// => 생성자 종류에 따른 Animal 인스턴스 비교 (an1, an2) 비교
		// => 모두 UpCasting 허용됨
		Animal2 an2 = new Animal2();
		//an1 = dog;
		//an2 = dog;		// an2 = new PetAnimal()
		
		// Test3 - class DownCasting Test
		// => 가능한 경우에만 명시적으로 허용
		System.out.println("DownCasting Test");
		an1.breath();
		PetAnimal cat = null;
		cat = (PetAnimal)an1;		//PetAnimal(후손) Type <- Animal2(조상) Type
		cat.checking();		// PetAnimal에 정의된 멤버 접근 가능
		
		//cat = (PetAnimal)an2;
		//cat.checking();
		// => 컴파일 오류 없음, 런타임 오류 있음 ( java.lang.ClassCastException)
		// 		: 위 72, 73행 있을 때 (정상 실행) / 없을 때(런타임 오류) 비교해보기
		// => 그러므로 instanceof 연산자로 확인 후 DownCasting 적용해야 함
		
		if (an2 instanceof PetAnimal) {
			cat = (PetAnimal)an2;
			System.out.println("** an2는 PetAnimal 입니다.");
		} else {
			System.out.println(" an2는 PetAnimal이 될 수 없습니다.");
		}
		
		// ** 인스턴스의 class Type 확인하기
		// => Object에 정의된 getClass() 메서드 이용
		System.out.println("** dog의 ClassType => " + dog.getClass().getName());
		System.out.println("** cat의 ClassType => " + cat.getClass().getName());
		System.out.println("** an1의 ClassType => " + an1.getClass().getName());
		System.out.println("** an2의 ClassType => " + an2.getClass().getName());
		
		System.out.println("** Program End **");
		
		
		
	} //main

} //class
