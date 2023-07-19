function Student(name, age) {
    this.name = name;
    this.age = age;
    this.infoPrint = function() {return(`이름은 ${this.name}이고 나이는 ${this.age}살 입니다.`);};
};

const student1 = new Student("찬미", 22);
const student2 = new Student("현주", 28);
const student3 = new Student("이지", 27);
const student4 = new Student("진휘", 27);

//age의 합계와 평균 출력
let total = 0, avg = 0;

let arr = new Array(4);
arr[0] = student1;
arr[1] = student2;
arr[2] = student3;
arr[3] = student4;

//eachfor은 값을 넣는 것은 불가능하고, readonly만 가능!!
for (let i of arr) {    //인덱스가 없기 때문에 arr[i].infoPrint()로 코드를 짜면 에러
    console.log(i.infoPrint());
}

for (let j in arr) {
    console.log(arr[j].name);
}