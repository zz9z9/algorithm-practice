package baekjun.prob3;

import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] selected;

    static void recursion(int[] arr, int depth, int limit) throws IOException {
        if(depth==limit) {
            for(int num : selected) {
                bw.write(num+" ");
            }
            bw.write("\n");
            return;
        }

        for(int i=0; i<arr.length; i++) {
            selected[depth] = arr[i];
            recursion(arr, depth+1, limit);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int n = Integer.parseInt(input.split(" ")[0]);
        int m = Integer.parseInt(input.split(" ")[1]);
        int[] arr = new int[n];
        selected = new int[m];

        for(int i=0; i<n; i++) {
            arr[i] = i+1;
        }

        recursion(arr, 0, m);

        bw.flush();
    }
}
