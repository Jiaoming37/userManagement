insert into USER ( NAME, PASSWORD, EMAIL, AGE) values ('Tom', 'password','tom@abc.com', 16);
insert into USER ( NAME, PASSWORD, EMAIL, AGE) values ('Jerry', 'password','jerry@abc.com', 17);
insert into USER ( NAME, PASSWORD, EMAIL, AGE) values ('Red', 'password','red@abc.com', 18);
insert into USER ( NAME, PASSWORD, EMAIL, AGE) values ('Marry', 'password','marry@abc.com', 19);
insert into USER ( NAME, PASSWORD, EMAIL, AGE) values ('James', 'password','james@abc.com', 20);
insert into USER ( NAME, PASSWORD, EMAIL, AGE) values ('Emma', 'password','emma@abc.com', 21);


insert into EMPLOYEE (NAME,TYPE,USERID) values ('hello',0,1);
insert into EMPLOYEE (NAME,TYPE,USERID) values ('hao',0,3);
insert into EMPLOYEE (NAME,TYPE,USERID) values ('good',1,5);
insert into EMPLOYEE (NAME,TYPE,USERID) values ('nice',1,2);
insert into EMPLOYEE (NAME,TYPE,USERID) values ('cool',1,6);
insert into EMPLOYEE (NAME,TYPE,USERID) values ('haha',2,4);


insert into CUSTOMER (NAME,EMAIL,PRIVATE_COACH) values ('zhao','zhao@abc.com',2);
insert into CUSTOMER (NAME,EMAIL,PRIVATE_COACH) values ('qian','qian@abc.com',6);


insert into COURSE (NAME,COACH_ID) values ('swimming',2);
insert into COURSE (NAME,COACH_ID) values ('jump',5);


insert into CUSTOMER_COURSE_JOIN(CUSTOMER_ID,COURSE_ID) values(1,1);
insert into CUSTOMER_COURSE_JOIN(CUSTOMER_ID,COURSE_ID) values(1,2);
insert into CUSTOMER_COURSE_JOIN(CUSTOMER_ID,COURSE_ID) values(2,2);
insert into CUSTOMER_COURSE_JOIN(CUSTOMER_ID,COURSE_ID) values(2,3);