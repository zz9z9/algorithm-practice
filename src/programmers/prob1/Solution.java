package programmers.prob1;

/**
 * [네트워크]
 * https://programmers.co.kr/learn/courses/30/lessons/43162
 */

import java.util.HashSet;
import java.util.Set;

class Solution {

    static int[] parents;

    int findParent(int node) {
        if(node == parents[node]) {
            return node;
        } else {
            int root = findParent(parents[node]);
            parents[node] = root;
            return root;
        }
    }

    void union(int x, int y) {
        if(parents[x]!=parents[y]) {
            x = findParent(x);
            y = findParent(y);

            parents[y] = x;
        }
    }

    // 컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers
    public int solution(int n, int[][] computers) {
        Set<Integer> s = new HashSet<>();
        parents = new int[n];

        for(int i=0; i<n; i++) {
            parents[i] = i;
        }

        for(int i=0; i<computers.length; i++) {
            for(int j=0; j<n; j++) {
                if(computers[i][j]==1) {
                    union(i,j);
                }
            }
        }

        for(int i=0; i<n; i++) {
            int root = findParent(i);
            s.add(root);
        }

        return s.size();
    }
}