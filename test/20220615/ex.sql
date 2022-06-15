-- DROP
DROP TABLE REPLY;
DROP TABLE MANAGER;
DROP TABLE FILEBOARD;
DROP TABLE CUSTOMER;

DROP SEQUENCE LIST_SEQ;


-- CREATE
CREATE TABLE CUSTOMER(
    CID          VARCHAR2(50) PRIMARY KEY,
    CPW         VARCHAR2(50) NOT NULL,
    CNAME     VARCHAR2(50) NOT NULL,
    CEMAIL     VARCHAR2(50),
    CFILENAME VARCHAR2(100),
    CBIRTH      DATE,
    CADDRESS  VARCHAR2(500),
    CRDATE      DATE DEFAULT SYSDATE NOT NULL
);

CREATE TABLE MANAGER(
    MID          VARCHAR2(50) PRIMARY KEY,
    MPW         VARCHAR2(50) NOT NULL,
    MNAME     VARCHAR2(50) NOT NULL
);

CREATE TABLE FILEBOARD(
    FNUM      NUMBER(5) PRIMARY KEY,
    CID          VARCHAR2(50) REFERENCES CUSTOMER(CID),
    MID         VARCHAR2(50) REFERENCES MANAGER(MID),
    FTITLE       VARCHAR2(100) NOT NULL,
    FCONTENT  VARCHAR2(4000),
    FFILENAME  VARCHAR2(100),
    FHIT            NUMBER(5)  DEFAULT 0 NOT NULL,
    FREF            NUMBER(5) NOT NULL,
    FRE_STEP     NUMBER(5) NOT NULL,
    FRE_INDENT NUMBER(5) NOT NULL,
    FIP              VARCHAR2(100) NOT NULL,
    FRDATE      DATE DEFAULT SYSDATE NOT NULL
);


CREATE SEQUENCE LIST_SEQ MAXVALUE 99999 NOCACHE NOCYCLE;



-- 회원가입
INSERT INTO CUSTOMER(CID, CPW, CNAME, CEMAIL, CFILENAME, CBIRTH, CADDRESS, CRDATE)
    VALUES ('aaa', '111', '홍길동',  NULL, NULL, NULL, NULL, SYSDATE);
    
-- 아이디 중복 체크
SELECT * FROM CUSTOMER WHERE CID='aaa';
    
-- 회원 정보 수정
UPDATE CUSTOMER SET CPW = '1111', 
                                CNAME = '김길동', 
                                CEMAIL = 'aaa@aaa.com', 
                                CFILENAME = NULL, 
                                CBIRTH = NULL, 
                                CADDRESS = '경기도 수원시'
                            WHERE CID = 'aaa';
    
--  로그인/로그아웃
SELECT * FROM CUSTOMER WHERE CID='aaa' AND CPW='1111';

    


    
-- 관리자 등록
INSERT INTO MANAGER(MID, MPW, MNAME)
                    VALUES ('aaa', '111', '홍길동');

-- 아이디 중복 체크
SELECT * FROM MANAGER WHERE mID='aaa';

-- 관리자 로그인/로그아웃
SELECT * FROM MANAGER WHERE MID='aaa' AND MPW='111';




-- 회원이 원글 쓰기
INSERT INTO FILEBOARD ( FNUM, CID, MID, FTITLE, FCONTENT, FFILENAME, FHIT, FREF, FRE_STEP, FRE_INDENT, FIP, FRDATE)
            VALUES (LIST_SEQ.NEXTVAL, 'aaa', NULL, '원글제목1', '원글내용', NULL, 0, LIST_SEQ.CURRVAL, 0, 0, '162.00.00', SYSDATE);

-- 관리자가 답변글 쓰기
--STEP1
UPDATE FILEBOARD 
    SET FRE_STEP = FRE_STEP+1
    WHERE FREF = 1 AND FRE_STEP > 0;
-- 답변글 작성    
INSERT INTO FILEBOARD ( FNUM, CID, MID, FTITLE, FCONTENT, FFILENAME, FHIT, FREF, FRE_STEP, FRE_INDENT, FIP, FRDATE)
            VALUES (LIST_SEQ.NEXTVAL, NULL, 'aaa', '답변글제목1', '답변내용', NULL, 0, 1, 1, 1, '162.00.00', SYSDATE);

--글 갯수
SELECT COUNT(*) CNT FROM FILEBOARD;

-- 글 수정
UPDATE FILEBOARD SET  FTITLE = '제목',
                                FCONTENT = NULL, 
                                FFILENAME = NULL, 
                                FIP = '106.22.00'
                            WHERE FNUM = 1;

-- 페이징 글 목록
SELECT *
    FROM (SELECT ROWNUM RN, A.* 
                FROM (SELECT * FROM 
                            (SELECT F.* , CNAME, MNAME
                                    FROM FILEBOARD F, MANAGER M, CUSTOMER C
                                        WHERE F.MID=M.MID OR F.CID=C.CID) 
                            ORDER BY FREF DESC, FRE_STEP ) A )
    WHERE RN BETWEEN 5 AND 6;
    
-- 글 상세보기 + 조회수 올리기
UPDATE FILEBOARD SET FHIT = FHIT+1 WHERE FNUM = 2;
SELECT * FROM FILEBOARD WHERE FNUM = 2;

-- 글 삭제
DELETE FROM FILEBOARD WHERE FNUM = 1;