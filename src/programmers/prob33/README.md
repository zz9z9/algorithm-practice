### 숫자 문자열과 영단어
- https://programmers.co.kr/learn/courses/30/lessons/81301

### 문제 해결 과정
1. Map에 (영단어, 숫자) 쌍 맵핑
2. 주어진 문자열 s를 문자(char) 단위로 탐색
3. 해당 문자가 '0' ~ '9'인 경우 정답을 위한 `StringBuilder`에 추가 
4. 3에 해당하지 않을 경우, 또 다른 `StringBuilder`에 문자를 추가하고 해당 `StringBuilder`에 담긴 문자열이 Map에 있는지 확인한다.
5. 4번에서 확인한 결과 맵핑되는 숫자가 있다면 해당 숫자를 정답을 위한 `StringBuilder`에 추가하고 또 다른 `StringBuilder`는 clear 시켜준다.
6. 문제에서 주어진 문자열 s를 처음부터 끝까지 탐색하면서 3~5 반복.
