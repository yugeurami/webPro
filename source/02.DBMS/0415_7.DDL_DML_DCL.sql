-- [VII] DDL, DML, DCL
-- SQL   = DDL (테이블 생성, 테이블 삭제, 테이블 구조 변경, 테이블 모든 데이터 제거)
--         = DML (검색=SELECT, 추가=INSERT, 수정=UPDATE, 삭제=DELETE)
--         = DCL (사용자 계정 생성, 사용자 권한 부여, 권한 박탈, 사용자 계정 삭제, 트랜잭션 명령어 = ROLLBACK, COMMIT)

-- [DDL]
-- 1. 테이블 생성 (CREATE TABLE)
CREATE TABLE BOOK(
    BOOKID         NUMBER(4), -- 도서번호 BOOKID 필드 타입은 숫자 4자리
    BOOKNAME    VARCHAR2(300), -- 책이름 BOOKNAME 필드 타입은 문자 300BYTE
    PUBLISHER     VARCHAR2(300), -- 출판사 PUBLISHER 필드 타입은 문자 300BYTE
    RDATE           DATE,               -- 출판일  RDATE 필드는 DATE 형
    PRICE            NUMBER(8),        -- 가격 PRICE 필드 숫자 8자리
    PRIMARY KEY(BOOKID)  );         -- 테이블 내 주키(PRIMARY KEY) 설정 - NOT NULL, 유일한 값 입력

SELECT * FROM BOOK;
DROP TABLE BOOK;

CREATE TABLE book (
    bookid        NUMBER (4) PRIMARY KEY,
    BOOKNAME VARCHAR2(20),
    PUBLISHER  VARCHAR2(20),
    RDATE        DATE,
    PRICE         NUMBER(8) );
    
 SELECT * FROM BOOK;   
 
SELECT * FROM EMP;
SELECT ROWNUM, EMPNO, ENAME FROM EMP; -- ROWNUM : 테이블에서 행의 논리적인 순서 
SELECT ROWNUM, EMPNO, ENAME FROM EMP WHERE DEPTNO = 20 ORDER BY ENAME;

-- EMP 테이블과 유사한 EMP01 : EMPNO(숫자 4자리), ENAME(문자20자리), SAL(숫자7, 2)
CREATE TABLE EMP01(
    EMPNO NUMBER(4),
    ENAME VARCHAR2(20),
    SAL     NUMBER(7, 2)    );

-- DEPT와 유사한 DEPT01 : DEPTNO (숫자2, PK) DNAME(문자14), LOC(문자13)
CREATE TABLE DEPT01(
    DEPTNO NUMBER(2),
    DNAME VARCHAR2(14),
    LOC VARCHAR2(13),    
    PRIMARY KEY (DEPTNO)    );

-- 서브쿼리를 이용한 테이블 생성
CREATE TABLE EMP02 AS SELECT * FROM EMP; -- 서브쿼리 결과만 EMP02테이블 생성 후 들어감(제약조건은 미포함)
SELECT * FROM EMP02;
DESC EMP02; 
-- 제약조건 미포함 확인
    -- ex. EMP03 : EMP 테이블에서 EMPNO, ENAME, DEPTNO만 추출한 데이터로 테이블
CREATE TABLE EMP03
    AS
    SELECT EMPNO, ENAME, DEPTNO FROM EMP;
    --  ex. EMP04: EMP 테이블에서 10번 부서만 추출한 데이터로 테이블
CREATE TABLE EMP04
    AS
    SELECT * FROM EMP WHERE DEPTNO = 10;
    -- ex. EMP05 : EMP 테이블 구조(필드와 그의 타입)만 추출
CREATE TABLE EMP05
    AS
    SELECT * FROM EMP WHERE 1=0; -- 반드시 거짓인 조건을 넣으면 된다.
SELECT * FROM EMP05;

-- 2. 테이블 구조 변경
-- ALTER TABLE 테이블명 ADD     : 추가
--                               MODIFY : 수정
--                               DROP    : 삭제
-- (1) 필드 추가 : 추가된 필드의 데이터는 NULL
SELECT * FROM EMP03; -- EMPNO, ENAME, DEPTNO
ALTER TABLE EMP03 ADD (JOB VARCHAR(20), SAL NUMBER(7, 2));
ALTER TABLE EMP03 ADD (COMM NUMBER(7,2));

-- (2) 필드 수정
SELECT * FROM EMP03; -- EMPNO 숫자(4), ENAME 문자(10), DEPTNO숫자(2) / JOB문자(20), SAL, COMM 숫자(7,2) 데이터 NULL
ALTER TABLE EMP03 MODIFY (EMPNO VARCHAR2(4)); -- 숫자 데이터가 들어 있는 상태에서는 숫자로만 변경 가능
ALTER TABLE EMP03 MODIFY (EMPNO NUMBER(3)); -- 불가능
ALTER TABLE EMP03 MODIFY (EMPNO NUMBER(5)); -- 가능
ALTER TABLE EMP03 MODIFY (ENAME NUMBER(4)); -- 문자 데이터가 들어가 있는 상태에서 문자로만 변경가능
SELECT MAX(LENGTH(ENAME)) FROM EMP;
ALTER TABLE EMP03 MODIFY (ENAME VARCHAR2(3000));
ALTER TABLE  EMP03 MODIFY (ENAME VARCHAR2(6));
ALTER TABLE  EMP03 MODIFY (ENAME VARCHAR2(5)); -- 불가능 (6BYTE 글자 데이터가 있어서)
ALTER TABLE EMP03 MODIFY (JOB VARCHAR2(2));
ALTER TABLE EMP03 MODIFY (JOB NUMBER(4));

-- (3) 필드 삭제
ALTER TABLE EMP03 DROP COLUMN JOB;
SELECT * FROM EMP03; 
-- 논리적으로 특정 필드 접근 못하도록
ALTER TABLE EMP03 SET UNUSED(DEPTNO);
-- 논리적으로 접근 불가했던 필드를 물리적으로 삭제
ALTER TABLE EMP03 DROP UNUSED COLUMN;

-- 3. 테이블 삭제
DROP TABLE EMP01;
DROP TABLE DEPT; -- 다른 테이블에서 참조하는 데이터가 있을 경우 바로 DROP 불가

-- 4. 테이블의 모든 행을 제거
SELECT * FROM EMP03;
TRUNCATE TABLE EMP03; -- EMP03안의 데이터 제거(취소 불가)

-- 5. 테이블 명 변경
-- RENAME  원이름 TO 새이름
SELECT * FROM EMP02;
RENAME EMP02 TO EMP2;
SELECT * FROM EMP2;

-- 6. 데이터 딕셔너리(접근불가)
-- 데이터 딕셔너리 뷰(사용자 접근용)
-- 종류
--  USER_XXX : 현 계정이 소유하고 있는 데이터 객체(테이블, 인덱스, 제약조건, 뷰)
    -- ex. USER_TABLES, USER_INDEXES, USER_CONSTRAINTS, USER_VIEWS
--  ALL_XXX : 현 계정이 접근 가능한 객체(테이블, 인덱스, 제약조건, 뷰)
    -- ex. ALL_TABLES, ALL_INDEXES, ALL_CONSTRAINTS, ALL_VIEWS
-- DBA_XXX : DBA권한자만 접근 가능, DBMS의 모든 객체
    -- ex. DBA_TABLES,DBA_INDEXES, DBA_CONSTRAINTS, DBA_VIEWS
SELECT * FROM USER_TABLES;  -- 내 계정이 소유한 테이블 객체 정보
SELECT * FROM USER_INDEXES; -- 내 계정이 소유한 인덱스 정보
SELECT * FROM USER_CONSTRAINTS; -- 내 계정이 소유한 제약 조건들
SELECT * FROM USER_VIEWS; -- 내 계정이 소유한 뷰 정보
SELECT * FROM DBA_TABLES;
SELECT * FROM DBA_INDEXES;
SELECT * FROM DBA_CONSTRAINTS;
SELECT * FROM ALL_TABLES;
SELECT * FROM ALL_INDEXES;
SELECT * FROM ALL_CONSTRAINTS;


-- DCL
-- 사용자 계정 생성, 사용자 권한 부여, 권한 박탈, 사용자 계정 삭제
CREATE USER scott2 IDENTIFIED BY 1234;
-- 1. 권한 부여(세션 권한, SCOTT.EMP, SCOTT.DEPT 테이블에 대해 모든 권한)
GRANT CREATE SESSION TO scott2;
GRANT ALL ON EMP TO scott2; -- EMP 테이블에 대한 모든 권한(검색, 추가, 수정, 삭제)
GRANT ALL ON DEPT TO scott2;
-- 2. 권한 박탈(권한 박탈할 사용자 계정이 접속해제된 상태여야 가능)
REVOKE ALL ON EMP FROM scott2; -- scott2의 EMP 테이블에 대한 모든 권한 박탈
REVOKE ALL ON DEPT FROM scott2;
-- 3. 사용자 계정 삭제(접속 중인 계정 삭제 불가)
DROP USER scott2 CASCADE;

-- DML
-- SELECT, INSERT, UPDATE, DELETE
-- 1. INSERT
-- INSERT INTO 테이블명 VALUES (값1, 값2, 값3....);
-- INSERT INTO 테이블명 (필드명1, 필드명2,.....) VALUES (값1, 값2,....);
SELECT * FROM DEPT01;
INSERT INTO DEPT01 VALUES (50, 'ACCOUNTING', 'NEW YORK');
INSERT INTO DEPT01 (DEPTNO, DNAME, LOC) VALUES (60, 'IT', 'SEOUL');
INSERT INTO DEPT01 (DEPTNO, DNAME) VALUES (70, 'OPERATION'); -- 묵시적으로 LOC에 NULL로 추가
INSERT INTO DEPT01 VALUES (80, 'HR', NULL); -- 명시적으로 LOC에 NULL 추가
INSERT INTO DEPT01 (DEPTNO, DNAME, LOC) VALUES (90, 'SALES', NULL);
-- 서브쿼리를 이용한 INSERT
INSERT INTO DEPT01 SELECT * FROM DEPT;
-- 트랜잭션 명령어 (DML 명령어만)
COMMIT;

CREATE TABLE SAM01 (
    EMPNO NUMBER(4) PRIMARY KEY,
    ENAME VARCHAR2(10),
    JOB      VARCHAR2(9),
    SAL      NUMBER(7,2) );

CREATE TABLE SAM01 (
    EMPNO NUMBER(4) CONSTRAINTS SAM_PK PRIMARY KEY, -- 제약조건 이름 설정
    ENAME VARCHAR2(10),
    JOB      VARCHAR2(9),
    SAL      NUMBER(7,2) );
DROP TABLE SAM01;
SELECT * FROM USER_CONSTRAINTS;    

INSERT INTO SAM01 VALUES (1000, 'APPLE', 'POLICE', 10000);
INSERT INTO SAM01 VALUES (1010, 'BANANA', 'NURSE', 15000);
INSERT INTO SAM01 VALUES (1020, 'ORANGE', 'DOCTOR', 25000);
INSERT INTO SAM01 (EMPNO, ENAME, SAL) VALUES (1030, 'VERY', 25000);
INSERT INTO SAM01 (EMPNO, ENAME, SAL) VALUES (1040, 'CAT', 2000);
INSERT INTO SAM01 SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE DEPTNO = 10;
SELECT * FROM SAM01;

ROLLBACK;

COMMIT;

-- 2. UPDATE
--UPDATE table_name 
--  SET column_name1=value1, column_name2 = value2, …
--  WHERE condition;
CREATE TABLE EMP01 AS SELECT * FROM EMP;
-- EMP01 테이블의 부서번호를 30번으로 수정(WHERE절 없이는 모든 행이 수정)
UPDATE EMP01 
    SET DEPTNO = 30;
SELECT * FROM EMP01;
ROLLBACK; -- 트랜잭션 취소 (DML만 취소 가능)
-- EMP01테이블의  모든  사원의  급여를  10% 인상
UPDATE EMP01 
    SET SAL = SAL*1.1;
-- 10번 부서의 직원의 입사일을 오늘로, 부서번호는 30번으로 수정
UPDATE EMP01
    SET HIREDATE = SYSDATE, 
          DEPTNO = 30 
    WHERE DEPTNO = 10;
-- 급여가  3000이상인  사원만  급여를  10%인상
UPDATE EMP01 
    SET SAL = SAL*1.1 
    WHERE SAL>=3000;
-- ‘DALLAS’에서  근무하는  직원 들의  연봉을  1000인상
UPDATE EMP01
    SET SAL = SAL+1000
    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS');
-- SCOTT사원의  부서번호는  20번으로, 직급은  MANAGER 로  SAL과 COMM 을 500씩 인상하고 상사를 KING으로 수정
UPDATE EMP01
    SET DEPTNO = 20, 
            JOB = 'MANAGER',
            SAL = SAL+500,
            COMM = NVL(COMM, 0) +500,
            MGR = (SELECT EMPNO FROM EMP WHERE ENAME = 'KING')
    WHERE ENAME = 'SCOTT';
-- DEPT01에서 20번부터의 지역명을 DEPT테이블의 60번부터의 지역명으로 변경
UPDATE DEPT01
    SET LOC = (SELECT LOC FROM DEPT WHERE DEPTNO = 60)
    WHERE DEPTNO >= 20; -- DEPT 테이블의 60번 부서가 없어서 NULL값으로 수정
-- EMP01 테이블의 모든 사원의 급여와 입사일을 'KING'의 급여와 입사일로 수정
UPDATE EMP01
    SET SAL = (SELECT SAL FROM EMP WHERE ENAME = 'KING'),
          HIREDATE = (SELECT HIREDATE FROM EMP WHERE ENAME = 'KING');
UPDATE EMP01
    SET (SAL, HIREDATE) = (SELECT SAL, HIREDATE FROM EMP WHERE ENAME = 'KING');
-- DEPT01 테이블의 20번 부서의 지역명과 부서명을 40번 부서의 지역명과 부서명으로 변경
UPDATE DEPT01
    SET (LOC, DNAME) = (SELECT LOC, DNAME FROM DEPT01 WHERE DEPTNO = 40);
    WHERE DEPTNO = 20;
    
-- 3. DELETE
-- DELETE FROM table_name 
--  WHERE condition;
DELETE FROM EMP01; -- WHERE절을 안 쓸 경우 전체 행이 모두 삭제
-- EMP01 테이블에서 'FORD'인 사원을 삭제
DELETE FROM EMP01 WHERE ENAME = 'FORD';

--EMP01 테이블에서 30번 부서 직원을 삭제
DELETE FROM EMP01 WHERE DEPTNO = 30;

-- EMP01 테이블에서 부서명이 RESEARCH 부서의 직원을 삭제
DELETE FROM EMP01 WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE ENAME = 'RESEARCH');
-- SAM01 테이블에서 JOB이 정해지지 않은 사원을 삭제
DELETE FROM SAM01 WHERE JOB IS NULL;
--SAM01테이블에서  ENAME이  ORANGE인  사원을  삭제하시오
DELETE FROM SAM01 WHERE ENAME = 'ORANGE';

-- 연습문제
--1
CREATE TABLE MY_DATA(
    ID          NUMBER(4) PRIMARY KEY,
    NAME    VARCHAR2(10),
    USERID   VARCHAR2(30),
    SALARY  NUMBER(10,2));
--2
INSERT INTO MY_DATA VALUES (1, 'Scott', 'sscott', 10000.00);
INSERT INTO MY_DATA VALUES (2, 'Ford', 'ffoed', 13000.00);
INSERT INTO MY_DATA VALUES (3, 'Patel', 'ppatel', 33000.00);
INSERT INTO MY_DATA VALUES (4, 'Report', 'rreport', 23500.00);
INSERT INTO MY_DATA VALUES (5, 'Good', 'ggood', 44450.00);
--3
SELECT ID, NAME, USERID, TO_CHAR(SALARY, '99,999.99') FROM MY_DATA;
--4
COMMIT;
--5
UPDATE MY_DATA
    SET SALARY = 65000.00
    WHERE ID = 3;
COMMIT;
--6
DELETE FROM MY_DATA
    WHERE NAME = 'Ford';
COMMIT;
--7
UPDATE MY_DATA
    SET SALARY = 15000.00
    WHERE SALARY<=15000.00;
--8
DROP TABLE MY_DATA;


-- 제약조건 : 부적합한 데이터가 테이블에 삽입, 수정되는 것을 방지하기 위해
-- (1) PRIMARY KEY : 유일하게 테이블의 각 행을 식별. NOT NULL
INSERT INTO EMP VALUES (7369, '홍', NULL, NULL, SYSDATE, NULL, NULL, 40); -- SMITH 사번과 중복 에러
UPDATE EMP SET EMPNO = 7369 WHERE ENAME = 'ALLEN'; -- SMITH 사번과 중복 에러
-- (2) NOT NULL : NULL 값을 포함하지 않음
-- (3) UNIQUE : 모든 행에 대해 유일해야함 NILL 값을 허용(NULL은 여러행 입력가능)
-- (4) FOREIGN KEY : 테이블의 열은 다른 테이블의 열을 참조 (ex. EMP 테이블의 DEPTNO는 DEPT 테이블의 DEPTNO를 참조)
-- 참조중인 테이블을 PARENT TABLE 혹은 부모 테이블이라고 한다
    -- 식별관계 : 부모 테이블의 주키가 자식테이블의 PRIMARY KEY 필드로 관계 (exERD 초록 점선 화살표)
    -- 비식별 관계 : 부모 테이블의 주키가 자식테이블의 일반 속성 필드로 관계 (exERD에서 빨간 점선 화살표)
INSERT INTO EMP (EMPNO, ENAME, DEPTNO) VALUES (1111, '홍', 90); -- DEPT 테이블에 DEPTNO에 90이라는 값이 없음
-- (5) CHECK(조건) : 해당 조건이 만족(NULL 값 허용)
-- *DEFAULT : 기본값 설정 (해당 열의 데이터 입력값이 없으면 NULL이 들어감)
CREATE TABLE DEPT1(
    DEPTNO NUMBER(2) PRIMARY KEY,
    DNAME VARCHAR2(14) UNIQUE,
    LOC VARCHAR2(13) NOT NULL   );
CREATE TABLE EMP1(
    EMPNO       NUMBER(4) PRIMARY KEY,
    ENAME       VARCHAR2(10) NOT NULL,
    JOB            VARCHAR2(9),
    MGR           NUMBER(4),
    HIREDATE    DATE DEFAULT SYSDATE,
    SAL            NUMBER(7,2) CHECK(SAL>0),
    COMM        NUMBER(7,2),
    DEPTNO      NUMBER(2) REFERENCES DEPT1(DEPTNO)   );
DROP TABLE EMP1; -- 자식테이블(참조하는 테이블) 먼저 DROP
DROP TABLE DEPT1; -- 다른 테이블에서 참조하는 필드가 있을 때 부모테이블을 먼저 지울 수 없다
DROP TABLE DEPT1 DASCADE CONSTRATRINTS; -- 참조하는 테이블이 있어도 무시하고 드롭

CREATE TABLE DEPT1(
    DEPTNO NUMBER(2),
    DNAME VARCHAR2(14),
    LOC VARCHAR2(13) NOT NULL,
    PRIMARY KEY (DEPTNO),
    UNIQUE(DNAME)   );

CREATE TABLE EMP1(
    EMPNO NUMBER(4),
    ENAME VARCHAR2(10) NOT NULL,
    JOB VARCHAR2(9),
    MGR NUMBER(4),
    HIREDATE DATE DEFAULT SYSDATE,
    SAL NUMBER(7,2),
    COMM NUMBER(7,2),
    DEPTNO NUMBER(2),
    PRIMARY KEY(EMPNO),
    CHECK(SAL>0),
    FOREIGN KEY(DEPTNO) REFERENCES DEPT1(DEPTNO)    );
INSERT INTO DEPT1 SELECT * FROM DEPT;
INSERT INTO DEPT1 VALUES (40, 'IT', 'SEOUL'); -- PK 위배
INSERT INTO DEPT1 VALUES (50, 'SALES', 'SEOUL'); -- UNIQUE 위배
INSERT INTO DEPT1 VALUES (50, 'IT', NULL); -- NOT NULL 위배

INSERT INTO EMP1 (EMPNO, ENAME, DEPTNO) VALUES (1001, '홍', 10); -- HIREDATE 기본값 설정
INSERT INTO EMP1 (EMPNO, ENAME, DEPTNO) VALUES (1001, '김', 10); --PK위배
INSERT INTO EMP1 (EMPNO, DEPTNO) VALUES (1002, 10); -- NOT NULL 위배
INSERT INTO EMP1 (EMPNO, ENAME, SAL) VALUES (1002, '박', -1); -- CHECK 조건(SAL>0) 위배
INSERT INTO EMP1 VALUES(1002, '윤', NULL, NULL, TO_DATE('95/01/01', 'YY/MM/DD'), 900, NULL, 99); -- FK 제약조건


-- 연습문제
--(1)
CREATE TABLE BOOKCATEGORY (
    CATEGORY_CODE NUMBER(3) PRIMARY KEY,
    CATEGORY_NAME VARCHAR2(50) UNIQUE,
    OFFICE_LOC VARCHAR2(40) NOT NULL);

CREATE TABLE BOOK (
    CATEGORY_CODE NUMBER(3) REFERENCES BOOKCATEGORY (CATEGORY_CODE),
    BOOKNO VARCHAR2 (10) PRIMARY KEY,
    BOOKNAME VARCHAR2(50),
    PUBLISHER VARCHAR2(50),
    PUBYEAR NUMBER(4) DEFAULT EXTRACT(YEAR FROM SYSDATE)
    );

INSERT INTO BOOKCATEGORY VALUES (100, '철학', '3층 인문실');
INSERT INTO BOOKCATEGORY VALUES (200, '인문', '3층 인문실');
INSERT INTO BOOKCATEGORY VALUES (300, '자연과학', '4층 과학실');
INSERT INTO BOOKCATEGORY VALUES (400, 'IT', '4층 과학실');

INSERT INTO BOOK VALUES (100, '100A01', '철학자의 삶', '더존출판', 2021);
INSERT INTO BOOK VALUES (400, '400A01', '이것이 DB', '더존출판', 2018);

--(2)
CREATE TABLE MAJOR(
    MAJOR_CODE NUMBER(2) PRIMARY KEY,
    MAJOR_NAME VARCHAR2(50) UNIQUE,
    MAJOR_OFFICE_LOC VARCHAR2(50) NOT NULL   );
DROP TABLE STUDENT;
CREATE TABLE STUDENT(
    STUDENT_CODE VARCHAR2(6) PRIMARY KEY,
    STUDENT_NAME VARCHAR2(50) NOT NULL,
    SCORE NUMBER(3) CHECK(SCORE>0 AND SCORE<=100),
    MAJOR_CODE NUMBER(2) REFERENCES MAJOR (MAJOR_CODE) );

INSERT INTO MAJOR VALUES(1, '경영정보', '경영관 305');
INSERT INTO MAJOR VALUES(2, '소프트웨어공학', '정보관 808호');
INSERT INTO MAJOR VALUES(3, '디자인', '예술관 606호');
INSERT INTO MAJOR VALUES(4, '경제', '경상관 202호');

INSERT INTO STUDENT VALUES('A01', '김길동', 100, 1);
INSERT INTO STUDENT VALUES('A02', '문길동', 90, 2);
INSERT INTO STUDENT VALUES('A03', '홍길동', 95, 1);