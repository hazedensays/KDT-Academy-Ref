package j04_Array;

import java.util.Arrays;

public class Ex02_ArrayType {

	public static void main(String[] args) {
		
		//** floatArr
		float[] floatArr = {1.1f, 2.2f, 3.3f, 4.4f, 5.5f};
		
		System.out.println("** floatArr");
		for (float f : floatArr) {
			System.out.print(f + " ");
		}
		System.out.println();
		
		//** strArr
		String[] strArr = {"apple", "orange", "grape", "tangerine", "peach"};
		
		System.out.println("\n** strArr");
		for (String s : strArr) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		//** charArr
		char[] charArr = {'c', 'h', 'a', 'n', 'm', 'i'};
		
		System.out.println("\n** charArr");
		for (char c : charArr) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		//** longArr
		long[] longArr = {12345, 45678, 12345678987654321L, 54321, 98765};
		
		System.out.println("\n** longArr");
		for (long l : longArr) {
			System.out.print(l + " ");
		}
		System.out.println();
		System.out.println();
		
		// 배열을 지원하는 Wrapper Class : Arrays
		System.out.println(Arrays.toString(floatArr));
		System.out.println(Arrays.toString(strArr));
		System.out.println(Arrays.toString(charArr));
		System.out.println(Arrays.toString(longArr));
		
		
	}

}
