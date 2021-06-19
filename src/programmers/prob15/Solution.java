package programmers.prob15;

import java.util.Arrays;

class Solution {
    // 셔틀 운행 횟수 n, 셔틀 운행 간격 t, 한 셔틀에 탈 수 있는 최대 크루 수 m, 크루가 대기열에 도착하는 시각을 모은 배열 timetable
    public String solution(int n, int t, int m, String[] timetable) {
        // 셔틀은 09:00부터 총 n회 t분 간격으로 역에 도착하며, 하나의 셔틀에는 최대 m명의 승객이 탈 수 있다.
        // 콘은 게으르기 때문에 같은 시각에 도착한 크루 중 대기열에서 제일 뒤에 선다.
        // 또한, 모든 크루는 잠을 자야 하므로 23:59에 집에 돌아간다. 따라서 어떤 크루도 다음날 셔틀을 타는 일은 없다.
        String answer = ""; // 콘이 무사히 셔틀을 타고 사무실로 갈 수 있는 제일 늦은 도착 시각을 출력한다. 도착 시각은 HH:MM 형식이며, 00:00에서 23:59 사이의 값이 될 수 있다.
        Arrays.sort(timetable);

        // 1. 18:01 ~ 23:59 분에 도착한 사람들은 다 집으로 돌려보낸다.
        int crewCnt = 0;
        for(String time : timetable) {
            String[] hourMinute = time.split(":");
            int hour = Integer.parseInt(hourMinute[0]);
            int min = Integer.parseInt(hourMinute[1]);

            if((hour==18 && min >=1) || hour>=19) {
                crewCnt++;
            }
        }

        // 버스 운행
        int initBusHour = 9;
        int initBusMin = 0;
        for(int i=0; i<n; i++) {
            int nextBusTerm = t*i;
            int busArrivalHour = initBusHour + (nextBusTerm/60);
            int busArrivalMin = initBusMin + (nextBusTerm%60);
            int takeBusCnt = 0;

            // 마지막 버스
            if(i==n-1) {
                // 2. 콘이 마지막 버스 타려고 할 때 남은 사람이 m-1 이하이면 콘은 마지막 버스 도착할 때 도착하면된다
                // 3. 콘이 마지막 버스 차려고 할 때 남은 사람이 m명 이상이면 맨 뒤에서부터 m-1명 될 때 까지 뺀다
            }

            for(int j=crewCnt; j<timetable.length; j++) {
                String[] crewArrivalInfo = timetable[j].split(":");
                int crewArrivalHour = Integer.parseInt(crewArrivalInfo[0]);
                int crewArrivalMin = Integer.parseInt(crewArrivalInfo[1]);

                if(busArrivalHour<=crewArrivalHour && busArrivalMin<=crewArrivalMin && takeBusCnt<m) {
                    takeBusCnt++;
                    crewCnt++;
                }
            }
        }


        int lastBusHour = (t*(n-1))/60+9;
        int lastBusMin = (t*(n-1))%60;


        return answer;
    }

}