package j11_APITest;

import java.util.Arrays;
import java.util.Calendar;

//** Person
//=> 주민등록번호, 이름을 전달받으면
//=> 주민등록번호를 이용해서, age, 성별을 set 하고
//=> info 출력하기 

//** PersonTest
//=> Person 5명 생성후 배열에 넣고,
// 나이순으로 출력하기
//=> 나이순 정렬은 정렬메서드 (static ageSort()) 만들어서 하세요~~  
//=> 출력은 infoPrint() 로 

//=> 맴버필드(private) : idNo(String), name(String), age(int), gender(char)
//=> 생성자 2개
//    * default
//    * 주민등록번호,이름을 매개변수로 전달받아 초기화 
//    -> 나이 계산, 성별도 찾아서 set
//=> setter/getter
//     이름만 수정 가능, 
//    모든필드를 사용가능 (그러나 주민번호는 뒷자리는 * 로표시)
//=> infoPrint()
//=> toString 은 오버라이딩

//** info
//이름 : 000
//번호 : 090909-*******
//나이 : 20세
//성별 : "남" 또는 "여"

class Person {
	private String idNo;
	private String name;
	private int age;
	private char gender;

	// default 생성자
	Person() {
	}

	// 생성자
	Person(String idNo, String name) {
		this.idNo = idNo;
		this.name = name;
		this.age = calcAge(this.idNo);
		this.gender = Whatgender(this.idNo);
	}

	public int calcAge(String idNo) {
		String[] str = idNo.split("-");
		int firstNum = Integer.parseInt(str[1].substring(0, 1));
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);

		int yearOfBirth;

		if (firstNum == 1 || firstNum == 2) {
			yearOfBirth = 1900 + Integer.parseInt(str[0].substring(0, 2));
		} else if (firstNum == 3 || firstNum == 4) {
			yearOfBirth = 2000 + Integer.parseInt(str[0].substring(0, 2));
		} else {
			yearOfBirth = 1800 + Integer.parseInt(str[0].substring(0, 2));
		}

		int currentAge = currentYear - yearOfBirth;
		return currentAge;
	}// calcAge()

	public char Whatgender(String idNo) {
		String[] str = idNo.split("-");
		int Isgender = Integer.parseInt(str[1].substring(0, 1));

		if (Isgender < 1 || Isgender > 5) {
			return ' ';
		}

		if (Isgender == 1 || Isgender == 3) {
			return 'M';
		} else {
			return 'W';
		}
	}// Whatgender()

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getIdNo() {
		return idNo.substring(0, 6) + " - *******";
	}

	public int getAge() {
		return age;
	}

	public char getGender() {
		return gender;
	}

	public void infoPrint() {
		System.out.println("이름 : " + name);
		System.out.println("번호 : " + getIdNo());
		System.out.println("나이 : " + age);
		System.out.println("성별 : " + gender);

	}// infoPrint()

	static void ageSort(Person[] pArr) {
		Person temp;

		for (int i = 0; i < pArr.length; i++) {
			for (int j = i + 1; j < pArr.length; j++) {
				if (pArr[i].age < pArr[j].age) {
					temp = pArr[i];
					pArr[i] = pArr[j];
					pArr[j] = temp;
				}
			}
		}
	}// ageSort

}// class Person

public class Ex07_PersonTest {

	public static void main(String[] args) {
		Person pArr[] = new Person[5];

		pArr[0] = new Person("010711-4123456", "김찬미");
		pArr[1] = new Person("880711-2894561", "박찬미");
		pArr[2] = new Person("450711-1546512", "이찬미");
		pArr[3] = new Person("090711-4457588", "홍찬미");
		pArr[4] = new Person("140711-1847686", "최찬미");
		
		Person.ageSort(pArr);
		
		for (int i = 0; i < pArr.length; i++) {
			pArr[i].infoPrint();
			System.out.println();
		}

	}

}
