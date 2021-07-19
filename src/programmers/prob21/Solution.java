package programmers.prob21;

class Solution {
    static long getAnswer(long num) {
        String binaryNum = "0"+Long.toBinaryString(num);
        char[] arr = binaryNum.toCharArray();
        int len = arr.length-1;

        for(int i=len; i>=0; i--) {
            if(binaryNum.charAt(i)=='0') {
                arr[i] = '1';
                if(i+1<=binaryNum.length()-1) {
                    arr[i+1] = '0';
                }
                break;
            }
        }

        long ans = 0;
        long multiply = 1;
        for(int i= len; i>=0; i--) {
            ans = (arr[i]=='1') ? ans+multiply : ans;
            multiply*=2;
        }

        return ans;
    }

    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for(int i=0; i< numbers.length; i++) {
            answer[i] = getAnswer(numbers[i]);
        }

        return answer;
    }
}