-- 테이블 설계
DROP TABLE STUDENT;
DROP TABLE MAJOR;
DROP SEQUENCE STUDENT_SNO_SEQ;

CREATE TABLE MAJOR(
    MNO     NUMBER(2) PRIMARY KEY,
    MNAME VARCHAR(30) NOT NULL UNIQUE   );

CREATE TABLE STUDENT(
    SNO     NUMBER(7) PRIMARY KEY,
    SNAME VARCHAR(20) NOT NULL,
    MNO     NUMBER(2) NOT NULL REFERENCES MAJOR(MNO),
    SCORE   NUMBER(3) DEFAULT 0 CHECK(SCORE BETWEEN 0 AND 100),
    REG     NUMBER(1) DEFAULT 0 CHECK(REG IN (0,1)) );

CREATE SEQUENCE STUDENT_SNO_SEQ
    MAXVALUE 999
    NOCACHE
    NOCYCLE;

INSERT INTO MAJOR VALUES(1, '빅데이터학');
INSERT INTO MAJOR VALUES(2, '경영정보학');
INSERT INTO MAJOR VALUES(3, '컴퓨터공학');
INSERT INTO MAJOR VALUES(4, '국어국문학');
INSERT INTO MAJOR VALUES(5, '인공지능학');

INSERT INTO STUDENT(SNO, SNAME, MNO, SCORE) 
    VALUES(EXTRACT(YEAR FROM SYSDATE)||TRIM(TO_CHAR(STUDENT_SNO_SEQ.NEXTVAL, '000')), '홍길동', 1, 99);
    
SELECT * FROM MAJOR;
SELECT * FROM STUDENT;
    
-- 학번 검색
SELECT SNO, SNAME, MNAME, SCORE
    FROM STUDENT S, MAJOR M
    WHERE S.MNO=M.MNO AND REG = 0 AND SNO = 2022001;
    
-- 이름검색
SELECT SNO, SNAME, MNAME, SCORE
    FROM STUDENT S, MAJOR M
    WHERE S.MNO=M.MNO AND REG = 0 AND SNAME = '홍길동';
    
-- 학과 검색
SELECT SNO, SNAME, MNAME, SCORE
    FROM STUDENT S, MAJOR M
    WHERE S.MNO=M.MNO AND REG = 0 AND MNAME = '빅데이터학'
    ORDER BY SCORE DESC;

SELECT ROWNUM RANK, A.*
    FROM (SELECT SNO, SNAME, MNAME, SCORE
                FROM STUDENT S, MAJOR M
                WHERE S.MNO=M.MNO AND REG = 0 AND MNAME = '빅데이터학'
                ORDER BY SCORE DESC) A ;

--학생 입력
INSERT INTO STUDENT(SNO, SNAME, MNO, SCORE) 
    VALUES(EXTRACT(YEAR FROM SYSDATE)||TRIM(TO_CHAR(STUDENT_SNO_SEQ.NEXTVAL, '000')), '홍길동', 1, 99);

INSERT INTO STUDENT(SNO, SNAME, MNO, SCORE) 
    VALUES(EXTRACT(YEAR FROM SYSDATE)||TRIM(TO_CHAR(STUDENT_SNO_SEQ.NEXTVAL, '000')), 
                '김길동', (SELECT MNO FROM MAJOR WHERE MNAME = '빅데이터학'), 80);
    
-- 학생수정 
UPDATE STUDENT
    SET   SNAME = '이길동',
            MNO = (SELECT MNO FROM MAJOR WHERE MNAME = '인공지능학'),
            SCORE = '80'
    WHERE REG = 0 AND SNO = 2022002;

-- 학생 출력
SELECT ROWNUM RANK, S.*
    FROM (SELECT SNO, SNAME, MNAME, SCORE FROM STUDENT S, MAJOR M 
                WHERE S.MNO=M.MNO AND REG = 0 ORDER BY SCORE DESC) S;

-- 재적처리
UPDATE STUDENT
    SET REG = 1
    WHERE SNO = 2022001;

-- 재적자 출력
SELECT SNO, SNAME, MNAME, SCORE
    FROM STUDENT S, MAJOR M
    WHERE S.MNO=M.MNO AND REG = 1;
COMMIT;