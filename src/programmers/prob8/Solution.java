package programmers.prob8;

import java.util.HashMap;
import java.util.Map;

class Position {
    int row;
    int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    static int getDistance(Position pos1, Position pos2) {
        return Math.abs(pos1.row - pos2.row) + Math.abs(pos1.col - pos2.col);
    }

    public String solution(int[] numbers, String hand) {
        String answer = "";
        Map<Integer, Position> m = new HashMap<>();
        Position leftThumb = new Position(3, 0); // *
        Position rightThumb = new Position(3, 2); // #

        int key = 1;
        for(int i=0; i<=2; i++) {
            for(int j=0; j<=2; j++) {
                m.put(key, new Position(i,j));
                key++;
            }
        }

        m.put(0, new Position(3, 1));

        for (int num : numbers) {
            Position target = m.get(num);
            int fromLeftThumb = getDistance(target, leftThumb);
            int fromRightThumb = getDistance(target, rightThumb);
            boolean leftThumbCond = (num == 1 || num == 4 || num == 7);
            boolean rightThumbCond = (num == 3 || num == 6 || num == 9);
            boolean moveLeftThumb = true;

            if(leftThumbCond) {
                moveLeftThumb = true;
            } else if (rightThumbCond) {
                moveLeftThumb = false;
            } else if(fromLeftThumb > fromRightThumb) {
                moveLeftThumb = false;
            } else if(fromLeftThumb==fromRightThumb && hand.equals("right")) {
                moveLeftThumb = false;
            }

            if(moveLeftThumb) {
                answer+="L";
                leftThumb = target;
            } else {
                answer+="R";
                rightThumb = target;
            }

        }

        return answer;
    }
}