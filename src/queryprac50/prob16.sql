
# 현재까지 입사했던 모든 직원들의 직원코드, 부서명, 직원명, 직급명, 입사일, 퇴사일을 출력하시오
# (부서와 직급의 경우는 코드가 아닌 부서명과 직급명으로 출력하고 입사일과 퇴사일은 연,월,일만 출력되어야한다)

SELECT emp.ENumber 직원코드,
       dept.DName 부서명,
       emp.EName 직원명,
       rnk.RName 직급명,
       DATE_FORMAT(emp.StartDate, '%Y-%m-%d') 입사일,
       DATE_FORMAT(emp.ResignationDate, '%Y-%m-%d') 퇴사일 FROM tDepartment dept
        LEFT JOIN tEmployee emp on emp.DNumber = dept.DNumber
        LEFT JOIN tRank rnk on emp.RNumber = rnk.RNumber;