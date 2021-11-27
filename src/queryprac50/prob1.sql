
# 문구생산부와 가구생산부의 직원정보를 확인하려한다.
# 위에 해당하는 직원들의 직원명과 입사일을 입사일이 빠른 순서대로 출력하세요.
# (문구생산부의 DNumber는 'D1001', 가구생산부는 'D2001'이며 입사일은 연,월,일까지만 출력되어야 한다)

SELECT EName 직원명, DATE_FORMAT(StartDate, '%Y-%m-%d') 입사일 FROM tEmployee
    WHERE DNumber IN ('D1001', 'D2001')
        ORDER BY StartDate;