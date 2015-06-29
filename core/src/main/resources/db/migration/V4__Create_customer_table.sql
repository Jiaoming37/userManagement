create table CUSTOMER (
    ID int not null AUTO_INCREMENT,
    NAME varchar(100) not null,
    EMAIL varchar(100) not null,
    PRIVATE_COACH int,
    PRIMARY KEY (ID)
);