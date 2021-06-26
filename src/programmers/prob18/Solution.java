package programmers.prob18;

class Solution {
    static boolean isPossible(int[] stones, int cnt, int limit) {
        int jumpDistance = 0;
        for(int i=0; i<stones.length; i++) {
            jumpDistance = (stones[i]-(cnt-1) <= 0) ? ++jumpDistance : 0;
            if(jumpDistance>=limit) {
                return false;
            }
        }
        return true;
    }

    public int solution(int[] stones, int k) {
        int answer = 0;
        int left = 0;
        int right = 200000000;

        while(left <= right) {
            int mid = (left+right)/2;

            if(isPossible(stones, mid, k)) {
                left = mid+1;
                answer = mid;
            } else {
                right = mid-1;
            }
        }

        return answer;
    }
}