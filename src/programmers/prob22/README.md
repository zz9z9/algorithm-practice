### 짝지어 제거하기
- https://programmers.co.kr/learn/courses/30/lessons/12973

### 문제 해결 과정
1. 여러개의 연속된 문자가 아니라, '두 개'의 연속된 문자가 나오는 경우 제거하는 것이므로 스택을 사용하면 될 것 같다.
2. 스택에서 pop 해야하는 경우는 스택의 맨 위에 있는 문자와 push 하려는 문자가 같은 경우이다. 
3. 이 외에는 주어진 문자열에서 탐색하고 있는 현재 문자를 push 한다. 
4. 문자열을 끝까지 탐색하고 난 뒤, 스택이 비어있으면 1(제거 가능), 아니면 0(불가능)을 리턴한다. 

### 코드 리팩토링 연습
---
#### Before

```java
import java.util.Stack;

class Solution {
    public int solution(String s) {
        int len = s.length();
        Stack<Character> stk = new Stack<>();

        for(int i=0; i<len; i++) {
            char c = s.charAt(i);

            if(stk.isEmpty()) {
                stk.push(c);
                continue;
            } 

            if(!stk.isEmpty()) {
                char top = stk.peek();
                if(top == c) {
                    stk.pop();
                } else {
                    stk.push(c);
                }
            }
        }

        return stk.isEmpty() ? 1 : 0;
    }
}
```

#### After
```java
import java.util.Stack;

class Solution {
    public int solution(String s) {
        int len = s.length();
        Stack<Character> stk = new Stack<>();

        for(int i=0; i<len; i++) {
            char c = s.charAt(i);

            if(!stk.isEmpty() && stk.peek()==c) {
                stk.pop();
                continue;
            }

            stk.push(c);
        }

        return stk.isEmpty() ? 1 : 0;
    }
}
```
