
# 부서별로 연령의 평균을 파악하기 위해서 각 부서마다 속해있는 직원들의 나이로 출생연도를 알아보려한다.
# 이를 위해 부서명, 직원명, 출생연도를 출력하되 각 부서의 직원들을 출생연도가 빠른 순으로 순위를 매겨라. (공동순위는 동일하게 부여하고 그 다음 순위는 공동 순위 다음 번호로 순위가 출력되어야 하며 출생연도는 tEmplyee의 ERRN의 앞 2자리로 비교하여 출력할 수 있다. D1001 부서는 문구생산부, D2001은 가구생산부, D3001은 액세서리생산부, D4001은 전자기기생산부, D5001은 음료생산부이다.)

SELECT
       (SELECT dept.DName
            FROM tDepartment dept WHERE emp.DNumber = dept.DNumber) 부서명,
       emp.EName 직원명,
       SUBSTR(emp.ERRN,1,2) 출생년도,
       DENSE_RANK() over (PARTITION BY emp.DNumber ORDER BY SUBSTR(emp.ERRN,1,2)) 출생년도_순위
            FROM tEmployee emp;