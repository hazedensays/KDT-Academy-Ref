package j07_classExtends;

public class Ex01_Student {

	private String no;
	private String name;
	private int score;

	Ex01_Car car = new Ex01_Car(1000, 5000, "Blue");
	static Ex01_Car car2 = new Ex01_Car(1000, 5000, "Red");

	// 생성자
	Ex01_Student() {
	}

	Ex01_Student(String no, String name, int score) {
		this.no = no;
		this.name = name;
		this.score = score;
	}
	
	// => 생성 시에 초기화하고 readonly로 사용
	public String getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}
	
	// => toString
	public String toString() {
		return "[ no = " + no + ", name = " + name + ", score = " + score + " ]";
	}
	

	public static void main(String[] args) {

	}

}
