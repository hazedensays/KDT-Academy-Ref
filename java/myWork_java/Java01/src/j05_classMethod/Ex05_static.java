package j05_classMethod;

// ** static, instance 비교

// - static (클래스 종속)
//    => static 키워드를 붙이게 되면, 변수 또는 메서드가, 해당 클래스 수준에 속하게 됨.
//    => static 변수는 해당 클래스 수준에서 전역변수와 유사하게 동작하게 됨
//    => 클래스 로드 시 한 번 할당되고, 모든 인스턴스가 static 변수를 공유하게 됨.
// 
// -  instance (non_static, dynamic, 인스턴스 종속)
//     => 따로 키워드를 붙이지 않고 사용하면 instance로 사용하게 되고, 객체 또는 인스턴스 수준에 속하게 됨.
//     => instance 변수는 객체 또는 인스턴스 수준에서 지역 변수(인스턴스에 종속적)로 동작함
//     => 각 인스턴스가 고유한 값을 가지므로, 한 인스턴스에서 변경해도 다른 인스턴스에 영향 주지 않음.

// ** 호출 규칙
//    => static 메서드 : static만, 인스턴스없이 호출 가능
//    => instance 메서드 : static, instance(non_static) 모두 인스턴스없이 호출 가능

public class Ex05_static {
	
//	1. 멤버변수 정의
	int result;
	int instanceTotal;
	static int total;
	
//	2. 멤버 메서드 정의
//	=> static
	public static int add (int i, int j, Ex05_static ex05_1) {
//		result += (i + j);
//		=> 인스턴스 없이 접근 불가
		
		total += (i + j);
//		=> static 메서드에서 static은 인스턴스없이 접근 가능
		
		ex05_1.instanceTotal += (i + j);
//		=> static 메서드에서 instance는 인스턴스가 있어야 접근 가능
		
		return i + j;
	}
	
	public static int min (int i, int j, Ex05_static ex05_1) {
		total += (i - j);
		ex05_1.instanceTotal += (i - j);
		
		return i - j; 
	}
	
	
//	=> instance
	public int mul (int i, int j) {
		result = i * j;
		
		total += result;
		instanceTotal += result;
		
		return result;
	}
	
	public int div (int i, int j) {
		result = i / j;
		
		total += result;
		instanceTotal += result;
		
		return result;
	}
	
//	** static : 모든 메서드 call
//    => 인스턴스 멤버에 경우, 인스턴스 멤버에 접근하기 위해서는 인스턴스가 필요함
	public static void staticAll (int i, int j, Ex05_static ex05_1) {
		System.out.println("** staticAll call : add => " + add(i, j, ex05_1));
		System.out.println("** staticAll call : min => " + min(i, j, ex05_1));
		System.out.println("** staticAll call : mul => " + ex05_1.mul(i, j));
		System.out.println("** staticAll call : div => " + ex05_1.div(i, j));
		System.out.println("** staticAll call : total => " + total);
		System.out.println("** staticAll call : instanceTotal => " + ex05_1.instanceTotal);
		System.out.println("** staticAll call : result => " + ex05_1.result);
	}
	
//	** instance : 모든 메서드 call
	public void instanceAll (int i, int j, Ex05_static ex05_1) {
		System.out.println("** instanceAll call : add => " + add(i, j, ex05_1));
		System.out.println("** instanceAll call : min => " + min(i, j, ex05_1));
		System.out.println("** instanceAll call : mul => " + mul(i, j));
		System.out.println("** instanceAll call : div => " + div(i, j));
		System.out.println("** instanceAll call : total => " + total);
		System.out.println("** instanceAll call : instanceTotal => " + instanceTotal);
		System.out.println("** instanceAll call : result => " + result);
	}
	
//	** static, instance(non_static) 모두 call
//	     => 인스턴스 멤버에 접근하기 위해서는 인스턴스가 필요
	public static void main(String[] args) {
		
//		** instance 2개 생성 후 비교
		
//		1- instance) =======================================
		Ex05_static ex05 = new Ex05_static();
		
//		1-1) static call
		System.out.println("** static call : add => " + add(10, 3, ex05));
		System.out.println("** static call : min => " + min(10, 3, ex05));
		System.out.println();
		
//		1-2) instance(non_static) call
		System.out.println("** instance(non_static) call : mul => " + ex05.mul(10, 3));
		System.out.println("** instance(non_static) call : div => " + ex05.div(10, 3));
		System.out.println();
		
//		1-3) staticAll call
		staticAll(30, 3, ex05);
		System.out.println();
		
//		1-4) instanceAll call
		ex05.instanceAll(40, 4, ex05);
		System.out.println();
		
//		2- instance) =======================================
		Ex05_static ex055 = new Ex05_static();
		
//		2-1) static call
		System.out.println("** static call2 : add => " + add(10, 3, ex055));
		System.out.println("** static call2 : min => " + min(10, 3, ex055));
		System.out.println();
		
//		2-2) instance(non_static) call
		System.out.println("** instance(non_static) call2 : mul => " + ex055.mul(10, 3));
		System.out.println("** instance(non_static) call2 : div => " + ex055.div(10, 3));
		System.out.println();
		
//		2-3) staticAll call
		staticAll(30, 3, ex055);
		System.out.println();
		
//		2-4) instanceAll call
		ex05.instanceAll(40, 4, ex055);
		System.out.println();
		
//		===================================================
		System.out.println("** test1 => " + ex05.total);	// 경고, 바람직한 접근 아님
		System.out.println("** test1 => " + Ex05_static.total);	// 클래스 종속
		
		
		
		
	}

}
