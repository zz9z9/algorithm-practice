### 행렬 테두리 회전하기
- https://programmers.co.kr/learn/courses/30/lessons/77485

### 문제 해결 과정
1. 오른쪽, 아래쪽, 왼쪽, 위쪽으로 나눠서 회전시킨다.
2. tmp에 현재 값을 넣고, nextTmp에 다음값을 넣는다.
3. 다음 값에 tmp를 넣고 nextTmp를 tmp에 넣는다. 
4. 2~3을 1번에 쓰인 회전 순서대로 진행한다.