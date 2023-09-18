package j14_Collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Ex02_LinkedList {

	public static void main(String[] args) {
		// 1) 정의
		List<String> list = new LinkedList<String>();
		// LinkedList<String> list = new LinkedList<String>();

		// 2) 초기화
		list.add("Java");
		list.add("JavaScript");
		list.add("Servlet");
		list.add("JSP");
		list.add("Spring");
		list.add("MySql");

		// 3) 사용
		// => get, set(수정), remove
		String ss = list.get(2) + list.get(3);
		list.set(1, ss);
		list.add(ss);
		list.add(5, "Mybais");

		// 4) 출력
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		// 5) 배열
		// => 배열 -> List -> Iterator(순차처리를 편리하게 지원하는 클래스)로 변환
		String[] menu = { "칼국수", "뿌링클", "훠궈", "마라탕", "불닭볶음면" };
		list = Arrays.asList(menu);

		// => list 확인
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		list.set(0, "마라샹궈"); // 허용
		// list.add("마라샹궈");
		// list.remove(0;)
		// ** 변환된 리스트에 추가
		// => 변환한 경우에는 추가/삭제 할 수 없음
		// => 런타임오류 발생 : ava.lang.UnsupportedOperationException
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		// List -> Iterator(순차처리를 편리하게 지원하는 클래스)
		// 				hasNext(), next() 메서드 제공
		Iterator iMenu = list.iterator();
		while(iMenu.hasNext()) {
			System.out.println(iMenu.next());
		}

	}

}
