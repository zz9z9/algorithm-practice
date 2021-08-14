package baekjun.prob8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Info {
        private int edgeNum;
        private int dist;

        public Info(int edgeNum, int dist) {
            this.edgeNum = edgeNum;
            this.dist = dist;
        }
    }

    static private int N,M;
    static private List<Info>[] links;
    static private PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
    static private int departure, arrival;

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        links = new ArrayList[N+1];

        for(int i=0; i<=N; i++) {
            links[i] = new ArrayList<>();
        }

        StringTokenizer st;
        while(M-->0) {
            st = new StringTokenizer(br.readLine());
            int fromEdge = Integer.parseInt(st.nextToken());
            int toEdge = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            Info info = new Info(toEdge, weight);

            links[fromEdge].add(info);
        }

        st = new StringTokenizer(br.readLine());
        departure = Integer.parseInt(st.nextToken());
        arrival = Integer.parseInt(st.nextToken());

        br.close();
    }

    static int dijkstra() {
        int[] dist = new int[N+1];
        for(int i=1; i<=N; i++) {
            dist[i] = (i==departure) ? 0 : Integer.MAX_VALUE;
        }

        pq.add(new Info(departure, 0));

        while(!pq.isEmpty()) {
            Info in = pq.poll();
            int currEdge = in.edgeNum;

            if(dist[currEdge] != in.dist) continue;

            for(Info info : links[currEdge]) {
                int toEdge = info.edgeNum;
                int newDist = dist[currEdge]+info.dist;

                if(dist[toEdge] > newDist) {
                    dist[toEdge] = newDist;
                    pq.add(new Info(toEdge, newDist));
                }
            }
        }

        return dist[arrival];
    }

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(dijkstra());
    }
}