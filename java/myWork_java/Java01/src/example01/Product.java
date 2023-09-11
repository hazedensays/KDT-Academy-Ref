package example01;

//1대 product
public class Product {

	static String brand = "dandog";
	String name;
	int price;
	int salePercentage;

	// 생성자
	Product() {}
	Product(String name, int price, int salePercentage) {
		this.name = name;
		this.price = price;
		this.salePercentage = salePercentage;
	}

	// 할인가격 계산 메서드
	public int saledPrice() {
		return price - (int) (price * (salePercentage / 100f));
	}
	
	void priceNsale() {
		System.out.printf("원래 가격은 %d원입니다. ", price);
		System.out.printf("현재 가격은 %d원입니다.%n", saledPrice());
	}

	// main 실행!!
	public static void main(String[] args) {

		System.out.printf("안녕하세요 이곳은 %s!!!!%n%n", Product.brand);
		DogProduct deliciousSnack = new DogProduct("엄청 맛있는 간식", "갱얼쥐", 0, 20000, 15);
		DogProduct fasion = new DogProduct("날개달린 옷", "시츄", 2, 15000, 20);
		deliciousSnack.dogfeild();
		deliciousSnack.infoPrint();
		fasion.infoPrint();
		System.out.println();

		CatProduct catBox = new CatProduct("매우 안락한 상자", "냐옹이", 2, 900000, 10);
		catBox.catfeild();
		catBox.infoPrint();

	}
} // product

//2대 강아지, 고양이
class Dog extends Product {
	String kind;

	Dog() {}
	Dog(String name, String kind, int price, int salePercentage) {
		super(name, price, salePercentage);
		this.kind = kind;
	}

	void dogfeild() {
		System.out.printf("이곳은 %s 용품을 파는 곳입니당~%n", kind);
	}
}

class Cat extends Product {
	String kind;

	Cat() {}
	Cat(String name, String kind, int price, int salePercentage) {
		super(name, price, salePercentage);
		this.kind = kind;
	}

	void catfeild() {
		System.out.printf("이곳은 %s 용품을 파는 곳입니당~%n", kind);
	}
}


//3대 강아지, 고양이 용품
class DogProduct extends Dog {
	String sortOfProduct;
	String[] sort = { "간식, 사료", "장난감", "리빙, 패션" };

	DogProduct() {}
	DogProduct(String name, String kind, int indexOfSort, int price, int salePercentage) {
		super(name, kind, price, salePercentage);
		sortOfProduct = sort[indexOfSort];
	}

	void productInfo() {
		System.out.printf("이 상품은 %s용 상품이고, %s 카테고리에 속합니다. %n상품명은 %s입니다.%n", kind, sortOfProduct, name);
	}

	void infoPrint() {
		productInfo();
		priceNsale();
	}

}

class CatProduct extends Cat {
	String sortOfProduct;
	String[] sort = { "간식, 사료", "장난감", "냥냥상자" };

	CatProduct() {}
	CatProduct(String name, String kind, int indexOfSort, int price, int salePercentage) {
		super(name, kind, price, salePercentage);
		sortOfProduct = sort[indexOfSort];
	}

	void productInfo() {
		System.out.printf("이 상품은 %s용 상품이고, %s 카테고리에 속합니다. %n상품명은 %s입니다.%n", kind, sortOfProduct, name);
	}
	
	@Override
	void catfeild() {
		System.out.printf("이곳은 %s 용품을 파는 곳입니당~%n", kind);
		System.out.println("야옹야옹");
	}


	void infoPrint() {
		productInfo();
		priceNsale();
		System.out.println("고양이 용품 할인 진행 중!! 마감 임박!!!!!");
	}

}
