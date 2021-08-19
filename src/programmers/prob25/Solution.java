package programmers.prob25;

import java.util.*;

class Solution {
    static List<String> cache = new ArrayList<>();
    
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize==0) {
            return cities.length * 5;
        }

        int answer = 0;

        for(String city : cities) {
            city = city.toLowerCase();

            if(cache.contains(city)) {
                cache.remove(city);
                cache.add(city);
                answer+=1;
                continue;
            }

            if(cache.size() == cacheSize) {
                cache.remove(0);
            }
            cache.add(city);
            answer+=5;
        }

        return answer;
    }
}

