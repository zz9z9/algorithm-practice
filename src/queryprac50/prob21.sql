
# 우리 회사의 고객인 ‘오랜문방구’의 반품제품명, 주문코드, 주문량, 반품량, 반품사유를 출력하세요

SELECT item.IName 반품제품명,
       ordr.ONumber 주문코드,
       prod.PCount 주문량,
       rtrn.RCount 반품량,
       reason.RReason 반품사유 FROM tCustomer cust
    INNER JOIN tOrder ordr ON cust.CNumber = ordr.CNumber
    INNER JOIN tReturn rtrn ON ordr.ONumber = rtrn.ONumber
    INNER JOIN tReturnReason reason ON rtrn.RRNumber = reason.RRNumber
    INNER JOIN tProduction prod ON ordr.PNumber = prod.PNumber
    INNER JOIN tItem item ON prod.INumber = item.INumber
        WHERE cust.CName = '오랜문방구';