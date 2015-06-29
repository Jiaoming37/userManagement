create table COURSE (
    ID int not null AUTO_INCREMENT,
    NAME varchar(100) not null,
    COACH_ID int not null,
    PRIMARY KEY (ID),
    NSTRAINT FOREIGN KEY (`COACH_ID`) REFERENCES `USER` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
);