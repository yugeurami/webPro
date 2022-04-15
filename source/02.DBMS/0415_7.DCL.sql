-- scott2로 들어와 딕셔너리 뷰 확인
SHOW USER;
SELECT * FROM USER_TABLES; -- SCOTT2가 가지고 있는 테이블
SELECT * FROM ALL_TABLES; -- SCOTT2가 접근 가능한 테이블
SELECT * FROM ALL_TABLES WHERE TABLE_NAME IN ('DEPT', 'EMP');
SELECT * FROM SCOTT.EMP;
SELECT * FROM SCOTT.EMP E, SCOTT.DEPT D WHERE E.DEPTNO=D.DEPTNO;
EXIT;