package programmers.prob31;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

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

       return Stream.of(enroll)
               .mapToInt(name -> profit.getOrDefault(name, 0))
               .toArray();
    }
}

