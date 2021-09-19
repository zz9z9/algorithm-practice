package programmers.prob29;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // 회의실에 입실한 순서가 담긴 정수 배열 enter (1 ≤ enter의 길이 ≤ 1,000)
    // 퇴실한 순서가 담긴 정수 배열 leave
    // 각 사람별로 반드시 만난 사람은 몇 명인지 번호 순서대로 배열에 담아 return
    public int[] solution(int[] enter, int[] leave) {
        int n = enter.length;
        int[] answer = new int[n];
        List<Integer> currentPeople = new ArrayList<>();
        boolean[] hasDone = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            currentPeople.add(enter[i]);
        }

        for (int leavePerson : leave) {
            for (int i = 0; i < currentPeople.size(); i++) {
                if (leavePerson == currentPeople.get(i)) {
                    for (int j = i; j >= 1 && !hasDone[currentPeople.get(j)]; j--) {
                        hasDone[currentPeople.get(j)] = true;
                        for (int k = j - 1; k >= 0; k--) {
                            answer[currentPeople.get(j) - 1] += 1;
                            answer[currentPeople.get(k) - 1] += 1;
                        }
                    }

                    currentPeople.remove(i);
                }
            }
        }

        return answer;
    }
}

