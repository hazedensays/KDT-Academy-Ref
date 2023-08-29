package j01_basic;

import java.util.Date;

public class Ex06_Print {

	public static void main(String[] args) {
		// ** Escape 문자 : 역할이 정해져 있는 문자
		// => \n 줄바꿈, \t 탭간격, ...
		// => 경로 : D:\mtest\mywork\java01...
		String path = "D:\\mtest\\...";
		System.out.println("** path => " + path);

		// => 'ABC', "ABC"
		System.out.println("** 따옴표 출력 => " + "'abc', \"abc\"");
		System.out.println("abcd\tefghi\tjk123\n");
		System.out.println("\n");
		System.out.println('\n'); // 한문자만(char) 출력하는 경우-> 작은따옴표 허용
		System.out.println('\''); // char ' 출력
		System.out.println('A');
		System.out.println('가');

		// ** print, println, printf
		System.out.print("** print1 => 개행 불가능");
		System.out.print("** print2 => 개행 가능 \n");
		System.out.print("** print3 => tab1 \t tab2 \t tab3 \t");
		System.out.print("** print4 => 개행 불가능");
		System.out.println();
		System.out.println();

		System.out.printf("반지름이 %d인 원의 넓이 => %10.2f \n", 10, 10 * 10 * Math.PI);
		// System.out.printf("%s는 %d학년 %d반, 학점은 %s 입니다.\n", "김하제", 2, 1.2, "A++");
		// => 출력 data와 format이 type이 같지 않을 경우 -> 컴파일 오류 X, 런타임 오류 O
		// error : java.util.IllegalFormatConversionException: d != java.lang.Double

		// ** 날짜출력
		// java.util.Date now = new java.util.Date(); -> import 안했을 시
		Date now = new Date();
		System.out.printf("오늘은 %tY년 %tm월 %td일 입니다. \n", now, now, now);
		System.out.printf("오늘은 %1$tY년 %1$tm월 %1$td일 입니다. \n", now);
		System.out.printf("지금은 %1$tH시 %1$tM분 %1$tS초 입니다. \n", now);

		// => 출력형식
		// % : 출력형식을 의미하는 문자열은 반드시 %로 시작,
		// %d : 정수 , %f 실수, %s 문자
		// %,d : 정수에 3자리마다 , 표시
		// %t : 날짜 시간을
		// %n , \n : 줄바꿈
		// $ 사용하면 매개변수의 갯수를 줄일 수 있음
		// => %2$d : 2번째 매개변수 정수

		// -는 왼쪽 정렬방식
		System.out.printf("%3d %10s %8s %-5d %n", 1, "jang", "장희정", 20);
		System.out.printf("%3d %9s %8s %-5d %n", 22, "hee", "정효욱", 03);

	}

}
