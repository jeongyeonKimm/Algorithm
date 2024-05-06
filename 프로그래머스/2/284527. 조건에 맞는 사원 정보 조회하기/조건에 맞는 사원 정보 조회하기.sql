SELECT SUM(SCORE) AS SCORE, B.EMP_NO, B.EMP_NAME, B.POSITION, B.EMAIL
FROM HR_DEPARTMENT A
JOIN HR_EMPLOYEES B ON A.DEPT_ID = B.DEPT_ID
JOIN HR_GRADE C ON B.EMP_NO = C.EMP_NO
WHERE C.YEAR = "2022"
GROUP BY EMP_NO
ORDER BY SCORE DESC LIMIT 1;