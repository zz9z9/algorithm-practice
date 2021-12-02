
# 2021년 1월의 전자기기류 판매금 정산을 위해 전자기기류 제품들의 제품명과 해당 제품의 총 판매량을 출력하세요.
# (전자기기류의 제품코드는 INumber 번호가 I4로 시작한다.)

SELECT item.IName 제품이름, SUM(prod.PCount) 생산량 FROM tProduction prod
    INNER JOIN tItem item ON prod.INumber = item.INumber
    INNER JOIN tOrder tOrdr ON prod.PNumber = tOrdr.PNumber
        WHERE prod.INumber LIKE 'I4%'
            AND DATE_FORMAT(tOrdr.ODate, '%Y%m') = '202101'
            GROUP BY prod.INumber;