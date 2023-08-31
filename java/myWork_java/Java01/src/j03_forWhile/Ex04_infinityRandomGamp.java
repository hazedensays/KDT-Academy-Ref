package j03_forWhile;

import java.util.Scanner;

public class Ex04_infinityRandomGamp {

	public static void main(String[] args) {
		int randomNum = (int) (Math.random() * 10) + 1;
		System.out.println("당첨번호 몰래 보기 => " + randomNum);

		Scanner sc = new Scanner(System.in);
		
		int num = 0, absM = 0, count = 1;

		while (true) {
			System.out.println();
			System.out.printf("*** 1 ~ 10 중 하나의 숫자를 입력하세요. > ");
			num = Integer.parseInt(sc.nextLine());
			absM = Math.abs(randomNum - num);
			if (randomNum == num) {
				System.out.println("당첨입니다잉^^ (정답 봤네 ㅋㅋ)");
				break;
			} else if (absM == 1) {
				System.out.println("1 차이 났다. 까비 ^^~");
				break;
			} else if (absM == 2) {
				System.out.println("2차이 났다. 다시 도전해보삼. 위에 정답있잖아");
				break;
			} else {
				System.out.println("축하합니다. 당신은 *운없는 사람*에 당첨되셨습니다. ^^");
				System.out.println("정직하군.....");
				count++;
			}

		}
		
		System.out.println();
		System.out.printf("=> 당첨번호 : %d, 입력번호 : %d, 차이 : %d %n=> %d번 시도 %n", randomNum, num, absM, count);

		sc.close();

	}

}
