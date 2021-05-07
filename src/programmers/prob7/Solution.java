package programmers.prob7;

import java.util.Arrays;

class Solution {
    static void doFloydWarshall(int n, int[][] linkInfo) {
        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    linkInfo[i][j] = Math.min(linkInfo[i][j], linkInfo[i][k]+linkInfo[k][j]);
                }
            }
        }
    }

    public int solution(int n, int[][] results) {
        int answer = 0;
        int INF = 100000;
        int[][] linkInfo = new int[n+1][n+1];

        for(int[] link : linkInfo) {
            Arrays.fill(link, INF);
        }

        for(int i=1; i<=n; i++) {
            linkInfo[i][i] = 0;
        }

        for(int[] result : results) {
            int winner = result[0];
            int loser = result[1];

            linkInfo[winner][loser] = 1;
        }

        doFloydWarshall(n, linkInfo);

        for(int i=1; i<=n; i++) {
            boolean knowRank = true;
            for(int j=1; j<=n; j++) {
                if(i!=j && linkInfo[i][j]==INF && linkInfo[j][i]==INF) {
                    knowRank = false;
                    break;
                }
            }

            if(knowRank) {
                answer++;
            }
        }

        return answer;
    }

}