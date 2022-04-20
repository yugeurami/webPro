-- [XII] TRANSATION
-- COMMIT
-- 트랜잭션 반영
-- ROLLBAK
-- 트랜잭션 취소
-- SAVEPOINT
--트랜잭션 분할
DROP TABLE DEPT01;
CREATE TABLE DEPT01 AS SELECT * FROM DEPT;
SELECT * FROM DEPT01; -- 10, 20, 30, 40
DELETE FROM DEPT01;
SELECT * FROM DEPT01;
ROLLBACK; -- 새로운 트랜잭션 시작
SELECT * FROM DEPT01; -- 10, 20, 30, 40
DELETE FROM DEPT01 WHERE DEPTNO=40;    
COMMIT; -- 새로운 트랜잭션 시작
SELECT * FROM DEPT01; -- 10, 20, 30
DELETE FROM DEPT01 WHERE DEPTNO=30;
SELECT * FROM DEPT01; -- 10, 20
SAVEPOINT C1; -- C1지점 - 10,20
DELETE FROM DEPT01 WHERE DEPTNO=20;
SELECT * FROM DEPT01;
SAVEPOINT C2; -- C2 지점 - 10번부서
DELETE FROM DEPT01 WHERE DEPTNO=10;
SELECT * FROM DEPT01; -- 데이터 없음
ROLLBACK TO C2;
SELECT * FROM DEPT01; -- 10번 부서
ROLLBACK TO C1;
SELECT * FROM DEPT01; -- 10, 20
COMMIT;
SELECT * FROM DEPT01;