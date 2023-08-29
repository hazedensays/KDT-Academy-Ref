package j01_basic;

//** 2진수(Binary number), 8진수 , 16진수 표기
//=> 2진수 : 0b 로시작 -> 0b1111
//=> 8진수 : 0  Octal Number
//=> 16진수: 0x Hexadecimal Number
//=> 03_01~.ppt, 18page  

public class Ex05_BinOctHex {

	public static void main(String[] args) {
		int bin = 0b1111;
		int oct = 017;
		int hex = 0xf;

		System.out.printf(" bin: %d, oct: %d, hex: %d \n", bin, oct, hex);
		System.out.printf(" bin: %s, oct: %#o, hex: %#x \n", Integer.toBinaryString(bin), oct, hex);

		// Integer를 2, 8, 16 진법으로 출력하기
		System.out.println("** Binary => " + Integer.toBinaryString(bin));
		System.out.println("** Octal => " + Integer.toOctalString(123));
		System.out.println("** Hexadecimal => " + Integer.toHexString(oct));

		// int to String : 문자열에 연결되면 문자로 취급
		System.out.println("** int to String1 => " + bin + oct + hex);
		System.out.println("** int to String2 => " + (bin + oct + hex));
		System.out.println("** int to String3 => " + (String.valueOf(bin) + 100));

		// String to int
		String s = "123";
		System.out.println("String to int1 => " + (s + 100));
		System.out.println("String to int2 => " + (Integer.parseInt(s) + 100));
		System.out.println("String to int3 => " + (Integer.valueOf(s) + 100));

		s = "일이삼";
		// System.out.println("String to int => " + (Integer.parseInt(s) + 100));
		// error : java.lang.NumberFormatException: For input string: "일이삼"

		// String to double
		s = "123.456";
		System.out.println("** String to double1 => " + (s + 100));
		System.out.println("** String to double2 => " + (Double.parseDouble(s) + 100));

		s = "abcd.4567";
		// System.out.println("** String to double3 => " + (Double.parseDouble(s) +
		// 100));
		// error : java.lang.NumberFormatException: For input string: "abcd.4567"

	}

}
