-- 고객(CUSTOMER)테이블 dummy data
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH, CRDATE) 
    VALUES ('bbb','111','유길동','010-9999-9999', 'bbb@naver.com', '서울시 용산구','m','1991-01-01', SYSDATE);
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH, CRDATE) 
    VALUES ('ccc','111','박길동','010-9999-9999', null, '서울시 마포구','m','1991-01-01', SYSDATE);
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH, CRDATE) 
    VALUES ('ddd','111','마길동','010-9999-9999', 'ddd@naver.com', '경기도 수원시','m','1991-01-01', SYSDATE);
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH, CRDATE) 
    VALUES ('eee','111','신길동','010-9999-9999', 'eee@joeun.com', '경기도 파주시','m','1991-01-01', SYSDATE);
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH, CRDATE) 
    VALUES ('fff','111','유길동','010-9999-9999', 'fff@naver.com', '경기도 남양주시','m','1991-01-01', SYSDATE);
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH, CRDATE) 
    VALUES ('ggg','111','유길동','010-9999-9999', 'fff@naver.com', '경기도 남양주시','m','1991-01-01', SYSDATE);
    
-- 도서 테이블 더미 데이터
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMG1, bIMG2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '당신이 글을 쓰면 좋겠습니다',14000,'102.jpg','noImg.png','좋아',5);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMG1, bIMG2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '울트라러닝',16000,'103.jpg','noImg.png','좋아',5);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMG1, bIMG2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '내가 왔다',11500,'104.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMG1, bIMG2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '나의 서툰 위로가 너에게 닿기를',13000,'105.jpg','noImg.png','좋아',30);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMG1, bIMG2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '아직 멀었다는 말',13500,'106.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMG1, bIMG2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '소금 지방 산열',33000,'107.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMG1, bIMG2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '디레버리징',20000,'108.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMG1, bIMG2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '너와 나의 암호말',18000,'109.jpg','noImg.png','좋아',5);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMG1, bIMG2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '오늘도 펭수, 내일도 펭수',17000,'110.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMG1, bIMG2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '지적대화를 위한 넓고 얕은 지식2',1600,'111.jpg','noImg.png','좋아',30);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMG1, bIMG2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '트렌드코리아 2020',20000,'112.jpg','noImg.png','2020 트렌드 키워드 ',15);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMG1, bIMG2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '여행의 이유',18000,'113.jpg','noImg.png','김영하의 여행 경험',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMG1, bIMG2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '작은 아씨들',20000,'114.jpg','noImg.png','좋다 ',10);
    
    
-- 게시판(FileBoard)테이블 dummy data
INSERT INTO FILEBOARD (fNUM, cID, fSUBJECT, fCONTENT, fFILENAME, fPW, 
                fREF, fRE_STEP, fRE_LEVEL, fIP)
        VALUES (FILEBOARD_SEQ.NEXTVAL, 'ccc', 'titile','',null,'111',
                FILEBOARD_SEQ.CURRVAL, 0,0, '192.168.20.44');--1번글 추가
INSERT INTO FILEBOARD (fNUM, cID, fSUBJECT, fCONTENT, fFILENAME, fPW, 
                fREF, fRE_STEP, fRE_LEVEL, fIP)
        VALUES (FILEBOARD_SEQ.NEXTVAL, 'bbb', 'titile','',null,'111',
                FILEBOARD_SEQ.CURRVAL, 0,0, '192.168.20.44');--2번글 추가
INSERT INTO FILEBOARD (fNUM, cID, fSUBJECT, fCONTENT, fFILENAME, fPW, 
                fREF, fRE_STEP, fRE_LEVEL, fIP)
        VALUES (FILEBOARD_SEQ.NEXTVAL, 'ccc', '제목','내용',null,'111',
                FILEBOARD_SEQ.CURRVAL, 0,0, '192.168.20.44');--3번글 추가
INSERT INTO FILEBOARD (fNUM, cID, fSUBJECT, fCONTENT, fFILENAME, fPW, 
                fREF, fRE_STEP, fRE_LEVEL, fIP)
        VALUES (FILEBOARD_SEQ.NEXTVAL, 'ccc', '제목','내용',null,'111',
                2, 1, 1, '192.168.20.44'); -- 2번글에 대한 첫번째 답변글 추가
commit;