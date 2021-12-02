
# 2020년 1월에 만들어진 모든 제품의 생산코드, 생산직원명, 제품명, 생산량, 생산일자를 출력하세요
# (단, 정렬은 고려하지 않는다 )

SELECT prod.PNumber 생산코드,
       emp.EName 생산직원명,
       item.IName 제품명,
       prod.PCount 생산량,
       prod.PDate 생산일자 FROM tProduction prod
           INNER JOIN tEmployee emp ON prod.ENumber = emp.ENumber
           INNER JOIN tItem item on prod.INumber = item.INumber
                WHERE DATE_FORMAT(PDate, '%Y%m') = '202001';