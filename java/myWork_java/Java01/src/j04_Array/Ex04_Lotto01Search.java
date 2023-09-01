package j04_Array;

import java.util.Arrays;

//** Lotto 번호 생성기 만들기 1
//=> int 를 6개 담을 수 있는 배열 생성 : lotto
//=> Random 으로 1~45 범위의 숫자를 생성해서 배열 초기화 하기
//(추가: 단, 중복은 허용하지 않음)
//=> 출력

public class Ex04_Lotto01Search {

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

		int max = numArr[0], min = numArr[0];
		
		for (int i = 0; i < numArr.length; i++) {
			if (numArr[i] > max) {
				max = numArr[i];
			}
			
			if (numArr[i] < min) {
				min = numArr[i];
			}
		}
		 
		Arrays.sort(numArr);	//배열 정렬
		
		System.out.println("numArr => " + Arrays.toString(numArr));
		System.out.println("min => " + min);
		System.out.println("max => " + max);

	}
}
