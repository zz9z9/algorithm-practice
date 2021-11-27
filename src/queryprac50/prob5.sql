
# 2020년 1월의 성실직원을 뽑기 위해 성실직원의 기준인 생산량 500개 이상을 달성한 인원들의 직원코드와 총 생산량을 출력하시오.

SELECT ENumber 직원코드, SUM(PCount) 총_생산량  FROM tProduction
    WHERE DATE_FORMAT(PDate, '%Y%m') = '202001'
        GROUP BY ENumber
            HAVING SUM(PCount) >= 500;
