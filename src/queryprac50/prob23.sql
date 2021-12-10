
# 부서별로 생산하는 제품들의 총 생산량을 부서명과 함께 순위를 매겨서 출력하세요
# (부서명, 부서에서 생산하는 제품의 총 생산량, 순위가 나와야 하며 공동순위(ex 공동 1등)가 있어도 다음 순위는 순차적으로 매겨진다.)

SELECT dept.DName 부서명,
       SUM(prod.PCount) 총_생산량,
       DENSE_RANK() OVER (ORDER BY SUM(prod.PCount) DESC) 총_생산량_순위
    FROM tEmployee emp
        INNER JOIN tDepartment dept ON emp.DNumber = dept.DNumber
        INNER JOIN tProduction prod ON emp.ENumber = prod.ENumber
            GROUP BY dept.DName;
