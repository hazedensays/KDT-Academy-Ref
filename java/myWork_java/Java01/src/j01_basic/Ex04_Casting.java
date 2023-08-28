package j01_basic;

//** Type Casting (형변환)
//1. 자동 (프로모션 promotion , 확대 형변환)
// => 큰자료형에 작은자료형을 대입하면 : 자동으로 이루어짐

//2. 강제 (디모션, demotion, 축소 형변환)
// => 작은자료형에 큰자료형을 대입 : 자동으로 이루어지지않음
//=> 자료의 Type이 다른경우
//=> 명시적 형변환

public class Ex04_Casting {

	public static void main(String[] args) {
		// 1. 자동 (프로모션 promotion, 확대 형변환)
		double d = 123.456; // 8byte
		int i = 123456; // 4byte
		d = i;

		System.out.printf("promotion Test => d: %f / i: %d\n", d, i);

		// i = d; Error : Type mismatch: cannot convert from double to int

		// 2. 강제 (디모션, demotion, 축소 형변환)
		i = (int) d;
		System.out.printf("promotion Test => d: %f / i: %d\n", d, i);

		// 2-1) 같은 크기, 다른 type인 경우 (int, float)
		float f = 456.789f;
		int n = 100;

		// n = f; Error : Type mismatch: cannot convert from float to int
		// f = n; // 허용 : 자동 형변환
		// System.out.printf("demotion Test => f: %f / n: %d\n", f, n);

		n = (int) f;
		System.out.printf("demotion Test => f: %f / n: %d\n", f, n);

		// 2-2) 정수형 연산
		// => 4byte 이하 type의 정수형 연산에 경우, 무조건 결과는 int (4byte)로 처리
		short s1 = 10, s2 = 20, s3 = 0;
		// s3 = s1 + s2; Type mismatch: cannot convert from int to short
		s3 = (short) (s1 + s2);
		System.out.println("정수형 연산 => " + s3);
		
		// 2-3) 정수형 연산
		char c = 'C';
		System.out.printf("demotion char1 => c : %s, c의 코드값 : %d\n", c, (int)c);
		n = c + 123; // 자동형변환으로 산술 연산이 적용됨
		System.out.println("demotion char2 =>" + n + ", n의 char 값 => " + (char)n);

	}
}
