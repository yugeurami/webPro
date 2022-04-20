--[XI] 인덱스 : 조회를 빠르게 하기 위해 사용
SELECT * FROM USER_INDEXES; -- 딕셔너리 뷰에서 SCOTT이 소유한 인덱스 정보

DROP TABLE EMP01;
CREATE TABLE EMP01 AS SELECT * FROM EMP; -- EMP테이블 내용과 같은 EMP01 생성
SELECT * FROM EMP01; -- 14행
INSERT INTO EMP01 SELECT * FROM EMP01; -- 1번 28행, 2번 56행
SELECT TO_CHAR(COUNT(*), '9,999,999') FROM EMP01;
INSERT INTO EMP01 SELECT * FROM EMP01; -- 11번(11만 4천개)
INSERT INTO EMP01 (EMPNO, ENAME, DEPTNO) VALUES (1111, 'HONG', 40);
INSERT INTO EMP01 SELECT * FROM EMP01; -- 3번 91만개 1.224초
-- 인덱스 생성 전 조회
SELECT * FROM EMP01 WHERE ENAME = 'HONG'; -- 인덱스 생성 전 : 0.018초
-- 인덱스 생성(EMP01테이블의 ENAME) 후 조회
CREATE INDEX IDX_EMP01_ENAME ON EMP01(ENAME); -- 인덱스 생성: 0.3초
SELECT * FROM EMP01 WHERE ENAME = 'HONG'; -- 인덱스 생성 후: 0.001초
SELECT * FROM USER_INDEXES WHERE INDEX_NAME = 'IDX_EMP01_ENAME';
COMMIT; -- 91만개
INSERT INTO EMP01 SELECT * FROM EMP01; -- 인덱스 생성 후 INSERT 속도 : 23초
ROLLBACK; -- 180만개에서 91만개로 취소 속도 : 10초
DROP INDEX IDX_EMP01_ENAME;
INSERT INTO EMP01 SELECT * FROM EMP01; -- 인덱스 제거 후 INSERT 속도 : 0.6초
