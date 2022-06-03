-- 테이블 drop & create

DROP TABLE BOARD;

CREATE TABLE BOARD(
    NUM             NUMBER(5,0)        PRIMARY KEY,      -- 글번호
    WRITER          VARCHAR2(30)     NOT NULL,          -- 글쓴이
    SUBJECT         VARCHAR2(100)    NOT NULL,         -- 글제목
    CONTENT       VARCHAR2(4000)   NOT NULL,         -- 글내용
    EMAIL            VARCHAR2(30),                             -- 작성자 이메일
    READCOUNT   NUMBER(5)           DEFAULT 0,         -- 글 HIT 수(조회수)
    PW               VARCHAR2(30)       NOT NULL,          -- 글 삭제시 쓸 비밀번호
    REF               NUMBER(5,0)         NOT NULL,          -- 글그룹(원글일 경우, 글번호로/ 답변글일 경우 원 글의 글번호로)
    RE_STEP         NUMBER(5)           NOT NULL,          -- 그룹내 출력 순서(원글 0)
    RE_INDENT     NUMBER(5)           NOT NULL,          -- 글 LIST 출력시 제목 들여쓰기 정도(원글 0)
    IP                 VARCHAR2(20)       NOT NULL,          -- 글 작성시 컴퓨터 IP 주소
    RDATE           DATE                   DEFAULT SYSDATE -- 글 작성 날짜
);

-- 글 갯수
SELECT COUNT(*) COUNT FROM BOARD;
-- 글 목록 (최신글이 위로)
SELECT * FROM BOARD ORDER BY REF DESC; 
-- 글 쓰기(원글쓰기)
    -- 글쓰기시 글번호 생성
        SELECT NVL(MAX(NUM), 0)+1 FROM BOARD;
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
    VALUES ((SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), '홍길동', '안녕하세요', '안녕하세요 홍길동입니다\n 잘부탁드립니다', NULL, 1, (SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), 0, 0, '192.168.10.3' );
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
    VALUES ((SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), '홍길동', '금요일좋아', '오늘은 금요일\n 행복한 날입니다.', NULL, 1, (SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), 0, 0, '192.168.10.3' );
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
    VALUES ((SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), '홍길동', '글3', '세번째 글이네요\n 열심히!', NULL, 1, (SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), 0, 0, '192.168.10.3' );
-- 글번호로 글 가져오기
SELECT * FROM BOARD WHERE NUM = 1;
-- 조회수 올리기
UPDATE BOARD SET READCOUNT = READCOUNT + 1 WHERE NUM = 1;
-- 글 수정
UPDATE BOARD
    SET SUBJECT = '첫 글은 인사',
        CONTENT = '안녕하세요 홍길동입니다\n 인사드려요!',
        EMAIL = 'aaa@naver.com',
        PW = '1234',
        IP = '127.0.0.1'
    WHERE NUM = 1;
COMMIT;
ROLLBACK;
-- 글 삭제(비밀번호)
DELETE FROM BOARD  WHERE NUM = 1 AND  PW = '1234';



-- 조회수 조작
UPDATE BOARD SET READCOUNT = 12 WHERE NUM = 3;