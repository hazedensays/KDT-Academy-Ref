package j02_ifSwitch;

import java.util.Scanner;

public class Ex04_switchMonth {

	public static void main(String[] args) {
		
//		=> new_version : Java 버젼 15이상 부터 가능
//				switch (month) {
//				case 1,3,5,7,8,10,12: days = 31; break;
//				case 4,6,9,11: days = 30; break;
//				case 2:  days = 29; break;
//				}
  
		Scanner sc = new Scanner(System.in);

		
		System.out.printf("연도 (year)를 입력하세요 > ");
		int year = Integer.parseInt(sc.nextLine());
		
		System.out.printf("월 (month)을 입력하세요 > ");
		int month = Integer.parseInt(sc.nextLine());

//		switch (month) {
//		case 3:
//		case 4:
//		case 5:
//			System.out.printf("%d월은 %s입니다.%n", month, "봄");
//			break;
//			
//		case 6:
//		case 7:
//		case 8:
//			System.out.printf("%d월은 %s입니다.%n", month, "여름");
//			break;
//			
//		case 9:
//		case 10:
//		case 11:
//			System.out.printf("%d월은 %s입니다.%n", month, "가을");
//			break;
//			
//		case 12:
//		case 1:
//		case 2:
//			System.out.printf("%d월은 %s입니다.%n", month, "겨울");
//			break;
//
//		}

//		if ((month == 4 || month == 6 || month == 9 || month == 11) && month != 2) {
//			System.out.printf("%d월은 30일까지 입니다.%n", month);
//		} else if (month == 2) {
//			System.out.printf("%d월은 28일까지 입니다.%n", month);
//		} else {
//			System.out.printf("%d월은 31일까지 입니다.%n", month);			
//		}

		int day = 0;

		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			day = 31;
			break;

		case 4:
		case 6:
		case 9:
		case 11:
			day = 30;
			break;

		case 2:
            if (((year % 4) == 0 && (year % 100) != 0 || (year % 400) == 0)) {
            	day = 29;            	
            } else {
        	  day = 28;
            }
            break;
		}

		String season = "";

		switch (month) {
		case 3:
		case 4:
		case 5:
			season = "봄";
			break;

		case 6:
		case 7:
		case 8:
			season = "여름";
			break;

		case 9:
		case 10:
		case 11:
			season = "가을";
			break;

		case 12:
		case 1:
		case 2:
			season = "겨울";
			break;
		}
		System.out.printf("%d년, %d월은 %d까지 있고, %s입니다.", year, month, day, season);

	}

}
