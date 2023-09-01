package j04_Array;

import java.util.Arrays;
import java.util.Random;

//*** Random 클래스
//=> java.util 에 있으므로 import 필요하고, new 선언후 사용가능함.
//=> Random() : 호출시마다 현재시간을 이용한 종자값이 자동 설정됨 
// Random(long seed) : 인자값으로 주어진 종자값이 설정됨 
// 종자값 : 난수 만드는 알고리즘에서 사용되는 값
//         ( 같으면 같은난수 얻음 )
//
//=> Random().nextInt(큰수 - 작은수 + 1) + 작은수 
// Random().nextInt() , Random().nextLong() , Random().nextBoolean()
// Random().nextDouble() , Random().nextFloat()

public class SetSeed_Lotto {

	public static void main(String[] args) {

		long seed = System.currentTimeMillis(); // 현재 시간을 시드로 사용
		Random random = new Random(seed);

		int[] myNum = new int[6];
		int[] lottoNum = new int[6];

		for (int i = 0; i < myNum.length; i++) {
			myNum[i] = random.nextInt(45) + 1;
			for (int j = 0; j < i; j++) {
				if (myNum[i] == myNum[j]) {
					i--; // 중복된 값이면 다시 난수를 생성
					break;
				}
			}
		}

		// lottoNum 배열에도 동일한 시드로 생성
		random.setSeed(seed); // 동일한 시드로 설정
		for (int i = 0; i < lottoNum.length; i++) {
			lottoNum[i] = random.nextInt(45) + 1;
			for (int j = 0; j < i; j++) {
				if (lottoNum[i] == lottoNum[j]) {
					i--; // 중복된 값이면 다시 난수를 생성
					break;
				}
			}
		}

		// 배열 비교
		if (Arrays.equals(myNum, lottoNum)) {
			System.out.println("당첨띠");
		} else {
			System.out.println("탈락띠");
		}
	}

}
