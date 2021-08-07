package baekjun.prob4;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] isMarked;
    static int[] arr;
    static int[] selected;
    static int n,m;

    static void recursion(int depth) throws IOException {
        if(depth == m) {
            for(int num : selected) {
                bw.write(num + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i=0; i<n; i++) {
            if(!isMarked[i]) {
                isMarked[i] = true;
                selected[depth] = arr[i];

                recursion(depth+1);

                isMarked[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        selected = new int[m];
        isMarked = new boolean[n];

        for(int i=0; i<n; i++) {
            arr[i] = i+1;
        }

        recursion(0);

        bw.flush();
        bw.close();
    }
}
