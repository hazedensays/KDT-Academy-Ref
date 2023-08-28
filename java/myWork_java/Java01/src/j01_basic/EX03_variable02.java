package j01_basic;

// 기본 자료형의 Wrapper Class, 치환, overflow

public class EX03_variable02 {

	public static void main(String[] args) {
		// ** 치환
		// => 값의 맞교환 (cup1 의 값과 cup2의 값을 교환)
		// => box 내에 여러값이 들어있는데 그중 어떤값이 cup1 , cup2 의 값이 될지 모른다고 가정
		// => 중간 보관을 위한 같은 타입의 임시 변수가 필요함
		// => "=" 동일성을 의미하는것이 아니고 대입연산자
		String s1 = "김찬미";
		String s2 = "김하제";
		System.out.printf("s1 = > %s, s2 = > %s\n", s1, s2);

		String temp = s1;
		s1 = s2;
		s2 = temp;

		System.out.printf("s1 = > %s, s2 = > %s\n", s1, s2);
		System.out.println();

		
		// ** 기본 자료형의 Wrapper Class
		// => 기본 자료형을 지원해주는 클래스 (모든 기본 자료형에 있음)
		// 해당 클래스명은 기본 자료형의 첫 글자를 대문자로 하면 됨
		System.out.println("정수형의 Literal의 범위");
		System.out.println("byte => " + Byte.MIN_VALUE + "~" + Byte.MAX_VALUE);
		System.out.println("short => " + Short.MIN_VALUE + "~" + Short.MAX_VALUE);
		System.out.println("int => " + Integer.MIN_VALUE + "~" + Integer.MAX_VALUE);
		System.out.println("long => " + Long.MIN_VALUE + "~" + Long.MAX_VALUE);
		System.out.println();

		System.out.println("실수형의 Literal의 범위");
		System.out.println("float => " + Float.MIN_VALUE + "~" + Float.MAX_VALUE);
		System.out.println("double => " + Double.MIN_VALUE + "~" + Double.MAX_VALUE);
		System.out.println();
		
		
		// ** 오버플로우(overflow) / 언더플로우(underflow)
		// 1) 정수형
		// => 컴파일, 런타임 오류 없음
		short sMax = Short.MAX_VALUE;
		short sMin = Short.MIN_VALUE;
		
		// => short 의 오버플로우(overflow) Test : 최소값과 동일
		System.out.printf("short 의 오버플로우 Test1 -> sMax = %d, sMax + 1 = %d\n", sMax, sMax + 1);
		System.out.printf("short 의 오버플로우 Test2 -> sMax = %d, sMax + 1 = %d\n", sMax, (short)(sMax + 1));
		System.out.println();
		
		// => short 의 언더플로우(underflow) Test : 최대값과 동일
		System.out.printf("short 의 언더플로우 Test1 -> sMin = %d, sMin + 1 = %d\n", sMin, sMin - 1);
		System.out.printf("short 의 언더플로우 Test2 -> sMin = %d, sMin + 1 = %d\n", sMin, (short)(sMin - 1));
		System.out.println();
		
		// 2) 실수형
		// => by zero Test
		// => 컴파일, 런타임 오류 없음
		float f = 1234.567f;
		System.out.println("** 실수형 by 0, 나누기 연산자 => " + (f/0));
		// Infinity (무한수) -> 오버플로우(overflow)
		
		System.out.println("** 실수형 by 0, 나머지 연산자 => " + (f%0));
		// NaN (Not a Number) -> 언더플로우(underflow)
		
		// 비교 : 정수형의 by zero
		System.out.println("** 정수형 by 0, 나누기 연산자 => " + (sMax/0));
		System.out.println("** 정수형 by 0, 나머지 연산자 => " + (sMax%0));
		
		
	}

}
