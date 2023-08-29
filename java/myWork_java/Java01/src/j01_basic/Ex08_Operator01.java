package j01_basic;

//연산자(Operator)는 특정한 연산을 나타내는 기호
//피연산자(Operand)는 연산의 대상
//연산자의 우선순위 => ppt J03_02 , 23p

public class Ex08_Operator01 {

	public static void main(String[] args) {
		// ** 사칙연산
		int a = 10, b = 3;

		System.out.println("** 사칙 연산 **");
		System.out.println("a + b = " + (a + b));
		System.out.println("a - b = " + (a - b));
		System.out.println("a * b = " + (a * b));
		System.out.println("a / b = " + (a / b));
		System.out.println("a % b = " + (a % b));
		System.out.println();

		// ** 대입연산
		// a=a+b -> a+=b
		System.out.println("** 대입 연산 **");
		System.out.println("a += b => " + (a += b));
		System.out.println("a - = b => " + (a -= b));
		System.out.println("a * = b => " + (a *= b));
		System.out.println("a /= b => " + (a /= b));
		System.out.println("a %= b => " + (a %= b));
		System.out.println();

		// ** 단항연산
		// => 1씩 증감 (전/후)
		a = 10;
		b = 10;

		System.out.println("** 단항 연산 **");
		System.out.println("a++ => " + (a++)); // 출력 후 증가
		System.out.println("++b => " + (++b)); // 증가 후 출력

		System.out.println("a-- => " + (a--)); // 출력 후 감소
		System.out.println("--b => " + (--b)); // 감소 후 출력
		System.out.println("a => " + a);
		System.out.println();

		// ** 관계연산
		// => 모든 관계연산의 결과는 boolean Type : true(참) / false(거짓)
		a = 10;
		b = 3;

		System.out.println("** 관계 연산 **");
		System.out.println("a == b => " + (a == b));
		System.out.println("a != b => " + (a != b));
		System.out.println("a  > b => " + (a > b));
		System.out.println("a >= b => " + (a >= b));
		System.out.println("a < b => " + (a < b));
		System.out.println("a <= b => " + (a <= b));
		System.out.println();

		// ** 삼항식
		// => (조건) ? 참 : 거짓
		// String 포함, 모든 기본자료형에 적용가능
		// => a,b 중 큰값 출력하기
		int max = (a > b) ? a : b;
		boolean bool = (a > b) ? true : false;
		char cc = (a > b) ? 'T' : 'F';
		String str = (a > b) ? "is true" : "is false";

		System.out.println("** 삼항식  **");
		System.out.printf("max = %d, bool = %b, cc = %s, str = %s\n", max, bool, cc, str);
		System.out.println();

		// ** 논리(집합) 연산
		// => AND && , OR || , NOT !
		System.out.println("** 논리(집합) 연산  **");
		// 1) a, b 모두 짝수이면 true
		boolean b1 = a % 2 == 0 && b % 2 == 0;
		System.out.println("a, b 모두 짝수이면 true => " + b1);

		// 2) a, b 중 하나만 짝수이면 true
		boolean b2 = a % 2 == 0 || b % 2 == 0;
		System.out.println("a, b 중 하나만 짝수이면 true => " + b2);

		// 3) 부정, NOT
		boolean b3 = a != b;
		System.out.println("부정, NOT => " + b3);

	}

}
