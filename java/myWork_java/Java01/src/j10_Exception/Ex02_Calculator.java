package j10_Exception;

import java.util.Scanner;

//** 실습
//=> 두개의 정수를 입력 받아 4칙연산(+,-,*,/) 결과 출력하기
//=> 입력 정수는 1 ~ 99 까지 허용
//=> nextLine() 으로 입력 받기 -> try~catch 적용하기
//1) 범위를 벗어난 값를 입력하면 정상 값 입력 할때까지 반복
//2) 반복분 이용해서 종료하고 싶을때까지 Test 하기.

//** Scanner 사용시 주의 사항
//=> nextInt() , nextLine() 사용시 주의
// nextInt()는 개행문자 (\n) 가 뒤에 붙고, 숫자만 받아 처리한다. 
// 그래서 nextInt() 만 계속되면 문제가 없는데, 
// 뒤이어서 nextLine() 이 오면 앞 nextInt() 의 
// 남겨진 \n 을 한줄로 인식 받아 버린다.

public class Ex02_Calculator {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num1, num2;

		while (true) {

			try {
				System.out.println("숫자 2개를 입력해주세요.");
//	            num1 = Integer.parseInt(sc.nextLine());
//	            num2 = Integer.parseInt(sc.nextLine());
				num1 = sc.nextInt();
				num2 = sc.nextInt();

				if (0 < num1 && num1 < 100 && 0 < num2 && num2 < 100) {
					System.out.printf("%d + %d = %d%n", num1, num2, num1 + num2);
					System.out.printf("%d - %d = %d%n", num1, num2, num1 - num2);
					System.out.printf("%d * %d = %d%n", num1, num2, num1 * num2);
					System.out.printf("%d / %d = %d%n", num1, num2, num1 / num2);
					break;
				} else {
					System.out.println("1~99까지 다시 입력하세요.");
				}
			} catch (Exception e) {
				System.out.println("숫자로만 입력해주세요.");
				sc.nextLine();
			} finally {
				System.out.println("I want to go home.");
			}
		} // while

		System.out.println("정상 종료 입니다~");
		sc.close();

	}

}
