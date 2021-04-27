package programmers.prob5;

import java.util.*;

class Solution {

    static List<String> ans = new ArrayList<>();
    static int totalTicketCnt = 0;

    static void dfs(String[][] tickets, boolean[] isUsed, int usedTicketCnt, String currAirport, List<String> path) {
        if (usedTicketCnt >= totalTicketCnt) {
            path.add(currAirport);

            if(ans.size() == 0) {
                ans.addAll(path);
            } else {
                for(int i=0; i<ans.size(); i++) {
                    int cond = ans.get(i).compareTo(path.get(i));
                    if(cond < 0) {
                        break;
                    } else if(cond > 0) {
                        ans.clear();
                        ans.addAll(path);
                    }
                }
            }

            path.remove(path.size()-1);
            return;
        }

        for (int i = 0; i < totalTicketCnt; i++) {
            String[] info = tickets[i];
            String from = info[0];

            if (!isUsed[i] && from.equals(currAirport)) {
                String to = info[1];
                isUsed[i] = true;
                path.add(from);
                dfs(tickets, isUsed, usedTicketCnt+1, to, path);
                path.remove(path.size()-1);
                isUsed[i] = false;
            }
        }
    }

    // 항공권 정보가 담긴 2차원 배열 tickets
    public String[] solution(String[][] tickets) {
        totalTicketCnt = tickets.length;
        boolean[] isUsed = new boolean[totalTicketCnt];
        List<String> path = new ArrayList<>();

        dfs(tickets, isUsed, 0, "ICN",path);

        return ans.toArray(new String[]{});
    }
}