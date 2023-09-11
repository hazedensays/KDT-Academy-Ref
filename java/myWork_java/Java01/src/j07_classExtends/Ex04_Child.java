package j07_classExtends;

public class Ex04_Child extends Ex04_Father {
	String name;
	int money;

	/*
	 		** 조상 생성자
	 		=> 묵시적 정의 (기술하지 않음)
	 				: 기본적으로 조상의 default 생성자 호출
	 				: 그러므로 조상은 default 생성자는 넣어주는 것이 바람직함
	 		=> 명시적 정의
	 				: super(매개변수, ...) 호출
	 */
	
	public Ex04_Child() {
		// super("홍길동", 0);
		// => 자식은 default 생성자여도 조상 생성자는 선택적으로 사용 가능
		System.out.println("** Child Default 생성자 **");
	}

	public Ex04_Child(String name, int money) {
		this.name = name;
		this.money = money;
		System.out.println("** Child 초기화 생성자 **");
	}
	
	   // => 메서드 오버라이딩
	   
	   // => Father 에서 final : 오버라이딩 금지 
	   // => 그러나 오버로딩은 무관
	   //    public void bank(int money, int i) {
	   
	   // => Father 에서 static : 오버라이딩 금지
	   //    그러나 Child 에서 같은 이름의 static 메서드는 허용되고,  
	   //    Child 에서 같은 이름의 인스턴스 메서드는 허용되지않음.
	   //    public static void bank(int money) {
	@Override
	public void bank (int money) {
		this.money += money;
		
		// => Father에 용돈드리기
		// => 오늘 입금액의 1/2은 Father_bank에 입금
		super.bank(money / 2);
		
		System.out.printf("** Child bank tot_Money = %d, today_money = %d, fTotal = 출력불가%n", this.money, money);  //super.money (private으로 정의됨)
	}
	
	@Override
	public void info() {
		//super.info();
		//System.out.printf("Child name = %s, money = %d%n", name, money);
		
		System.out.printf("FName = %s, Child name = %s, money = %d%n", Ex04_Father.name, name, money);
		// => 상속관계보다 static이 우선 적용되므로, 조상의 static멤버는 super가 아닌 클래스 접근
	}
	
	// => 조상과 자손 모두 초기화
	public Ex04_Child(String fname, int fmoney, String name, int money) {
		super(fname, fmoney);
		this.name = name;
		this.money = money;
		System.out.println("** Father, Child 초기화 생성자 **");
	}

	public static void main(String[] args) {
		// 1) tom
		Ex04_Child tom = new Ex04_Child("스티브", 10000, "Tom", 1000);
		tom.bank(300);
		tom.bank(500);		
		tom.info();
		
		// 2) jerry
		Ex04_Child jerry = new Ex04_Child("Jerry", 1000);
		jerry.bank(-300);
		jerry.bank(-500);
		jerry.info();
	}

}
