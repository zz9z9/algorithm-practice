
# 입사일이 10년이 넘는 직원들에게는 해당 직원들의 평균판매량을 기준으로 추가수당을 주려한다.
# 2022년 2월 28일을 기준으로 해당 직원들의 평균 판매 금액을 출력하시오.
# (반품 내역은 고려하지 않지만 퇴사자는 제외되어야 한다.)

SELECT AVG(tBase.total_sales) FROM
(SELECT SUM(item.Price * prod.PCount) total_sales FROM tEmployee emp
    INNER JOIN tProduction prod ON emp.ENumber = prod.ENumber
    INNER JOIN tItem item ON item.INumber = prod.INumber
    INNER JOIN tOrder ordr ON ordr.PNumber = prod.PNumber
        WHERE emp.StartDate < DATE_SUB('2022-02-28', INTERVAL 10 YEAR )
            AND emp.ResignationDate IS NULL
                GROUP BY emp.ENumber) tBase;
