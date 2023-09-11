package j07_classExtends;

import j06_packageTest.Ex01_CarPackageTest_;
import static j07_classExtends.Animal.color;

import java.util.Arrays;

	//** static, final 과 상속, main 메서드 정리

	//** static import
	//=> static 맴버 호출시 클래스명 생략가능

public class Ex04_Father {
	
	// ** import Test
	//j06_packageTest.Ex01_CarPackageTest_ car;	//import하진 않는 경우
	Ex01_CarPackageTest_ car;  //import 하는 경우 => 포함 (has_a)
	
	//** static import 비교 Test => import한 클래스의 변수명과 현재(father) 클래스의 변수명이 같을 시
	// static String color = "colorInFatherClass";
	
	// => 모든 자손의 인스턴스가 공유하는 값은 static으로 정의함
	// => static 적용 전/후 child 인스턴스 생성 시 비교해봄
	static String name;
	private int money;
	static String country = "Korea";

	Ex04_Father() {
		System.out.println("** Father Default 생성자 **");
	}

	Ex04_Father(String name, int money) {
		Ex04_Father.name = name;
		this.money = money;
		System.out.println("** Father 초기화 생성자 **");
	}
	
	// => 오버라이딩 불가 : final
	//final public void bank (int money) {
	public void bank (int money) {
		this.money += money;
		System.out.printf("** Father bank tot_Money = %d, today_money = %d%n", this.money, money);
	}
	
	 // ** 메서드에 static
	 // => static 메서드에서는 this, super 사용금지
	 //   public static void sbank(int money) {
	 //	      this.money += money;
	 //	      System.out.printf("** Father bank total_money=%d, today_money=%d \n"
	 //	            , this.money, money);
	 //   }


	public void info() {
		System.out.printf("Father name = %s, money = %d%n", name, money);
	}

	//** main 메서드 ==================================================================
	//=> JVM 이 클래스를 실행시키는 기본 메서드
	//	  그러므로 public static void 여야만 하고
	//      메서드명 main과 인자값 중 하나라도 변경되면 실행되지 않음
	//=> 매개변수는 필요시 사용가능 함. (사용 Test)
	//=> main 메서드 오버로딩 Test
	//	  허용은 되지만 사용이 바람직하지는 않음
	
	public static void main(String name) {
		System.out.println("** main 오버로딩 Test name => " + name);
	}
	
	public static void main(String[] args) {
	//public static void main1(String[] args) { 
	// => main이 한글자라도 다르거나 없으면 에러뜸	
		
		 
		// ** main의 매개변수 args 사용
		// : 실행시 전달됨 : 하하하 호호호 짜장 탕탕 2424 (스페이스로 구별)
		System.out.println("** main 인자 Test => " + Arrays.toString(args));
		
		//** main 메서드 오버로딩 Test
		main("홍홍홍");
		
		
		Ex04_Father f1 = new Ex04_Father("아빵빵", 5000);
		f1.bank(100);
		f1.info();
		
		Ex04_Father f2 = new Ex04_Father("오빵빵", 5000);
		f2.bank(-100);
		f2.info();
		
		System.out.println("======================================");
		System.out.println();
		
		// ** static import Test
		System.out.println("** static import 사용 전 => " + Animal.color);
		System.out.println("** static import 사용 후 => " + color);
		// => import한 클래스의 변수명과 현재(father) 클래스의 변수명이 같을 시에, 현재 클래스의 변수의 값이 출력됨
		// => 같은 변수명 있을 때 : colorinFatherClass 출력 / 같은 변수명 없을 때 : Red 출력
		
	}

}
