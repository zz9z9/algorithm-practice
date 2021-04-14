package programmers.prob2;

/**
 * [다리를 지나는 트럭]
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 */

class Solution {
    // 다리 길이 bridge_length, 다리가 견딜 수 있는 무게 weight, 트럭별 무게 truck_weights
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; // 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지
        int truckCnt = truck_weights.length;
        int[][] truckInfo = new int[truckCnt][3]; // 출발시간, 도착시간, 무게
        int currBridgeWeight = 0;
        int departTruckCnt = 0;
        int passTruckCnt = 0;
        int elapsedTime = 0;

        while(departTruckCnt<truckCnt) {
            int currTruckWeight = truck_weights[departTruckCnt];
            int onBridgeTruckCnt = departTruckCnt - passTruckCnt;

            // 현재 트럭이 출발할 수 있는지 여부를 생각한다
            // 출발할 수 있으면 바로 출발
            if(currBridgeWeight + currTruckWeight <= weight && onBridgeTruckCnt < bridge_length) {
                int departTime = elapsedTime+1;
                int arrivalTime = departTime+bridge_length;
                truckInfo[departTruckCnt][0] = departTime;
                truckInfo[departTruckCnt][1] = arrivalTime;
                truckInfo[departTruckCnt][2] = currTruckWeight;

                elapsedTime+=1;
                departTruckCnt+=1;
                currBridgeWeight+=currTruckWeight;
            } else {
                // 아니라면 현재 다리에 맨 앞에 있는 트럭부터 현재 트럭이 출발할 수 있을 때 까지 내보낸다
                for(int i=passTruckCnt; i<departTruckCnt; i++) {
                    int headTruckArrivalTime = truckInfo[i][1];
                    int headTruckWeight = truckInfo[i][2];

                    elapsedTime = Math.max(headTruckArrivalTime-1, elapsedTime);
                    currBridgeWeight-= headTruckWeight;
                    passTruckCnt+=1;

                    if(currBridgeWeight + currTruckWeight <= weight){
                        break;
                    }
                }
            }
        }

        return truckInfo[truckCnt-1][1];
    }
}