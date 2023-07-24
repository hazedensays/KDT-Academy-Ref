 // Test2) 클래스
  // 2.1) 객체(클래스) 정의
  class Vacation2 {
    // => 변수(속성) 정의
    id='banana'; // prototype(인스턴스) 변수
    static country='Korea'; // static 변수

    // => 생성자함수 정의
    constructor(destination, days, name) {
      this.destination=destination;
        this.days=days;
      // => static 사용법
      //country=destination; //Uncaught ReferenceError: country is not defined
     //this.country=destination; // 오류응 없지만, 바람직한 접근법이아님, 클래스명으로 접근
      Vacation2.country=destination;
      this.name=name; // this.name 즉, '홍길동' 과는 다른 내부 변수
    }

    // 2.2) 메서드 추가
    // => prototype(인스턴스) 메서드
    print() {
      console.log(`** Test2) 우리는 ${this.destination} 를 ${this.days} 일간 여행 합니다. `);
      console.log(`** Test2) this.name=${this.name}, id=${this.id}, country=${Vacation2.country}`);
    }
    // => static 메서드 
    static info() {
      // => static 메서드에서 this의 값은 클래스 생성자인 Vacation2 자체가 됨.
         // => static 메서드에서 prototype(인스턴스) 변수 사용 : 불가능  
         //    오류는 발생하지 않지만 undefined 
      console.log(` ${this.destination} 는 여행 안전 지역 입니다.`);
         console.log(`prototype_name => ${this.name} `);
         // => static 메서드에서 this는  Vacation2 자체 이므로
         //    ${this.name} 은 객체 자신의 name 을 return : Vacation2
         
         console.log(`%%% this_country => ${this.country} `);  
         // => static 메서드에서 this는  Vacation2 자체 이므로 출력가능  
         console.log(`Vacation2.country => ${Vacation2.country} `);
         // => static 메서드에서 static 변수 사용 : 내부에서도 클래스 명으로 접근
    }
  } //class

  // 2.3) 활용
  // => 인스턴스 생성전 static 사용
  console.log(`** Test3) 인스턴스 생성전 static 사용: country=${Vacation2.country}`);
  Vacation2.info();

  // => 인스턴스 생성(생성자호출) 후 사용
  let winterTrip = new Vacation2("노르웨이",30, '김길동');
  winterTrip.print();
  Vacation2.info();
  
  let winterTrip2 = new Vacation2("알프스",20, '이길동');
  winterTrip2.id='apple';
  winterTrip2.print();
  Vacation2.info();

  // => winterTrip2 인스턴스 생성 후 비교
  // => id 변경은 winterTrip2 만 반영되지만, 
  //    static(클래스) 변수 countrty 변경은 모두에게 적용됨. 
  winterTrip.print();