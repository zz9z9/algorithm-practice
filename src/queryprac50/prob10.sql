
# 회사 내 전 직원들의 평균 생산량보다 한번이라도 많이 생산한 직원들에게는 상여금을 주려한다.
# 이에 해당하는 직원명을 출력하시오 (생산량은 tProduction 테이블의 PCount이다.)

SELECT (SELECT EName FROM tEmployee emp WHERE prod.ENumber = emp.ENumber) 직원명
    FROM tProduction prod
        WHERE prod.PCount > (SELECT AVG(PCount) FROM tProduction);
