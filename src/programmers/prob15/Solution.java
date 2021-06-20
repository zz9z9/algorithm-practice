package programmers.prob15;


import java.time.LocalTime;
import java.util.Arrays;

class Solution {
    // 셔틀 운행 횟수 n, 셔틀 운행 간격 t, 한 셔틀에 탈 수 있는 최대 크루 수 m, 크루가 대기열에 도착하는 시각을 모은 배열 timetable
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = ""; // 콘이 무사히 셔틀을 타고 사무실로 갈 수 있는 제일 늦은 도착 시각을 출력한다. 도착 시각은 HH:MM 형식이며, 00:00에서 23:59 사이의 값이 될 수 있다.
        Arrays.sort(timetable);

        // 마지막 버스 전까지 운행
        int takeBusCnt = 0;
        for(int i=0; i<n-1; i++) {
            int nextBusTerm = t*i;
            int busArrivalHour = 9 + (nextBusTerm/60);
            int busArrivalMin = nextBusTerm%60;
            LocalTime busArrivalTime = LocalTime.of(busArrivalHour, busArrivalMin);
            int cnt = 0;

            for(int j=takeBusCnt; j<timetable.length && cnt<m; j++) {
                LocalTime crewArrivalTime = LocalTime.parse(timetable[j]);
                if(crewArrivalTime.compareTo(busArrivalTime)<=0) {
                    takeBusCnt++;
                    cnt++;
                }
            }
        }

        // 18:01 ~ 23:59 분에 도착한 사람들은 다 집으로 돌려보낸다.
        int goHomeIdx = timetable.length;
        for(int i=takeBusCnt; i<timetable.length; i++) {
            LocalTime arrivalTime = LocalTime.parse(timetable[i]);
            if(arrivalTime.isAfter(LocalTime.parse("18:00")) && arrivalTime.isBefore(LocalTime.parse("00:00"))) {
                goHomeIdx = i;
                break;
            }
        }

        int leftCrewCnt = goHomeIdx - takeBusCnt;
        int lastBusHour = (t*(n-1))/60+9;
        int lastBusMin = (t*(n-1))%60;
        LocalTime lastBusTime = LocalTime.of(lastBusHour, lastBusMin);

        if(leftCrewCnt < m) {
            answer = lastBusTime.toString();
        } else {
            int targetIdx = takeBusCnt+m-1;
            LocalTime targetTime = LocalTime.parse(timetable[targetIdx]);

            if(targetTime.isAfter(lastBusTime)) {
                answer = lastBusTime.toString();
            } else {
                while(targetIdx>takeBusCnt) {
                    LocalTime target = LocalTime.parse(timetable[targetIdx]);
                    LocalTime beforeTarget = LocalTime.parse(timetable[targetIdx-1]);

                    if(beforeTarget.isBefore(target)) {
                        break;
                    }

                    targetIdx--;
                }
                LocalTime ans = LocalTime.parse(timetable[targetIdx]).minusMinutes(1);
                answer = ans.toString();
            }
        }

        return answer;
    }
}