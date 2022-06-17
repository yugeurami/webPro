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
-- 로그인
SELECT * FROM MVC_MEMBER WHERE MID = 'aaa' AND MPW='111';

-- 회원정보 수정
UPDATE MVC_MEMBER 
    SET   MPW = '1111', 
            MNAME = '강동원', 
            MEMAIL = 'aaa@aa.com', 
            MPHOTO = 'kang.jpg', 
            MBIRTH = '1981-08-18', 
            MADDRESS = '부산광역시'
    WHERE MID = 'aaa';

-- 회원리스트
SELECT * 
    FROM (SELECT ROWNUM RN, A.*
                FROM (SELECT * FROM MVC_MEMBER ORDER BY MID) A)
    WHERE RN BETWEEN 1 AND 3;

SELECT * FROM MVC_MEMBER;