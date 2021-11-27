
# 2020년 크리스마스부터 입사일이 만 2년이 넘어가는 사람에게 보너스를 지급하려고 한다. 위 조건에 해당하는 직원의 직원명과 입사일을 출력하시오.
# (단, 정렬은 고려하지 않는다)

SELECT EName 직원명, StartDate 입사일 FROM tEmployee
    WHERE StartDate < DATE_SUB('2020-12-25', INTERVAL 2 YEAR );