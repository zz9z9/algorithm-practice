### 배달
- https://programmers.co.kr/learn/courses/30/lessons/12978

### 문제 해결 과정
- dist[i] : 1번 마을부터 i 마을까지의 최단거리
- Link : 현재 마을에서 갈 수 있는 다음 마을과 그 마을까지의 거리를 나타냄
- Info : 마을 번호와 1번 마을에서 해당 마을 번호(`edgeNum`)까지의 거리(`distFromStart`)를 나타냄

1. 초기화 단계를 거친다.
- dist 배열 
  - 0은 없는 마을이므로, 마지막에 답 구할 때 영향끼치지 않도록 `Integer.MAX_VALUE`로 세팅
  - 1은 출발점이므로 0, 나머지 마을은 `Integer.MAX_VALUE`로 세팅
- `List<Link>[] linksPerEdge;`
  - 각 인덱스별로 `new ArrayList<>()`로 초기화 시켜준다. 
  - 해당 배열에 각 마을 번호를 idx로 사용하여 해당 마을과 갈 수 있는 거리를 Link 객체로 만들어 추가한다. 
2. 각 마을별로 최단거리 구하기 위해 다익스트라 알고리즘 활용
- Info 객체를 담는 `PriorityQueue`(pq)를 만들고, Info에 있는 `distFromStart`로 오름차순 정렬한다. 
- pq에 출발점에 대한 정보인 `new Info(1,0)`을 담는다. 
- pq가 빈 큐가 될 때 까지 반복한다.
  - pq에서 Info를 꺼내 현재 정점과 출발점부터의 거리를 파악한다.
  - `dist[현재 정점] != distFromStart` 이면 해당 Info는 최신정보가 아니므로 폐기한다. 
  - 최신정보이면, linksPerEdge를 활용해 해당 정점에서 갈 수 있는 정점들(toEdge)을 파악한다.
  - dist[to 정점] > dist[현재 정점] + 현재정점 ~ to정점까지의 거리 이면 
    - dist[to 정점]을 로`(dist[현재 정점] + 현재정점 ~ to정점까지의 거리)`로 갱신
    - pq에 `new Info(to 정점, 갱신된 거리)` 추가 

### 사용 알고리즘
- 다익스트라 