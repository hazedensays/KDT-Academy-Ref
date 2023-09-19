package j15_enum;

//** Enum 클래스 (java.lang.Enum)
//=> 모든 열거형의 조상
//=> 열거형을 지원하는 다양한 메서드제공
// values(), valueOf(), name(), ordinal() 등
// ordinal() 은 열거형 상수가 정의된 순서를 정수로 반환 (0부터 시작)
// 그러나 이값은 내부적 용도이므로 열거형 상수의 값으로 사용하지 않는것이 좋다.

enum Direction {
	EAST, WEST, SOUTH, NORTH
} // enum

public class Ex02_enumMethod {

	public static void main(String[] args) {
		// ** 열거형 Test
		Direction d1 = Direction.EAST;
		Direction d2 = Direction.valueOf("WEST");
		Direction d3 = Direction.valueOf(Direction.class, "SOUTH");
		Direction d4 = Direction.NORTH;
		
		System.out.printf("d1 = %s, d2 = %s, d3 = %s, d4 = %s%n", d1, d2, d3, d4);
		
		
		
		
	}

}
