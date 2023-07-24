// 1. new.target =================================================================================
// => 생성자 함수로 객체 정의

// 1-1. new.target 사용
function Circle(radius) {
    this.radius = radius;
    this.getDiameter = () => {
        return this.radius * 2
    }
}

//let c1 = Circle(5);  //new 없이 사용: 일반 함수로 호출 -> 인스턴스를 생성하지 못함
// console.log (`new 없이 사용1 => Diameter: ${c1. getDiameter()}`);
let c1 = new Circle(5);
console.log (`new.target 사용 => Diameter: ${c1. getDiameter()}`);

// 1-2. new 없이 호출해도 생성 가능한 객체 정의
// => new 연산자를 사용하지 않은 경우에는 생성된 함수 내부에서 생성시켜줌
// => new.target 속성
//    -> new 연산자와 함께 호출되지 않았다면 new.taarget은 undefined
//    -> new 연산자와 함께 호출되었다면 생성자 또는 함수 참조를 반환함

function Circle2(radius) {
    // new.target 속성을 확인하고 undefined인 경우에는 내부에서 생성시켜 반환
    if (!new.target) {
        return new Circle2(radius);
    }

    this.radius = radius;
    this.getDiameter = () => {
        return this.radius * 2
    }
}

let c2 = Circle2(5);

console.log (`new 없이 사용 => Diameter: ${c2. getDiameter()}`);



// 2. instanceof =================================================================================
// => 객체의 타입을 확인하기 위해 사용되는 연산자

function Circle3(radius) {
    // => 인스턴스를 확인해서 다르면 생성 후 return
    if(!(this instanceof Circle3)) {
        return new Circle3(radius);
    }

    this.radius = radius;
    this.getDiameter = () => {
        return this.radius * 2
    }
}

let c3 = Circle3(5);
// new 연산자 없이 생성자 함수를 호출하여도 생성자 함수로서 호출됨

console.log (`instanceof 사용 => Diameter: ${c3. getDiameter()}`);



// 3. function_객체의 상속 =================================================================================
// => 3-1) 상속 없는 경우
//    -> Circle3은 new 연산자 없이 생성됨
let e1 = Circle3(11);
let e2 = Circle3(22);
let e3 = Circle3(33);

console.log (`상속없이 사용 => Diameter: ${e1. getDiameter()}`);
console.log (`상속없이 사용 => Diameter: ${e2. getDiameter()}`);
console.log (`상속없이 사용 => Diameter: ${e3. getDiameter()}`);


function Circle4(radius) {
    this.radius = radius;
    this.getArea = function() {
        return Math.PI * this.radius ** 2;
    }
}
// => 상속관계 구현: 위 코드의 this.getArea를 조상에 정의
// => 객체의 조상: prototype 속성
//    즉, 객체의 prototype 속성을 활용하면 상속의 관계를 구현함

function Circle5(radius) {
    this.radius = radius;
}

Circle5.prototype.getArea = function() {
    return Math.PI * this.radius ** 2;
}

let ee1 = new Circle5(11);
let ee2 = new Circle5(22);
let ee3 = new Circle5(33);

// let ee1 = Circle3(11);
// let ee2 = Circle3(22);
// let ee3 = Circle3(33);

console.log (`prototype 사용 - 상속관계 구현 => Area: ${ee1.getArea()}`);
console.log (`prototype 사용 - 상속관계 구현 => Area: ${ee2.getArea()}`);
console.log (`prototype 사용 - 상속관계 구현 => Area: ${ee3.getArea()}`);

// => 생성자 함수가 생성한 모든 인스턴스는 부모 객체의 역할을 하는
//    프로토타입 Circle5.prototype으로부터 getArea 메서드를 상속받는다.
//    즉, Circle5 생성자 함수가 생성하는 모든 인스턴스는 하나의 getArea 메서드를 공유한다.