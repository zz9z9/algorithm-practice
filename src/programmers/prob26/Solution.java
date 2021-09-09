package programmers.prob26;

class Solution {
    public int getNumOneCnt(int num) {
        int cnt = 0;

        while(num>=1) {
            int remainder = num%2;
            if(remainder==1) cnt++;
            num/=2;
        }

        return cnt;
    }

    public int solution(int n) {
        int MAX = 1000000;
        int answer = 0;
        int targetCnt = getNumOneCnt(n);

        for(int i=n+1; i<=MAX; i++) {
            if(targetCnt == getNumOneCnt(i)) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}

