// ** Map **
// 1) 정의====================================================================

// => 생성과 동시에 초기화
let myMap = new Map([['a', 111], ['b', 222], ['c', 333]]);  //map의 생성자 함수 호출,
                                                            //객체와 같은 형태로 [] 대괄호 사용
                                                            //key는 문자,함수 형태는 가능하지만
                                                            //문자 형태는 불가능 하다.
console.log(`Test1 => size: ${myMap.size}, a: ${myMap.get('a')}`);

myMap.set('a', "aaa");
console.log(`Test2 => size: ${myMap.size}, a: ${myMap.get('a')}`);

myMap.set('d', "ddd");  //추가
console.log(`Test3 => size: ${myMap.size}, d: ${myMap.get('d')}`);

myMap.delete('b');  //삭제
console.log(`Test4 => size: ${myMap.size}, b: ${myMap.get('b')}`);  //undefined

//존재 확인
console.log(`Test5 => k의 존재 유무: ${myMap.has('k')}`);
console.log(`Test5 - 1 => a의 존재 유무: ${myMap.has('a')}`);


// => 생성 후 초기화
let stuMap = new Map();
stuMap.set('1', "뽀로로");
stuMap.set('2', "크롱");
stuMap.set('3', "포비");
stuMap.set('4', "루피");




// 2) 활용 : for ~ of====================================================================
// 출력 - 1 : map의 형태로 받기

for (let [key, value] of stuMap) {      //stuMap.set('1', "뽀로로");를 출력할 때
                                        //[] 대괄호 안에 변수를 데이터 개수만큼 넣으면 됨
    console.log (`Test6 : for ~ of => key: ${key}, name: ${value}`);
}

// 출력 - 2 : 일반 변수 형태로 받기 : 맵의 기본 Iterator인 entries가 적용되어 출력됨
for (let stu of stuMap) {
    console.log (`Test7 : for ~ of => stu: ${stu}`);
    console.log (`Test7-1 : for ~ of => stu: ${stu[0]}번-${stu[1]}`);
}

// 순회 메서드 : keys, values, entries (맵의 기본 이터레이터(Iterator: 반복자))
//keys
for (let stu of stuMap.keys()) {
    console.log (`Test8 : 순회 메서드(keys) => stu: ${stu}`);
}

//values
for (let stu of stuMap.values()) {
    console.log (`Test8-1 : 순회 메서드(values) => stu: ${stu}`);
}

for (let stu of stuMap.entries()) {
    console.log (`Test8-2 : 순회 메서드(entries) => stu: ${stu}`);
}

// 출력 - 3 : 모든 엔트리 일괄 삭제
myMap.clear();
console.log(`Test9 => size: ${myMap.size}`);    //size = 0




// 3) 활용====================================================================
// (1) : key가 객체인 경우
const user1 = {id:'pororo', name:'김뽀로로'};
const user2 = {id:'povi', name:'김포비'};
const user3 = {id:'rupi', name:'김루피'};
const user4 = {id:'eddy', name:'김에디'};

// Map 생성
const userMap = new Map();

userMap.set(user1, '뽀통령');
userMap.set(user2, '북극곰');
userMap.set(user3, '잔망루피');
userMap.set(user4, '사막여우');

// <for ~ of 이용하기>
// => 1. id, name 출력
for (let u of userMap.keys()) {
    console.log (`Test10 => id: ${u.id}, name: ${u.name}`);
}

// => 2. id와 등급(value) 출력

for (let u of userMap.entries()) {
    console.log (`Test10-1 => User: ${u[0].id}, 별명: ${u[1]}`);
}

// (2) : value가 객체인 경우
// student prototype(nickname, name)을 작성 후에 인스턴스 4개 생성
// Map에 담기 (key: 1~4, value: Student)

function TeamUser(nick, name) {    //생성자 함수 생성
    this.teamNick = nick;
    this.teamName = name;
}

const u1 = new TeamUser('수달', '김찬미');
const u2 = new TeamUser('상괭이', '조현주');
const u3 = new TeamUser('바다사자', '김이지');
const u4 = new TeamUser('북극곰', '김진휘');

const teamMap = new Map();

teamMap.set('1', u1);
teamMap.set('2', u2);
teamMap.set('3', u3);
teamMap.set('4', u4);

//출력방법 - 1
/* for (let [key, value] of teamMap) {
    console.log (`Test11 => 번호: ${key}, nickname: ${value.teamNick}, name: ${value.teamName}`);
} */

//출력방법 - 2
for (let t of teamMap) {
    console.log (`Test11 => 번호: ${t[0]}, nickname: ${t[1].teamNick}, name: ${t[1].teamName}`);
}