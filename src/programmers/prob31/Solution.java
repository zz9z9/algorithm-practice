package programmers.prob31;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    static final int PRICE = 100;
    static Map<String, String> ref = new HashMap<>();
    static Map<String, Integer> profit = new HashMap<>();

    public void init(String[] enroll, String[] referral) {
        for(int i=0; i<enroll.length; i++) {
            String en = enroll[i];
            String refer = referral[i];

            ref.put(en, refer);
        }
    }

    public void calculate(String name, int amount) {
        if(name.equals("-")) {
            return;
        }

        if(amount<10) {
            int total = profit.getOrDefault(name,0) + amount;
            profit.put(name, total);
            return;
        }

        int referralProfit = (int) (amount*(0.1));
        int myProfit = (amount-referralProfit);
        int total = profit.getOrDefault(name,0) + myProfit;

        profit.put(name, total);
        calculate(ref.get(name), referralProfit);
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        init(enroll, referral);

        for(int i=0; i<seller.length; i++) {
            calculate(seller[i], amount[i]*PRICE);
        }

        int[] answer = new int[enroll.length];
        for(int i=0; i<enroll.length; i++) {
            answer[i] = profit.getOrDefault(enroll[i], 0);
        }

        return answer;
    }
}

