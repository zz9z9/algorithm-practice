### 예상 대진표 
- https://programmers.co.kr/learn/courses/30/lessons/12985

### 문제 해결 과정
- 8명이 있다고 생각해봤을 때, (1,2) - (3,4) - (5,6) - (7,8) 의 대진이 완성될 것이다.
- 각 대진별로 이겼을 때를 생각하면 해당 조에서 이긴 사람은 다시 (1,2) → 1, (3,4) → 2, (5,6) → 3, (7,8) → 4의 순번을 배정 받을 것이다.
- 따라서, 다음과 같은 규칙을 발견할 수 있었다.
  - 자신의 순번(n)이 짝수인 경우 : 이겼을 경우 n/2 가 다음 순번이 된다.
  - 자신의 순번(n)이 홀수인 경우 : (n+1)/2 가 다음 순번이 된다. 
- 이 순번이 같아질 때까지 반복한 횟수가 답이 된다.

### 해결 방식
- 규칙 찾기 