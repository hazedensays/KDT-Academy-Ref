package j01_basic;

public class Ex09_Operator02_bit {

	public static void main(String[] args) {
		int x = 10, y = 3; // 2진수 => 10 : 1010 / 3 : 0011
		System.out.println("x => " + x + " y => " + y);
		System.out.println();

		// 1) 쉬프트(shift) 연산 : <<, >> ===============================
		System.out.println("** 쉬프트 연산 **");
		System.out.println("x >> y : " + (x >> y));
		// x를 오른쪽으로 y만큼 이동
		// 1010 -> 0101 -> 0010 -> 0001 : (답 : 1)
		
		System.out.println("x << y : " + (x << y));
		// x를 왼쪽으로 y만큼 이동
		// 1010 -> 1 0100 -> 10 1000 -> 101 0000 : (답 : 80)

		System.out.println("x << 1 : " + (x << 1));
		// x를 왼쪽으로 1만큼 이동
		// 1010 ->1 0100 : (답 : 20)
		
		System.out.println();

		// 2) 논리 연산 ===========================================
		// => AND & , OR | , XOR ^ (같으면 0)
		System.out.println("** 논리 연산 **");
		System.out.println("10진수 -> x & y : " + (x & y));
		System.out.println("2진수 -> x & y : " + Integer.toBinaryString(x & y));
		// 둘 다 참일 경우에만 참         x : 1 0 1 0
		//                                              y : 0 0 1 1
		//                                      -------------------
		//                                                   0 0 1 0
		
		System.out.println("10진수 -> x | y : " +(x | y));
		System.out.println("2진수 -> x | y : " + Integer.toBinaryString(x | y));
		// 둘 중 하나라도 참일 경우 참 x : 1 0 1 0
		//                                              y : 0 0 1 1
		//                                      -------------------
		//                                                    1 0 1 1
		
		System.out.println("10진수 -> x ^ y : " + (x ^ y));
		System.out.println("2진수 -> x ^ y : " + Integer.toBinaryString(x ^ y));
		// 두개가 같은 경우에 0           x : 1 0 1 0
		//                                              y : 0 0 1 1
		//                                      -------------------
		//                                                   1 0 0 1
		
		System.out.println();
		
		// 3) 활용 ===========================================
		int pw = 1234567, d = 0;
		int s = 0x1A253B65;
		System.out.println("암호화 전 pw => " + pw);
		
	    // => 암호화 (Encryption)
		d = pw ^ s;
		System.out.println("암호화 된 pw => " + d);
	      
	    // => 복호화 (Decryption)
		d = d ^ s;
		System.out.println("복호화 된 pw => " + d);
		
	}

}
