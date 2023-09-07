package j07_classExtends;

public class Ex03_mammal extends Ex03_Animal {
	String cryingSound;
	int runningSpeed;

	// 생성자
	public Ex03_mammal() {
	}

	// 조상과 자손 멤버들 모두 초기화 하는 생성자
	public Ex03_mammal(String cryingSound, int runningSpeed, String breathe, int legs) {
		super(breathe, legs);
		this.cryingSound = cryingSound;
		this.runningSpeed = runningSpeed;
	}

	public void runningSpeed(int runningSpeed) {
		this.runningSpeed = runningSpeed;
	}

	public String toString() {
		return super.toString() + "저는 " + cryingSound + "소리를 내며 울고(찌질이 아님) 스피드는 " + runningSpeed
				+ "km/s 만큼 빠르게 달릴 수 있어요. \n";
	}

}

//public class Ex03_mammal {
//
//	public static void main(String[] args) {
//
//	}
//
//}
