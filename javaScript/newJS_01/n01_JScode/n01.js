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



const sandwich = {
  bread: "더치크런치",
  meat: "참치",
  cheese: "스위스",
  toppings: ["상추", "토마토", "머스타드"]
}

let { bread, meat } = sandwich;
console.log(bread, meat); //더치크런치, 참치

bread = "마늘";
meat = "칠면조";

console.log(bread, meat); //마늘, 칠면조
console.log(sandwich.bread, sandwich.meat); //더치크런치, 참치

// ** babel, 바벨 
        // => java script의 최신문법을 구형 브라우저에서도 쓸 수 있도록해줌.
        // => 브라우저에서 코드를 실행하기전에 더 호환성이 높은 코드로 변환하는것을
        //    컴파일링(compiling) 이라하고, 대표적인 JS 컴파일링도구가 바벨 이다.  
        // => 단, 이것은 코드를 바이너리로 변환하는 전통적인 컴파일링언어 와는 다르게
        //    JS 코드를 더많은 브라우저가 이해할수있는 다른 버전의 JS구문으로 변환해준다. 

        // ** 객체 구조분해 사례 1
        // => 아래 코드는 sandwich 객체를 분해해서 bread, meat의 값을 같은 이름의 변수에 넣어줌.
        // => 그러나 두변수의 값을 변경해도 sandwich의 값에 영향을 주지는 않는다. 


        // 1. Object Destructuring(구조분해)
