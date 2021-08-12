package baekjun.prob6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /**
     * [주의]
     * - 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문
     * - 2초 / 128 MB
     * [입력]
     * - 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V
     * - 정점 번호는 1번부터 N번까지이다.
     * [구해야할 정답]
     * - 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력
     * - 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력
     */

    static int N, M, V;
    static boolean[] isVisited;
    static List<ArrayList<Integer>> links = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    static void dfs(int currNode) {
        sb.append(currNode+" ");
        isVisited[currNode] = true;

        for (int toNode : links.get(currNode)) {
            if (!isVisited[toNode]) {
                dfs(toNode);
            }
        }
    }

    static void bfs(int currNode) {
        Queue<Integer> que = new LinkedList<>();
        que.add(currNode);
        isVisited[currNode] = true;

        sb.append(currNode+" ");

        while (!que.isEmpty()) {
            int fromNode = que.poll();
            for (int toNode : links.get(fromNode)) {
                if (!isVisited[toNode]) {
                    que.add(toNode);
                    isVisited[toNode] = true;

                    sb.append(toNode+" ");
                }
            }
        }
    }

    static void init() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            isVisited = new boolean[N + 1];

            for (int i = 0; i <= N; i++) {
                links.add(new ArrayList<>());
            }

            while (M > 0) {
                st = new StringTokenizer(br.readLine());
                int fromNode = Integer.parseInt(st.nextToken());
                int toNode = Integer.parseInt(st.nextToken());

                links.get(fromNode).add(toNode);
                links.get(toNode).add(fromNode);

                M--;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void sort() {
        for(int i=0; i<links.size(); i++) {
            links.get(i).sort(Integer::compareTo);
        }
    }

    static void resetVisitedNodes() {
        for (int i = 0; i < isVisited.length; i++) {
            isVisited[i] = false;
        }
    }

    public static void main(String[] args) {
        init();
        sort();
        dfs(V);
        sb.append("\n");
        resetVisitedNodes();
        bfs(V);

        System.out.println(sb);
    }
}