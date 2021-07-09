package programmers.prob20;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static class Point {
        int fromRow;
        int fromCol;
        int toRow;
        int toCol;

        public Point(int fromRow, int fromCol, int toRow, int toCol) {
            this.fromRow = fromRow;
            this.fromCol = fromCol;
            this.toRow = toRow;
            this.toCol = toCol;
        }
    }

    static boolean isPossible(Point p, int num, int[][] arr) {
        int fromRow = p.fromRow;
        int fromCol = p.fromCol;
        int toRow = p.toRow;
        int toCol = p.toCol;

        for(int i=fromRow; i<=toRow; i++) {
            for(int j=fromCol; j<=toCol; j++) {
                if(arr[i][j]!=num) {
                    return false;
                }
            }
        }

        return true;
    }

    static void addPoints(Point p, Queue<Point> que) {
        int newRow = (p.fromRow+p.toRow+1)/2;
        int newCol = (p.fromCol+p.toCol+1)/2;

        que.add(new Point(p.fromRow, p.fromCol, newRow-1, newCol-1));
        que.add(new Point(p.fromRow, newCol, newRow-1, p.toCol));
        que.add(new Point(newRow, p.fromCol, p.toRow, newCol-1));
        que.add(new Point(newRow, newCol, p.toRow, p.toCol));
    }

    public int[] solution(int[][] arr) {
        int[] answer = new int[2];// 배열에 최종적으로 남는 0의 개수와 1의 개수
        int n = arr.length;

        Queue<Point> que = new LinkedList<>();
        que.add(new Point(0, 0, n-1, n-1));

        while(!que.isEmpty()) {
            Point p = que.poll();
            int num = arr[p.fromRow][p.fromCol];

            if(isPossible(p, num, arr)) {
                answer[num]+=1;
            } else {
                addPoints(p, que);
            }
        }

        return answer;
    }
}