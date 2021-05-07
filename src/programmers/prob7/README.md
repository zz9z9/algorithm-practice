### 순위
- https://programmers.co.kr/learn/courses/30/lessons/49191

### 문제 해결 과정
<img src = "https://user-images.githubusercontent.com/64415489/117438213-38405100-af6c-11eb-896b-fc8f85aeadae.png" height="50%" width="50%"><br>
1. 자신의 순위를 확신할 수 있으려면 자신보다 강한 상대 + 약한 상대의 합이 n-1명 이어야한다.
2. 나보다 약한 상대인지 강한 상대인지 어떻게 판단할 수 있을까? 에 대한 해결책으로 Floyd-Warshall 알고리즘을 사용할 수 있다.
3. d[i][j]가 i->j로 가는 최단 경로라고 했을 때, 위 그래프를 기준으로 생각해보면, 나보다 강한상대(i), 나(j)인 경우 d[i][j]는 값이 존재하지만 d[j][i]로의 값은 존재할 수 없다.
4. 이를 기반으로 모든 정점간의 최단 거리를 구한 뒤, 선수별로 나보다 강한 상대, 약한 상대를 계산해서 n-1명이면 answer+1 을 한다.

### 해결 방식
- Floyd-Warshall

### 막혔던 부분
- 매 경기 결과마다 winner의 winner들을 loser의 winner에 추가하고<br>
loser의 loser를 winner의 loser에 추가하는 식으로 했더니 시간초과가 났었음
