package programmers.prob34;

public class Solution {
    public int solution(int[] numbers) {
        int sum = getSumFromOneToN(9);
        for(int num : numbers) {
            sum-=num;
        }

        return sum;
    }

    private int getSumFromOneToN(int n) {
        return n*(n+1)/2;
    }
}

