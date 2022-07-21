-- DEPT.XML의 ID=deptList
SELECT * FROM DEPT;

-- EMP.XML의 ID=empList
SELECT * 
    FROM (SELECT ROWNUM RN, A.* 
                FROM (SELECT * FROM EMP ORDER BY EMPNO) A)
    WHERE RN BETWEEN 1 AND 10;
-- Emp.xml ID=empDeptList
SELECT * 
    FROM (SELECT ROWNUM RN, A.*
                 FROM (SELECT E.*, DNAME, LOC 
                            FROM EMP E, DEPT D
                            WHERE E.DEPTNO=D.DEPTNO ORDER BY EMPNO) A)
    WHERE RN BETWEEN 6 AND 10;
    
-- EMP.XML ID=totCnt
SELECT COUNT(*) CNT FROM EMP;

-- EMP.XML ID=detail
SELECT * FROM EMP WHERE EMPNO = 7369;

-- emp.xml ID=managerList    
SELECT * FROM EMP 
    WHERE EMPNO IN (SELECT MGR FROM EMP);

-- emp.xml ID=insert
INSERT INTO EMP
    VALUES(9000, 'YUJIN', 'ANALYST', 7566, SYSDATE, 3600, 500, 20);

-- emp.xml ID=update
UPDATE EMP
    SET ENAME = 'YUJIN',
          JOB= 'SALESMAN',
          SAL = 5000,
          HIREDATE = '2018-02-01',
          COMM = 300,
          MGR = 7839,
          DEPTNO = 30
    WHERE EMPNO = 9000;

-- emp.xml ID=delete
DELETE FROM EMP WHERE EMPNO = 9000;