package programmers.prob10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    class Info {
        String userId;
        boolean isEnter;

        public Info(String userId, boolean isEnter) {
            this.userId = userId;
            this.isEnter = isEnter;
        }
    }

    public String[] solution(String[] records) {
        Map<String, String> userNickname = new HashMap<>();
        List<String> answer = new ArrayList<>();
        List<Info> infoList = new ArrayList<>();

        for(String record : records) {
            String[] li= record.split(" ");
            String command = li[0];
            String userId = li[1];

            if(command.equals("Enter") || command.equals("Change")) {
                String nickName = li[2];
                userNickname.put(userId, nickName);
                if(command.equals("Enter")) {
                    infoList.add(new Info(userId, true));
                }
            } else if(command.equals("Leave")){
                infoList.add(new Info(userId, false));
            }
        }

        String enterMsg = "들어왔습니다.";
        String leaveMsg = "나갔습니다.";

        for(Info i : infoList) {
            String nickName = userNickname.get(i.userId);
            StringBuilder displayMsg = new StringBuilder(nickName+"님이 ");

            if(i.isEnter) {
                displayMsg.append(enterMsg);
            } else {
                displayMsg.append(leaveMsg);
            }

            answer.add(displayMsg.toString());
        }

        return answer.toArray(new String[]{});
    }
}