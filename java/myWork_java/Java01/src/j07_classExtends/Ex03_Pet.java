package j07_classExtends;

class Pet extends Ex03_mammal {
	String mypetName;

	// 생성자
	public Pet() {
	}

	public Pet(String cryingSound, int runningSpeed, String breathe, int legs, String mypetName) {
		super(cryingSound, runningSpeed, breathe, legs);
		this.mypetName = mypetName;
	}

	public String toString() {
		return super.toString() + mypetName + "의 주인은 찬미예요.\n";
	}

}

public class Ex03_Pet {
	
	public static void main(String[] args) {
		Pet p1 = new Pet("엉엉", 100, "킁킁", 4, "Cream");
		p1.letmeIntro("크림");
		System.out.println(p1.toString());
	}

}
