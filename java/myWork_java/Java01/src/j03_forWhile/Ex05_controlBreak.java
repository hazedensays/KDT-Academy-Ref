package j03_forWhile;

public class Ex05_controlBreak {

	public static void main(String[] args) {
		// ** Continue
		// => Continue 문 이하의 구문을 실행하지 않고 다음 반복문 진행

		// ** Break
		// => 반복문 탈출

		// ** Label
		// => continue, break 가 적용될 반복문을 지정할 수 있도록 해줌
		// => 위치를 표시함
//		       반드시 ":" 표시,
		// 반드시 반복문 바로 위에 위치함.
		// -> Lable 다음에 반복문외의 문장이 오면 break, continue 에서 인식안됨 오류

		// ** 과제
		// => 5층건물에 각 층마다 7개의 방이 있고 이것을 [층,호실] 출력하기
		// => 4층 4호 는 창고이기 때문에 출력하지 않는다.

		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= 7; j++) {
				if (i == 3 && j > 5) {
					break;
				} else if (i == 4 && j == 4) {
					continue;
				}

				System.out.printf("[%d, %d]", i, j);

			}
			System.out.println();
		}

		System.out.println("====================================");

		// ** Label 적용
		// => continue, break 를 원하는 반복문 에 적용
		// => 원하는 반복문 위에 Labeling, 사용
		
		outer1: for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= 7; j++) {
				if (i == 3 && j > 5) {
					break;
				} else if (i == 4 && j == 4) {
					continue outer1;
				}

				System.out.printf("[%d, %d]", i, j);

			}
			System.out.println();
		}
		
		System.out.println("====================================");
		
		outer2: for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= 7; j++) {
				if (i == 3 && j > 5) {
					break outer2;
				} else if (i == 4 && j == 4) {
					continue;
				}

				System.out.printf("[%d, %d]", i, j);

			}
			System.out.println();
		}
		
		
		

	}

}
