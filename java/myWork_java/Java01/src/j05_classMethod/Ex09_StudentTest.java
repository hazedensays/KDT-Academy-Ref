package j05_classMethod;

// ** 복습
// => 207p 연습문제 6-1, 6-2, 6-3 구현
// => 6-1
//	-> 맴버변수는 private 으로 정의
//	-> setter/getter, toString 추가
// => 6-2 : info() 는 만들지 않아도 됨.
// => 6-3
//	-> Student 의 인스턴스를 5개 만들어서 배열에 담기
//	-> 배열을 이용해서 위 5개 인스턴스의 정보와 
//     Total, Averagre 출력하기

class Student {
	private String name;
	private int ban;
	private int no;
	private int kor;
	private int eng;
	private int math;
	
//	** package test용 변수 선언
	public static int ddd = 100;

	public Student() {
	}

	public Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setBan(int ban) {
		this.ban = ban;
	}

	public int getBan() {
		return ban;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getKor() {
		return kor;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getEng() {
		return eng;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getMath() {
		return math;
	}

	public int getTotal() {
		return kor + eng + math;
	}

	public float getAverage() {
//		 return (int)((kor + eng + math) / 3f * 10 + 0.5f) / 10f;
		return Math.round(((kor + eng + math) / 3f) * 100) / 100.0f;
	}

	public String info() {
		return name + ", " + ban + ", " + no + ", " + kor + ", " + eng + ", " + math;
	}

	public static void rankList(Student[] students) {
		for (int i = 0; i < students.length; i++) {
			for (int j = i + 1; j < students.length; j++) {
				if (students[i].getAverage() < students[j].getAverage()) {
					Student tmp = students[i];
					students[i] = students[j];
					students[j] = tmp;
				}
			}
		}

		for (Student s : students) {
			System.out.printf("이름 : %s, 순위 : %.2f%n", s.getName(), s.getAverage());
		}
	}

}

public class Ex09_StudentTest {

	public static void main(String[] args) {

		Student[] students = new Student[5];

		students[0] = new Student("홍길동", 5, 1, 89, 75, 24);
		students[1] = new Student("김길동", 4, 2, 92, 91, 92);
		students[2] = new Student("박길동", 3, 3, 86, 87, 87);
		students[3] = new Student("이길동", 2, 4, 100, 71, 72);
		students[4] = new Student("최길동", 1, 5, 51, 68, 62);

		for (int i = 0; i < students.length; i++) {
			String str = students[i].info();
			System.out.println("info => " + str);
			System.out.println("tot => " + students[i].getTotal());
			System.out.println("avg => " + students[i].getAverage());
			System.out.println();
		}

		// 3) 석차순 출력
		// => 정렬 메서드 만들기

		int totalAll = 0;

		for (int i = 0; i < students.length; i++) {
			totalAll += students[i].getTotal();
		}

		System.out.println("전체 합계 => " + totalAll);
		System.out.println("전체 평균 => " + Math.round(((totalAll) / 5f) * 100) / 100.0f);
		System.out.println();

		System.out.printf("** 석차 순위 **%n");
		Student.rankList(students);

	}
}