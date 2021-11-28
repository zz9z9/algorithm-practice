
# 현재 판매하는 제품들 중 장농의 인기가 많아져 판매 가능한 장농의 재고를 확인하기 위하여
# 장농 생산이력을 전부 출력하되 생산량이 높은 순서대로 생산한 직원의 코드와 제품코드, 생산량을 순위를 매겨 출력하시오.
# (공동 순위가 나오지 않게 출력 해야 하며 또한 동률일경우 직원코드(ENumber)가 작은 코드가 우선순위를 가지도록한다, 장농의 제품코드는 I2003번이다)

SELECT ENumber 직원코드,
       INumber 제품코드,
       SUM(PCount) 생산량,
       ROW_NUMBER() over (ORDER BY SUM(PCount) DESC) 순위 FROM tProduction
    WHERE INumber = 'I2003'
        GROUP BY ENumber;