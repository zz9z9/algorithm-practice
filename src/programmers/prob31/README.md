### 다단계 칫솔 판매
- https://programmers.co.kr/learn/courses/30/lessons/77486

### 문제 해결 과정
1. enroll, referral 배열을 이용해서 HashMap에 (이름, 상위자 이름) 쌍을 만든다.
2. (이름, 전체 수익)을 파라미터로 받는 calculate 메서드를 만든다.
- 상위자에게 돌아가는 수익 : 전체수익의 10%
- 나에게 돌아가는 수익 : (전체수익 - 상위자 수익)
- 이름이 "-" 인 경우 더 이상 계산할 필요가 없다.
3. 상위자는 본인의 상위자에게 또 배분해야 하므로 (본인 이름, 수익)을 파라미터로 다시 calculate 메서드를 실행한다.
4. seller, amount 배열을 기반으로 calculate 메서드를 실행한다. 