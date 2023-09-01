package j04_Array;

import java.util.Arrays;

public class Ex01_arrayBasic {

	public static void main(String[] args) {
		// ** 과제
		// => 5명의 성적을 처리한다고 가정
		int s1 = 11, s2 = 22, s3 = 33, s4 = 44, s5 = 55;

		int sum = s1 + s2 + s3 + s4 + s5;
		double avg = (double) (sum / 5);

		// ** 배열 : 동일성격의 동일Type 의 자료를 하나의 묶음으로 처리
		// 장점 => 일괄처리 (반복문적용)
		// 특징 => 동일타입, 모든 자료형에 적용가능
		// 방법
		// => 선언 후 사용 : 명시적선언, 묵시적선언
		// => 크기(length), 인덱스(0 부터 length-1)

		// 1. 명시적 선언 (new 연산자 이용)
		// => 크기를 반드시 지정
		int[] score = new int[5];

		// 2. 초기화
		score[0] = 11;
		score[1] = 22;
		score[2] = 33;
		score[3] = 44;
		score[4] = 55;

		// Error : Type mismatch: cannot convert from String to int (컴파일 오류)
		// score[4] = "55";

		// Error : Index 5 out of bounds for length 5 (컴파일 오류 X, 런타임 오류 O)
		// score[5] = 66;

		// 2-1. 합계구하기
		sum = 0;

		for (int i = 0; i < score.length; i++) {
			sum += score[i];
		}

		System.out.println("** score의 주소값 => " + score);
		System.out.println("** score의 크기 => " + score.length);
		System.out.println("** score의 sum => " + sum);
		System.out.println("** Arrays 활용 => " + Arrays.toString(score));

		// ** eachFor (쉬운, 간편한 for 구문)
		// for each 문 : JDK5.0 부터 지원되는 향상된 for 문
		// for (변수타입 변수명 : 배열이름 ) { 실행부 }
		// => 배열의 요소의 갯수(배열의 크기) 만큼 반복 하며
		// 배열 score 가 가지고 있는 값을 순차적으로 변수(s) 에 전달
		// => 주의사항
		// 배열의 값만 순차적으로 사용가능하며 read만 가능. write 불가능
		// (순차처리, readOnly)
		sum = 0;
		
		for (int i : score) {
			System.out.print(i + " ");
			sum += i;
		}
		System.out.println("\n** eachFor : score의 sum => " + sum);
		
		
		// 3. 묵시적 정의
		// => new 연산자를 사용하지 않고, 선언과 동시에 초기화
		char[] grade = {'A', 'B', 'C', 'D', 'F'};
		
		for (char i : grade) {
			System.out.print(i + " ");
		}
		
		
	}

}
