-- DROP
DROP TABLE MEMBER;

-- CREATE
CREATE TABLE MEMBER(
    ID VARCHAR2(50) PRIMARY KEY,
    PW VARCHAR2(50) NOT NULL,
    NAME VARCHAR2(50) NOT NULL,
    BIRTH DATE,
    RDATE DATE DEFAULT SYSDATE NOT NULL);
    
-- 회원가입
INSERT INTO 
    MEMBER(ID, PW, NAME, BIRTH)
    VALUES('aaa', '111', '홍길동', '1999-12-12');
    
                    
-- 회원 리스트
SELECT * FROM MEMBER;

COMMIT;