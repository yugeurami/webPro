-- ★ ★ ★ 고객 테이블 DAO ★ ★ ★
-- 1. 회원 가입 시 중복된 아이디 처리
SELECT * FROM MEMBER WHERE CID = 'aaa';
-- 2. 회원가입
INSERT INTO CUSTOMER(CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH, CRDATE)
    VALUES('aaa', '111', '홍길동', '010-0000-0000', NULL, NULL, 'm', '1999-01-01', SYSDATE);

-- 3. 로그인
SELECT * FROM CUSTOMER WHERE CID = 'aaa' AND CPW = '222';

-- 4. 아이디로 DTO가져오기
SELECT * FROM CUSTOMER WHERE CID = 'aaa';

-- 5. 회원정보 수정
UPDATE CUSTOMER SET CPW = '222', 
                                CNAME = '김길순', 
                                CTEL = '010-1111-1111', 
                                CEMAIL = 'bbb@bb.com', 
                                CADDRESS = '경기도 수원시', 
                                CGENDER = 'f', 
                                CBIRTH = '2000-05-05'
                            WHERE CID = 'aaa';

-- 6. 회원 리스트 보기(TOP-N)
SELECT * 
    FROM (SELECT ROWNUM RN, A.* 
                    FROM (SELECT * FROM CUSTOMER ORDER BY CID) A)
    WHERE RN BETWEEN 4 AND 6;
                    
-- 7. 등록된 회원 수
SELECT COUNT(*) CNT FROM CUSTOMER;


-- ★ ★ ★ 책 테이블 DAO ★ ★ ★
-- 책 등록
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMG1, bIMG2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '당신이 글을 쓰면 좋겠습니다',14000,'102.jpg','noImg.png','좋아',5);

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



-- ★ ★ ★ 게시판 테이블 DAO ★ ★ ★
-- 1. 글목록(START ROW~END ROW)
SELECT * 
    FROM (SELECT ROWNUM RN, A.*
                    FROM (SELECT F.*, CNAME, CEMAIL FROM FILEBOARD F, CUSTOMER C
                                WHERE F.CID = C.CID
                                ORDER BY FREF DESC, FRE_STEP) A)
    WHERE RN BETWEEN 2 AND 3;
    
-- 2. 등록된 글 수
SELECT COUNT(*)  FROM FILEBOARD;

-- 3. 원글 쓰기
INSERT INTO FILEBOARD (FNUM, CID, FSUBJECT, FCONTENT, FFILENAME, FPW, 
                FREF, FRE_STEP, FRE_LEVEL, FIP)
        VALUES (FILEBOARD_SEQ.NEXTVAL, 'ccc', 'titile','',null,'111',
                FILEBOARD_SEQ.CURRVAL, 0,0, '192.168.20.44');

-- 4. 답변글쓰기전 스텝A
UPDATE FILEBOARD SET FRE_STEP = FRE_STEP+1 WHERE FREF = 5 AND FRE_STEP > 0;
-- 5. 답변글쓰기
INSERT INTO FILEBOARD (FNUM, CID, FSUBJECT, FCONTENT, FFILENAME, FPW, 
                FREF, FRE_STEP, FRE_LEVEL, FIP)
        VALUES (FILEBOARD_SEQ.NEXTVAL, 'ccc', '제목','내용', null, '111',
                5, 1, 1, '192.168.20.44');
           
-- 6. 글 상세보기
UPDATE FILEBOARD SET FHIT = FHIT+1 WHERE FNUM = 1;
SELECT F.*, CNAME, CEMAIL FROM FILEBOARD F, CUSTOMER C
    WHERE F.CID = C.CID AND FNUM = 2;

-- 7. 글 수정
UPDATE FILEBOARD 
    SET   FSUBJECT = '수정된 제목', 
            FCONTENT = '수정된 내용', 
            FFILENAME = NULL, 
            FPW = '111',
            FIP = '192.168.20.44'
    WHERE FNUM = 5;

-- 8. 글 삭제
DELETE FROM FILEBOARD
    WHERE FNUM = 1 AND FPW = '111';
    
