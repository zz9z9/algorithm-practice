package programmers.prob13;

class Solution {
    // 입국심사를 기다리는 사람 수 n
    // 각 심사관이 한 명을 심사하는데 걸리는 시간이 담긴 배열 times
    public long solution(int n, int[] times) {
        int MAX_N = 1000000000;
        long answer = (long) Math.pow(MAX_N,2); // 모든 사람이 심사를 받는데 걸리는 시간의 최솟값
        long left = 0;
        long right = answer;

        while(left <= right) {
            long mid = (left+right) / 2; // 걸리는 시간
            long totalNum = 0;

            for(int time : times) {
                totalNum+=(mid/time);

                if(totalNum >= n) {
                    right = mid-1;
                    answer = Math.min(answer, mid);
                    break;
                }
            }

            if(totalNum < n) {
                left = mid+1;
            }
        }

        return answer;
    }
}