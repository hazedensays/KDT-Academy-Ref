package j03_forWhile;

public class Ex06_star {

	public static void main(String[] args) {
		// 1) 반삼각형
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.printf("*");
			}
			System.out.println();
		}

		System.out.println("=============================");

		int line = 5;
		
		for (int i = 1; i <= line; i++) {
			for (int j = 1; j <= (line - 1) + i; j++) {
				if (j < (line + 1) - i) {
					System.out.printf(" ");
				} else {
					System.out.printf("*");
				}
			}
			System.out.println();
		}
		
//       선생님 코드
//		for (int i = 1; i <= line; i++) {
//			for (int j = 1; j <= line - i; j++) {
//				System.out.printf(" ");
//			}
//			for (int k = 1; k < i * 2 - 1; k++) {
//				System.out.printf("*");
//			}
//			System.out.println();
//		}
		
		System.out.println("=============================");
		
//		int m = (line + 1) / 2;
//		
//		for (int i = 1; i <= line; i++) {
//			if (i <= m) {
//				for (int j = 1; j <= m+1; j++) {
//					if (j < (line + 1) - i) {
//						System.out.printf(" ");
//					} else {
//						System.out.printf("*");
//					}
//				}
//			}
//		}
		
	      int line3 = 11;
	      for (int i = 0; i < line3 / 2 + 1; i++) {
	         for (int j = 1; j <= i; j++) {
	            System.out.print(" ");
	         }
	         for (int k = 1; k <= 2 * (line3 / 2 - i) + 1; k++) {
	            System.out.print("*");
	         }
	         System.out.println();
	      }
	      for (int i = line3 / 2 + 1; i > 1; i--) {
	         for (int j = 1; j < i - 1; j++) {
	            System.out.print(" ");
	         }
	         for (int k = 1; k <= 2 * ((line3 / 2 + 2) - i) + 1; k++) {
	            System.out.printf("*");
	         }
	         System.out.println();
	      }
		
		
		
		
		
		

	}

}
