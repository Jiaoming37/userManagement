ALTER TABLE CUSTOMER DROP FOREIGN KEY CUSTOMER_ibfk_1;
alter table CUSTOMER add constraint foreign key(PRIVATE_COACH) references EMPLOYEE(ID);

ALTER TABLE COURSE DROP FOREIGN KEY COURSE_ibfk_1;
alter table COURSE add constraint foreign key(COACH_ID) references EMPLOYEE(ID);