package baekjun.prob5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, S;
    static int[] nums;

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        S = Integer.parseInt(st1.nextToken());
        nums = new int[N];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int idx = 0;

        while (st2.hasMoreTokens()) {
            nums[idx] = Integer.parseInt(st2.nextToken());
            idx++;
        }
    }

    static int getAnswer() {
        int firstCursor = 0;
        int secondCursor = 1;
        int sum = nums[firstCursor];
        int answer = N+1;

        while (secondCursor < N) {
            if (nums[firstCursor] >= S || nums[secondCursor] >= S) {
                return 1;
            }

            sum += nums[secondCursor];

            while (sum >= S) {
                answer = Math.min(answer, secondCursor - firstCursor + 1);
                sum -= nums[firstCursor++];
            }

            secondCursor++;
        }

        return (answer==N+1) ? 0 : answer;
    }

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(getAnswer());
    }
}