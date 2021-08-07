package baekjun.prob3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void recursion(int[] arr, List<Integer> nums, int limit) throws IOException {
        if(nums.size()==limit) {
            for(int num : nums) {
                bw.write(num+" ");
            }
            bw.write("\n");
            bw.flush();

            return;
        }
        
        for(int i=0; i<arr.length; i++) {
            nums.add(arr[i]);
            recursion(arr, nums, limit);
            nums.remove(nums.size()-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int n = Integer.parseInt(input.split(" ")[0]);
        int m = Integer.parseInt(input.split(" ")[1]);
        int[] arr = new int[n];
        List<Integer> nums = new ArrayList<>();

        for(int i=0; i<n; i++) {
            arr[i] = i+1;
        }

        recursion(arr, nums, m);

    }
}
