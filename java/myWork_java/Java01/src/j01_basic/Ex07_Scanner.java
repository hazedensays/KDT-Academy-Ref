package j01_basic;

import java.util.Scanner;

public class Ex07_Scanner {

	public static void main(String[] args) {
		// 1. Scanner 정의 (생성)
		Scanner sc = new Scanner(System.in);

		// 2. 입력 받기
		System.out.printf("이름을 입력하세요 > ");
		String name = sc.nextLine();

		System.out.printf("나이를 입력하세요 > ");
		// int age = sc.nextInt(); // 정상 실행 : 입력된 enter_key 값은 두고 숫자값만 가져감
		// sc.nextLine(); // 그러므로 nextLine()을 주로 사용함
		// 다른 타입 입력 시 : java.util.InputMismatchException

		// nextLine으로 입력받고 int로 형변환
		int age = Integer.parseInt(sc.nextLine());
		// => 다른 타입 입력 시 : java.lang.InputMismatchException

		System.out.printf("키를 입력하세요 > ");
		// double height = sc.nextDouble(); // 정상 실행 : 입력된 enter_key 값은 두고 숫자값만 가져감
		// sc.nextLine();

		// nextLine으로 입력받고 double로 형변환
		double height = Double.parseDouble(sc.nextLine());

		System.out.printf("별명을 입력하세요 > ");
		String nickname = sc.nextLine();

		System.out.printf("저의 이름은 %s이고, 저는 %d살 입니다.\n" + "그리고 저의 키는 %.1f이에요.\n 저를 %s라고 불러주세요.\n", name, age, height,
				nickname);

		sc.close();

	}

}
