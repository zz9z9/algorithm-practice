package programmers.prob9;

import java.util.HashSet;
import java.util.Set;

class Solution {
    static int[] answer = new int[2];
    static boolean isPossible(String[] gems, int scanLength, int typeCnt) {
        Set<String> gemType = new HashSet<>();
        boolean isPossible = false;

        for(int i=0; i<=gems.length-scanLength && !isPossible; i++) {
            gemType.clear();
            for (int j = i; j < i + scanLength; j++) {
                gemType.add(gems[j]);

                if (typeCnt == gemType.size()) {
                    isPossible = true;
                    answer[0] = i + 1;
                    answer[1] = i + scanLength;
                    break;
                }
            }
        }
        return isPossible;
    }

    public int[] solution(String[] gems) {
        Set<String> gemType = new HashSet<>();

        for(String gem : gems) {
            gemType.add(gem);
        }

        int typeCnt = gemType.size();

        // 이분탐색
        int left = typeCnt;
        int right = gems.length;

        while(left <= right) {
            int mid = (left+right)/2;
            if(isPossible(gems, mid, typeCnt)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}