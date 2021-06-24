package programmers.prob17;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        char EMPTY_SPACE = ' ';
        char WALL = '#';

        for(int i=0; i<n; i++) {
            StringBuilder sb = new StringBuilder();
            String binaryStr = Integer.toBinaryString(arr1[i]|arr2[i]);
            int gap = n - binaryStr.length();

            for(int j=0; j<n; j++) {
                if(gap > j) {
                    sb.append(EMPTY_SPACE);
                    continue;
                }

                sb.append(binaryStr.charAt(j-gap)=='0' ? EMPTY_SPACE : WALL);
            }

            answer[i] = sb.toString();
        }

        return answer;
    }
}