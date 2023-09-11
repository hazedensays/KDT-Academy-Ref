package example01;

class Bionic { // 보병부대
	final static String group = "보병부대";
	int hp; // 체력
	int mobility; // 이동력
	static int attackDamage = 10; // 공격력
	static int attackDefence = 5; // 방어력

	public Bionic(int hp) {
		this.hp = hp;
		System.out.println("바이오닉 유닛 생성완료");
	}

	void move() {
		System.out.println("이동");
	}

	void attack() {
		System.out.println("공격");
	}

	void splint(int point) {
		System.out.println("전력질주 발동");
		this.mobility = 5 + point; // 인스턴스 변수 (보병부대 개개인의 이동력 증가)
		System.out.printf("이동속도 %d 증가합니다.%n", this.mobility);
	}
}

class Marine extends Bionic { // 마린 <- 보병부대

	String name = "마린";
	
	public Marine(int hp) {
		super(hp);
		System.out.println("마린 생성완료");
	}

	void stimPack() {
		System.out.println("스팀팩 주입");
		Bionic.attackDamage += 5; // 마린이라는 유닛이 갖는 공격력은 보병부대의 공격력 + 5
		System.out.printf("공격력이 %d 상승했습니다.\n", Bionic.attackDamage);
	}

	@Override
	void splint(int point) { // 마린은 전력질주시 보병부대의 이동력보다 5가 더 높다.
		super.splint(point + 5);
	}

	@Override
	void move() {
		//System.out.println(name + " 이동");
		System.out.print(name + " ");
		super.move();
	}

}

class Mechanic { // 중갑부대
	final static String group = "중갑부대";
	int hp;
	static int attackDamage = 15;
	static int attackDefence = 8;

	public Mechanic(int hp) {
		System.out.println("메카닉 유닛 생성완료");
	}

	void move() {
		System.out.println("이동");
	}

	void attack() {
		System.out.println("공격");
	}

}

class Tank extends Mechanic {

	public Tank(int hp) {
		super(hp);
		System.out.println("탱크 생성완료");
	}

}

public class Terran {

	public static void main(String[] args) {
		Marine m1 = new Marine(100);
		System.out.println("m1.hp => " + m1.hp);
		m1.stimPack();
		m1.splint(5);
		m1.move();
	}

}

