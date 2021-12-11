
# 고객별 반품 현황을 파악하기 위하여 고객별로 고객명과 제품을 구매한 양과 반품한 양 그리고 이를 구매량 대비 반품량을 반품률로 나타내시오.
# (반품률은 높은 순으로 소숫점 2자리까지 반올림되어 출력되어야하며 반품내역이 없는 값(null)은 0으로 대체되면서 마지막에 출력되어야 한다.)

SELECT tBase.CName                                                         고객명,
       SUM(tBase.PCount)                                                   주문량,
       IFNULL(SUM(rtrn.RCount), 0)                                         반품량,
       IFNULL(ROUND(SUM(rtrn.RCount)*100/SUM(tBase.PCount),2), 0)          반품률
    FROM (SELECT cust.CName, prod.PCount, ordr.ONumber FROM tCustomer cust
            INNER JOIN tOrder ordr ON cust.CNumber = ordr.CNumber
            INNER JOIN tProduction prod ON prod.PNumber = ordr.PNumber) tBase
    LEFT OUTER JOIN tReturn rtrn ON rtrn.ONumber = tBase.ONumber
        GROUP BY 고객명
        ORDER BY 반품률 DESC;