package j07_classExtends;

class Wild extends Ex03_mammal {
	String nationalPark;

	// 생성자
	public Wild() {
	}

	public Wild(String cryingSound, int runningSpeed, String breathe, int legs, String nationalPark) {
		super(cryingSound, runningSpeed, breathe, legs);
		this.nationalPark = nationalPark;
	}

	public String toString() {
		return super.toString() + "저는 " + nationalPark + "에 살고 있어요.\n";
	}

}

public class Ex03_Wild {

	public static void main(String[] args) {
		Wild m1 = new Wild("엉엉", 400, "킁킁", 4, "Masai Mara");
		m1.letmeIntro("알로하");
		System.out.println(m1.toString());
	}

}
