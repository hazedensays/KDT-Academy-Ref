package j14_Collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

//*** 해싱과 해시함수 => 정석 651p
//해싱 => 해시 함수를 이용해서 데이터를 해시 테이블에 저장하고
//     검색하는 기법

//*** Map ( Key, Value )
//=> HashMap (Key 값의 중복을 허용하지 않고, 순서 유지를 보장받지 못한다.) 
//=> TreeMap (Key 값의 중복을 허용하지 않고, 키값으로 오름차순 정렬이 된다.)
//=> LinkedHashMap (Key 값의 중복을 허용하지 않고, 입력순서 유지를 보장받는다.)

//*** HashMap : Key, Value 정보 지정
//=> key 는 유일, Value 는 중복 허용 
//=> null 값 허용 map.put(null, null) 또는 map.get(null) 가능

public class Ex07_HashMap {

	public static void main(String[] args) {
		// 1) HashMap
		// 1-1) 정의
		Map<Integer, String> hMap = new HashMap<>();

		// 1-2) 초기화
		hMap.put(1, "Java");
		hMap.put(10, "Java");
		hMap.put(5, "마라탕");
		hMap.put(2, "Spring");
		hMap.put(20, "SpringMVC");
		hMap.put(new Integer(3), "Java");
		hMap.put(4, "Mybatis");
		hMap.put(4, "JPA");
		hMap.put(null, "null");

		// 1-3) 출력
		System.out.println("** HashMap => " + hMap);
		System.out.println("** HashMap.size() => " + hMap.size());

		// 1-4) 활용
		// => get, remove : key로 접근
		System.out.println("** HashMap get(20) => " + hMap.get(20)); // key값이 20인 자료
		System.out.println("** HashMap remove(20) => " + hMap.remove(20)); // 삭제 & value return
		//System.out.println("** HashMap remove(5, '마라탕') => " + hMap.remove(5, "마라탕")); // 삭제 & value return
		System.out.println("** HashMap remove(null, 'null') => " + hMap.remove(null, "null"));
		System.out.println("** HashMap2 => " + hMap);

		// 1) Map 종류(구현클래스들) 비교
		// => 생성자 매개변수로 위의 HashMap 을 사용
		// => 단, key 값이 null 인 경우에는 전달과정에서 런타임오류 NullPointerException 발생
		Map<Integer, String> tMap = new TreeMap<>(hMap);
		System.out.println("** TreeMap => " + tMap);  //key순 오름차순
		
		Map<Integer, String> lhMap = new LinkedHashMap<>(hMap);
		System.out.println("** LinkedHashMap =>" + lhMap);
		// => 입력순을 유지 / 단, 위같은 경우에는 처리과정에서 전달된 순서를 유지함
		
		// => 확인
		lhMap = new LinkedHashMap<>();
		lhMap.put(1, "Java");
		lhMap.put(10, "Java");
		lhMap.put(5, "마라탕");
		lhMap.put(2, "Spring");
		lhMap.put(20, "SpringMVC");
		
		System.out.println("** new LinkedHashMap => " + lhMap);
		
	}

}
