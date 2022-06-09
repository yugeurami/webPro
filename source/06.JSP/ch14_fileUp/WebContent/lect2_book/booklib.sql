--DROP
DROP TABLE BOOK;
DROP SEQUENCE BOOK_SEQ;

-- CREATE
CREATE TABLE BOOK(
    BID            NUMBER(5)         PRIMARY KEY, -- 책 번호
    BTITLE        VARCHAR2(100)   NOT NULL,    -- 책 제목
    BPRICE       NUMBER(6)         NOT NULL,    -- 책 가격
    BIMG1        VARCHAR2(30)    NOT NULL,    -- 책 대표 이미지(첨부 안할 경우 : noImg.png)
    BIMG2        VARCHAR2(30)    NOT NULL,    -- 책 부가 이미지(첨부 안할 경우 : nothing.png) 
    BCONTENT  VARCHAR2(4000),                   -- 책 설명 (한글 1,333글자 이내)
    BDISCOUNT NUMBER(3)         NOT NULL,   -- 할인율 (0~100%)
    BRDATE      DATE          DEFAULT SYSDATE -- 책 등록일
);

CREATE SEQUENCE BOOK_SEQ MAXVALUE 99999 NOCACHE NOCYCLE;

-- 책 등록
INSERT INTO BOOK(BID, BTITLE, BPRICE, BIMG1, BIMG2, BCONTENT, BDISCOUNT) 
                VALUES(BOOK_SEQ.NEXTVAL, '자바의 정석', 28000, 'noImg.png', 'nothing.png', '책설명', 20);
INSERT INTO BOOK(BID, BTITLE, BPRICE, BIMG1, BIMG2, BCONTENT, BDISCOUNT) 
                VALUES(BOOK_SEQ.NEXTVAL, '개발자의 봄', 32000, 'noImg.png', 'nothing.png', '책설명', 10);
INSERT INTO BOOK(BID, BTITLE, BPRICE, BIMG1, BIMG2, BCONTENT, BDISCOUNT) 
                VALUES(BOOK_SEQ.NEXTVAL, '이것이 자바다', 26000, 'noImg.png', 'nothing.png', '책설명', 5);
INSERT INTO BOOK(BID, BTITLE, BPRICE, BIMG1, BIMG2, BCONTENT, BDISCOUNT) 
                VALUES(BOOK_SEQ.NEXTVAL, '데이터베이스란', 35000, 'noImg.png', 'nothing.png', '책설명', 20);

-- 책 목록(전체 LIST)
SELECT * FROM BOOK ORDER BY BRDATE DESC;

-- 책 목록 (TOP-N 구문)
SELECT *
    FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK ORDER BY BRDATE DESC) A )
    WHERE RN BETWEEN 2 AND 3;

-- 등록된 책 갯수
SELECT COUNT(*) CNT FROM BOOK;

-- 책 상세보기(BID로 DTO 가져오기)
SELECT * FROM BOOK WHERE BID = 1;

COMMIT;