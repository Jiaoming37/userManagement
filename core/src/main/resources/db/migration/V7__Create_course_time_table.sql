create table COURSE_TIME (
    ID int not null AUTO_INCREMENT,
    COURSE_ID int not null,
    TIME DATE ,
    PRIMARY KEY (ID),
    CONSTRAINT FOREIGN KEY (`COURSE_ID`) REFERENCES `COURSE` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
);