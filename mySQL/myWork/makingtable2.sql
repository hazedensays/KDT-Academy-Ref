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










