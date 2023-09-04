package j04_Array;

import java.util.Arrays;
import java.util.Random;

public class Ex06_Shuffle {

	public static void main(String[] args) {
		// **배열 활용 (섞기 Shuffle)
		// => 길이가 10인 배열 정의 하고, 0~9 로 초기화
		// => random 을 이용해서 배열의 임의의 위치에 있는 배열의 값과
		// 배열의 첫번째(0) 값과 교환하는일을 100번 반복해서 배열을
		// 뒤섞이도록 한후, 출력하기.
		// => 교재 139p

		// ** 복습: 연습문제 5-4
		// ** 예습: 교재6장 160p~175p 를 읽고
		// => 클래스, 객체, 인스턴스를 간단히 비교 & 요약 해오세요 ~~

		int arr[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(Arrays.toString(arr));
		Random rn = new Random();

		for (int i = 0; i < 100; i++) {
			int n = rn.nextInt(9) + 1;
			int temp = arr[0];
			arr[0] = arr[n];
			arr[n] = temp;
		}
		System.out.println(Arrays.toString(arr));

	}

}
