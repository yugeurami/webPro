-- DEPT.XML의 ID=deptList
SELECT * FROM DEPT;
-- EMP.XML의 ID=empList
SELECT * FROM EMP WHERE 1=1 
    AND ENAME LIKE '%'||'S'||'%' 
    AND JOB LIKE '%'||'E'||'%' 
    AND DEPTNO = 20;
    