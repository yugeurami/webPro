-- DROP
DROP TABLE MVC_MEMBER;

--CREATE
CREATE TABLE MVC_MEMBER(
    MID            VARCHAR2(30)    PRIMARY KEY,
    MPW           VARCHAR2(30)    NOT NULL,
    MNAME       VARCHAR2(30)    NOT NULL,
    MEMAIL       VARCHAR2(30),
    MPHOTO      VARCHAR2(30)    NOT NULL,
    MBIRTH        DATE,
    MADDRESS    VARCHAR2(300),
    MRDATE        DATE                DEFAULT SYSDATE);

-- ID 중복체크 및 DTO 가져오기
SELECT * FROM MVC_MEMBER WHERE MID = 'aaa';

-- 회원가입
INSERT INTO MVC_MEMBER(MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
                        VALUES('aaa', '111', '김익명', NULL, 'NOIMG.JPG', NULL, NULL);
                        
-- 이메일 체크하기
SELECT * FROM MVC_MEMBER WHERE MEMAIL = 'aaa@aa.com';