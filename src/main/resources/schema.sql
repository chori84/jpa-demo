DROP TABLE IF EXISTS emp;

create table emp
(
	empno bigint not null primary key,
	ename varchar(255) null,
	addr_id bigint null,
	deptno bigint null
);

create index FKdgyakt3d0784rm8hsjkhh2l8u on emp (addr_id);
create index FKfqt0j25nlvjwt7qt1t3x7v6qf on emp (deptno);

DROP TABLE IF EXISTS dept;

create table dept
(
	deptno bigint not null primary key,
	dname varchar(255) null
);

DROP TABLE IF EXISTS addr;

create table addr
(
	id bigint not null primary key,
	address varchar(255) null
);

DROP TABLE IF EXISTS sawon;

create table sawon
(
  id bigint not null primary key,
  name varchar(255) null
);

DROP TABLE IF EXISTS hobby;

create table hobby
(
  id bigint not null primary key,
  name varchar(255) null
);

DROP TABLE IF EXISTS sawon_hobby;

create table sawon_hobby
(
  sawon_id bigint not null,
  hobby_id bigint not null,
  primary key(sawon_id, hobby_id)
);

DROP TABLE IF EXISTS student;

create table student
(
  id bigint not null primary key,
  name varchar(10) not null,
  professor_id bigint not null
);

DROP TABLE IF EXISTS subject;

create table subject
(
  id bigint not null primary key,
  name varchar(10) not null
);

DROP TABLE IF EXISTS student_subject;

create table student_subject
(
  student_id bigint not null,
  subject_id bigint not null,
  primary key(student_id, subject_id)
);

DROP TABLE IF EXISTS professor;

create table professor
(
  id bigint not null primary key,
  name varchar(10) not null,
  subject_id bigint null
);