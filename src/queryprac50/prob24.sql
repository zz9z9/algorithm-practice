

# 시장조사를 위하여 불량을 제외한 반품내역을 가진 고객들의 주변에 거주하는 직원들의 명단을 출력하시오 (고객들의 주소와 고객명단, 고객 주변에 거주하는 직원명단은 전부 출력되어야 한다)

SELECT tBase.CAddr 고객주소
     , tBase.CName 고객명
     , emp.EName 직원명
FROM (SELECT cust.CAddr, cust.CName FROM tCustomer cust
         INNER JOIN tOrder ordr ON ordr.CNumber = cust.CNumber
         INNER JOIN tReturn rtrn ON rtrn.ONumber = ordr.ONumber
            WHERE rtrn.RRNumber <> (SELECT RRNumber FROM tReturnReason WHERE RReason='불량')) tBase
    LEFT OUTER JOIN tEmployee emp ON tBase.CAddr = emp.EAddr;
