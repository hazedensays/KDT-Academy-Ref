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











