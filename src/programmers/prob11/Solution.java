package programmers.prob11;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n = board.length;
        Stack<Integer> bucket = new Stack<>();
        Map<Integer, Stack<Integer>> columnStk = new HashMap<>();

        for(int i=n-1; i>=0; i--) {
            for(int j=0; j<n; j++) {
                if(board[i][j]==0) {
                    continue;
                }

                Stack<Integer> stk = columnStk.getOrDefault(j+1, new Stack<>());
                stk.push(board[i][j]);
                columnStk.put(j+1, stk);
            }
        }

        for(int col : moves) {
            Stack<Integer> target = columnStk.get(col);
            if(target!=null && target.size() > 0) {
                int dollNum = target.pop();
                if(bucket.size() > 0 && bucket.peek()==dollNum) {
                    bucket.pop();
                    answer+=2;
                } else {
                    bucket.push(dollNum);
                }
            }
        }

        return answer;
    }
}