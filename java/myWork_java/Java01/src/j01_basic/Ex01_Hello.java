package j01_basic;

//** 이클립스 단축키 
//자동 import : Ctrl+Shift+O
//Line삭제 : Ctrl + d

//들여쓰기 : Ctrl+A , Ctrl+I 
//=> 한번에 Ctrl+Shift+F

//클래스 Ctrl+클릭 => 클래스 소스보기 
//클래스 Ctrl+T => 클래스 계층도 

//** 클래스 
//=> 클래스명은 화일명과 동일함.
//=> 맴버   
//변수:value, 
//메서드 (함수 function , 프로시져 procedure) : 동작

//** 문장(Statement)
//=> 사용자가 컴퓨터에게 작업을 지시하는 단위
//=> 문장의 끝은 항상 세미콜론 (;)
//=> 선언문과 실행문(메소드 안에 작성) 

//** Java Coding
//=> 대.소 문자구별함

/* 주석(comment)의 종류
=> 한줄 주석
 => 여러줄 주석
*/

public class Ex01_Hello {
	
	int number = 100;
	
	//자바에서 대소문자를 구분하여 name과 Name은 다르지만,
	//변수명의 첫 글자를 대문자는 바람직하지 않음
	String Name;
	
	//한글도 허용하지만 바람직하지 않음
	String addr;
	String 주소 = "서울시";


	public static void main(String[] args) {
		String name = "하제";
		String job = "슈퍼부자";
		int age = 22;
		boolean b = false;
		
		System.out.println("Hello, World!");
		System.out.print("메롱메롱");
		System.out.printf("바보바보");
		System.out.println();
		
		System.out.println("저의 이름은 " + name + "입니다.");
		System.out.println("저의 직업은 " + job + "입니다.");
		System.out.println("저는 고작 " + age + "이에요.");
		System.out.println("위에 내용은 일부 " + b + " 입니다. ㅋㅋ");
		
		//문자가 포함된 "+" 연산은 모두 문자열 연산으로 취급
		 System.out.println("100 + 200의 합 => " + 100 + 200);
		 System.out.println("100 + 200의 합 => " + (100 + 200)); //우선순위 설정
		
		
	}

}
