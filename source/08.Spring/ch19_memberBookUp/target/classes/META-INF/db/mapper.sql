-- member.xml (회원가입, ID로 DTO 가져오기, 로그인, 회원정보 수정)
    -- idConfirm
    SELECT * FROM MEMBER WHERE mID = 'aaa';
    -- joinMember
    INSERT INTO MEMBER VALUES ('aaa','1','홍길동','hong@naver.com','12345','서울');
    -- modifyMember
    UPDATE MEMBER 
        SET mPW = '1',
              mNAME = '홍길동',
              mMAIL = 'hong@naver.com',
              mPOST = '12345',
              mADDR = '서울'
        WHERE mID = 'aaa';
    -- loginMember
    SELECT * FROM MEMBER WHERE mID = 'aaa' AND mPW = '1';

-- book.xml (신규순 리스트, 도서보기-PAGING(책이름순), 책 갯수, 상세보기, 도서등록, 도서수정)
    -- mainList
    SELECT * 
        FROM (SELECT ROWNUM RN, A.*
                    FROM (SELECT * FROM BOOK ORDER BY bRDATE DESC) A);
    -- bookList
      SELECT * 
            FROM (SELECT ROWNUM RN, A.*
                        FROM (SELECT * FROM BOOK 
                                    WHERE 1=1
                                     AND bTITLE LIKE '%'||'김'||'%'
                                    OR bWRITER LIKE '%'||'김'||'%'
                                    ORDER BY bTITLE) A)
            WHERE RN BETWEEN 1 AND 5;
    -- totCntBook
    SELECT COUNT(*) CNT FROM BOOK
        WHERE 1=1
        AND bTITLE LIKE '%'||'김'||'%'
        OR bWRITER LIKE '%'||'김'||'%';
    -- getDetailBook
    SELECT * FROM BOOK WHERE bNUM = 1;
    -- registerBook
    INSERT INTO BOOK VALUES 
    (BOOK_SQ.NEXTVAL, 'Spring','김스프',sysdate, 'noImg.png','noImg.png','좋은스프링책');
    -- modifyBook
    UPDATE BOOK
        SET bTITLE = 'Spring',
              bWRITER = '김작가',
              bRDATE = SYSDATE,
              bIMG1 = 'noImg.png',
              bIMG2 = 'noImg.png',
              bINFO = '스프링 개념서'
        WHERE bNUM = 1;