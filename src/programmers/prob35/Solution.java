package programmers.prob35;

public class Solution {
    public int getDivisorCnt(int num) {
        if(num==1) return 1;

        int MAX = num;
        int divisorCnt = 0;

        for(int i=1; i<MAX; i++) {
            if(num%i==0) {
                int mok = num/i;
                MAX = mok;
                divisorCnt = (mok!=i) ? divisorCnt+2 : divisorCnt+1;
            }
        }

        return divisorCnt;
    }

    public int solution(int left, int right) {
        int answer = 0;
        for(int i=left; i<=right; i++) {
            int dc = getDivisorCnt(i);
            if(dc%2==0) {
                answer+=i;
                continue;
            }

            answer-=i;
        }

        return answer;
    }
}

