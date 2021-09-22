package programmers.prob30;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    static Set<Integer> winNums = new HashSet<>();

    public void init(int[] win_nums) {
        for(int num : win_nums) {
            winNums.add(num);
        }
    }

    public int getRank(int correctCnt) {
        int rank = 7 - correctCnt;
        return (rank < 6) ? rank : 6;
    }

    public int[] solution(int[] lottos, int[] win_nums) {
        init(win_nums);

        int correctCnt = 0;
        int zeroCnt = 0;

        for(int num : lottos) {
            if(num==0) {
                zeroCnt++;
                continue;
            }

            if(winNums.contains(num)) correctCnt++;
        }

        int[] answer = {getRank(correctCnt+zeroCnt), getRank(correctCnt)};
        return answer;
    }
}

