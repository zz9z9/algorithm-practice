package baekjun.prob2;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] dp;

    static void solve() {

        int max = arr[0];
        dp[0] = arr[0];
        for(int i=1; i<arr.length; i++) {
            if(dp[i-1] < 0) dp[i-1] =0;
            dp[i] = dp[i-1] + arr[i];
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int test =0; test<t; test++) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n];
            dp = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            solve();
        }
    }
}