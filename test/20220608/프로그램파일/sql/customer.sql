DROP TABLE CUSTOMER;

CREATE TABLE CUSTOMER(
    CID     VARCHAR2(50) PRIMARY KEY,
    CPW   VARCHAR2(50) NOT NULL,
    CNAME VARCHAR2(50) NOT NULL,
    CTEL VARCHAR2(50)  NOT NULL,
    CEMAIL VARCHAR2(50),
    CADDRESS VARCHAR2(250),
    CGENDER VARCHAR2(10) NOT NULL,
    CBIRTH DATE NOT NULL,
    CRDATE DATE NOT NULL
);

SELECT * FROM CUSTOMER;

-- 회원 가입 시 중복된 아이디 처리
SELECT * FROM MEMBER WHERE CID = 'aaa';
--회원가입
INSERT INTO CUSTOMER(CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH, CRDATE)
    VALUES('aaa', '111', '홍길동', '010-0000-0000', NULL, NULL, 'm', '1999-01-01', SYSDATE);

-- 로그인
SELECT * FROM CUSTOMER WHERE CID = 'aaa' AND CPW = '222';
-- 아이디로 DTO가져오기
SELECT * FROM CUSTOMER WHERE CID = 'aaa';
-- 회원정보 수정
UPDATE CUSTOMER SET CPW = '222', 
                                CNAME = '김길순', 
                                CTEL = '010-1111-1111', 
                                CEMAIL = 'bbb@bb.com', 
                                CADDRESS = '경기도 수원시', 
                                CGENDER = 'f', 
                                CBIRTH = '2000-05-05'
                            WHERE CID = 'aaa';
COMMIT;