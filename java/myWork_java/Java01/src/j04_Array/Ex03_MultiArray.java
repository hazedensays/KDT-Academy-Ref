package j04_Array;

//** 다차원 배열
//1차원 배열이 2개 모이면 2차원 배열
//1차원 배열이 3개 모이면 3차원 배열 ...2차원 이상은 거의 안쓰임

public class Ex03_MultiArray {

	public static void main(String[] args) {
		// 1. 명시적 선언
		int[][] mulArr = new int[2][3];
		//mulArr {{10, 20, 30}, {11, 22, 33}};
		
		mulArr[0][0] = 10;
		mulArr[0][1] = 20;
		mulArr[0][2] = 30;
		mulArr[1][0] = 11;
		mulArr[1][1] = 22;
		mulArr[1][2] = 33;
		
		//mulArr[1][2] ;
		// => 배열에서 값을 할당하지 않으면 default 값을 가짐 (int의 default : 0)
	
		for (int i = 0; i < mulArr.length; i++) {
			for (int j = 0; j < mulArr[i].length; j++) {
				System.out.printf("mulArr[%d][%d] => %d %n", i, j, mulArr[i][j]);
			}
		}
		
		System.out.println("=======================================");
		// 2. 묵시적 선언
		int[][] mulArr2 = {{1, 2, 3}, {4, 5}, {6, 7, 8, 9}};
		// => 명시적으로 내부 배열의 크기가 정의되어 있지 않기 때문에 각각의 크기를 가짐
		
		for (int i = 0; i < mulArr2.length; i++) {
			for (int j = 0; j < mulArr2[i].length; j++) {
				System.out.printf("mulArr[%d][%d] => %d %n", i, j, mulArr2[i][j]);
			}
		}
		
		//정의되어 있지 않는 배열 출력할 경우
		//System.out.println("mulArr2[5][5]" + mulArr2[5][5]);
		//Error : java.lang.ArrayIndexOutOfBoundsException
		
		
		
	}

}
