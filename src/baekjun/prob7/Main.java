package baekjun.prob7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] parentNode;
    static boolean[] isVisited;
    static List<Integer>[] links;

    static void init() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try{
            N = Integer.parseInt(br.readLine());
            parentNode = new int[N+1];
            isVisited = new boolean[N+1];
            links = new ArrayList[N+1];

            for(int i=1; i<=N; i++) {
                links[i] = new ArrayList<>();
            }

            StringTokenizer st;
            while(N-->1) {
                st = new StringTokenizer(br.readLine());
                int firstNode = Integer.parseInt(st.nextToken());
                int secondNode = Integer.parseInt(st.nextToken());

                links[firstNode].add(secondNode);
                links[secondNode].add(firstNode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void findParent() {
        int rootNode = 1;
        Queue<Integer> que = new LinkedList<>();
        que.add(rootNode);

        isVisited[rootNode] = true;

        while(!que.isEmpty()) {
            int parent = que.poll();

            for(int child : links[parent]) {
                if(isVisited[child]) continue;

                que.add(child);
                isVisited[child] = true;
                parentNode[child] = parent;
            }
        }
    }

    static void printAnswer() {
        StringBuilder sb = new StringBuilder();
        for(int i=2; i<parentNode.length; i++) {
            sb.append(parentNode[i]+"\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) {
        init();
        findParent();
        printAnswer();
    }
}