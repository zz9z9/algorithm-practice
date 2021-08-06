package baekjun.prob3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static void recursion(int[] arr, List<Integer> nums, int limit) {
        if(nums.size()==limit) {
            for(int num : nums) {
                System.out.print(num +" ");
            }
            System.out.println();

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

        for(int i=0; i<n; i++) {
            nums.add(arr[i]);
            recursion(arr, nums, m);   
            nums.remove(nums.size()-1);
        }
    }
}