package programmers.prob4;

class Solution {
    // Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2]; //  카펫의 가로, 세로 크기
        int halfBrown = (brown/2);

        for(int w=3; w<halfBrown; w++) {
            int result = (halfBrown-w)*(w-2);
            int h = halfBrown-w+2;

            if(result==yellow) {
                answer[0] = Math.max(w,h);
                answer[1] = Math.min(w,h);
                break;
            }
        }

        return answer;
    }
}