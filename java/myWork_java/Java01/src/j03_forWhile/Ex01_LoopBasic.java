package j02_ifSwitch;

// ** 반복문 의 3요소 : 반복자의 초기값, 조건식(true or false), 증감식
// => for : for(초기값; 조건식; 증감식)
// => while, do while : 초기값(before while_Loop),
//		조건식(true or false => while 조건문), 
//		증감식(in while_Loop)

// ** 반복자(iterator)
// => 반복문에서 횟수를 count 하는 변수

public class LoopBasic {

	public static void main(String[] args) {
		// ** 과제
		// => 1~100 까지의 합 출력하기
		// => 1+2+3+.......+100
		// => int result = 1+2+3+.......+100 ;
		int result = 0;

		// 1) for
		for (int i = 1; i <= 100; i++) {
			result += i;
		}

		System.out.println("for : result => " + result);
		System.out.println();

		// 2) while
		result = 0;
		int i = 1;

		while (i <= 100) {
			result += i;
			i++;
		}

		System.out.println("while : result => " + result);
		System.out.println();

		// 3) do_while
	    // => 조건에 맞지 않아도 최소한 1번은 무조건 실행함. 
		result = 0;
		i = 1;

		do {
			result += i;
			i++;
		} while (i <= 100);

		System.out.println("do-while : result => " + result);
		System.out.println();

	}

}

