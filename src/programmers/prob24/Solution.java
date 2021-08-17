package programmers.prob24;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    static Set<Character>[][] directionPerPoint = new Set[11][11];
    static Map<Character, Character> oppositeDirection = new HashMap<>();
    static int fromX,fromY;
    static int toX,toY;

    public void init() {
        fromX = 5;
        fromY = 5;
        toX = fromX;
        toY = fromY;

        for(int i=0; i<11; i++) {
            for(int j=0; j<11; j++) {
                directionPerPoint[i][j] = new HashSet();
            }
        }

        oppositeDirection.put('U', 'D');
        oppositeDirection.put('D', 'U');
        oppositeDirection.put('L', 'R');
        oppositeDirection.put('R', 'L');
    }

    public void move(char dir) {
        switch (dir) {
            case 'U':
                toX = fromX;
                toY = (fromY==10) ? fromY : fromY+1;
                break;
            case 'D':
                toX = fromX;
                toY = (fromY==0) ? fromY : fromY-1;
                break;
            case 'L':
                toY = fromY;
                toX = (fromX==0) ? fromX : fromX-1;
                break;
            case 'R':
                toY = fromY;
                toX = (fromX==10) ? fromX : fromX+1;
                break;
        }
    }


    public int getAnswer(String dirs) {
        int answer = 0;

        for(int i=0; i<dirs.length(); i++) {
            char dir = dirs.charAt(i);

            move(dir);

            if(toX==fromX && toY==fromY) continue;

            if(!directionPerPoint[fromX][fromY].contains(dir)) {
                directionPerPoint[fromX][fromY].add(dir);
                directionPerPoint[toX][toY].add(oppositeDirection.get(dir));
                answer++;
            }

            fromX = toX;
            fromY = toY;
        }

        return answer;
    }

    public int solution(String dirs) {
        init();

        return getAnswer(dirs);
    }
}