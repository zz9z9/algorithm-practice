package programmers.prob32;

/**
 * 행렬의 세로 길이(행 개수) rows,
 * 가로 길이(열 개수) columns,
 * 회전들의 목록 queries가 주어질 때,
 *
 * 각 회전들을 배열에 적용한 뒤,
 * 그 회전에 의해 위치가 바뀐 숫자들 중 가장 작은 숫자들을 순서대로 배열에 담아 return
 */
public class Solution {
    static int[][] board;

    public void init(int rows, int columns) {
        board = new int[rows+1][columns+1];

        int cnt = 1;
        for(int i=1; i<=rows; i++) {
            for(int j=1; j<=columns; j++) {
                board[i][j] = cnt++;
            }
        }
    }

    public int rotateAndGetMin(int x1, int y1, int x2, int y2) {
        int tmp = board[x1][y1];
        int MIN = Integer.MAX_VALUE;

        // 오른쪽
        for(int i=y1; i<y2; i++) {
            int nextTmp = board[x1][i+1];
            board[x1][i+1] = tmp;
            MIN = Math.min(MIN, tmp);
            tmp = nextTmp;
        }

        // 아래
        for(int i=x1; i<x2; i++) {
            int nextTmp = board[i+1][y2];
            board[i+1][y2] = tmp;
            MIN = Math.min(MIN, tmp);
            tmp = nextTmp;
        }

        // 왼쪽
        for(int i=y2; i>y1; i--) {
            int nextTmp = board[x2][i-1];
            board[x2][i-1] = tmp;
            MIN = Math.min(MIN, tmp);
            tmp = nextTmp;
        }

        // 위
        for(int i=x2; i>x1; i--) {
            int nextTmp = board[i-1][y1];
            board[i-1][y1] = tmp;
            MIN = Math.min(MIN, tmp);
            tmp = nextTmp;
        }

        return MIN;
    }

    public int[] solution(int rows, int columns, int[][] queries) {
        init(rows, columns);

        int[] answer = new int[queries.length];
        for(int i=0; i< queries.length; i++) {
            int[] query = queries[i];
            int min = rotateAndGetMin(query[0], query[1], query[2], query[3]);

            answer[i] = min;
        }

        return answer;
    }
}

