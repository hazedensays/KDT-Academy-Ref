package j13_generic;

//** Generic Class Test 
//** FruitBox 만들기
//=> Apple, Banana 등 모든 과일을 담을수 있는 Generic FruitBox class 를 만들어 보세요.
// 단 과일들만 담을 수 있어야 함.
// ( 자율적으로 해보시면 됩니다. )
// 힌트: Apple, Banana 등 각종 과일들이 class 이고, 
//      이들은 과일(Fruit) 로 구분 될 수 있어야함.   
//=> 실습
// -> 1) Fruit 만들기
// -> 2) 과일 클래스들 만들기 (3개)
// -> 3) FruitBox 만들기 : 과일들담기_setter, 과일들출력메서드_fruitPrint()
// -> 4) main 완성하기

class FruitBox<T extends Fruits> {
	private T[] arr;

	public void setArr(T[] arr) {
		this.arr = arr;
	}

	public void fruitPrint() {
		for (T a : arr) {
			System.out.println(a);
		}
	}// fruitPrint()

}// class FruitBox

class Fruits {
	public String toString() {
		return "과일들의 모음집";
	}
}

class Banana extends Fruits {
	public String toString() {
		return "Banana";
	}
}// class Banana

class Apple extends Fruits {
	public String toString() {
		return "Apple";
	}
}// class Apple

class Tangerine extends Fruits {
	public String toString() {
		return "Tangerine";
	}
}// class Tangerine

public class Ex03_FruitBox {

	public static void main(String[] args) {
		Fruits[] ff = {(new Banana()), (new Apple()), (new Tangerine())};
		FruitBox<Fruits> f1 = new FruitBox<Fruits>();
		f1.setArr(ff);
		f1.fruitPrint();
		
//		Integer[] ii = {1, 2, 3, 4, 5};
//		FruitBox<Integer> f2 = new FruitBox<Integer>();
//		f2.setArr(ii);
//		f2.arrayPrint();
		
		
	}

}