### 다리를 지나는 트럭
-  https://programmers.co.kr/learn/courses/30/lessons/42583
    
### 문제 해결 과정
1. 현재 대기 중인 트럭이 출발할 수 있는지 판단 
- 출발할 수 없는 경우 다리의 맨 앞에 있는 트럭부터 빠져나가도록 한다.
2. 마지막 트럭이 출발하면 반복문 종료되고, 마지막 트럭의 도착시간이 곧 답이된다.
             
### 해결 방식

- 시뮬레이션
             
### 막혔던 부분
- 트럭이 출발할 수 있는지 판단하는 부분에서 다리의 길이는 생각하지 않고 다리가 버틸 수 있는 하중만 생각했었다.
- 출발할 수 없는 경우, 다리의 맨 앞 트럭부터 빠지게할 때 사실 해당 트럭은 이미 도착 시간이 지나서 빠져나간 트럭일 수도 있다.<br>
따라서, 현재까지의 경과시간을 맨 앞 트럭의 도착시간과 비교해서 더 큰 것을 경과 시간으로 해야한다. 