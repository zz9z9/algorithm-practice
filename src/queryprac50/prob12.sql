
# 2021년부터 판매가 시작됨에 따라 지난 1년(20년 1월 1일 ~ 20년 12월 31일) 동안 생산된 제품들의 제품코드와 총 생산량을 생산량이 많은 순으로 확인하려한다. 위의 조건에 맞춰 출력하시오.

SELECT INumber 제품코드, SUM(PCount) 총_생산량 FROM tProduction
    WHERE DATE_FORMAT(PDate, '%Y') = '2020'
        GROUP BY INumber
            ORDER BY SUM(PCount) DESC;