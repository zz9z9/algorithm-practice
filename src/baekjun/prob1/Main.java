package baekjun.prob1;

/**
 * https://www.acmicpc.net/problem/1966
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseCnt = sc.nextInt();

        while(--testCaseCnt>=0) {
            int numberCnt = sc.nextInt();
            int targetIdx = sc.nextInt();
            int[] priority = new int[numberCnt];
            int answer = 0;
            Deque<int[]> dq = new ArrayDeque<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

            for (int i = 0; i < numberCnt; i++) {
                int num = sc.nextInt();
                priority[i] = num;
                dq.add(new int[]{i, num});
                pq.add(num);
            }

            while(!pq.isEmpty()) {
                int highestPriority = pq.peek();
                int[] header = dq.peekFirst();
                int currIdx = header[0];
                int currPriority = header[1];

                if(highestPriority == currPriority) {
                    pq.poll();
                    dq.pollFirst();
                    answer++;

                    if(currIdx == targetIdx) {
                        break;
                    }
                } else {
                    dq.pollFirst();
                    dq.addLast(header);
                }
            }

            System.out.println(answer);
        }
    }
}
