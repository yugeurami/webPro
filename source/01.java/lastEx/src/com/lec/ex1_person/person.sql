DROP TABLE JOB;
DROP TABLE PERSON;
DROP SEQUENCE PERSON_NO_SQ;
CREATE TABLE JOB (
    JNO     NUMBER(2) PRIMARY KEY,
    JNAME VARCHAR2(30) NOT NULL );

CREATE TABLE PERSON(
    PNO         NUMBER(2) PRIMARY KEY,
    PNAME     VARCHAR(30) NOT NULL,
    JNO         NUMBER(2) NOT NULL,
    KOR         NUMBER(3),
    ENG         NUMBER(3),
    MAT         NUMBER(3),
    FOREIGN KEY (JNO) REFERENCES JOB(JNO) );
    
CREATE SEQUENCE PERSON_NO_SQ NOCACHE NOCYCLE;

INSERT INTO JOB VALUES(10, '배우');
INSERT INTO JOB VALUES(20, '가수');
SELECT
    * FROM PERSON;
INSERT INTO PERSON VALUES(PERSON_NO_SQ.NEXTVAL, '정우성', 10, 90, 80, 81);
INSERT INTO PERSON VALUES(PERSON_NO_SQ.NEXTVAL, '박세영', 10, 80, 90, 80);
INSERT INTO PERSON VALUES(PERSON_NO_SQ.NEXTVAL, '배수지', 20, 20, 90, 90);
INSERT INTO PERSON VALUES(PERSON_NO_SQ.NEXTVAL, '설현', 20, 95, 95, 95);
INSERT INTO PERSON VALUES(PERSON_NO_SQ.NEXTVAL, '송혜교', 10, 100, 100, 100);

-- 1
SELECT JNO FROM JOB WHERE JNAME='가수';
INSERT INTO PERSON VALUES (PERSON_NO_SQ.NEXTVAL, '정우성', (SELECT JNO FROM JOB WHERE JNAME='가수'), 90, 80, 81);

-- 2
SELECT P.*, JNAME FROM PERSON P, JOB J WHERE P.JNO=J.JNO AND JNAME='배우' ORDER BY (KOR+ENG+MAT) DESC;

SELECT ROWNUM, PNAME||'('||PNO||'번)' NAME, JNAME, KOR, ENG, MAT, SUM
    FROM (SELECT P.*, JNAME, (KOR+ENG+MAT) SUM  
                FROM PERSON P, JOB J 
                WHERE P.JNO=J.JNO AND JNAME='배우' 
                ORDER BY SUM DESC);

-- 3
SELECT ROWNUM, PNAME||'('||PNO||')' NAME, JNAME, KOR, ENG, MAT, SUM
    FROM (SELECT P.*, JNAME, (KOR+ENG+MAT) SUM
                FROM PERSON P, JOB J 
                WHERE P.JNO=J.JNO ORDER BY SUM DESC);
                
               
