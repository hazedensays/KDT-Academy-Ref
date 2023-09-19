package j14_Collection;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//** Entry -------------------------------------------
//Map 인터페이스는 내부에 내부인터페이스 Entry를 가지고 있고, 
//Object key, Object value는 Entry 인터페이스에 선언되어 있음.
//그러므로 Map의 key와 value는 각각의 Object 이며 Map.Entry타입으로 저장됨. 
//그래서 Map의 key와 value에 접근 할때는
//=> 먼저 Map의 인스턴스에서 entrySet으로 키와 value를 둘다 가져온다. 
//=> entrySet은 Set타입이므로 Set타입 인스턴스에 저장
//=> Set타입으로 가져온 인스턴스에서 iterator()메소드 호출해서 iterator가져옴
//=> 얻어온 iterator에서 hasNext메소드를 호출하여 HashMap 내부 요소에 접근.
//=> HashMap의 각 key와 value값은 결국 Map.Entry 타입의 배열에 들어있으므로    
//  HashMap에서 각 key와 value값에 접근하기위해서는  
//  Map.Entry 타입 인스턴스에 iterator의 next()메소드로 key와 value값 가져온다.
//------------------------------------------------------

//** HashMap 의 순차처리 ( Iterator , Entry ) 
//=> HashMap 의 주요 메서드 ( Set Type 으로 return ) 활용
//- entrySet() : key+value 를 Entry Type 으로 묶어 Set 으로
//- keySet() : key 값들만 Set 으로
//- values() : value 들만 Set 으로
//1) 키와 값 같이 읽어 순차처리
//2) 키와 값을 따로 읽어 순차처리

public class Ex09_MapIterator {

	public static void main(String[] args) {
		// 1. HashMap 정의
		// => <이름, 점수>
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put("마라탕", 8000);
		hm.put("마라샹궈", 16000);
		hm.put("뿌링클", 18000);
		hm.put("불닭볶음면", 1800);
		hm.put("바닐라라떼", 5500);
		System.out.println("** hm => " + hm);
		// 2. 순차처리
		// 2.1) entrySet() : key+value 를 Entry Type 으로 묶어 Set 으로
		// => HashMap 의 entrySet() -> Set -> Iterator
		// 키와 값을 같이읽어 하나의 데이터(entry) 로 Set에 저장
		Set<?> set = hm.entrySet();
		System.out.println("** set => " + set);

		// ** Set -> Iterator
		Iterator<?> iSet = set.iterator();
		while (iSet.hasNext()) {
			// System.out.println("** while문 => " + iSet.next());
			// => key, value 구분 없음 (Set의 Data를 읽어오는 것에 불과함)
			// => key, value 구분하려면 Entry 객체를 활용해야 함
			// : Entry 객체를 이용하면 key, value 구분 가능

			Map.Entry<?, ?> e = (Map.Entry<?, ?>) iSet.next();
			// => Map.Entry<?, ?> Type의 인스턴스 e를 통해 key, value 접근 가능
			System.out.printf("** Entry: key = %s, value = %d%n", e.getKey(), e.getValue());
		}

		// 2.2) keySet() : key 값들만 Set 으로
		// => HashMap 의 keySet() -> Set -> Iterator
		set = hm.keySet();
		System.out.println("** keySet => " + set);
		
		
		// * while
		// -> Set -> Iterator
		iSet = set.iterator();
		while (iSet.hasNext()) {
			//System.out.println("key = " + iSet.next());
			//System.out.println("value = " + hm.get(iSet));
			// => next()가 2회 발생해서 바람직하지 않음 : Error 발생
			
			String hmKey = (String)iSet.next();
			System.out.printf("** while: key = %s, value = %d%n", hmKey, hm.get(hmKey));
		}
		
		// * for
		for (String s : hm.keySet()) {
			System.out.printf("** for: key = %s, value = %d%n", s, hm.get(s));
		}
		
		// 2.3) values() : value 들만 Set 으로
		// 		   => return type이 Collection
		// -> Collection -> Iterator
		Collection<Integer> cv = hm.values();
		iSet = cv.iterator();
		int sum = 0;
		
		while(iSet.hasNext()) {
			sum += (Integer)iSet.next();
		}
		
		System.out.println("** 총합계 = " + sum);
		System.out.println("** 평균 = " + sum / hm.size());
		System.out.println("** 제일 비싼 음식 : " + Collections.max(cv));
		System.out.println("** 제일 싼 음식 : " + Collections.min(cv));
	}

}
