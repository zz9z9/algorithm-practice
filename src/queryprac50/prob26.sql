
# 부서별로 직급이 제일 높은 직원을 확인하려 한다. 이에 해당하는 직원의 부서명과 직급명, 직원명을 출력하시오

SELECT tBase.DName 부서명, tBase.RName 직급명, tBase.EName FROM
(SELECT dept.DName,
       rnk.RName,
       emp.EName,
       RANK() over (PARTITION BY emp.DNumber ORDER BY emp.RNumber DESC) rankNum
        FROM tEmployee emp
            INNER JOIN tDepartment dept ON emp.DNumber = dept.DNumber
            INNER JOIN tRank rnk ON rnk.RNumber = emp.RNumber
                WHERE emp.DNumber IS NOT NULL) tBase
WHERE rankNum=1;