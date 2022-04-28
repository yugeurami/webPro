DROP TABLE CUS_LEVEL;
DROP TABLE CUSTOMER;

CREATE TABLE CUS_LEVEL(
    LEVELNO     NUMBER(1) PRIMARY KEY,
    LEVELNAME VARCHAR2(20) NOT NULL );

CREATE TABLE CUSTOMER(
    CNO         NUMBER(2) PRIMARY KEY,
    CNAME     VARCHAR2(30) NOT NULL,
    JOINDATE  DATE DEFAULT SYSDATE,
    PHONE      VARCHAR2(30) UNIQUE,
    POINT       NUMBER(9),
    LEVELNO    NUMBER(1),
    FOREIGN KEY (LEVELNO)REFERENCES CUS_LEVEL(LEVELNO)  );
    
CREATE SEQUENCE CUS_SQ NOCACHE NOCYCLE;

INSERT INTO CUS_LEVEL VALUES (1, 'VVIP');
INSERT INTO CUS_LEVEL VALUES (2, 'VIP');
INSERT INTO CUS_LEVEL VALUES (3, 'NORMAL');
INSERT INTO CUS_LEVEL VALUES (4, 'BLACK');

INSERT INTO CUSTOMER VALUES (CUS_SQ.NEXTVAL, '홍길동', '22/03/10', '010-9999-9999', 0, 1);
INSERT INTO CUSTOMER (CNO, CNAME, JOINDATE, PHONE, LEVELNO)
    VALUES (CUS_SQ.NEXTVAL, '이철수', '22/04/19', '010-8888-8888', 2);

COMMIT;

SELECT CNO, CNAME, TO_CHAR(JOINDATE, 'YYYY-MM-DD') JOINDATE, PHONE, POINT, LEVELNAME 
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO=L.LEVELNO
    ORDER BY CNO;