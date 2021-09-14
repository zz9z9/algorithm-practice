package programmers.prob28;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    static boolean[] isUsedAttribute;
    static List<String> candidateKey = new ArrayList<>();
    static int possibleCnt = 0;
    static int columnCnt = 0;

    public void init(String[][] relation) {
        int colCnt = relation[0].length;
        columnCnt = colCnt;
        isUsedAttribute = new boolean[colCnt];
    }

    public void combination(int currIdx, int k, String[][] relation, List<Integer> selectedIdx) {
        if (selectedIdx.size() == k && isPossible(relation, selectedIdx)) {
            possibleCnt++;

            StringBuilder sb = new StringBuilder();
            for(int idx : selectedIdx) {
                sb.append(idx);
            }
            candidateKey.add(sb.toString());
            return;
        }

        for (int i = currIdx; i < columnCnt; i++) {
            selectedIdx.add(i);
            combination(i + 1, k, relation, selectedIdx);
            selectedIdx.remove(selectedIdx.size() - 1);
        }
    }

    public boolean isPossible(String[][] relation, List<Integer> selectedIdx) {
        Set<String> dictionary = new HashSet<>();

        for (int i = 0; i < relation.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int idx : selectedIdx) {
                sb.append(relation[i][idx]);
            }
            if (dictionary.contains(sb.toString())) {
                return false;
            }

            dictionary.add(sb.toString());

            for(int j = 0; j< candidateKey.size(); j++) {
                String s = candidateKey.get(j);
                for(int k=0; k<s.length(); k++) {
                    int num = Character.getNumericValue(s.charAt(k));
                    if(!selectedIdx.contains(num)) {
                        break;
                    }
                    if(k==s.length()-1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public int solution(String[][] relation) {
        init(relation);

        for (int k = 1; k <= columnCnt; k++) {
            combination(0, k, relation, new ArrayList<>());
        }

        return possibleCnt;
    }
}
