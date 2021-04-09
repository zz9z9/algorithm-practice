### 네트워크
- https://programmers.co.kr/learn/courses/30/lessons/43162
    
### 문제 해결 과정
1. 컴퓨터 간의 연결 구성 정보를 알기 위해 com1과 com2 union
- union 시에는 com1과 com2의 부모 간에 연결되어야 한다
2. 완성된 연결 정보를 바탕으로 com1 ~ comN 까지 부모를 찾는다. (동일 네트워크 상에 있다면 부모도 같다.)
3. 부모의 개수가 곧 네트워크의 개수 
          
### 해결 방식

- 유니온 파인드 (find시에는 경로 압축방식)

```java
int findParent(int node) {
        if(node == parents[node]) {
            return node;
        } else {
            int root = findParent(parents[node]);
            parents[node] = root;
            return root;
        }
    }
```