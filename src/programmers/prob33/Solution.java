package programmers.prob33;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<String, Integer> num = new HashMap<>();

    public void init() {
        num.put("zero", 0);
        num.put("one", 1);
        num.put("two", 2);
        num.put("three", 3);
        num.put("four", 4);
        num.put("five", 5);
        num.put("six", 6);
        num.put("seven", 7);
        num.put("eight", 8);
        num.put("nine", 9);
    }

    public boolean isNumber(char c) {
        char ZERO = '0';
        char NINE = '9';

        return (c >= ZERO && c <= NINE);
    }

    public int solution(String s) {
        init();
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()) {
            if(isNumber(c)) {
                answer.append(c);
                continue;
            }

            sb.append(c);

            int n = num.getOrDefault(sb.toString(), -1);
            if(n > -1) {
                answer.append(n);
                sb.delete(0, sb.length());
            }
        }

        return Integer.parseInt(answer.toString());
    }
}

