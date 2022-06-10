-- 테이블 & 시퀀스 DROP
DROP TABLE BOOK;
DROP SEQUENCE BOOK_SEQ;
DROP TABLE CUSTOMER;
DROP TABLE FILEBOARD;
DROP SEQUENCE FILEBOARD_SEQ;

-- 테이블 & 시퀀스 CREATE
-- BOOK
CREATE TABLE BOOK(
    BID            NUMBER(5)         PRIMARY KEY, 
    BTITLE        VARCHAR2(100)   NOT NULL,    
    BPRICE       NUMBER(6)         NOT NULL,    
    BIMG1        VARCHAR2(30)    NOT NULL,    
    BIMG2        VARCHAR2(30)    NOT NULL,   
    BCONTENT  VARCHAR2(4000),                  
    BDISCOUNT NUMBER(3)         NOT NULL,   
    BRDATE      DATE          DEFAULT SYSDATE 
);

CREATE SEQUENCE BOOK_SEQ MAXVALUE 99999 NOCACHE NOCYCLE;

-- CUSTOMER
CREATE TABLE CUSTOMER(
    CID             VARCHAR2(50)    PRIMARY KEY,
    CPW           VARCHAR2(50)    NOT NULL,
    CNAME       VARCHAR2(50)    NOT NULL,
    CTEL           VARCHAR2(50)    NOT NULL,
    CEMAIL       VARCHAR2(50),
    CADDRESS   VARCHAR2(250),
    CGENDER    VARCHAR2(10)    NOT NULL,
    CBIRTH       DATE                NOT NULL,
    CRDATE      DATE                NOT NULL
);

-- FILEBOARD
CREATE TABLE FILEBOARD(
    FNUM        NUMBER(7)         PRIMARY KEY,
    CID            VARCHAR2(50)    REFERENCES CUSTOMER (CID),
    FSUBJECT    VARCHAR2(250)   NOT NULL,
    FCONTENT  VARCHAR2(4000),
    FFILENAME  VARCHAR2(50),
    FPW           VARCHAR2(50)    NOT NULL,
    FHIT           NUMBER(7)         DEFAULT 0 NOT NULL,
    FREF           NUMBER(7)         NOT NULL,
    FRE_STEP     NUMBER(7)         NOT NULL,
    FRE_LEVEL    NUMBER(7)         NOT NULL,
    FIP              VARCHAR2(50)    NOT NULL,
    FRDATE        DATE                DEFAULT SYSDATE NOT NULL
);

CREATE SEQUENCE FILEBOARD_SEQ MAXVALUE 9999999 NOCACHE NOCYCLE;