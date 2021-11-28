
# 회사 내 우수직원을 생산량이 많은 직원을 기준으로 하여 상위 10명까지 뽑아 상여금을 주려한다. 이에 해당하는 직원들의 직원코드와 총 생산량을 상위 10명까지 순위를 매겨 출력하시오.
# (만약 공동순위(ex. 공동 1등)가 있다면 다음 순위는 중복 된 순위의 수 만큼 떨어진다.)

SELECT ENumber 직원코드,
       SUM(PCount) 총_생산량,
       RANK() over (ORDER BY SUM(PCount) DESC) 총_생산량_순위
    FROM tProduction
        GROUP BY ENumber
            LIMIT 10;