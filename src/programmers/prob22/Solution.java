package programmers.prob22;

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