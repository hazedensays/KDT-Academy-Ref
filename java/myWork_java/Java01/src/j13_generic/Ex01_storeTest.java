package j13_generic;

import j07_classExtends.Ex01_Car;

//------------------------------------------------------------
//** Generic
//=> 컬렉션(Collection:자료구조) 을 보강해준 기능
//=> 컴파일 단계에서 객체의 자료형을 선언(정의) 해주면
// 다른 타입의 자료가 저장될수 없도록 해주는 기능

//** Generic 클래스 정의
//=> 클래스 이름 옆에 <> 사이에 알파벳 1글자를 사용하여 
// Generic Type 명을 선언해줌 
// ex : <T> 처럼 "<" 와 ">" 사이에 선언 
//=> 대문자로 T, E 등을 많이 사용 
// Type 의미로 "T" 를 주로 사용
//=> Generic 타입으로 클래스를 사용한다는 의미 
//=> 제네릭으로 기본 자료형(int, float, double....)은 사용할 수 없지만
// 기본자료형의 wrapper 클래스를 이용할 수있다. 

//** Generic 타입제한 (사용시, Wildcards_와일드카드타입 이용으로)
//=> <?>
// Unbounded Wildcards (제한없음_모든 클래스나 인터페이스 타입 가능)
//=> <? extends 클래스명>
// Upper Bounded Wildcards (상위클래스 제한_같거나 하위 타입 가능)
//=> <? super 클래스명>
// Lower Bounded Wildcards (하위클래스 제한_ 같거나 상위타입 가능)

//=> 정의할때: <T> , <T extends 클래스명> , <T super 클래스명>
//------------------------------------------------------------

// 1) Object 이용한 기존 방식
// => 모든 클래스는 Object의 후손이므로
//		아래와 같이 Object Type으로 우측에 정의될 수 있음
//		즉, 모든 클래스는 setData의 매개변수가 될 수 있다
// 		Object data = new String("Generic_Test");
// => 이러한 Object의 특성을 이용해서 다목적용 클래스를 만들 수 있지만,
//		클래스 타입으로 인해 발생 가능한 런타임 오류를 컴파일 타임에서 알 수 없는 단점이 있음
class Store {
	private Object data;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}// class Store

// 2) Generic 방식
// => 다양한 클래스에 적용할 수 있는 다목적용 기능을 만들기 위해
// 클래스 멤버변수의 타입을 T(임의의 알파벳) 로 표현 해놓고
// 실행코드에서 결정해서 사용
// => 결정된 타입 이외에는 사용불가 ( Exception 발생 )

class StoreG<T> {
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}// class StoreG

public class Ex01_storeTest {

	public static void main(String[] args) {
		// 1) Object 이용한 기존 방식
		// => 다양한 클래스에 적용할 수 있는 다목적용 기능을 만들기 위해
		// 모든 클래스의 조상인 Object Type으로 하면 가능하지만,
		// 형변환이 불가능한 경우에 사용 시, 컴파일 오류가 없음 (런타임 오류 발생)
		// 이 상황을 방지하기 위해 Generic 프로그래밍 방식 이용
		Store s1 = new Store();
		s1.setData("마라탕");
		s1.setData(123); // int형 123 -> Integer : 자동형변환
		s1.setData(123.456); // double형 123.456 -> Double : 자동형변환
		s1.setData(new Ex01_Car(100, 500, "silver"));
		s1.setData(123.456f); // setData(Object data) : Object data = new Float(123.456f) 와 같은 현상이 발생 중
		Float f = (Float) s1.getData(); // s1.getData()이 Object 타입이기 때문에, 조상이 후손이 되는 UpCasting 발생 중

		System.out.println("** Test1) " + s1.getData());

		// String s = (String)s1.getData();
		// s1.getData()는 Object 타입인데 s1.getData()를 String 타입으로 형변환 시도 시에 오류가 발생한다.
		// (컴파일X, 런타임O)
		// => 런타임 오류 발생 : java.lang.ClassCastException
		// 즉, 컴파일 타임에서는 오류의 여부를 알 수 없음

		// 2) Generic 방식
		// => Generic Type 생략
		// 생성시 Generic Type 생략가능(경고) 하지만,
		// Generic 이 적용안됨 (기존방식처럼 작동됨 -> Object)
		StoreG<String> g1 = new StoreG<String>();
		g1.setData("GenericStore");
		// g1.setData(123.456); setData를 타입을 String타입으로 지정했기 때문에 에러발생

		StoreG<Integer> g2 = new StoreG<Integer>();
		g2.setData(123);
		// g2.setData(123.456); setData를 타입을 Integer타입으로 지정했기 때문에 에러발생

		StoreG<Ex01_Car> g3 = new StoreG<Ex01_Car>();
		g3.setData(new Ex01_Car(100, 500, "SILVER"));

		// StoreG<int> g4 = new StoreG<int>();
		// => Error : Syntax error, insert "Dimensions" to complete ReferenceType
		// : 객체형만 사용 가능, 기본 자료형 사용 불가능 (Wrapper_Class 이용하면 됨)

	}

}