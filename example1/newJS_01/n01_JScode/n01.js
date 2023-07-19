// ** Object 축약표현================================
// 1. Property 축약
 //   => ES5
 
 var x = 1, y = 2;
 var oldObject = {x: x,
                  y: y,
                  sayHello: function() {
                    console.log(`sayHello => x: ${this.x}, y: ${oldObject.y}`);
                  }};

 console.log (`oldObject.x => ${oldObject.x}, oldObject.y => ${oldObject.y}`);
 
 

 //   => ES6 : 프로퍼티 축약 표현 적용
 //객체의 속성명과 동일한 이름의 변수에 값이 할당
 let xx = 10, yy = 20;
 let newObject = {xx,
                  yy,
                  sayHello() {
                    console.log(`sayHello => xx: ${this.xx}, yy: ${newObject.yy}`);
                  }};
 console.log (`newObject.xx => ${newObject.xx}, newObject.yy => ${newObject.yy}`);



 //2. 메서드 축약
  //   => ES5: 익명함수 형식으로 정의
  //   => ES6: function 키워드를 생략한 선언함수 형식으로 정의
oldObject.sayHello();
newObject.sayHello();


