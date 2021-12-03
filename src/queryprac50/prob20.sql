
# 2020년 1월의 제품별 생산량의 순위를 확인하기 위하여 제품명과 생산량을 순위를 매겨 출력하시오.
# (모든 제품이 출력되어야 하며 공동순위가 있다면 다음 순위는 공동순위의 수 만큼 밀려나고 생산되지 않은 제품은 제일 마지막 순위로 결정되어야 한다)

SELECT item.IName 제품명,
       MONTHLY_PRDO.TotalProdCnt 생산량,
       RANK() over (ORDER BY MONTHLY_PRDO.TotalProdCnt DESC) 생산량_순위
        FROM tItem item LEFT OUTER JOIN
            (SELECT prod.INumber, SUM(prod.PCount) TotalProdCnt FROM tProduction prod
                WHERE DATE_FORMAT(prod.PDate, '%Y%m') = '202001'
                    GROUP BY prod.INumber) MONTHLY_PRDO ON item.INumber = MONTHLY_PRDO.INumber;