
# 퇴사자들이 생산한 제품들 중 반품된 제품들의 정보에 대해 알아보려 한다.
# 해당 조건에 맞는 제품을 생산한 직원명과 제품명, 해당 제품의 생산량, 반품량, 반품이유를 출력하시오.

SELECT emp.EName 직원명,
       item.IName 제품명,
       prod.PCount 생산량,
       rtrn.RCount 반품량,
       rrs.RReason 반품이유 FROM tEmployee emp
    INNER JOIN tProduction prod ON emp.ENumber = prod.ENumber
    INNER JOIN tItem item ON prod.INumber = item.INumber
    INNER JOIN tOrder ordr ON prod.PNumber = ordr.PNumber
    INNER JOIN tReturn rtrn ON ordr.ONumber = rtrn.ONumber
    INNER JOIN tReturnReason rrs ON rtrn.RRNumber = rrs.RRNumber
        WHERE emp.ResignationDate IS NOT NULL;
