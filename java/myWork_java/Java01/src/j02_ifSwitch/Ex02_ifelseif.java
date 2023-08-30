package j02_ifSwitch;

import java.util.Scanner;

public class Ex02_ifelseif {

	public static void main(String[] args) {
		// ** 등급 처리
		// => score 90이상:A , 80이상:B, 70이상:C, 60이상:D, 아니면 "F" 출력
		// => 이상 / 이하 (포함)
		// => 초과 / 미만 (불포함)

		System.out.printf("점수를 입력하세요 > ");
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();

		char grade = 'A';

		if (score >= 90) {
			if (score == 100) {
				System.out.println("장학금을 주겠노라 으하하하하!!!!!!!!!!");
			}
			System.out.println(grade + "점 => " + "통과^^");
		} else if (score >= 80) {
			grade = 'B';
			System.out.println(grade + "점 => " + "조금만 더 노력해보세요^^");
		} else if (score >= 70) {
			grade = 'C';
			System.out.println(grade + "점 => " + "노력이 부족하군요. 분발하세요");
		} else if (score >= 60) {
			grade = 'D';
			System.out.println(grade + "점 => " + "가망이 없습니다.....");
		} else {
			grade = 'F';
			System.out.println(grade + "점 => " + "그냥 포기하세요..");
		}

		// ** 중첩 if
		score = 78;
		if (score >= 90) {
			grade = 'A';
		} else {
			if (score >= 80) {
				grade = 'B';
			} else {
				if (score >= 70) {
					grade = 'C';
				} else {
					if (score >= 60) {
						grade = 'D';
					} else {
						grade = 'F';
					}
				}
			}
		} // if
		System.out.printf("** score=%d, grade=%s \n", score, grade);

	}

}
