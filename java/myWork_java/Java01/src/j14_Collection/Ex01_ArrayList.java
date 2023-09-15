package j14_Collection;

import java.util.ArrayList;
import java.util.LinkedList;

import j07_classExtends.Ex01_Car;

public class Ex01_ArrayList {

	public static void main(String[] args) {
		// 1) 정의
		// => Generic Type을 지정하지 않으면 Object Type
		ArrayList list = new ArrayList();
		list.add("방구쟁이");
		list.add(123);
		list.add(123.456);
		list.add('A');
		list.add(1.234f);
		list.add(new Integer(500));

		// => 출력
		for (Object o : list) {
			System.out.println(o);
		}

		ArrayList<Ex01_Car> list2 = new ArrayList<Ex01_Car>();
		list2.add(new Ex01_Car(100, 500, "pink"));
		list2.add(new Ex01_Car(100, 500, "pink"));
		list2.add(new Ex01_Car(100, 500, "pink"));

		for (Ex01_Car o : list2) {
			System.out.println(o);
		}
		
		// => color만 출력
		for (Ex01_Car o:list2) {
			System.out.println(o.color);
		}
		
		// ** LinkedList 비교
		LinkedList<Ex01_Car> list3 = new LinkedList<Ex01_Car>();
		list3.add(new Ex01_Car(100, 500, "black"));
		list3.add(new Ex01_Car(100, 500, "black"));
		list3.add(new Ex01_Car(100, 500, "black"));

		for (Ex01_Car o : list3) {
			System.out.println(o);
		}
	}

}
