package j07_classExtends;

public class Ex03_Animal {
	public String name;
	public String breathe;
	public int legs;

	// 생성자
	public Ex03_Animal() {
	}
	
	public Ex03_Animal(String breathe, int legs) {
		this.breathe = breathe;
		this.legs = legs;
	}

	// 멤버 메서드
	public void letmeIntro(String name) {
		System.out.println("안녕하세요. 저는 " + name + " 입니다. \n");
	}
	
	public String toString() {
		return "저는 " + breathe + "소리를 내며 숨을 쉬고, 다리는 " + legs + "개 있어요\n";
	}


}
