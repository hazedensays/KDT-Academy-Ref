package j02_ifSwitch;

import java.util.Scanner;

//** switch - case - break 문
//1. => switch(key) 문 인자의 Type은 int, char, String 만 가능
//2. => break : 무조건 탈출 (없으면 아래로 계속 default 까지 진행)
//3. => case 블럭에 구문이 없어도 됨 (아래 구문으로 진행됨)
//4. => case 블럭에는 복합구문에도 {....} 사용하지 않음 
//5. => case 값으로 변수 사용은 불가 그러나 변수를 사용하지 않은 수식은 허용

public class Ex03_switchBasic {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("추천 메뉴를 입력해주세요 > "); // ================================

		int i = Integer.parseInt(sc.nextLine());

		System.out.printf("** 점심메뉴 오스스메 **");
		System.out.println();

		System.out.printf(" => ");

		switch (i) {
		case 1:
			System.out.println("라면");

			if (i == 1) {
				System.out.println();
				System.out.printf("후식을 선택하세요 > "); // ================================

				String desert = sc.nextLine().toLowerCase();

				switch (desert) {
				case "cake":
					System.out.println("레드벨벳 치즈 케이크");
					break;
				case "cookie":
					System.out.println("초콜릿 스모어 쿠키");
					break;
				case "macarong":
					System.out.println("황치즈 뽀또 마카롱");
					break;
				default:
					System.out.println("다쿠아즈");
				}

				System.out.println("enjoy your desert ^^ ***");
			}
			break;
		case 2:
			System.out.println("칼국수");
			break;
		case 3:
			System.out.println("떡볶이");
			break;
		case 4:
			System.out.println("짜장면");
			break;
		default:
			System.out.println("급식");
		}
		if (i != 1) {
			System.out.println("맛있게 드세요 ^^***");
		}
		System.out.println();

		System.out.printf("커피는 hot or Iced ☕☕ (hot = h, Iced = c) "); // ================================

		char option = sc.nextLine().toUpperCase().charAt(0);

		switch (option) {
		case 'H':
			System.out.println("hot");
			break;
		case 'C':
			System.out.println("cold");
			break;
		default:
			System.out.println("hot");
		}

		System.out.println(" => Good Choice ^^");
		System.out.println();

		sc.close();

	}

}
