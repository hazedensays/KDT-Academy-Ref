package j08_AbsInterface;

//** interface 1
//=> 상수, 추상메서드
//=> static, default 메서드 (구현부가 있는 메서드, Java8 부터 추가됨)

interface AnimalIF {
	void breath();

	void sound();

	void special();
}

class CatIF implements AnimalIF {
	@Override
	public void breath() {
		System.out.println("냐옹이가 숨을 크게 쉰드아");
	}

	@Override
	public void sound() {
		System.out.println("냐옹이가 소리를 크게 낸드아");
	}

	@Override
	public void special() {
		System.out.println("냐옹이는 special of special");
	}
} // catIF

class DogIF implements AnimalIF {
	@Override
	public void breath() {
		System.out.println("멍멍이가 숨을 크게 쉰드아");
	}

	@Override
	public void sound() {
		System.out.println("멍멍이가 소리를 크게 낸드아");
	}

	@Override
	public void special() {
		System.out.println("멍멍이는 special of special");
	}
} // DogIF

class RabbitIF implements AnimalIF {
	@Override
	public void breath() {
		System.out.println("토순이가 숨을 크게 쉰드아");
	}

	@Override
	public void sound() {
		System.out.println("토순이가 소리를 크게 낸드아");
	}

	@Override
	public void special() {
		System.out.println("토순이는 special of special");
	}
} // RabbitIF

public class Ex02_InterAnimal {

	public static void main(String[] args) {
		// 1) 생성
		// => 직접생성은 불가능
		// => 인스턴스의 Type 으로는 정의가능, 구현클래스를 통해 생성됨
		// => 그러나 사용범위는 interface 에 정의된 만큼만
		AnimalIF c1 = new CatIF();
		c1.breath();
		c1.sound();
		c1.special();

		CatIF c2 = new CatIF();
		c2.breath();
		c2.sound();
		c2.special();

		// 2) 다형성 적용
		AnimalIF animal = new DogIF(); // CatIF(), RabbitIF(), DogIF()
		animal.breath();
		animal.sound();
		animal.special();
		
		animal = c1;
		animal = c2;	//AnimalIF animal = new catIF()와 동일 구문
		//c2 = c1;		//CatIF c2 = new AnimalIF()와 동일 구문 -> 허용 X
		//c2 = animal;
		
		
		// 3) 메서드 호출
		animalUse(c1);
		animalUse(c2);
		animalUse(animal);
		animalUse(new RabbitIF());
		
		// 4) 연산자 instanceof 적용
		Bear bear = new Bear();
		if (bear instanceof AnimalIF) {
			//animalUse(bear);
			System.out.println("** bear은 AnimalIF 인스턴스입니다.**");
		} else {
			System.out.println("** bear은 AnimalIF 인스턴스가 아닙니다.**");			
		}

	} // main

	public static void animalUse(AnimalIF animal) {
		animal.breath();
		animal.sound();
		animal.special();
	}

}
