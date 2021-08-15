package programmers.prob23;

import java.util.*;

class Solution {
    static class Link {
        int toEdge;
        int weight;

        public Link(int toEdge, int weight) {
            this.toEdge = toEdge;
            this.weight = weight;
        }
    }

    static class Info {
        int edgeNum;
        int distFromStart;

        public Info(int edgeNum, int distFromStart) {
            this.edgeNum = edgeNum;
            this.distFromStart = distFromStart;
        }
    }


    static int[] dist;
    static List<Link>[] linksPerEdge;

    public void init(int N, int[][] road) {
        dist = new int[N+1];
        dist[0] = Integer.MAX_VALUE;

        linksPerEdge = new List[N+1];

        for(int i=1; i<=N; i++) {
            linksPerEdge[i] = new ArrayList<>();
            dist[i] = (i==1) ? 0 : Integer.MAX_VALUE;
        }

        for(int[] r : road) {
            int from = r[0];
            int to = r[1];
            int weight = r[2];

            linksPerEdge[from].add(new Link(to, weight));
            linksPerEdge[to].add(new Link(from, weight));
        }
    }

    public void dijkstra() {
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.distFromStart));
        pq.add(new Info(1,0));

        while (!pq.isEmpty()) {
            Info inf = pq.poll();
            int currEdge = inf.edgeNum;
            int distFromStart = inf.distFromStart;

            if(dist[currEdge]!=distFromStart) continue;

            for(Link link : linksPerEdge[currEdge]) {
                int toEdge = link.toEdge;
                int weight = link.weight;
                int newDist = dist[currEdge] + weight;

                if(dist[toEdge] > newDist) {
                    dist[toEdge] = newDist;
                    pq.add(new Info(toEdge, newDist));
                }
            }
        }
    }

    public int solution(int N, int[][] road, int K) {
        init(N, road);
        dijkstra();
        int answer = (int) Arrays.stream(dist)
                .filter(num -> num<=K)
                .count();

        return answer;
    }
}