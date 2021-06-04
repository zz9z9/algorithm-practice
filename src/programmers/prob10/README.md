### 오픈 채팅방
- https://programmers.co.kr/learn/courses/30/lessons/42888

### 문제 해결 과정
1. 입장, 퇴장, 닉네임변경에 따라 적절한 로직 구현
 - 입장 : userId와 입장여부(true)를 Info 객체로 생성 후 답을 출력하기 위한 리스트에 저장, userId - nickname 쌍으로 맵에 저장
 - 퇴장 : userId와 입장여부(false)를 Info 객체로 생성 후 답을 출력하기 위한 리스트에 저장
 - 닉네임변경 : userId - nickname 쌍으로 맵에 저장
2. Info 객체가 저장된 리스트를 순회하면서 해당 객체의 userId에 맵핑된 nickname 찾고 입장, 퇴장 여부에 따라 적절한 메세지 출력.

### 해결 방식
시뮬레이션
