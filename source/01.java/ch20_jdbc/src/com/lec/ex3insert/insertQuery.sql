-- 
INSERT INTO DEPT VALUES (50, 'IT', 'SEOUL');
SELECT * FROM DEPT WHERE DEPTNO=50;
SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=50;
COMMIT;

UPDATE DEPT SET DNAME='ABC' WHERE DEPTNO=55;
DELETE FROM DEPT WHERE DEPTNO=55;

-- 수정
UPDATE DEPT SET DNAME = 'ABC', LOC = 'ABD' 
    WHERE DEPTNO = 55;
    
commit;