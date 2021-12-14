
# 직원들의 평균 불량률이 5%라고 가정하였을 때, 전체 직원명과 직원별 전체 생산량과 평균 불량률을 고려한 예상 불량품량과
# 실제로 나온 실제 불량품량을 직원명과 함께 모두 출력하시오.

SELECT tBase1.EName 직원명,
       SUM(tBase1.PCount) 전체_생산량,
       SUM(tBase1.PCount)*0.05 예상_불량품량,
       SUM(tBase2.RCount) 실제_불량품량 FROM
    (SELECT emp.EName, ordr.ONumber, prod.PCount FROM tEmployee emp
        INNER JOIN tProduction prod ON emp.ENumber = prod.ENumber
        INNER JOIN tOrder ordr ON prod.PNumber = ordr.PNumber) tBase1
LEFT OUTER JOIN
    (SELECT rtrn.ONumber, rtrn.RCount FROM tReturn rtrn
        INNER JOIN tReturnReason rss ON rtrn.RRNumber = rss.RRNumber
            WHERE rss.RReason = '불량') tBase2
ON tBase1.ONumber = tBase2.ONumber
    GROUP BY tBase1.EName;