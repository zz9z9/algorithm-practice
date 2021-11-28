### 약수의 개수와 덧셈
- https://programmers.co.kr/learn/courses/30/lessons/77884

### 문제 해결 과정
1. num의 약수의 갯수를 구한다.
- 1부터 시작해서 num을 나눈다.
- 나머지가 0이면 해당 수는 약수이다. 
- 나머지에 대한 몫이 탐색 범위의 최댓값이므로 굳이 num까지 다 살펴볼 필요는 없다.
- `num%a`(나머지)이 0 이면 a와 `num/a`(몫) 또한 약수가된다.
  - 따라서 a와 몫이 같은 경우엔 약수 갯수에 +1, 다른 경우엔 +2를 해준다. 
2. 1에서 구한 약수의 갯수가 짝수이면 정답에 num을 더하고 홀수이면 num을 뺀다.  