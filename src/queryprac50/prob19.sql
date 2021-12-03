
# 2022년 3월 20일 기준으로 현재 판매 가능한 공책의 재고량을 구하시오
# (반품되어 돌아온 공책의 경우 재판매 하지 않는다.)

SELECT TOTAL_PROD.IName 제품명, (TOTAL_PROD.TotalProdCnt - TOTAL_ORDR.TotalOrderCnt) 재고 FROM
(SELECT item.IName, SUM(prod.PCount) TotalProdCnt  FROM tProduction prod
    INNER JOIN tItem item ON prod.INumber = item.INumber
        WHERE item.IName = '공책' AND DATE_FORMAT(prod.PDate, '%Y%m%d') < '20220320'
            GROUP BY prod.INumber) TOTAL_PROD
    INNER JOIN
    (SELECT item.IName, SUM(prod.PCount) TotalOrderCnt FROM tProduction prod
        INNER JOIN tOrder ordr ON prod.PNumber = ordr.PNumber
        INNER JOIN tItem item ON prod.INumber = item.INumber
            WHERE DATE_FORMAT(ordr.ODate, '%Y%m%d') < '20220320' AND item.IName = '공책'
                GROUP BY prod.INumber) TOTAL_ORDR ON TOTAL_PROD.IName = TOTAL_ORDR.IName;