
# 판매 가능한 제품들의 재고 파악을 위해 2020년 2월에 생산된 양을 확인하려하는데 우선 문구류 제품들을 먼저 파악하려 한다. 해당 제품명과 제품들의 총 생산량을 출력하시오.
# (문구류의 제품코드(INumber)는 I100(1~5)이며 1번은 가위, 2번은 풀, 3번은 공책, 4번은 볼펜, 5번은 지우개이다,

SELECT (CASE
            WHEN INumber = 'I1001' THEN '가위'
            WHEN INumber = 'I1002' THEN '풀'
            WHEN INumber = 'I1003' THEN '공책'
            WHEN INumber = 'I1004' THEN '볼펜'
            WHEN INumber = 'I0005' THEN '지우개'
            ELSE '기타'
        END) 제품명,
       SUM(PCount) 총_생산량
    FROM tProduction
        WHERE DATE_FORMAT(PDate, '%Y%m') = '202002'
          AND INumber LIKE 'I100%'
            GROUP BY INumber;
