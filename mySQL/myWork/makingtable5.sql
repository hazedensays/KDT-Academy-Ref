select * from glasses;
select * from student;
select * from glasses;
create Table test1 as select * from glasses;
create Table test2 as select * from glasses;
select * from test1;
desc test1;
select * from student;
create table test3 as select name, price, review from glasses;
select * from test3;
select * from glasses;
create table test4 as select * from glasses where price >= 700000;
select * from glasses;
select * from test4;
create table test5 as select name, price, review from glasses where price < 500000;
select * from test5;
drop table test;
create table test6 as select * from glasses where 1=2;
select * from test6;
insert into test6(name, price, optColor) select name, price, optColor from glasses;
select * from test6;
select * from glasses;
select * from test6;
insert into test6(name, price, optColor, orderNumber) select name, price, optColor, orderNumber from glasses;
desc glasses;
select * from test6;
insert into test5(name,price,optColor,orderNumber,review) select name,price,optColor,orderNumber,review from test6;
select * from test5;
rename table test6 to newTest6;
select * from newtest6;
truncate newtest6;
select * from newtest6;
desc newtest6;
drop table newtest6;
desc newtest6;
select * from newtest6;
select * from student;
insert into student(name, age, jno, info) values("홍길동", 20, 1, "난 홍길동");
insert into student(name, age, jno, info) values("김길동", 30, 1, "난 김길동");
insert into student(name, age, jno, info) values("최길동", 40, 1, "난 최길동");
insert into student(name, age, jno, info) values("박길동", 50, 1, "난 박길동");
insert into student(name, age, jno, info) values("이길동", 60, 1, "난 이길동");
insert into student(name, age, jno, info) values("신길동", 70, 1, "난 신길동");
insert into student(name, age, jno, info) values("배길동", 80, 1, "난 배길동");
insert into student(name, age, jno, info) values("은길동", 90, 1, "난 은길동");
select * from student;
create table stu1 as select * from student;
select * from stu1;
rename table stu1 to newStu1;
select * from newStu1;
create table stu2 as select * from student where 1=2;
select * from stu2;
insert stu2 (name, age, jno, info) values ("하제", 22, 4, "금요일이닷!");
select * from stu2;
insert into stu2(name, age, jno, info) select name, age, jno, info from student where age >= 50;
select * from stu2;
create table student2 (
sno int auto_increment Primary key,
name varchar(10) not null,
age int(3) Constraint sc02 check(age>15 and age<100),
jno int(1),
info varchar(30),
point float(5,2) default 100
);
select * from student2;
SELECT constraint_name, constraint_type
FROM information_schema.table_constraints
WHERE table_name = 'student';
SELECT constraint_name, constraint_type
FROM information_schema.table_constraints
WHERE table_name = 'student2';
create table friend (
name varchar(30),
phone varchar(16),
addres varchar(100),
constraint pk_friend primary key (name, phone)
);
desc friend;
insert into friend values ("홍길동", "010-1111-1111", "korea");
insert into friend values ("홍길동", "010-1111-1111", "korea");
insert into friend values ("홍길동", "010-1111-2222", "korea");
insert into friend values ("김길동", "010-1111-1111", "korea");
select * from friend;
  CREATE TABLE parent2(
     parent_id int(10) auto_increment,
     parent_name varchar(20) NOT NULL,
     phone varchar(13),
     CONSTRAINT pk_parent_id PRIMARY KEY(parent_id),
     CONSTRAINT un_parent_ph unique(phone)
  );
 CREATE TABLE parent3(
     parent_id int(10) auto_increment,
     parent_name varchar(20) NOT NULL,
     phone varchar(13),
     PRIMARY KEY(parent_id),
     unique(phone),
     NOT NULL(parent_name)
  );
  CREATE TABLE parent3(
parent_id int(10) auto_increment,
parent_name varchar(20) NOT NULL,
phone varchar(13),
PRIMARY KEY(parent_id),
unique(phone)
); 
SELECT constraint_name, constraint_type
FROM information_schema.table_constraints
WHERE table_name = 'parent2' ;
  CREATE TABLE parent(
     p_id int(10),
     p_name varchar(20) NOT NULL,
     phone varchar(13),
     CONSTRAINT pk_parent_id PRIMARY KEY(p_id)
  );
CREATE TABLE child (
seq int(5) primary key,
id int(10),

title varchar(20),

CONSTRAINT fk_child_id foreign key(id) references parent(p_id)
);
SELECT constraint_name, constraint_type
FROM information_schema.table_constraints
WHERE table_name = 'parent' ;
SELECT constraint_name, constraint_type
FROM information_schema.table_constraints
WHERE table_name = 'child' ;
insert into child values (1, 1, “child insert test”);
insert into parent values (1, “홍길동”, “010-1111-1111”);
select * from parent;
insert into parent values(1, "홍길동", "010-1111-1111");
insert into parent values(2, "김길동", "010-2222-1111");
insert into parent values(3, "박길동", "010-3333-1111");
select * from parent;
insert into child values(1, 1, "child insert test1");
insert into child values(2, 2, "child insert test2");
insert into child values(3, 3, "child insert test3");
insert into child values(4, 1, "child insert test4");
select * from child;
update child set id = 2 where seq = 4;
select * from child;
update child set id = 5 where seq = 1;
delete from child where seq = 2;
insert into parent values(7, "이길동", "010-4444-1111");
insert into parent values(8, "이길동", "010-8888-1111");
insert into parent values(9, "이길동", "010-9999-1111");
update parent set phone = "010-7777-1111" where p_id = 7;
update parent set p_id = 5, p_name = "바나나" where p_id = 7;
select * from parent;
update parent set p_id = 6, p_name = "김애플" where p_id = 3;
update parent set p_name = “사과나무” where p_id = 3;
update parent set p_name = "사과나무" where p_id = 3;
select * from parent;
delete from parent where p_id = 9;
select * from child;
delete from parent where p_id = 2;
delete from child where id = 2;
delete from parent where p_id = 2;
drop table child;
drop table parent;
  Create table parent(
     p_id int(10),
     p_name varchar(20) NOT NULL,
     phone varchar(13),
     CONSTRAINT pk_parent_id PRIMARY KEY(p_id)
  );
    Create table child (
			seq int(5) primary key,
			id int(10),
			title varchar(20),
			Foreign Key(id) References parent(p_id)
			ON DELETE CASCADE ON UPDATE CASCADE
		);
insert into child values (1, 1, “parent Data 없는 상태에서 입력”);
insert into parent values(1, "홍길동", "010-1111-1111");
insert into parent values(2, "김길동", "010-2222-1111");
insert into parent values(3, "박길동", "010-3333-1111");
select * from parent;
insert into child values(1, 1, "child insert test1");
insert into child values(2, 2, "child insert test2");
insert into child values(3, 3, "child insert test3");
insert into child values(4, 1, "child insert test4");
select * from child;
update parent set p_id = 5 where p_id = 1;
select * from parent;
select * from parent;
select * from child;
delete from parent where p_id = 5;
select * from parent;
select * from child;
show tables;
desc student;
desc student2;
drop table student2;
create table student2 as select * from student;
desc student2;
alter table student2 add primary key (sno);
desc student2;
select * from student2;
Alter Table student2 Add Constraint ccc01 check(point between 100 and 5000);
desc student2;
SELECT constraint_name, constraint_type 
   FROM information_schema.table_constraints
   WHERE table_name = 'student2';
Alter Table student2 Modify info varchar(30) not null;
desc student2;
Alter Table student2 Drop constraint ccc01;
SELECT constraint_name, constraint_type
FROM information_schema.table_constraints
WHERE table_name = 'student2';
SELECT constraint_name, constraint_type
FROM information_schema.table_constraints
WHERE table_name = 'parent';
SELECT constraint_name, constraint_type
FROM information_schema.table_constraints
WHERE table_name = 'child';
alter table parent drop constraint primary;
SELECT constraint_name, constraint_type
FROM information_schema.table_constraints
WHERE table_name = 'child';
alter table child drop constraint child_ibfk_1;
insert into child values (55, 55, “Drop Constraint”);
insert into child values (55, 55, 'Drop Constraint');
desc child;
use mydb;
show tables;
drop table test1;
drop table test2;
drop table test3;
drop table test4;
drop table test5;
drop table glasses;
drop table newstu1;
drop table parent;
drop table student2;
drop table student;
drop table parent2;
drop table parent3;
drop table child;
drop table friend;
drop table stu2;
-- 20230925
create table student (
sno int auto_increment,
name varchar(10) not null,
age int(3),
jno int(1),
info varchar(30),
point float(5,2) default 100,
primary key(sno),
check (age > 15 and age < 100)
);
create table jo (
jno int(1),
jname varchar(10) not null,
captain int not null,
project varchar(20) not null,
slogan varchar(30) not null,
primary key(jno)
);
-- insert into student(name, age, jno, info) values("김찬미", 22, 4, "4조의 학생");
-- insert into student values (...) : 모든 컬럼 값을 순서대로 입력할 때만 가능 
-- 									: (auto_increment와 default 있을 때 불가)
insert into student(name, age, jno, info) values("김소라",28,1,"1조");
insert into student(name, age , jno, info, point ) values("김이지렁이",27,4,"햄스터 좋아해용",999.99);
insert into student (name, age, jno, info) values("김진휘",  27, 4 ,"4조의 비둘기" );
insert into student(name, age, jno, info) values("김찬미", 22, 4, "4조의 학생");
insert into student(name, age, jno, info) values('김해림', 29, 2, '2조 조장');
insert into student(name, age, jno, info) values("남우리", 29, 3, "i4");
insert into student (name, age, jno, info, point) values('배정현', 36, 1, '준우 아빠', 99.9);
insert into student(name, age, jno, info) values("설수현", 27, 4, "i4");
insert into student(name, age, jno, info) values("신혜진", 27, 3, "I4");
insert into student(name, age, jno, info) values("안진혁", 26, 2, "학생");
insert into student(name, age, jno, info) values("양세현", 33, 2, "여우조");
insert into student(name, age, jno, info) values("성은",25,5,"성은 어");
insert into student(name, age, jno, info) value("연제승", 27, 3, "i4");
insert into student (name, age, jno, info) values ("오원희", 30, 5, "5조의 폭주기관차");
insert into student (name, age, jno, info) values("유희상", 35, 5, "5조의 학생");
insert into student(name, age, jno, info) values ("은희상", 27, 1, "1조의 학생");
insert into student(name, age, jno, info) values("이성룡",27,2,"CastleDragon");
insert into student(name, age, jno, info) values("이진기", 38, 5, "505호 학생중 나이 제일 많음yo...");
insert into student(name, age, jno, info) values("조현주", 48, 4, "다신 학원을 빠지지 않겠습니다.");
insert into student(name, age, jno, info) values("최승호", 25, 1, "1조의 학생");
select * from student;
-- truncate student => 데이터 구조는 그대로 두고 데이터 값만 삭제
insert into jo(jno,jname,captain,project,slogan) values(1, '119', 7, '펫밀리', '애완동물을 위한 홈페이지');
insert into jo values(2, '여우', 5, '여우책방', '책으로 마음의 양식을♡');
insert into jo values(3, "i4", 13, "단Dog", "반려동물 한마리 한마리 모두 소중하다");
insert into jo values(4,"최고조", 2,"tbtConcept","열정빼면 시체");
insert into jo values(5, "오조", 14, "Ojoa", "완주 아니면 죽음뿐");
select * from jo;
select s.sno, s.name, s.jno, j.project 
from student s, jo j
where s.jno = j.jno;
select s.sno, s.name, s.jno, j.project
from student s, jo j
where s.jno = j.jno
order by jno;
select j.jno, j.jname, j.captain, s.name
from student s, jo j
where s.jno = j.jno
order by jno;
select j.jno, j.jname, j.captain, s.name
from student s, jo j
where j.jno = s.jno
order by jno;
select j.jno, j.jname, j.captain, s.name
from jo j, student s
where j.captain = s.sno
order by jno;
insert into jo values (9, "test조", 99, "project_name", "slogan");
select * from jo;
insert into student(name, age, jno, info) values("홍길동", 22, 7, "joTable에 없는 조");
select * from student;
create table student2 (
sno int auto_increment,
name varchar(10) not null,
age int(3),
jno int(1),
info varchar(30),
point float(5, 2) default 100,
primary key(sno),
check(age > 15 and age < 100)
);
create table jo2 (
jno int(1),
jname varchar(10) not null,
captain int not null,
project varchar(20) not null,
slogan varchar(30) not null,
primary key(jno),
foreign key(captain) references student2(sno)
);
SELECT constraint_name, constraint_type
FROM information_schema.table_constraints
WHERE table_name = 'jo' ;
insert into student2 select * from student;
select * from student2;
select * from jo;
insert into jo2 select * from jo where jno <= 5;
select * from jo2;
update student2 set sno = 100 where sno = 21;
select * from student2;
update student2 set sno = 200 where sno = 13;
create table student3 (
sno int auto_increment,
name varchar(10) not null,
age int(3),
jno int(1),
info varchar(30),
point float(5, 2) default 100,
primary key(sno),
check(age > 15 and age < 100)
);
create table jo3 (
jno int(1),
jname varchar(10) not null,
captain int not null,
project varchar(20) not null,
slogan varchar(30) not null,
primary key(jno),
foreign key(captain) references student3(sno)
					 ON delete cascade
                     on update cascade
);
insert into student3 select * from student2;
select * from student3;
insert into jo3 select * from jo2;
select * from jo3;
insert into jo3 values(7, "Test", 55, "project_name", "slogan");
update student3 set sno = 111 where sno = 14;
select * from jo3;
update student3 set sno = 14 where name = "오원희";
update student3 set sno = 14 where sno = 111;
delete from student3 where sno = 7;
select * from student3;
select * from jo3;
delete from student3 where sno = 2;
select j.jno, j.jname, j.captain, s.name
from student3 s, jo3 j
where j.captain = s.sno;
create table jo4_parent (
jno int(1),
jname varchar(10) not null,
captain int not null,
project varchar(20) not null,
slogan varchar(30) not null,
primary key(jno)
);
drop table jo4_parent;
create table jo4 (
jno int(1),
jname varchar(10) not null,
captain int not null,
project varchar(20) not null,
slogan varchar(30) not null,
primary key(jno)
);
select * from jo4;
create table student4 (
sno int auto_increment,
name varchar(10) not null,
age int(3),
jno int(1),
info varchar(30),
point float(5, 2) default 100,
primary key(sno),
check(age > 15 and age < 100),
foreign key(jno) references jo4(jno)
on delete cascade
on update cascade
);
insert into jo4 select * from jo2;
select * from jo4;
insert into student4 select * from student2 where jno <= 5;
select * from student2;
select s.sno, s.name, s.jno, j.captain, j.project, j.slogan
from student4 s, jo4 j
where s.jno = j.jno;
update jo4 set name = “김이지우개” where sno = 2;
update jo4 set jname = “김이지우개” where sno = 2;
update jo4 set jno = 119 where jno = 1;
select * from jo4;
delete from jo4 where jno = 4;
select * from jo4;
update student2 set info = "Transaction test" where sno = 21;
rollback;
start transaction;
select * from student2;
update student2 set name = "홍길동" where jno = 2;
select * from student2;
rollback;
select * from student2;
start transaction;
update student2 set name = "김길동" where jno = 2;
select * from student2 where jno = 2;
rollback;
select * from student2 where jno = 2;
select sno, name, s.jno, j.jno, j.jname
from student s, jo j;
select sno, name, s.jno, j.jno, jname
from student s, jo j
where s.jno=j.jno ;
select * from student;
select * from jo;
select  sno, name, s.jno, j.jno, jname
from student s LEFT OUTER JOIN jo j
ON s.jno=j.jno;
select  sno, name, s.jno, j.jno, jname
from student s RIGHT OUTER JOIN jo j
ON s.jno=j.jno;
 select j.jno, j.jname, j. captain, s.name, s.age
from jo j Left Outer Join student s
On j.captain = s.sno;
select j.jno, j.jname, j. captain, s.name, s.age
from jo j RIGHT OUTER JOIN student s
On j.captain = s.sno;
alter table student2 ADD rno int default sno;
alter table student2 ADD rno int default 21;
select * from student2;
update student2 set rno = 12 where sno=13;
update student2 set rno = 5 where sno = 17;
update student2 set rno = 9 where sno = 3 ;
update student2 set rno=10 where sno=6;
UPDATE student2 SET rno = 8 WHERE sno=14;
UPDATE student2 SET rno = 14 WHERE sno=8;
update student2 set rno = 6 where sno = 10;
update student2 set rno = 1 where sno=7;
update student2 set rno = 3 where sno = 9;
update student2 set rno = 7 where sno =1;
update student2 set rno = 2 where sno = 16 ;
update student2 set rno = 15 where sno = 4;
update student2 set rno=17 where sno=5;
Update student2 set Rno=18 where sno=11;
Update student2 set Rno=11 where sno=18;
update student2 set rno = 13 where sno =12;
update student2 set rno = 4 where sno = 15;
select s1.sno, s1.name, s1.jno, s1.rno, s2.name as 짝꿍이름
from student2 s1, student2 s2
where s1.rno = s2.sno;
start transaction;
select s1.sno, s1.name, s1.jno, j.jname, j.captain, s2.name as 조장이름
from student2 s1, jo2 j, student2 s2
where s1.jno = j.jno and j.captain = s2.sno
order by jno;

-- 20230926-----------------------------------------------------------
use mydb;
select * from jo3;
update student3 set sno = 33 where sno = 13;
select * from student3;
start transaction;
delete from student3 where sno = 33;
select * from jo3;
rollback;
select sno, name, s.jno, jname, project
from student3 s join jo3 j
on s.jno = j.jno;
select sno, name, s.jno, jname, project
from student3 s left outer join jo3 j
on s.jno = j.jno;
select * from student where jno = (select jno from student where name = "안진혁");
select sno, name, jno from student2 where jno = (select jno from jo2 where jname = "오조");
select * from student2 where age >= (select age from student2 where name = "조현주");
select * from student2 where age < (select age from student2 where name = "조현주");
select * from student
where age < (select age from student where name = "조현주")
order by age desc;
select jno, jname, captain, ( select name from student where sno=j.captain ) 조장이름 from jo j;
select sno, name, jno, (select jname from jo j where jno = s.jno) 조이름 from student s;
update student set age = 28 where name = "조현주";
select sno, name, age, s.jno, j.jname
from student s, jo j
where s.jno = j.jno
and age <= (select age from student where name = "조현주")
order by age;
select count(*), sum(age), avg(age), max(age), min(age) from student;
insert into student(name, age, jno) values("왕길동", 77, 7);
select * from student;
select count(*), count(info), sum(age), avg(age), max(age), min(age) from student;
select jno, count(*), sum(age) , avg(age), max(age), min(age) from student GROUP BY jno order by jno ;
select age from student where jno = 4;
select jno, name, count(*), sum(age) , avg(age), max(age), min(age) from student GROUP BY jno order by jno;
select jno, count(*), sum(age) , avg(age), max(age), min(age)
from student
where jno > 2
group by jno
order by jno;
select jno, count(*), sum(age) , avg(age), max(age), min(age)
from student
where age >= 28
group by jno
order by jno;
select jno, count(*), sum(age) , avg(age), max(age), min(age)
from student
group by jno
having count(*) >= 4
order by jno;
select jno, count(*), sum(age) , avg(age), max(age), min(age)
from student
group by jno
having age >= 28
order by jno;
select  jno, count(*), sum(age) , avg(age), max(age), min(age)
from student
Group By jno
Having jno > 2
order by jno;
select  jno, count(*), sum(age) , avg(age), max(age), min(age)
from student
where age >= 28
Group By jno
Having count(*) >= 4
order by jno;
select  jno, count(*), sum(age) , avg(age), max(age), min(age)
from student
where age >= 28
Group By jno
Having count(*) >= 3
order by jno;
select jno, jname, count(*), sum(age), avg(age)
from student
group by jno;
select s.jno, j.jname, count(*), sum(age), avg(age)
from student s, jo j
where s.jno = j.jno
group by s.jno;
select s.jno, (select jname from jo j where j.jno = s.jno)조이름, count(*), sum(age), avg(age) from student s
group by jno
order by jno;
show tables;
create table test select * from student;
select * from test;
desc test;
SELECT constraint_name, constraint_type
FROM information_schema.table_constraints
WHERE table_name = "test";
alter table test add primary key(sno);
desc test;
alter table test add unique(name);
desc test;
alter table test add foreign key(jno) references jo(jno);
select * from Atest;
select * from jo;
alter table test add address varchar(30) not null default "경기도 광주시 오포읍";
select * from test;
alter table test drop column age;
alter table test rename column point to score;
alter table test rename column sno to idno;
desc test;
-- alter table test modify score number(10); -- 소수점 이하 있을 경우 허용 X
update test set score = 300.00 where idno = 2 or idno = 7;
select * from test;
alter table test modify score int(20);
desc test;
alter table test modify idno float(7, 3);
alter table test modify score varchar(10);
alter table test modify score int(10);
alter table test modify address varchar(20);
alter table test rename to newTest;
drop table student2;
drop table student3;
delete from student3;
-- view 예제 ------------------
create view myview01 as select sno, name, jno from student;
select * from myview01;
update myview01 set name = "MC그리" where sno = 22;
select * from myview01;
create view myview02 as
select s.sno, s.name, s.jno, j.jname, j.captain
from student s left outer join jo j
on s.jno = j.jno;
select * from myview02;
select v1.sno, v1.name, v1.jno, v1.jname, v1.captain, v2.name as 조장이름
from myview02 v1, myview02 v2
where v1.captain = v2.sno
order by jno;
create view myview01 as select sno, name, jno from student order by jno;
create or replace view myview01 as select sno, name, jno from student order by jno;
select * from myview01;
desc myview02;
select * from views where TABLE_SCHEMA = "mydb";
use mydb;
drop view myview01;
drop view myview02;
select * from myview02;
SHOW INDEX FROM student;
-- 20230927 --
USE mydb;
select sno, jno as 조번호 from student;
select sno, name, jno, point, jno + point 보너스 from student;
select sno, concat(name, info) 나의정보 from student;
select sno, name, concat("만", (age - 1), "세") 나이 from student;
select concat((age - 5), "이 되고 싶은 ",age, "살인 ", jno, "조", ",", name, "입니다. 저는 ", info, "입니다.") 자기소개 from student;
select sno, name, age, jno, (age * jno) Bonus, (Bonus + point) Ytotal, (Ytotal / 12) Monthly from student;
update student set point = point + (jno * sno + age) where point < 200;
select * from student order by point desc;
select sno, name, point from student where point = (select max(point) from student);
select sno, name, point from student where point >= (select avg(point) from student);
select sno, name, age from student where age = (select min(age) from student);
select sno, name, age from student where age >= 25 and age <= 30;
select sno, name, age from student where age between 25 and 30 order by age;
select sno, name, age from student where age > 25 || age < 30 order by age;
select sno, name, age from student where age >= 25 && age <= 30;
select * from student where info != "i4";
select * from student where info <> "i4";
select * from student where not info = "i4";
alter table student add address varchar(20);
select * from student;
update student set address = "분당구 미금역" where age >= (select avg(age) from student);
update student set address = "분당구 미금역" where (sno % 3 != 0);
select * from student where address is Null;
select sno, name from student where name BETWEEN "남" AND "안" order by name;
select * from student where jno IN(1, 4, 5) order by jno ;
select * from student where info IN("학생", "CastleDragon", "성은 어");
select * from student where name  LIKE  "_진%" ;
select * from student where info Like "%학생%";
select * from student where info Like "%학생%" || info Like "%Dragon%" || info Like "%어%";
select * from student where (age between 27 and 33) and (info like "%학생%");
CREATE TABLE IF NOT EXISTS divisions (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(25) NOT NULL,
belts VARCHAR(200) NOT NULL
);
INSERT INTO divisions(name,belts)
VALUES ('O-1','white,yellow,orange'),
('O-2','purple,green,blue'),
('O-3','brown,red,black'),
('O-4','white,yellow,orange'),
('O-5','purple,green,blue'),
('O-6','brown,red'),
('O-7','black'),
('O-8','white,yellow,orange'),
('O-9','purple,green,blue'),
('O-10','brown,red');
SELECT * FROM divisions;
drop table divisions;
SELECT * from divisions where belts like '%orange%' ;
select *, FIND_IN_SET('orange', belts) from divisions;
select sno, name, jno from student limit 3;
select sno, name, jno from student limit 5, 5;
select * from student order by name desc limit 3,3;
select * from student order by name limit 3,3;
select DISTINCT jno, name from student order by jno;
select DISTINCT jno from student order by jno ;
select jno, age from student order by jno, age ;
select DISTINCT jno, age from student order by jno, age ;
select DISTINCT jno, age from student order by jno; 
select DISTINCT age from student; 
select jno, age, name from student order by jno, age desc, name;
select 24*60*365 ;
select sno, name, age, (3*8000*365*age) 내밥값 from student;
select sno, name, age, point, (sno-age),abs(sno-age), ABS(age-point) from student;
select 34.56789, Truncate(34.56789, 3), Truncate(34.56789, 0);
select Truncate(-34.56789, 3), Truncate(-34.1, 3);
select ROUND(1477.56789, 3), ROUND(1577.56789, -3), ROUND(1277.56789, -3),
ROUND(1277.56789, -2), ROUND(1277.56789, 2) ;
select name, point, Floor(point), Truncate(point,1), Round(point, -2) from student;
select name, point, age, (point/age), ceil(point/age), round(point/age) from student;
select MOD(27,2) , MOD(27,3) ;
select sno, name, age from student where MOD(age,3) = 0;
SELECT sno, name, point, FLOOR(point)
FROM student
WHERE MOD(FLOOR(point), 2) = 0;
SELECT sno, name, point, FLOOR(point)
FROM student
WHERE MOD(FLOOR(point), 3) = 0;
alter table student ADD birthday varchar(10) default "1999-04-05";
update student set birthday = "1988-08-08" where MOD(jno, 2) = 0;
select * from student;
select sno, name, birthday from student where substr(birthday, 6, 2) = "08";
select sno, name, age from student where substr(name, 1, 1) in ("김", "이", "박");
select sno, name, RPAD(substr(name, 1, 1), char_length(name), "*") name2 from student; 
select sno, name, birthday, DATE_FORMAT(birthday, '%Y년 %m월 %d일') 생일 from student;
use mydb;
select sno, CONCAT(substr(name,1,1), '**') name, birthday from student;

select sno, name, jno, IF(jno=7,'관리자','학생') ifTest from student;
select sno, name, jno, IF((jno%2=0), "짝수조", "홀수조") ifTest from student;
select sno, name, jno, if (jno = 1, "일조",
					   if  (jno = 2, "이조",
					   if  (jno = 3, "삼조",
					   if (jno = 4, "사조",
					   if  (jno = 5, "오조", "칠조"))))) 조이름 from student;
select sno, name, jno, address, IFNull(address, "에러") from student;
show tables;
create table student5 select * from student where 1 = 2;
desc student5;
select Max(sno), Max(sno) + 1 from student5;
select Max(sno), Max(sno) + 1, IFNULL(Max(sno), 0) from student5;
insert into student5(sno, name, age, jno)
values ((select * from (select IFNULL(Max(sno), 0) + 1 from student5) as temp), "김김김", 22, 7);
select * from student5;
select sno, name, point,
Case When point > 200 and point < 500  Then "VVIP"
When point >= 150 and point <= 200 Then "VIP"
When point < 150 Then "normal"
Else "Error"
End Grade
from student;
select sno, name, point,
Case When point between 201 and 500  Then "VVIP"
	 When point between 150 and 200 Then "VIP"
     When point < 150 Then "normal"
     Else "Error"
     End Grade
     from student;
select sno, name, s.jno from student s
where EXISTS ( select jno from jo j where j.jno=s.jno );
select sno, name, jno from student where exists (select * from jo where captain = sno);
select * from jo;
select sno, name, jno, "조없음" info from student s where Not Exists (select * from jo j where j.jno = s.jno);
select sno, name, jno, replace(info, info, "조없음") as info from student s where Not Exists (select * from jo j where j.jno = s.jno);
update student s set info = "조없음" where not exists (select * from jo j where j.jno = s.jno);
select * from student;
select sno, name, jno from student
where jno IN (1, 4, 5);
select sno, name, jno from student
where sno in (select captain from jo where captain = sno);
select sno, name, s.jno,
Case When Exists(select 1 from jo where captain = sno ) Then  "조장"
Else "조원"
End 구성	
from student s;
select * from jo;
desc jo;
desc student;
alter table student drop column address;
desc student;
select * from student;
start transaction;
update student set name = "홍길동";
select * from student;
rollback;
select * from student;
delete from student where sno = 31;
drop table member;
create table member as
select * from student;
desc member;
alter table member change sno id varchar(10);
alter table member modify point double(5, 2);
alter table member add password varchar(10);
alter table member modify point double;
drop table member;
create table member(
id varchar(10) primary key,
password varchar(10) not null,
name varchar(10),
age int(3),
jno int(3),
info varchar(30),
point double,
birthday varchar(10),
rid varchar(10)
);
insert into member(id,password,name,age,jno,info,point,birthday)
select s.sno,'12345!', s.name, s.age,s.jno, s.info, s.point, s.birthday
from student s;
select * from member;
update member set id = "zzaeminy" where id = "4";
update member set id='csh98' where id='20';
update member set id='haerim' where id='5';
update member set id='silver' where id='16';
update member set id = "hyejin11" where name = "신혜진";
update member set id='sora' where id='1';
update member set id='ajh97' where id='10';
update member set id='ruhappy' where id='12';
update member set id="suehyun" where id='8';
update member set id="ezirenge" where id='2';
update member set id='kongbori' where id='19';
update member set id='wonee512' where id='14';
update member set id='memoire' where id='18';
update member set id='jekichan' where name='이성룡';
update member set id='papipu' where id='15';
update member set id='ajh97' where id='10';
update member set id = "nameground" where id ='3';
update member set id='jeseung' where id='13';
update member set id="ysh" where id='11';
update member set id='papipu' where id='15';
update member set id='bae87' where id='7';
update member set id='wri' where id='6';
update member set id = "zzaeminy" where id = "4";
desc member;
select * from member;
update member set name = "관리자" where id = "admin";
SELECT * FROM CAR_RENTAL_COMPANY_CAR
WHERE OPTIONS
LIKE "네비게이션"
order by d;

create  table board (    
seq int(5) primary key AUTO_Increment,
id varchar(10) not null,
title varchar(200) not null,
content Text(2000),
regdate datetime DEFAULT CURRENT_TIMESTAMP,
cnt int default 0
);
insert into board(id, title, content) values("sonny","손흥민에 대하여","토트넘 주장");
insert into board(id, title, content) values("zzaeminy","잼민이의 특기","메롱을 잘한다.");
insert into board(id, title, content) values("kongbori","학원을 결석하는 11가지 방법","집가고 싶다");
insert into board(id, title, content) values("admin","관리자","관리자다임마");
insert into board(id, title, content) values("ezirenge","김이지렁이가 좋아하는 것","햄스터");
insert into board(id, title, content) values("nameground","비둘기 일상","비둘비둘비둘기");
insert into board(id, title, content) values("hyejin11","잼민잼민언니","i4최고잼민");
insert into board(id, title, content) values("32","파리생제르망","강인이는 귀여워");
insert into board(id, title, content) values("이강인","파리에서의 일상","음바페랑 축구하기");
insert into board(id, title, content) values("황희찬","희발 씨찬이형","황소");
select * from board;
drop table jo;
drop table jo2;
drop table jo3;
drop table jo4;
create table jo (
   jno int(1),
   jname varchar(10) not null,
   id varchar(10) not null,  
   project varchar(20) not null,
   slogan varchar(30) not null,
   Primary Key(jno)
);
insert into jo values(1, '119', 'bae87', '펫밀리', '애완동물을 위한 홈페이지');
insert into jo values(2, '여우', 'haerim', '여우책방', '책으로 마음의 양식을♡');
insert into jo values(3, "i4", 'jeseung', "단Dog", "반려동물 한마리 한마리 모두 소중하다");
insert into jo values(4,"최고조", 'ezirenge',"tbtConcept","열정빼면 시체");
insert into jo values(5, "오조", 'wonee512', "Ojoa", "완주 아니면 죽음뿐");
insert into jo values(7, "칠면조", 'admin', "관리팀", "열심히 일하자 !!!");
select * from jo;











