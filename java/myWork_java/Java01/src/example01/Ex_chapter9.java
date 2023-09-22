package example01;

public class Ex_chapter9 {
	public static int count(String src, String target) {
		int count = 0;
		int pos = 0;

		while (true) {
			int res = src.indexOf(target, pos);

			if (res == -1) {
				return count;
			} else {
				count++;
				pos += target.length();
			}
			return count;
		}
	}

	public static void main(String[] args) {
		System.out.println(count("12345AB12AB345AB", "AB"));
		System.out.println(count("12345", "AB"));
	}

}
