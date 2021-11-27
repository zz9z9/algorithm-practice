
# 생산량 조정을 위해 2020년 2월의 총 생산량을 알려고 한다.
# 해당 월에 생산된 제품들의 코드와 해당 제품들의 총 생산량을 출력하시오.

SELECT INumber 제품코드, SUM(PCount) 총_생산량 FROM tProduction
    WHERE DATE_FORMAT(PDate, '%Y%m') = '202002'
        GROUP BY INumber;
