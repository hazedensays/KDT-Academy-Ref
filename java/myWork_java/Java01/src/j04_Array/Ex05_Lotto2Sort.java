package j04_Array;

import java.util.Arrays;

// => 순차정렬 (Sequence Sort)
// => 정렬 알고리즘에서 가장 간단하고 기본이 되는 알고리즘으로
//    배열의 처음과 끝을 탐색하면서 차순대로 정렬하는 가장 기초적인 정렬 알고리즘
// ** 정렬 알고리즘 : 삽입(insert)정렬, 합병(Merge)정렬, 퀵(Quick)정렬...
// => https://blog.naver.com/tepet/221690306235 

public class Ex05_Lotto2Sort {

	public static void main(String[] args) {
		int[] numArr = new int[6];

		for (int i = 0; i < numArr.length; i++) {
			int randomNum = (int) (Math.random() * 45) + 1;
			numArr[i] = randomNum;

			for (int j = 0; j < i; j++) {
				if (numArr[i] == numArr[j]) {
					--i;
					break;
				}
			}

		}

		// Arrays.toString를 이용한 배열 출력 ===================================
		System.out.println("Arrays.toString : numArr => " + Arrays.toString(numArr));

		// Arrays.sort를 이용한 배열 정렬 ======================================
		Arrays.sort(numArr);
		System.out.println("Arrays.sort : numArr => " + Arrays.toString(numArr));

		int temp = 0;
		int max = numArr[0], min = numArr[0];

		// 내림차순 =======================================================
		for (int i = 0; i < numArr.length; i++) {
			for (int j = i + 1; j < numArr.length; j++) {
				if (numArr[i] < numArr[j]) {
					temp = numArr[i];
					numArr[i] = numArr[j];
					numArr[j] = temp;
				}
			}
		}

		System.out.println("내림차순 : numArr => " + Arrays.toString(numArr));

		// 오름차순 ========================================================
		for (int i = 0; i < numArr.length; i++) {
			for (int j = i + 1; j < numArr.length; j++) {
				if (numArr[i] > numArr[j]) {
					temp = numArr[i];
					numArr[i] = numArr[j];
					numArr[j] = temp;
				}
			}
		}

		System.out.println("오름차순 : numArr => " + Arrays.toString(numArr));

		// 배열 Wrapper Class : Arrays
		// ========================================================
		// => Arrays 의 주요 메서드 : equals(null, null), sort(null)

		// myNumber 생성후 비교하기
		// => 배열정의, Random 추출 후, 중복확인 후 배열에 담기,
		// => 정렬, equals 비교
		int[] myNum = new int[6];
		int[] lottoNum = new int[6];

		for (int i = 0; i < myNum.length; i++) {
			int randomNum = (int) (Math.random() * 45) + 1;
			myNum[i] = randomNum;

			for (int j = 0; j < i; j++) {
				if (myNum[i] == myNum[j]) {
					--i;
					break;
				}
			}
		}
		
		for (int i = 0; i < lottoNum.length; i++) {
			int randomNum = (int) (Math.random() * 45) + 1;
			lottoNum[i] = randomNum;

			for (int j = 0; j < i; j++) {
				if (lottoNum[i] == lottoNum[j]) {
					--i;
					break;
				}
			}
		}
		
		if (Arrays.equals(numArr, lottoNum)) {
			System.out.println("당첨띠");
		} else {
			System.out.println("탈락띠");
		}
		
		
		

	}

}
