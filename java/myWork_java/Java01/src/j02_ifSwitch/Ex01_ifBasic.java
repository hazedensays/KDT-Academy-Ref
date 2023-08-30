package j02_ifSwitch;

public class Ex01_ifBasic {

	public static void main(String[] args) {

		// ** 삼항식
		boolean rain = true;
		String doing = (rain == true ? "eating pajeon and driking makgeolli" : "riding a bike with music");
		System.out.println(doing);

		// ** if
		if (rain == true) {
			doing = "eating pajeon and driking makgeolli";
			System.out.println(doing);
			// String str = "I love pajeon!"; => 지역변수
		} else {
			doing = "riding a bike with music";
			System.out.println(doing);
			// System.out.println(str); str은 지역변수로 정의된 {...} 내에서만 유효
		}

		// ** 복합조건식
		// => 여러 문장의 경우 중괄호를 사용하여 문장들을 그룹핑
		String day = "red";

		if (!rain) {
			if (day == "red") {
				System.out.println("riding a bike with my friends");
			} else {
				System.out.println("taking a vacation and riding a bike");
			}
		} else {
			System.out.println("staying home");
		}

	}

}
