package j05_classMethod;

//** static, instance잡근하기
//=> 다른클래스의 멤버 접근 (Ex05_static)

public class Ex05_staticTest {

	public static void main(String[] args) {
		// 1. static 변수 출력하기
		System.out.println("** total => " + Ex05_static.total);
		
		// 2) instance(non_static) 멤버 접근
		Ex05_static ex05 = new Ex05_static();
		ex05.instanceAll(10, 3, ex05);
		Ex05_static.staticAll(10, 3, ex05);
		System.out.println();
		
		// 3) instance 추가 후 출력
		System.out.println("** instance 추가 후 출력");
		Ex05_static ex055 = new Ex05_static();
		ex055.instanceAll(10, 3, ex055);
		Ex05_static.staticAll(10, 3, ex055);
		
	}

}
