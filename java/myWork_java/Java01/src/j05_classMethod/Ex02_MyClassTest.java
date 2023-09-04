package j05_classMethod;

class WhatToEat {
	public String breakFast;
	public String lunch;
	public String dinner;
	public int coffeeTotal = 200;

	public void coffeeML(int localCoffee) {
		//int coffeeTotal = 1000;	//지역 변수 우선 적용
		
		coffeeTotal += 10; // 전역 변수
		System.out.println("** 지역변수 coffeeTotal_1 => " + coffeeTotal);
		
		// ** 지역(local)변수
		// => 내부에 정의된 변수, 인자
		// => { ... } 내부에서만 적용 가능
		// 클래스 외부에서 접근 불가능
		// 전역 변수와 동일한 이름의 지역 변수를 정의하면 지역 변수 우선 적용
		// 단, 지역 변수 선언 이후부터
		
		//int coffeeTotal = 1000;
		System.out.println("** 지역변수 coffeeTotal_2 => " + coffeeTotal);
	}

	public String toString() {
		return "나는 아침으로 " + breakFast + ", 점심으로는 " + lunch + ", 저녁으로는 " + dinner + "을 먹었당. 그리고 커피는 총 " + coffeeTotal
				+ "ml를 마셨어요.";
	}

}

public class Ex02_MyClassTest {

	public static void main(String[] args) {
		WhatToEat myfirstDay = new WhatToEat();
		myfirstDay.breakFast = "팬케이크";
		myfirstDay.lunch = "훠궈";
		myfirstDay.dinner = "고등어회";
		myfirstDay.coffeeML(700);

		System.out.println(myfirstDay.toString());

		// ==================================================

		WhatToEat mysecDay = new WhatToEat();
		mysecDay.breakFast = "김밥";
		mysecDay.lunch = "샤브샤브";
		mysecDay.dinner = "삼겹살";
		mysecDay.coffeeTotal = 550;

		System.out.println(mysecDay.toString());

	}

}
