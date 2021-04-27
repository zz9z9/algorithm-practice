package programmers.prob6;

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        List<Integer> nums = new ArrayList<>();

        for(String op : operations) {
            boolean isInsert = op.contains("I");

            if(isInsert) {
                nums.add(Integer.parseInt(op.split(" ")[1]));
            } else if(nums.size() > 0){
                nums.sort(Comparator.comparingInt(n -> n));
                if(op.contains("-")) {
                    nums.remove(0);
                } else {
                    nums.remove(nums.size()-1);
                }
            }
        }

        int[] answer = new int[2]; // 모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return

        nums.sort(Comparator.comparingInt(n -> n));
        if(nums.size() > 0) {
            answer[0] = nums.get(nums.size()-1);
            answer[1] = nums.get(0);
        }

        return answer;
    }
}