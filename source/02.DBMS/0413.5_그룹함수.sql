-- [V] 그룹함수 : SUM, AVG, MIN, MAX, COUNT, STDDEV(표준편차), VARIANCE(분산)

SELECT ENAME, ROUND(SAL, -3) FROM EMP; -- 단일행 함수
-- 그룹 함수
SELECT MAX(SAL) FROM EMP;
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO; -- 그룹함수와 함께 사용되는 단일행은 GROUP BY 절을 꼭 붙여야한다
SELECT ENAME, MAX(SAL) FROM EMP; -- 에러(단일행과 다중행 같이 써서) 최대 급여를 받은 사람의 이름(6장 서브쿼리)

-- 1. 그룹함수
-- (1) 
SELECT ROUND(AVG(SAL), 2) FROM EMP;
SELECT COUNT(*) FROM EMP; -- EMP 테이블의 행(ROW) 수
SELECT AVG(SAL), SUM(SAL)/COUNT(SAL) FROM EMP;
SELECT COMM FROM EMP; -- SUM : 300+500+1400+0(2200) / AVG: 2200/4
SELECT SUM(COMM), AVG(COMM), COUNT(COMM), MIN(COMM), MAX(COMM) FROM EMP;
-- 모든 그룹함수는 NULL 을 제외하고 수행한다

-- SAL의 평균, 합, 최소급여, 최대급여, 급여분산, 급여표준편차, 갯수
SELECT AVG(SAL), SUM(SAL),  MIN(SAL), MAX(SAL), VARIANCE(SAL), STDDEV(SAL) FROM EMP;
-- 2100-1200~2100+1200
SELECT SQRT(VARIANCE(SAL)), STDDEV(SAL) FROM EMP;
-- MIN, MAX, COUNT는 숫자형, 문자형, 날짜형, 모두 사용가능
SELECT MIN(ENAME), MAX(ENAME), COUNT(ENAME) ENAME갯수 FROM EMP;
SELECT MIN(HIREDATE) "최초 입사일", MAX(HIREDATE) "최근 입사일", COUNT(HIREDATE) FROM EMP;

-- 탄탄1.	가장 최근에 입사한 사원의 입사일과 입사한지 가장 오래된 사원의 입사일을 출력. 
SELECT MIN(HIREDATE) "최초 입사일", MAX(HIREDATE) "최근 입사일" FROM EMP;

-- 탄탄2	(결과) 80년12월17일 최초입사  :14,620일째 83년01월12일 최근입사 :13,864일째
SELECT TO_CHAR(MAX(HIREDATE), 'RR"년"MM"월"DD"일"') || ' 최근입사일 : ' || 
    TO_CHAR(SYSDATE-MAX(HIREDATE), '99,999') || '일 근무,  ' ||
    TO_CHAR(MIN(HIREDATE), 'RR"년"MM"월"DD"일"') || '  최초입사일 : ' || 
    TO_CHAR(SYSDATE-MIN(HIREDATE), '99,999') || '일 근무'
    FROM EMP;
    
SELECT MAX(HIREDATE) || '최근 입사일 : ' ||
    TO_CHAR(MIN(SYSDATE-HIREDATE), '99,999') || '일 근무, ' ||
    MIN(HIREDATE) || '최초 입사일 : ' ||
    TO_CHAR(MAX(SYSDATE-HIREDATE), '99,999') || '일 근무'
    FROM EMP;
-- 10번 부서 소속의 사원 급여평균
SELECT ROUND(AVG(SAL)) FROM EMP WHERE DEPTNO = 10;

-- 2. GROUP BY 절
-- GROUP BY 절에는 별칭을 쓸 수 없다
-- 부서번호별 최대급여, 최소급여, 급여평균, 급여합
SELECT DEPTNO 부서, MAX(SAL), MIN(SAL), ROUND(AVG(SAL)), SUM(SAL) FROM EMP GROUP BY DEPTNO;
    -- ex. 급여가 5000미만인 사원의 대해서만 부서번호 별 사원수, 최대급여, 최소급여, 평균급여 (부서번호 순으로)
SELECT DEPTNO 부서, COUNT(*), MAX(SAL), MIN(SAL), ROUND(AVG(SAL)) -- SELECT절에서는 필드 별칭 사용가능 
    FROM EMP 
    WHERE SAL <5000 -- WHERE절 필드 별칭 사용 불가능
    GROUP BY DEPTNO -- GROUP BY절 필드 별칭 사용 불가능
    ORDER BY 부서; -- ORDER BY절 필드 별칭 사용 가능
    -- ex. 부서명별 사원수 최대급여, 최소급여, 평균급여
SELECT DNAME, COUNT(*), MAX(SAL), MIN(SAL), ROUND(AVG(SAL), 2)
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
    GROUP BY DNAME
    ORDER BY COUNT(*) DESC;
    
-- 3. HAVING 절 : 그룹함수 결과의 조건, 별칭 사용불가능
-- 부서번호 별 평균 급여(평균급여가 2000이상인 부서만 출력, 평균급여 순으로 정렬)
-- WHERE 절에는 그룹함수를 쓸 수 없다
SELECT DEPTNO, ROUND(AVG(SAL)) "AVG" 
    FROM EMP 
    GROUP BY DEPTNO
    HAVING AVG(SAL) >=2000
    ORDER BY AVG;

-- ex. SAL이 5000미만인 사원에 대해 부서명별 최소 급여, 최대급여, 평균급여(단, 평균 급여가 1800이상인 부서명에 대해서 평균 급여 순으로 정렬해서 출력)
SELECT DNAME, MIN(SAL), MAX(SAL), ROUND(AVG(SAL), 2) "AVG"
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND SAL<5000
    GROUP BY DNAME
    HAVING AVG(SAL)>=1800
    ORDER BY AVG;
    
-- 4. 결과 집계합 내 집계값 생성
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY ROLLUP(DEPTNO);
    -- 부서별, JOB별 급여합
SELECT DEPTNO, JOB, SUM(SAL) FROM EMP GROUP BY DEPTNO, JOB ORDER BY DEPTNO;
    -- 부서별 JOB별 급여합(소계와 전체합 포함)
SELECT DEPTNO, JOB, SUM(SAL) FROM EMP GROUP BY ROLLUP(DEPTNO, JOB);



-- ★<총 연습문제>
-- 1. 인원수,최대 급여,최소 급여,급여의 합을 출력
SELECT COUNT(*), MAX(SAL), MIN(SAL), SUM(SAL) FROM EMP;
-- 2. 업무별 인원수를 구하여 출력
SELECT JOB, COUNT(*) FROM EMP GROUP BY JOB;
--- 3. 최고 급여와 최소 급여의 차이는 얼마인가 출력
SELECT MAX(SAL)-MIN(SAL) FROM EMP;
-- 4. 각 부서별로 인원수, 급여 평균, 최저 급여, 최고 급여, 급여의 합을 출력(급여의 합이 많은 순으로)
SELECT DEPTNO, COUNT(*), ROUND(AVG(SAL)), MIN(SAL), MAX(SAL), SUM(SAL)
FROM EMP
GROUP BY DEPTNO
ORDER BY SUM(SAL) DESC;
-- 5. 부서별, 업무별 그룹하여 결과를 부서번호, 업무, 인원수, 급여의 평균, 급여의 합을 출력(부서번호, 업무순으로 오름차순 정렬)
SELECT DEPTNO, JOB, COUNT(*), ROUND(AVG(SAL)), SUM(SAL) FROM EMP
GROUP BY ROLLUP(DEPTNO, JOB)
ORDER BY DEPTNO, JOB;
-- 6. 업무별, 부서별 그룹하여 결과를  업무, 부서번호, 인원수, 급여의 평균, 급여의 합을 출력(출력결과는 업무순, 부서번호 순 오름차순 정렬)
SELECT JOB, DEPTNO, COUNT(*), ROUND(AVG(SAL)), SUM(SAL) FROM EMP
GROUP BY ROLLUP(JOB, DEPTNO)
ORDER BY JOB, DEPTNO;
--7. 사원수가 5명이상 넘는 부서번호와 사원수를 출력
SELECT DEPTNO, COUNT(*) FROM EMP
GROUP BY DEPTNO
HAVING COUNT(*)>=5;
-- 8. 사원수가 5명이상 넘는 부서명과 사원수를 출력
SELECT DNAME, COUNT(*)
FROM EMP E, DEPT D
WHERE E.DEPTNO=D.DEPTNO
GROUP BY DNAME
HAVING COUNT(*)>=5;
--9. 업무별 급여의 평균이 3000이상인 업무에 대해서 업무명, 평균 급여, 급여의 합을 출력
SELECT JOB, ROUND(AVG(SAL)), SUM(SAL)
FROM EMP
GROUP BY JOB
HAVING AVG(SAL)>=3000;
--10. 급여 합이 5000을 초과하는 각 업무에 대해서 업무와 급여합을 출력(급여 합계순 내림차순 정렬)
SELECT JOB, SUM(SAL)
FROM EMP
GROUP BY JOB
HAVING SUM(SAL)>=5000
ORDER BY SUM(SAL) DESC;
--11. 부서별 급여평균, 부서별 급여합계, 부서별 최소급여를 출력
SELECT DEPTNO, ROUND(AVG(SAL)), SUM(SAL), MIN(SAL)
FROM EMP
GROUP BY DEPTNO;
--12. 위의 11번을 수정하여, 부서별 급여평균 최대치, 부서별 급여합의 최대치, 부서별 최소급여의 최대치를 출력
SELECT MAX(ROUND(AVG(SAL))), MAX(SUM(SAL)), MAX(MIN(SAL))
FROM EMP
GROUP BY DEPTNO;

--13. 사원 테이블에서 아래의 결과를 출력
--   H_YEAR	COUNT(*)	MIN(SAL)	MAX(SAL)	AVG(SAL)	SUM(SAL)
--     80	  1		    800		    800		    800		    800
--	81	 10		    950		    5000	    2282.5	  22825
--	82	  2		    1300	    3000	   2150		   4300
--	83	  1		    1100	    1100	    1100	   1100
SELECT TO_CHAR(HIREDATE, 'RR') "H_YEAR", COUNT(*), MIN(SAL), MAX(SAL), ROUND(AVG(SAL)), SUM(SAL)
FROM EMP
GROUP BY TO_CHAR(HIREDATE, 'RR')
ORDER BY TO_CHAR(HIREDATE, 'RR');
-- 14.  아래의 결과를 출력(입사년도별 사원수)
--  1980     1	
--  1981     10
--  1982     2
--  1983     1
--  total    14	
SELECT NVL(TO_CHAR(HIREDATE, 'YYYY'), 'TOTAL') YEAR, COUNT(*)
FROM EMP
GROUP BY ROLLUP((TO_CHAR(HIREDATE, 'YYYY')));
--15. 최대급여, 최소급여, 전체급여합, 평균을 출력
SELECT MAX(SAL), MIN(SAL), SUM(SAL), ROUND(AVG(SAL)) FROM EMP;
--16. 부서별 인원수 출력
SELECT DEPTNO, COUNT(*) FROM EMP
GROUP BY DEPTNO;
--17. 부서별 인원수가 6명이상인 부서번호 출력
SELECT DEPTNO, COUNT(*) FROM EMP
GROUP BY DEPTNO
HAVING COUNT(*)>=6;
--18. 급여가 높은 순서대로 등수를 부여하여 다음과 같은 결과가 나오게 하시오. 
-- (힌트 self join, group by, count사용)
--ENAME	    등수
--________________________
--KING		1
--SCOTT		2
--……
SELECT E1.ENAME "이름", COUNT(E2.ENAME)+1 "등수"
FROM EMP E1, EMP E2
WHERE E1.SAL<E2.SAL(+)
GROUP BY E1.ENAME
ORDER BY COUNT(E2.ENAME);

SELECT ENAME, RANK() OVER(ORDER BY SAL DESC) "RANK", -- 함수, 속도가 느리다! 데이터가 많아지면 차이가 난다
                        DENSE_RANK() OVER(ORDER BY SAL DESC) "DENCE_RANK",
                        ROW_NUMBER() OVER(ORDER BY SAL DESC) "ROW_NUMBER" FROM EMP;







