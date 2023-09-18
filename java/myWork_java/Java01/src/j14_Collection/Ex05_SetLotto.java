package j14_Collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

//** Set 을 이용한 로또번호 생성하기
//=> 중복자료가 허용안되는 Set 의 특징을 이용하여 로또 번호 생성하기
//=> Random 또는 Math 로 1 ~ 45 범위내의 정수를 중복되지 않도록 
// 6개를 추출후 오름차순으로 출력하기   

public class Ex05_SetLotto {

	public static void main(String[] args) {
		TreeSet<Integer> tSet = new TreeSet<Integer>();

		while (tSet.size() < 6) {
			int randomNum = (int) (Math.random() * 45) + 1;
			tSet.add(randomNum);
		}

		System.out.println(tSet);

		// ** 배열과 Set
		// : set -> 배열로
		HashSet<Integer> hSet = new HashSet<Integer>();

		// => 비교용 : 중복확인은 되지만 정렬은 안됨
		while (hSet.size() < 6) {
			int randomNum2 = (int) (Math.random() * 45) + 1;
			hSet.add(randomNum2);
		}

		System.out.println("** 정렬 전, hSet => " + hSet);
		Object[] oSet = hSet.toArray();
		Arrays.sort(oSet);
		System.out.println("** 정렬 후, oSet => " + Arrays.toString(oSet));
		System.out.println("** 정렬 후 원본 hSet => " + hSet);

		// 5. Colletions
		// => Collection 들의 WrapperClass
		// Collection 과 관련된 편리한 메서드를 제공
		// 단, interface Collection 과 구별
		// interface Collector 의 구현클래스 Collectors 와 구별
		// => Collections.sort(List<T> list)
		// 인자로 List 타입이 필요함

		// ** 오름차순 출력
		// => Set -> 순차구조 (Iterator , List)
		// => Set -> List
		// LinkedList 의 생성자중에 set을 매개변수로 사용하면
		// 이 set 을 list 생성해주는 생성자가 있음.
		List<Integer> list = new LinkedList<>(hSet);
		Collections.sort(list);
		
		System.out.println("Collections.sort(list) => " + list);

	}

}
