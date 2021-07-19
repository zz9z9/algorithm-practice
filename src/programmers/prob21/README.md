### 2개 이하로 다른 비트 
- https://programmers.co.kr/learn/courses/30/lessons/77885

### 문제 해결 과정
- long형 숫자를 이진 문자열로 바꾼다 
- LSB(Least Significant Bit) 부터 MSB(Most Significant Bit)까지 탐색하면서 0나오는 부분 찾는다
- 해당 자리수의 0을 1로 바꾸고 바로 오른쪽 1을 0으로 바꾼다 
  - LSB가 0이라면 오른쪽 비트가 없으므로 0만 1로 바꾸고 끝낸다
- 변경된 이진 문자열을 기반으로 십진수로 변경한다

### 해결 방식
- 규칙 찾기  
