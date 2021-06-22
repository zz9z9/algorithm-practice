package programmers.prob16;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for(int i=0; i<arr1.length; i++) {
            for(int j=0; j<arr1[i].length; j++) {
                int num1 = arr1[i][j];
                for(int k=0; k<arr2[j].length; k++) {
                    int num2 = arr2[j][k];
                    int result = num1*num2;

                    answer[i][k]+=result;
                }
            }
        }

        return answer;
    }
}