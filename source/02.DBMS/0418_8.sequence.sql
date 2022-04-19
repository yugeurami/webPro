-- [VIII] Sequence : 순차번호 생성기, 대부분 인위적인 PK 사용 용도
DROP SEQUENCE FRIEND_SEQ;
CREATE SEQUENCE FRIEND_SEQ
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 9999
    MINVALUE 1
    NOCACHE
    NOCYCLE;
    
CREATE SEQUENCE FRIEND_SEQ
    MAXVALUE 9999
    NOCACHE
    NOCYCLE;

SELECT FRIEND_SEQ.NEXTVAL FROM DUAL;

CREATE TABLE FRIEND(
    NUM NUMBER(4) PRIMARY KEY, -- 시퀀스 이용
    NAME VARCHAR2(30) NOT NULL,
    TEL VARCHAR2(30) UNIQUE,
    ADDRESS VARCHAR2(300),
    LAST_MODIFYED DATE DEFAULT SYSDATE);
INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS) 
    VALUES (FRIEND_SEQ.NEXTVAL, '홍길동', NULL, '서울시 용산구');

INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS) 
    VALUES (FRIEND_SEQ.NEXTVAL, '박길동', '010-9999-9999', '서울시 강남구 강남대로94길 13 삼겸빌딩 402');

INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS)
    VALUES (FRIEND_SEQ.NEXTVAL, '신길동', '010-8888-8888', '서울시 영등포구');

SELECT FRIEND_SEQ.CURRVAL FROM DUAL; -- 현재 시퀀스 값
COMMIT;

-- ex. 초기값 101부터 최대값 999,999까지 1씩 증가하는 TEST_SEQ 시퀀스를 생성
CREATE SEQUENCE TEST_SEQ START WITH 101 MAXVALUE 999999 NOCACHE NOCYCLE;
SELECT TEST_SEQ.CURRVAL FROM DUAL; -- 시퀀스의 현재값이 없어서 에러
SELECT TEST_SEQ.NEXTVAL FROM DUAL;
SELECT TEST_SEQ.CURRVAL FROM DUAL;


-- 연습문제
CREATE TABLE MEMBER_LEVEL(
    LEVELNO NUMBER(1) PRIMARY KEY,
    LEVELNAME VARCHAR2(20) NOT NULL );
    
CREATE TABLE MEMBER(
    MNO NUMBER(5) PRIMARY KEY,
    MNAME VARCHAR2(20) NOT NULL,
    MPW VARCHAR2(20) CHECK(LENGTH(MPW) BETWEEN 1 AND 8),
    MMAIL VARCHAR2(40) UNIQUE,
    MPOINT NUMBER(20) CHECK(MPOINT>=0),
    MRDATE DATE DEFAULT SYSDATE,
    LEVELNO NUMBER(1) REFERENCES MEMBER_LEVEL(LEVELNO)   );

CREATE SEQUENCE MEMBER_SEQ MAXVALUE 99999 NOCACHE NOCYCLE;

INSERT INTO MEMBER_LEVEL VALUES(-1, 'black');
INSERT INTO MEMBER_LEVEL VALUES(0, '일반');
INSERT INTO MEMBER_LEVEL VALUES(1, '실버');
INSERT INTO MEMBER_LEVEL VALUES(2, '골드');

INSERT INTO MEMBER 
    VALUES(MEMBER_SEQ.NEXTVAL, '홍길동', 'aa', 'hong@hong.com', 0, '22/03/10', 0);
INSERT INTO MEMBER 
    VALUES(MEMBER_SEQ.NEXTVAL, '신길동', 'bb', 'sin@sin.com', 1000, '22/04/01', 1);
    
SELECT MNO "mNO", MNAME "mNAME", MRDATE "mRDATE", MMAIL "mMAIL", MPOINT "point", LEVELNAME "levelname"
    FROM MEMBER M, MEMBER_LEVEL ML
    WHERE M.LEVELNO=ML.LEVELNO;