
# 제품이 한번이라도 주문됐거나, 반품이 한번이라도 발생한 월의 정보를 알아보려고한다.
# 위, 조건에 해당하는 월들을 중복을 제거하고 출력하시오.

SELECT DATE_FORMAT(ODate, '%m') FROM tOrder
UNION
SELECT DATE_FORMAT(RDate, '%m') FROM tReturn;