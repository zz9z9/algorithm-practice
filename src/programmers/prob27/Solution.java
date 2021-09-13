package programmers.prob27;

public class Solution {
    static final char EMPTY = '-';
    static int totalRemoveCnt = 0;
    static char[][] map;
    static int height,width;

    public void init(int m, int n, String[] board) {
        height = m;
        width = n;
        map = new char[m][n];

        int row = 0;
        for(String s : board) {
            int col = 0;
            for(char c : s.toCharArray()) {
                map[row][col++] = c;
            }
            row++;
        }
    }

    public int getRemoveCnt() {
        boolean[][] isRemove = new boolean[height][width];

        for(int i=0; i<height-1; i++) {
            for(int j=0; j<width-1; j++) {
                char target = map[i][j];
                char right = map[i][j+1];
                char below = map[i+1][j];
                char diag = map[i+1][j+1];

                if(target!=EMPTY && target==right && target==below && target==diag) {
                    isRemove[i][j] = true;
                    isRemove[i][j+1] = true;
                    isRemove[i+1][j] = true;
                    isRemove[i+1][j+1] = true;
                }
            }
        }

        int removeCnt = 0;
        for(int i=0; i<height; i++) {
            for(int j=0; j<width; j++) {
                if(isRemove[i][j]) {
                    map[i][j] = EMPTY;
                    removeCnt++;
                }
            }
        }

        return removeCnt;
    }

    public void arrange() {
        for(int i=height-1; i>=0; i--) {
            for(int j=0; j<width; j++) {
                if(map[i][j] == EMPTY) {
                    for(int k=i-1; k>=0; k--) {
                        if(map[k][j]!=EMPTY) {
                            map[i][j] = map[k][j];
                            map[k][j] = EMPTY;
                            break;
                        }
                    }
                }
            }
        }
    }

    public int solution(int m, int n, String[] board) {
        init(m,n,board);

        int cnt;
        while((cnt = getRemoveCnt()) > 0) {
            totalRemoveCnt+=cnt;
            arrange();
        }

        return totalRemoveCnt;
    }
}
