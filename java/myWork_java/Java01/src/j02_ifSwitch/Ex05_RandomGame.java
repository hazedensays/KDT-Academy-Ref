package j02_ifSwitch;

import java.util.Scanner;

//** 숫자 맞추기 게임
//=> 1~10 범위에서 숫자 하나를 입력받아
//=> Random 함수의 결과와 일치하면 금메달
//=> 차이가 1 이면 은메달, 차이가 2면 동메달, 아니면 꽝
//=> Math 클래스를 이용하세요 ~~

public class Ex05_RandomGame {

	public static void main(String[] args) {
		int randomNum = (int) (Math.random() * 10) + 1;
		System.out.println("당첨번호 몰래 보기 => " + randomNum);

		Scanner sc = new Scanner(System.in);
		System.out.printf("1 ~ 10 중 하나의 숫자를 입력하세요. > ");

		int num = Integer.parseInt(sc.nextLine());

		int absM = Math.abs(randomNum - num);

		if (randomNum == num) {
			System.out.println("당첨입니다잉^^ (정답 봤지 ? )");
		} else if (absM == 1) {
			System.out.println("까비 ^^");
		} else if (absM == 2) {
			System.out.println("다시 도전해보삼 ㅋㅋ");
		} else {
			System.out.println("축하합니다. 당신은 *운없는 사람*에 당첨되셨습니다. ^^");
		}
		
		sc.close();

	}

}
