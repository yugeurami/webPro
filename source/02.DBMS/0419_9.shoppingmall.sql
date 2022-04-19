-- [IV] 쇼핑몰 설계
CREATE TABLE MEMBER(
     ID            VARCHAR2(100) PRIMARY KEY,
    MNAME     VARCHAR2(50) NOT NULL,
    MADDRESS VARCHAR2(300),
    MTEL         VARCHAR2(100),
    EMAIL        VARCHAR2(100) NOT NULL);
    
CREATE TABLE PRODUCT(
    CODE    VARCHAR2(10) PRIMARY KEY,
    PNAME  VARCHAR2(50) NOT NULL,
    PRICE    NUMBER(5) NOT NULL,
    STOCK NUMBER(3) DEFAULT 0 );

CREATE SEQUENCE CART_SEQ
    MAXVALUE 9999
    NOCACHE
    NOCYCLE;    
    
CREATE TABLE CART(
    CNO     NUMBER(4) PRIMARY KEY,
    ID         VARCHAR2(100) REFERENCES MEMBER(ID),
    CODE    VARCHAR2(10) REFERENCES PRODUCT(CODE),
    COUNT   NUMBER(2) NOT NULL,
    COST     NUMBER(10)  );    
    
CREATE SEQUENCE ORDERS_SEQ
    MAXVALUE 9999
    NOCACHE
    NOCYCLE;
  
CREATE TABLE ORDERS(
    ONO         NUMBER(12) PRIMARY KEY,
    ID         VARCHAR2(100) REFERENCES MEMBER(ID),
    ODATE       DATE DEFAULT SYSDATE,
    OADDRESS  VARCHAR2(300),
    OTEL          VARCHAR2(100)  );
    
CREATE SEQUENCE ORDER_DETAIL_SEQ
    MAXVALUE 9999
    NOCACHE
    NOCYCLE;    

CREATE TABLE ORDER_DETAIL(
    ODNO   NUMBER(4) PRIMARY KEY,
    ONO    NUMBER(12) REFERENCES ORDERS(ONO),
    CODE    VARCHAR2(10) REFERENCES PRODUCT(CODE),
    COUNT  NUMBER(2), 
    COST     NUMBER(8));    
    
INSERT INTO MEMBER VALUES ('abc', '홍길동', '서울 강남구', '010-1111-1111', 'abc@gmail.com');
INSERT INTO MEMBER VALUES ('def', '전투왕', '서울 서대문구', '010-2222-222', 'def@gmail.com');    
    
INSERT INTO PRODUCT VALUES ('A1', '맥주', 3000, 20);
INSERT INTO PRODUCT VALUES ('A2', '소주', 2000, 40);
INSERT INTO PRODUCT VALUES ('B1', '땅콩', 3500, 50);
INSERT INTO PRODUCT VALUES ('B2', '오징어', 5000, 60);
INSERT INTO PRODUCT VALUES ('C1', '기저귀', 7000, 15);    
    
INSERT INTO ORDERS VALUES ( 
    TO_CHAR(SYSDATE, 'YYMMDD')||TRIM(TO_CHAR(ORDERS_SEQ.NEXTVAL,'0000')), SYSDATE,
    'abc','서울시 강남구', '010-1111-1111');
INSERT INTO ORDERS VALUES ( 
    TO_CHAR(SYSDATE, 'YYMMDD')||TRIM(TO_CHAR(ORDERS_SEQ.NEXTVAL,'0000')), SYSDATE,
    'def','서울시 서대문구', '010-2222-2222');
INSERT INTO ORDERS VALUES ( 
    TO_CHAR(SYSDATE, 'YYMMDD')||TRIM(TO_CHAR(ORDERS_SEQ.NEXTVAL,'0000')), SYSDATE,
    'abc','경기도 과천', '010-3333-3333',SYSDATE);
                
INSERT INTO ORDER_DETAIL
    VALUES (ORDER_DETAIL_SEQ.NEXTVAL, 2022041900001, 'abc', 'A1', 3,
                (SELECT PRICE FROM PRODUCT WHERE CODE= 'A1')*3);
UPDATE PRODUCT
    SET STOCK = STOCK - 3
    WHERE CODE = 'A1';
    
INSERT INTO ORDER_DETAIL
    VALUES (ORDER_DETAIL_SEQ.NEXTVAL, 2022041900001, 'abc', 'B1', 1,
                (SELECT PRICE FROM PRODUCT WHERE CODE= 'B1')*1);
UPDATE PRODUCT
    SET STOCK = STOCK - 1
    WHERE CODE = 'B1';
    
INSERT INTO ORDER_DETAIL
    VALUES (ORDER_DETAIL_SEQ.NEXTVAL, 2022041900001, 'abc', 'A2', 2,
                (SELECT PRICE FROM PRODUCT WHERE CODE= 'A2')*2);
UPDATE PRODUCT
    SET STOCK = STOCK - 2
    WHERE CODE = 'A2';
                
INSERT INTO ORDER_DETAIL
    VALUES (ORDER_DETAIL_SEQ.NEXTVAL, 2022041900001, 'abc', 'B2', 1,
                (SELECT PRICE FROM PRODUCT WHERE CODE= 'B2')*1);
UPDATE PRODUCT
    SET STOCK = STOCK - 1
    WHERE CODE = 'B2';                

INSERT INTO ORDER_DETAIL
    VALUES (ORDER_DETAIL_SEQ.NEXTVAL, 2022041900002, 'edf', 'A2', 2,
                (SELECT PRICE FROM PRODUCT WHERE CODE= 'A2')*2);
UPDATE PRODUCT
    SET STOCK = STOCK - 2
    WHERE CODE = 'A2';  
    
INSERT INTO ORDER_DETAIL
    VALUES (ORDER_DETAIL_SEQ.NEXTVAL, 2022041900002, 'edf', 'B2', 1,
                (SELECT PRICE FROM PRODUCT WHERE CODE= 'B2')*1);
UPDATE PRODUCT
    SET STOCK = STOCK - 1
    WHERE CODE = 'B2';  
    
INSERT INTO ORDER_DETAIL
    VALUES (ORDER_DETAIL_SEQ.NEXTVAL, 2022041900002, 'edf', 'C1', 1,
                (SELECT PRICE FROM PRODUCT WHERE CODE= 'C1')*1);
UPDATE PRODUCT
    SET STOCK = STOCK - 1
    WHERE CODE = 'C1';  
    
INSERT INTO ORDER_DETAIL
    VALUES (ORDER_DETAIL_SEQ.NEXTVAL, 2022041900003, 'abc', 'A1', 2,
                (SELECT PRICE FROM PRODUCT WHERE CODE= 'A1')*2);
UPDATE PRODUCT
    SET STOCK = STOCK - 2
    WHERE CODE = 'A1';   

INSERT INTO ORDER_DETAIL
    VALUES (ORDER_DETAIL_SEQ.NEXTVAL, 2022041900003, 'abc', 'B1', 1,
                (SELECT PRICE FROM PRODUCT WHERE CODE= 'B1')*1);
UPDATE PRODUCT
    SET STOCK = STOCK - 1
    WHERE CODE = 'B1';  

INSERT INTO ORDER_DETAIL
    VALUES (ORDER_DETAIL_SEQ.NEXTVAL, 2022041900003, 'abc', 'C1', 1,
                (SELECT PRICE FROM PRODUCT WHERE CODE= 'C1')*1);
UPDATE PRODUCT
    SET STOCK = STOCK - 1
    WHERE CODE = 'C1';
 