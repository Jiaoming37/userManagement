create table EMPLOYEE (
    ID int not null AUTO_INCREMENT,
    NAME varchar(100) not null,
    TYPE int(1) not null,
    USERID int,
    PRIMARY KEY (ID),
    CONSTRAINT FOREIGN KEY (`USERID`) REFERENCES `USER` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
);